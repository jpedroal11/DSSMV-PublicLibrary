package handler;
import java.util.ArrayList;

import DTO.LibraryBookDTO;
import DTO.ReviewDTO;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import model.*;
import model.CoverUrls;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import DTO.LibraryDTO;
import DTO.BookDTO;
import java.util.ArrayList;
import java.util.List;

public class JsonHandler {

    public static LibraryDTO deSerializeJson2LibraryDTO(String resp) throws JSONException {
        LibraryDTO data = new LibraryDTO();
        JSONObject mResponseObject = new JSONObject(resp);
        data.setAddress(mResponseObject.getString("address"));
        data.setId(mResponseObject.getString("id"));
        data.setName(mResponseObject.getString("name"));
        data.setOpen(mResponseObject.getBoolean("open"));
        data.setOpenDays(mResponseObject.getString("openDays"));
        data.setOpenStatement(mResponseObject.getString("openStatement"));
        data.setOpenTime(mResponseObject.getString("openTime"));
        data.setCloseTime(mResponseObject.getString("closeTime"));

        return data;
    }

    public static String serializeLibraryDTO2Json(LibraryDTO obj) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("address", obj.getAddress());
        jsonObject.put("closeTime", obj.getCloseTime());
        jsonObject.put("name", obj.getName());
        jsonObject.put("open", obj.getOpen());
        jsonObject.put("openDays", obj.getOpenDays());
        jsonObject.put("openStatement", obj.getOpenStatement());
        jsonObject.put("openTime", obj.getOpenTime());

        return jsonObject.toString();
    }

    public static List<LibraryDTO> deSerializeJson2ListLibraryDTO(String resp) throws JSONException {
        JSONArray jsonResponse = new JSONArray(resp);
        List<LibraryDTO> list = new ArrayList<>();
        for(int i = 0; i<jsonResponse.length();i++){
            JSONObject jsonChildNode = jsonResponse.getJSONObject(i);
            String address = jsonChildNode.optString("address");
            String name = jsonChildNode.optString("name");
            String id = jsonChildNode.optString("id");
            boolean open = jsonChildNode.optBoolean("open");
            String openDays = jsonChildNode.optString("openDays");
            String openStatement = jsonChildNode.optString("openStatement");
            String openTime = jsonChildNode.optString("openTime");
            String closeTime = jsonChildNode.optString("closeTime");

            list.add(new LibraryDTO(address , id, name, open, openDays, openStatement, openTime, closeTime));
        }
        return list;
    }


    public static List<LibraryBookDTO> deSerializeJson2ListLibraryBookDTO(String resp) throws JSONException {
        JSONArray jsonResponse = new JSONArray(resp);
        List<LibraryBookDTO> list = new ArrayList<>();
        for(int i = 0; i<jsonResponse.length();i++){
            JSONObject jsonChildNode = jsonResponse.getJSONObject(i);
            int available = jsonChildNode.getInt("available");
            Book book = (Book) jsonChildNode.get("book");
            int checkedOut = jsonChildNode.getInt("checkedOut");
            String isbn = jsonChildNode.optString("isbn");
            Library library = (Library) jsonChildNode.get("library");
            int stock = jsonChildNode.getInt("stock");

            list.add(new LibraryBookDTO(available, book, checkedOut, isbn, library, stock));
        }
        return list;
    }


    private static List<String> getListFromJsonArray(JSONArray jsonArray) throws JSONException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            list.add(jsonArray.getString(i));
        }
        return list;
    }



}