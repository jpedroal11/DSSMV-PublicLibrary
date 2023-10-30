package model;

import android.graphics.Bitmap;

public class Book {

    private String title;
    private Author author;
    private String isbn;
    private String description;
    private Bitmap icon;
    private String numberOfPages;
    private String publishDate;
    private Review review;

    public Book(){}

    public Book(String title, Author author, String isbn, String description, Bitmap icon, String numberOfPages, String publishDate, Review review) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.description = description;
        this.icon = icon;
        this.numberOfPages = numberOfPages;
        this.publishDate = publishDate;
        this.review = review;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public String getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(String numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {this.review = review;}

    public Bitmap getIcon() {
        return icon;
    }
}

