package com.kodilla.bookslibrary.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "BOOKS")
public final class Books {

    private int id;
    private String title;
    private String author;
    private LocalDate releaseDate;

    public Books() {}

    public Books(final String name, final String author, final LocalDate releaseDate) {
        this.title = name;
        this.author = author;
        this.releaseDate = releaseDate;
    }

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

    @Column(name = "TITLE")
    @NotNull
    public String getName() {
        return title;
    }

    public void setName(String name) {
        this.title = name;
    }

    @Column(name = "AUTHOR")
    @NotNull
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column(name = "RELEASEDATE")
    @NotNull
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Books books = (Books) o;
        return id == books.id && Objects.equals(title, books.title) && Objects.equals(author, books.author) && Objects.equals(releaseDate, books.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, releaseDate);
    }

    @Override
    public String toString() {
        return "Book " +
                "nr: " + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", releaseDate=" + releaseDate;
    }
}
