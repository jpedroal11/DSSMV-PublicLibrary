package dto;

import java.util.List;

public class LibraryDTO {

    private String address;
    private String id;
    private String name;
    private Boolean open;
    private String openDays;
    private String openStatement;
    private List books;

    public List<BookDTO> getBookDTOS() {
        return books; // TA MALLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
