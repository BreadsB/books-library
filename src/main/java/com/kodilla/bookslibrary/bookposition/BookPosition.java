package com.kodilla.bookslibrary.bookposition;

import com.kodilla.bookslibrary.book.Books;
import com.kodilla.bookslibrary.rents.Rents;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamedQueries({
        @NamedQuery(
                name = "BookPosition.retrieveLostBooks",
                query = "FROM BookPosition WHERE status LIKE 'LOST'"
        ),
        @NamedQuery(
                name = "BookPosition.retrieveRentedBooks",
                query = "FROM BookPosition WHERE status LIKE 'RENTED'"
        ),
        @NamedQuery(
                name = "BookPosition.retrieveBooksByStatus",
                query = "FROM BookPosition WHERE status LIKE upper(:STATUS)"
        )
})

@Entity
@Table(name = "BOOKPOSITION")
public class BookPosition {

    private int id;
    private String status; // Instead of String put here ENUM

    private Books books;

    private Rents rents;

    public BookPosition(String status) {
        this.status = status;
    }

    public BookPosition() {}

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "BOOK_ID", referencedColumnName = "id")
    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "bookPosition")
    public Rents getRents() {
        return rents;
    }

    public void setRents(Rents rents) {
        this.rents = rents;
    }
}