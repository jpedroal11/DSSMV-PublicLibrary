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

}


