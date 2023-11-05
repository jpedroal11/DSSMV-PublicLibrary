package handler;
import java.util.ArrayList;

import DTO.ReviewDTO;
import model.Review;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import DTO.LibraryDTO;
import DTO.BookDTO;
import java.util.ArrayList;
import java.util.List;

public class JsonHandler {

        public static LibraryDTO deSerializeJsonToLibraryInformationDTO(String resp) throws JSONException {
            LibraryDTO data = new LibraryDTO();
            JSONObject mResponseObject = new JSONObject(resp);
            data.setName(mResponseObject.getString("name"));
            data.setAddress(mResponseObject.getString("address"));
            data.setOpenTime(mResponseObject.getString("openTime"));
            data.setCloseTime(mResponseObject.getString("closeTime"));
            data.setOpenDays(mResponseObject.getString("openDays"));
            return data;
        }
        /*public static String serializeStockDTOToJson(StockDTO obj) throws JSONException {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("stock", obj.getStock());
            return jsonObject.toString();

        }*/
        public static List<BookDTO> deSerializeJsonToListBookDTO(String resp) throws JSONException {
            JSONArray jsonResponse = new JSONArray(resp);
            List<BookDTO> list = new ArrayList<>();
            for(int i = 0; i<jsonResponse.length();i++){
                String author = "";
                JSONObject jsonChildNode = jsonResponse.getJSONObject(i);
                String stock = jsonChildNode.optString("stock");
                String isbn = jsonChildNode.optString("isbn");
                JSONObject _jsonChildNode = jsonChildNode.optJSONObject("book");
                String title = _jsonChildNode.optString("title");
                JSONArray __jsonChildNode = _jsonChildNode.optJSONArray("authors");--
                for (int j = 0; j < __jsonChildNode.length() ; j++){
                    JSONObject json = __jsonChildNode.getJSONObject(j);
                    if (j==0) {
                        author = json.optString("name");
                    }
                }

                list.add(new BookDTO(isbn, title, author, stock));
            }
            return list;
        }

        public static String serializeAddReviewDTO2Json(ReviewDTO obj) throws JSONException {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("recommended", obj.getRecommended());
            jsonObject.put("review", obj.getReview());
            return jsonObject.toString();

        }
        public static List<ReviewDTO> deSerializeJson2ListCommentDTO(String resp) throws JSONException {
            JSONArray jsonResponse = new JSONArray(resp);
            List<ReviewDTO> list = new ArrayList<>();
            for(int i = 0; i<jsonResponse.length();i++){
                JSONObject jsonChildNode = jsonResponse.getJSONObject(i);
                Boolean recommended = jsonChildNode.getBoolean("recommended");
                String opinion = jsonChildNode.optString("review");
                String isbn = jsonChildNode.optString("isbn");
                String userId = jsonChildNode.optString("reviewer");
                list.add(new ReviewDTO(recommended, opinion, isbn, userId));
            }
            return list;
        }
        public static ReviewDTO deSerializeJson2CommentDTO(String resp) throws JSONException {
            ReviewDTO data = new ReviewDTO();
            JSONObject mResponseObject = new JSONObject(resp);
            data.setRecommended(mResponseObject.getBoolean("recommended"));
            data.setReview(mResponseObject.getString("review"));
            data.setIsbn(mResponseObject.getString("isbn"));
            data.setReviewer(mResponseObject.getString("reviewer"));
            return data;
        }

        /*public static String serializeStockDTO2Json(StockDTO obj) throws JSONException {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("stock", obj.getStock());
            return jsonObject.toString();

        }*/
}