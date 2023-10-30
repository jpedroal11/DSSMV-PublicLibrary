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
    private LocalTime openTime;
    private LocalTime closeTime;
    private List books;


    public Library(String Name, List<Book> books) {
        this.name= name;
        this.books = books;
    }

    public Library(String address, String id, String name, Boolean open, String openDays, String openStatement, LocalTime openTime, LocalTime closeTime, List books) {
        this.address = address;
        this.id = id;
        this.name = name;
        this.open = open;
        this.openDays = openDays;
        this.openStatement = openStatement;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.books = books;
    }


    public String getAddress() {return address;}

    public List getBooks() {return books;}

    public void setBooks(List books) {this.books = books;}

    public void setAddress(String address) {this.address = address;}

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public Boolean getOpen() {return open;}

    public void setOpen(Boolean open) {this.open = open;}

    public String getOpenDays() {return openDays;}

    public void setOpenDays(String openDays) {this.openDays = openDays;}

    public String getOpenStatement() {return openStatement;}

    public void setOpenStatement(String openStatement) {this.openStatement = openStatement;}

    public LocalTime getOpenTime() {return openTime;}

    public void setOpenTime(LocalTime openTime) {this.openTime = openTime;}

    public LocalTime getCloseTime() {return closeTime;}

    public void setCloseTime(LocalTime closeTime) {this.closeTime = closeTime;}

}
