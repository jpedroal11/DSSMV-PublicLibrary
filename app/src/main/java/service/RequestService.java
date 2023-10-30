package service;
import DTO.LibraryDTO;
import DTO.Mapper;
import  model.Library;
import network.HttpOperation;
import handler.JsonHandler;


public class RequestService {

    public static Library getLibraryBook(String urlStr) {
        LibraryDTO libraryDTO = _getLibraryBook(urlStr);
        Library library= Mapper.libraryDTO2livrary(libraryDTO);
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
    }

}


