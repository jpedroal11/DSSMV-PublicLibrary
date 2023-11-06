package DTO;

import model.Book;
import model.Library;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
    public static Book bookDTO2book( BookDTO BOOKDTO) {
        Book book = new Book();
        book.setTitle(BOOKDTO.getTitle());
        book.setIsbn(BOOKDTO.getIsbn());
        book.setIcon(BOOKDTO.getIcon());
        book.setReview(BOOKDTO.getReview());
        return book;
    }

    public static Library libraryDTO2Library(LibraryDTO libraryDTO) throws NullPointerException{
        List<Book> books = new ArrayList<>();
        List<BookDTO> booksDTO = libraryDTO.getBookDTOS();
        for (BookDTO bookDTO : booksDTO){
            Book book = bookDTO2book(bookDTO);
            books.add(book);
        }
        Library res = new Library(libraryDTO.getName(),books);
        return res;
    }

    public static List<Book> listInstructorDTO2listInstructor(List<BookDTO>  list) throws NullPointerException {
        List<Book> data = new ArrayList();
        for (BookDTO obj : list) {
            Book i = bookDTO2book(obj);
            data.add(i);
        }
        return data;
    }
}


