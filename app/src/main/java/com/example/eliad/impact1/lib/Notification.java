package com.example.eliad.impact1.lib;

import com.example.eliad.impact1.Scolar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Eliad on 01/09/2016.
 */
public class Notification {

    private String fname;
    private String lname;
    private String date;
    private String message;
    private String id;




    public static ArrayList<Notification> list = new ArrayList<Notification>();

    public Notification(String id, String fname,String lname,String message, String date){
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.date = date;
        this.message=message;

    }


    public static ArrayList<Notification> getList() {
        return list;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public static void setNotification(String houre1) {
        JSONArray jArray = null;
        JSONObject json_data;
        try {
            jArray = new JSONArray(houre1);
        } catch (JSONException e) {

            e.printStackTrace();
        }
        for (int i = 0; i < jArray.length(); i++) {
            try {

                json_data = jArray.getJSONObject(i);
                String id = json_data.getString("id");
                String fname = json_data.getString("fname");
                String date = json_data.getString("date");
                String lname = json_data.getString("lname");
                String message = json_data.getString("message");
                Notification notification = new Notification(id, fname, lname, message, date);
                list.add(notification);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static void clearList() {
        list=new ArrayList<Notification>();
    }
}
