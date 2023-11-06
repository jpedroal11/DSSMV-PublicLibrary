package handler;
import java.util.ArrayList;

import DTO.ReviewDTO;
import android.graphics.Bitmap;
import model.Author;
import model.LocalTime;
import model.Review;
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
        //Create closeTime object
        data.setCloseTime(mResponseObject.getJSONObject("closeTime").getInt("hour")
                ,mResponseObject.getJSONObject("closeTime").getInt("minute")
                ,mResponseObject.getJSONObject("closeTime").getInt("nano")
                ,mResponseObject.getJSONObject("closeTime").getInt("second"));
        data.setId(mResponseObject.getString("id"));
        data.setName(mResponseObject.getString("name"));
        data.setOpen(mResponseObject.getBoolean("open"));
        data.setOpenDays(mResponseObject.getString("openDays"));
        data.setOpenStatement(mResponseObject.getString("openStatement"));
        //Create openTime object
        data.setOpenTime(mResponseObject.getJSONObject("openTime").getInt("hour")
                ,mResponseObject.getJSONObject("openTime").getInt("minute")
                ,mResponseObject.getJSONObject("openTime").getInt("nano")
                ,mResponseObject.getJSONObject("openTime").getInt("second"));

        return data;
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
            //Create a new object through a new JSONObject instance
            JSONObject _jsonChildNode = jsonChildNode.optJSONObject("closeTime");
            int hour = _jsonChildNode.optInt("hour");
            int minute = _jsonChildNode.optInt("minute");
            int nano = _jsonChildNode.optInt("nano");
            int second = _jsonChildNode.optInt("second");
            LocalTime closeTime = new LocalTime(hour, minute,nano,second);
            //Create a new object through a new JSONObject instance
            _jsonChildNode = jsonChildNode.optJSONObject("openTime");
            hour = _jsonChildNode.optInt("hour");
            minute = _jsonChildNode.optInt("minute");
            nano = _jsonChildNode.optInt("nano");
            second = _jsonChildNode.optInt("second");
            LocalTime openTime = new LocalTime(hour, minute,nano,second);

            list.add(new LibraryDTO(address , id, name, open, openDays, openStatement, openTime, closeTime));
        }
        return list;
    }


}