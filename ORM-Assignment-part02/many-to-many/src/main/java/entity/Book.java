package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.List;

@Entity
public class Book {
    @Id
    private String isbn;
    private String title;
    private int pages;
    private double price;
    @ManyToMany(mappedBy = "books")
    private List<Author> authors;

    public Book(){}

    public Book(String isbn, String title, int pages, double price, List<Author> authors) {
        this.isbn = isbn;
        this.title = title;
        this.pages = pages;
        this.price = price;
        this.authors = authors;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}