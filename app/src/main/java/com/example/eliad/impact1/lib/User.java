package com.example.eliad.impact1.lib;

/**
 * Created by asafjonathan on 30/08/16.
 */

import org.json.JSONException;
import org.json.JSONObject;
public class User  extends  UserSession{

    private static String id;
    private static String fname;
    private static String lname;
    private static String email;
    private static String university;
    private static String city;
    private static String address;
    private static String mobile ;
    public static boolean isLogin = false;


    public static String getUniversity() {
        return university;
    }

    public static void setUniversity(String university) {
        User.university = university;
    }

    public static String getCity() {
        return city;
    }

    public static void setCity(String city) {
        User.city = city;
    }

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        User.address = address;
    }

    public static String getMobile() {
        return mobile;
    }

    public static void setMobile(String mobile) {
        User.mobile = mobile;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        User.id = id;
    }

    public static String getFname() {
        return fname;
    }

    public static void setFname(String fname) {
        User.fname = fname;
    }

    public static String getLname() {
        return lname;
    }

    public static void setLname(String lname) {
        User.lname = lname;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        User.email = email;
    }

    public  static void setUser (String user){
        JSONObject userObj = null;
        try {
            userObj = new JSONObject(user);

            User.setId(userObj.getString("id"));
            User.setFname(userObj.getString("fname"));
            User.setLname(userObj.getString("lname"));
            User.setCity(userObj.getString("city"));
            User.setUniversity(userObj.getString("university"));
            User.setAddress(userObj.getString("address"));
            User.setMobile(userObj.getString("mobile"));
            User.setEmail(userObj.getString("email"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public static void logOut (){
        User.isLogin = false;
        User.setId(null);
        User.setFname(null);
        User.setLname(null);
        User.setAddress(null);
        User.setMobile(null);
        User.setCity(null);
        User.setUniversity(null);
    }

}
