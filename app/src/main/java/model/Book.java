package model;

import android.graphics.Bitmap;

public class Book {

    private String title;
    private String author;
    private String isbn;
    private String description;
    private Bitmap Icon;
    private String numberOfPages;
    private String publishDate;

    private String Riview;

    private String Name;

    public Book() {

    }

    public Book(String title, String author, String isbn, String description, Bitmap icon, String numberOfPages, String publishDate) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.description = description;
        this.Icon = icon;
        this.numberOfPages = numberOfPages;
        this.publishDate = publishDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = Name;
    }

    public void setIcon(Bitmap Icon) {
        Icon = Icon;
    }

    public String getRiview() {
        return Riview;
    }

    public void setRiview(String riview) {
        Riview = riview;
    }
}

