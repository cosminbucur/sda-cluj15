package com.sda.spring.boot.rest;

import com.sda.spring.boot.rest.model.Book;
import com.sda.spring.boot.rest.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void givenTwoAuthors_whenFindByAuthor_thenReturnOneAuthor() {
        // given
        bookRepository.save(new Book("test", "alex"));
        bookRepository.save(new Book("test 2", "ana"));

        // when
        List<Book> actual = bookRepository.findByAuthor("alex");

        // then
        assertThat(actual.size()).isEqualTo(1);
    }

    @Test
    void givenTwoAuthors_whenFindByAuthorQuery_thenReturnOneAuthor() {
        // given
        bookRepository.save(new Book("test", "alex"));
        bookRepository.save(new Book("test 2", "ana"));

        // when
        List<Book> actual = bookRepository.findByAuthorQuery("alex");

        // then
        assertThat(actual.size()).isEqualTo(1);
    }
}