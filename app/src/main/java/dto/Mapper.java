package dto;

import model.Book;
import model.Library;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
    public static Book bookDTO2book( BookDTO BOOKDTO) {
        Book book = new Book();
        String title = new String(BOOKDTO.getName());
        book.setName(title);
        book.setIsbn(BOOKDTO.getIsbn());
        book.setIcon(BOOKDTO.getIcon());
        book.setRiview(BOOKDTO.getRiview());
        return book;
    }

    public static Library libraryDTO2livrary(LibraryDTO libraryDTO) throws NullPointerException{
        List<Book> books = new ArrayList<>();
        List<BookDTO> booksDTO = libraryDTO.getBookDTOS();
        for (BookDTO bookDTO : booksDTO){
            Book book = bookDTO2book(bookDTO);
            books.add(book);
        }
        Library res = new Library(libraryDTO.getName(),books);
        return res;
    }


}


