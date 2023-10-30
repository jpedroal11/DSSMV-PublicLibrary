package DTO;

import android.graphics.Bitmap;
import model.Book;
import model.Review;

public class BookDTO {

    private String title;

    private String isbn;

    private Review review;

    private Bitmap icon;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }

    public static Book bookDTO2book(BookDTO BOOKDTO) {
        Book book = new Book();
        String title = new String(BOOKDTO.getTitle());
        book.setTitle(title);
        book.setIsbn(BOOKDTO.getIsbn());
        book.setIcon(BOOKDTO.getIcon());
        book.setReview(BOOKDTO.getReview());
        return book;
    }
}


