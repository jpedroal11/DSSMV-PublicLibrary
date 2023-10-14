package service;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import pt.caf_pbs.schooldiskclient.dto.*;
import handler.JsonHandler;
import handler.NetworkHandler;
import helper.Utils;

import java.util.List;

public class RequestsService {
    public static String lastUrl;
    public static SchoolInfo getSchoolInfo(Context c) {
        try{
            String url = Utils.getWSAddress(c)+"school/version";
            String json = NetworkHandler.getDataInStringFromUrl(url);
            lastUrl = url;
            SchoolInfoDTO schoolInfoDTO = JsonHandler.deSerializeJson2SchoolInfoDTO(json);
            SchoolInfo data = Mapper.schoolInfoDTO2SchoolInfo(schoolInfoDTO);
            return  data ;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Instructor> getInstructors(Activity c) {
        try{
            String url = Utils.getWSAddress(c)+"instructor";
            lastUrl = url;
            String json = NetworkHandler.getDataInStringFromUrl(url);
            List<InstructorDTO> instructorDTOS = JsonHandler.deSerializeJson2ListInstructorDTO(json);
            List<Instructor> instructors = Mapper.listInstructorDTO2listInstructor(instructorDTOS);
            return instructors;
        }
        catch(Exception e){
            e.printStackTrace();
            c.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(c, "getInstructors Error"+e.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        return null;
    }

    public static void addInstructor(InstructorDTO instuctorDTO, Activity activity) {
        try{
            String url = Utils.getWSAddress(activity)+"instructor";
            lastUrl = url;
            String json = JsonHandler.serializeInstructorDTO2Json(instuctorDTO);
            String result = NetworkHandler.addDataInStringFromUrl(url, json);
        }catch(Exception e){
            e.printStackTrace();
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(activity, "addInstructor Error"+e.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public static void updateInstructor(String currentInitials, InstructorDTO instuctorDTO, Activity activity) {
        try{
            String url = Utils.getWSAddress(activity)+"instructor/"+currentInitials;
            lastUrl = url;
            String json = JsonHandler.serializeInstructorDTO2Json(instuctorDTO);
            String result = NetworkHandler.updateDataInStringFromUrl(url, json);
        }catch(Exception e){
            e.printStackTrace();
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(activity, "updateInstructor Error"+e.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public static void deleteInstructor(String currentInitials, Activity activity) {
        try{
            String url = Utils.getWSAddress(activity)+"instructor/"+currentInitials;
            lastUrl = url;
            NetworkHandler.deleteDataInStringFromUrl(url);
        }catch(Exception e){
            e.printStackTrace();
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(activity, "deleteInstructor Error"+e.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    public static List<Subject> getSubjects(Activity activity) {
        try{
            String url = Utils.getWSAddress(activity)+"subject";
            lastUrl = url;
            String json = NetworkHandler.getDataInStringFromUrl(url);
            List<SubjectDTO> listDTOS = JsonHandler.deSerializeJson2ListSubjectDTO(json);
            List<Subject> subjects = Mapper.listSubjectDTO2listSubject(listDTOS);
            return subjects;
        }
        catch(Exception e){
            e.printStackTrace();
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(activity, "getSubjects Error"+e.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        return null;
    }

    public static List<Subject> getInstructorLectures(String id, Activity activity) {
        try{
            String url = Utils.getWSAddress(activity)+"instructor/"+id+"/lecture";
            lastUrl = url;
            String json = NetworkHandler.getDataInStringFromUrl(url);
            List<LectureDTO> listDTOS = JsonHandler.deSerializeJson2ListLectureDTO(json);
            List<Subject> subjects = Mapper.listLectureDTO2listSubject(listDTOS);
            return subjects;
        }
        catch(Exception e){
            e.printStackTrace();
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(activity, "getInstructorLectures Error"+e.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        return null;
    }

    public static void addInstructorLecture(String id, LectureDTO lectureDTO, Activity activity) {
        try{
            String url = Utils.getWSAddress(activity)+"instructor/"+id+"/lecture";
            lastUrl = url;
            String json = JsonHandler.serializeLectureDTO2Json(lectureDTO);
            String result = NetworkHandler.addDataInStringFromUrl(url, json);
        }catch(Exception e){
            e.printStackTrace();
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(activity, "addInstructorLecture Error"+e.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
