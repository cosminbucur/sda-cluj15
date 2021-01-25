package com.sda.spring.boot.rest.service;

import com.sda.spring.boot.rest.dto.BookMapper;
import com.sda.spring.boot.rest.dto.BookRequest;
import com.sda.spring.boot.rest.dto.BookResponse;
import com.sda.spring.boot.rest.exception.NotFoundException;
import com.sda.spring.boot.rest.model.Book;
import com.sda.spring.boot.rest.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private static final Logger log = LoggerFactory.getLogger(BookService.class);

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public List<BookResponse> findAll() {
        log.debug("finding all books");

        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    public BookResponse findById(Long id) {
        log.debug("finding book by id: {}", id);

        return bookRepository.findById(id)
                .map(bookMapper::toDto)
                .orElseThrow(() -> new NotFoundException("book not found"));
    }

    public BookResponse save(BookRequest createBookRequest) {
        log.debug("saving book: {}", createBookRequest);

        boolean exists = bookRepository.findByTitle(createBookRequest.getTitle()).isPresent();
        if (exists) {
            throw new NotFoundException("duplicate book");
        }

        Book book = bookMapper.toEntity(createBookRequest);
        Book newBook = bookRepository.save(book);
        return bookMapper.toDto(newBook);
    }

    public BookResponse update(Long id, BookRequest updateRequest) {
        log.debug("updating book with id: {} and request body: {}", id, updateRequest);

        return bookRepository.findById(id)
                .map(book -> bookMapper.toEntity(book, updateRequest))
                .map(bookRepository::save)
                .map(bookMapper::toDto)
                .orElseThrow(() -> new NotFoundException("book not found"));
    }

    public void delete(Long id) {
        log.debug("deleting book with id: {}", id);

        bookRepository.findById(id)
                .map(book -> {
                    bookRepository.deleteById(id);
                    return book;
                })
                .orElseThrow(() -> new NotFoundException("book not found"));
    }

    // find using filter
    public List<BookResponse> findByAuthor(String author) {
        log.debug("finding books by author: {}", author);

        return bookRepository.findAll()
                .stream()
                .filter(book -> book.getAuthor().equals(author))
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    // find using derived query
    public List<BookResponse> findByAuthorDerived(String author) {
        log.debug("finding books by author: {}", author);
        return bookRepository.findByAuthor(author)
                .stream()
                .filter(book -> book.getAuthor().equals(author))
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    // find using JPQL
    public List<BookResponse> findByAuthorQuery(String author) {
        log.debug("finding books by author: {}", author);

        return bookRepository.findByAuthor(author)
                .stream()
                .filter(book -> book.getAuthor().equals(author))
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

}
