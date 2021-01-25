package com.sda.hibernate;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AuthorRepositoryTest {

    @Test
    void givenAuthorWith2Books_whenCreate_shouldSave1AuthorAnd2Books() {
        // create 2 books
        Author author = createAuthorWithBooks();
        // create author
        AuthorRepository authorRepository = new AuthorRepository();

        // save author with books
        authorRepository.create(author);

        // find all authors
        int actualSize = authorRepository.findAll().size();
        // check size = 1
        // check has 2 books
        assertThat(actualSize).isEqualTo(1);
    }

    @Test
    void givenTwoAuthors_whenFindAuthorsWithBookPriceJoinFetch_shouldReturn2Authors() {
        AuthorRepository authorRepository = new AuthorRepository();
        authorRepository.create(createAuthorWithBooks());
        authorRepository.create(createAnotherAuthorWithBooks());
        authorRepository.create(createAuthorWithNoBooks());

        // when
        int actualSize = authorRepository.findAuthorsWithBookPriceJoinFetch(100).size();

        // then
        assertThat(actualSize).isEqualTo(2);
    }

    private Author createAuthorWithBooks() {
        Book book1 = new Book("game of thrones", 100);
        Book book2 = new Book("game of thrones 2", 20);

        Author author = new Author("george martin");
        author.addBook(book1);
        author.addBook(book2);

        return author;
    }

    private Author createAnotherAuthorWithBooks() {
        Book book1 = new Book("title 1", 100);
        Book book2 = new Book("title 2", 30);

        Author author = new Author("paul ene");
        author.addBook(book1);
        author.addBook(book2);

        return author;
    }

    private Author createAuthorWithNoBooks() {
        return new Author("ana vasile");
    }
}