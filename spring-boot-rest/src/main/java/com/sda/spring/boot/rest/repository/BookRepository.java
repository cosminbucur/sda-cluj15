package com.sda.spring.boot.rest.repository;

import com.sda.spring.boot.rest.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findAll();

    Optional<Book> findByTitle(String title);

    // derived query
    // SELECT * FROM book WHERE book.author = :author
    List<Book> findByAuthor(String author);

    // custom query
    @Query("FROM Book b WHERE b.author=:author")
    List<Book> findByAuthorQuery(String author);
}
