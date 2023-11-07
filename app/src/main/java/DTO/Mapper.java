package DTO;

import model.Book;
import model.Library;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
    public static List<Library> listLibraryDTO2listLibrary(List<LibraryDTO>  list) throws NullPointerException {
        List<Library> data = new ArrayList();
        for(LibraryDTO obj : list){
            Library i = libraryDTO2Library(obj);
            data.add(i);
        }
        return data;
    }

    private static Library libraryDTO2Library(LibraryDTO obj) {

        Library data = new Library(obj.getAddress(), obj.getId(), obj.getName(), obj.getOpen(), obj.getOpenDays(), obj.getOpenStatement(), obj.getOpenTime(), obj.getCloseTime());
        return data;

    }

    /*public static Book bookDTO2book( BookDTO BOOKDTO) {
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
    }*/

}


