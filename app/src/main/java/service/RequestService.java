package service;
import DTO.BookDTO;
import DTO.LibraryDTO;
import DTO.Mapper;
import android.app.Activity;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.example.dssmv_1211066_1210939.LibraryActivity;
import helper.Utils;
import model.Book;
import  model.Library;

import handler.JsonHandler;
import handler.NetworkHandler;

import java.util.List;


public class RequestService {

    public static String lastUrl;

    public static List<Library> getLibraries(Activity c){
        try{
            String url = Utils.getWSAddress(c)+"library";
            lastUrl = url;
            String json = NetworkHandler.getDataInStringFromUrl(url);
            List<LibraryDTO> libraryDTOS = JsonHandler.deSerializeJson2ListLibraryDTO(json);
            List<Library> libraries = Mapper.listLibraryDTO2listLibrary(libraryDTOS);
            return libraries;
        }
        catch (Exception e){
            e.printStackTrace();
            c.runOnUiThread(new Runnable() {
                @Override
                public void run(){
                    Toast.makeText(c, "getLibraries Error"+e.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        return null;
    }









    /*public static Library getLibraryBook(String urlStr) {
        LibraryDTO libraryDTO = _getLibraryBook(urlStr);
        Library library= Mapper.libraryDTO2Library(libraryDTO);
        return library;
    }

    private static LibraryDTO _getLibraryBook (String urlStr){
        LibraryDTO library =null;
        try{

            String jsonString = HttpOperation.get(urlStr);
            library = JsonHandler.deSerializeJson2LibraryDTO(jsonString);

        }catch (Exception e) {
            e.printStackTrace();
        }
        return library;
    }*/

    /*public static List<Book> getBooks(Activity c) {
        try{
            String url = Utils.getWSAddress(c)+"book";
            lastUrl = url;
            String json = NetworkHandler.getDataInStringFromUrl(url);
            List<BookDTO> bookDTOS = JsonHandler.deSerializeJsonToListBookDTO(json);
            List<Book> books = Mapper.listInstructorDTO2listInstructor(bookDTOS);
            return books;
        }
        catch(Exception e){
            e.printStackTrace();
            c.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(c, "getBooks Error"+e.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        return null;
    }*/




}


