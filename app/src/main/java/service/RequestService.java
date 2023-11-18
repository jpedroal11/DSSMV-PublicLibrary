package service;
import DTO.BookDTO;
import DTO.LibraryBookDTO;
import DTO.LibraryDTO;
import DTO.Mapper;
import android.app.Activity;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.example.dssmv_1211066_1210939.LibraryActivity;
import helper.Utils;
import model.Book;
import  model.Library;

import handler.JsonHandler;
import handler.NetworkHandler;
import model.LibraryBook;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


public class RequestService {

    public static String lastUrl;

    public static List<Library> getLibraries(Activity c){
        try{
            String url = Utils.getWSAddress(c)+"library";
            lastUrl = url;
            String json = NetworkHandler.getDataInStringFromUrl(url);
            Log.d("json1", json);
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

    public static Library getLibrary(Activity c, String libraryId) {
        try{
            String url = Utils.getWSAddress(c)+"library/" + libraryId;
            lastUrl = url;
            String json = NetworkHandler.getDataInStringFromUrl(url);
            LibraryDTO libraryDTO = JsonHandler.deSerializeJson2LibraryDTO(json);
            Library library = Mapper.libraryDTO2Library(libraryDTO);
            return library;
        }
        catch (Exception e){
            e.printStackTrace();
            c.runOnUiThread(new Runnable() {
                @Override
                public void run(){
                    Toast.makeText(c, "getLibrary Error"+e.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        return null;
    }


    public static void createLibrary(LibraryDTO libraryDTO, Activity activity) {
        try{
            String url = Utils.getWSAddress(activity)+"library";
            lastUrl = url;
            String json = JsonHandler.serializeLibraryDTO2Json(libraryDTO);
            String result = NetworkHandler.addDataInStringFromUrl(url, json);
        }catch(Exception e){
            e.printStackTrace();
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(activity, "createLibrary Error"+e.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public static void deleteLibrary(String id, Activity activity) {
        try{
            String url = Utils.getWSAddress(activity)+"library/"+id;
            lastUrl = url;
            NetworkHandler.deleteDataInStringFromUrl(url);
        }catch(Exception e){
            e.printStackTrace();
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(activity, "deleteLibrary Error"+e.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public static void updateLibrary(String id, LibraryDTO libraryDTO, Activity activity) {
        try{
            String url = Utils.getWSAddress(activity)+"library/"+id;
            lastUrl = url;
            String json = JsonHandler.serializeLibraryDTO2Json(libraryDTO);
            String result = NetworkHandler.updateDataInStringFromUrl(url, json);
        }catch(Exception e){
            e.printStackTrace();
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(activity, "updateLibrary Error"+e.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public static List<LibraryBook> getLibraryBooks(Activity c, String libraryId) {
        try{
            String url = Utils.getWSAddress(c)+"library"+ libraryId +"/books";
            lastUrl = url;
            String json = NetworkHandler.getDataInStringFromUrl(url);
            List<LibraryBookDTO> libraryBookDTOS = JsonHandler.deSerializeJson2ListLibraryBookDTO(json);
            List<LibraryBook> libraryBooks = Mapper.listLibraryBookDTO2listLibraryBook(libraryBookDTOS);
            return libraryBooks;
        }
        catch (Exception e){
            e.printStackTrace();
            c.runOnUiThread(new Runnable() {
                @Override
                public void run(){
                    Toast.makeText(c, "getLibraryBooks Error"+e.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        return null;
    }



}


