package com.sda.jdbc.book;

import java.util.List;

public interface CustomBookRepository {

    Book save(Book book);

    int saveLongVersion(Book book);

    List<Book> findAll();

    void deleteById(Long id);
}
