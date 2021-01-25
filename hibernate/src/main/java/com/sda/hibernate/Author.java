package com.sda.hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQuery(
        name = "Author.findAuthorsWithBookPriceJoinFetch",
        query = "SELECT a FROM Author a JOIN FETCH a.books b WHERE b.price = :price"
)
// POJO - plain old java object
// POCO - plain old class object
@Entity(name = "Author")    // defines entity Author
@Table(name = "author") // maps to table author
public class Author {

    @Id // defines id column
    @GeneratedValue(strategy = GenerationType.AUTO) // define auto increment strategy
    private Long id;

    @Column(name = "author_name")   // change the name of the column
    private String authorName;

    @OneToMany(
            mappedBy = "author",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

    // needed by hibernate
    public Author() {
    }

    public Author(String authorName) {
        this.authorName = authorName;
    }

    // getter setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                '}';
    }

    public void addBook(Book book) {
        books.add(book);        // add child to parent
        book.setAuthor(this);   // add parent to child
    }

    public void removeBook(Book book) {
        books.remove(book);
        book.setAuthor(null);
    }
}
