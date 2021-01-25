package com.sda.jdbc.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class BookIntegrationTest {

    BookRepository repository = new BookRepository();

    @BeforeEach
    void setUp() {
        repository.findAll()
                .forEach(book -> repository.deleteById(book.getId()));
    }

    // save book, check is in db
    @Test
    void givenBook_whenSave_thenBookIdExist() {
        // given
        Book book = new Book();
        book.setTitle("game of thrones");
        book.setAuthor("george martin");
        book.setPublishDate(LocalDate.now());

        // when
        Book actualBook = repository.save(book);

        // then
        // verify that book exists

        // var 1: check size of book repository
        // var 2: i find the id of the book
        assertThat(actualBook.getId()).isNotNull();
    }

    @Test
    void givenTwoBooks_whenFindAll_thenSizeIs2() {
        // given
        Book book1 = new Book();
        book1.setTitle("game of thrones");
        book1.setAuthor("george martin");
        book1.setPublishDate(LocalDate.now());

        Book book2 = new Book();
        book2.setTitle("karamazov brothers");
        book2.setAuthor("dostojevsky");
        book2.setPublishDate(LocalDate.now());

        repository.save(book1);
        repository.save(book2);

        // when
        List<Book> actual = repository.findAll();

        // then
        assertThat(actual.size()).isEqualTo(2);
    }

    @Test
    void givenBook_whenDelete_thenSizeIs0() {
        // given
        Book book = new Book();
        book.setTitle("game of thrones");
        book.setAuthor("george martin");
        book.setPublishDate(LocalDate.now());

        Book savedBook = repository.save(book);

        // when
        repository.deleteById(savedBook.getId());

        List<Book> foundBooks = repository.findAll();
        int bookCount = foundBooks.size();

        // then
        assertThat(bookCount).isZero();
    }
}
