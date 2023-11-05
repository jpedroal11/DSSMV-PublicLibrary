package DTO;

import android.graphics.Bitmap;
import model.Author;
import model.Book;
import model.Review;

public class BookDTO {

    private String title;
    private Author author;
    private String isbn;
    private String description;
    private Bitmap icon;
    private String numberOfPages;
    private String publishDate;
    private Review review;


    public BookDTO(){}

    public BookDTO(String title, Author author, String isbn, String description, Bitmap icon, String numberOfPages, String publishDate, Review review) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.description = description;
        this.icon = icon;
        this.numberOfPages = numberOfPages;
        this.publishDate = publishDate;
        this.review = review;
    }


    public static Book bookDTO2book(BookDTO BOOKDTO) {
        Book book = new Book();
        book.setTitle(BOOKDTO.getTitle());
        book.setIsbn(BOOKDTO.getIsbn());
        book.setIcon(BOOKDTO.getIcon());
        book.setReview(BOOKDTO.getReview());
        return book;
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

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
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

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}


