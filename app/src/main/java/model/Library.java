package model;

import android.graphics.Bitmap;

import java.util.List;

public class Library {

    private String address;
    private String id;
    private String name;
    private Boolean open;
    private String openDays;
    private String openStatement;
    private List books;



    public Library(String Name, List<Book> books) {
        this.name= name;
        this.books = books;
    }


    public String getAddress() {
        return address;
    }

    public List getBooks() {
        return books;
    }

    public void setBooks(List books) {
        this.books = books;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public String getOpenDays() {
        return openDays;
    }

    public void setOpenDays(String openDays) {
        this.openDays = openDays;
    }

    public String getOpenStatement() {
        return openStatement;
    }

    public void setOpenStatement(String openStatement) {
        this.openStatement = openStatement;
    }
}
