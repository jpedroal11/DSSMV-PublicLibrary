package dto;

import android.graphics.Bitmap;
import model.Book;

public class BookDTO {

    private String Name;

    private String Isbn;

    private String Riview;

    private Bitmap Icon;


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getIsbn() {
        return Isbn;
    }

    public void setIsbn(String isbn) {
        Isbn = isbn;
    }

    public String getRiview() {
        return Riview;
    }

    public void setRiview(String riview) {
        Riview = riview;
    }

    public Bitmap getIcon() {
        return Icon;
    }

    public void setIcon(Bitmap icon) {
        Icon = icon;
    }
    public static Book bookDTO2book(BookDTO BOOKDTO) {
        Book book = new Book();
        String title = new String(BOOKDTO.getName());
        book.setName(title);
        book.setIsbn(BOOKDTO.getIsbn());
        book.setIcon(BOOKDTO.getIcon());
        book.setRiview(BOOKDTO.getRiview());
        return book;
    }
}


