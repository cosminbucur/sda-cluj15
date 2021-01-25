package com.sda.jdbc.book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements CustomBookRepository {

    // protocol:db://ip:port/db_name
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_tutorial";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    @Override
    public Book save(Book book) {
        String query = "INSERT INTO book (title, author, publish_date) VALUES (?, ?, ?)";
        // try (resources;) {
        // } catch () {
        // }
        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)
        ) {
            // connect (create connection)

            // query (create statement: query / update)
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setString(3, String.valueOf(book.getPublishDate()));

            // process result (result set)
            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("creating failed, no rows affected");
            }

            // grab the returned index and put it on the book.id property
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    book.setId(generatedKeys.getLong(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
    }

    @Override
    public int saveLongVersion(Book book) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            // connect (create connection)
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // query (create statement: query / update)
            String query = "INSERT INTO book (title, author, publish_date) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setString(3, String.valueOf(book.getPublishDate()));

            // process result (result set)
            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("creating failed, no rows affected");
            }

            result = affectedRows;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // close (close resources)
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println("failed to close statement");
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.printf("failed to close connection");
            }
        }

        return result;
    }

    @Override
    public List<Book> findAll() {
        String query = "SELECT * FROM book";
        List<Book> result = new ArrayList<>();
        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery(query)
        ) {
            // iterate result set and grab data
            while (resultSet.next()) {
                // create book from data and add to list
                Book bookInDb = new Book();
                bookInDb.setId(resultSet.getLong(1));
                bookInDb.setTitle(resultSet.getString(2));
                bookInDb.setAuthor(resultSet.getString(3));
                bookInDb.setPublishDate(resultSet.getDate(4).toLocalDate());

                result.add(bookInDb);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // return a list of books
        return result;
    }

    @Override
    public void deleteById(Long id) {
        String query = "DELETE FROM book WHERE id = ?";
        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            statement.setLong(1, id);

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("deleting failed, no rows affected");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
