package com.example.eliad.impact1.lib;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;



/**
 * Created by asafjonathan on 30/08/16.
 */
public class Deposit {

    private String amount ;
    private String date;
    private String id ;

    public static  ArrayList<Deposit>list = new ArrayList<Deposit>();

    public Deposit (String id, String amount, String date){
        this.id = id;
        this.amount = amount;
        this.date = date;

    }


    public static ArrayList<Deposit> getList() {
        return list;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public static void setDeposits (String deposits) {
        JSONArray jArray = null;
        JSONObject json_data;
        try {
            jArray = new JSONArray(deposits);
        } catch (JSONException e) {

            e.printStackTrace();
        }
        for (int i = 0; i < jArray.length(); i++) {
            try {

                json_data = jArray.getJSONObject(i);
                String id = json_data.getString("id");
                String amount = json_data.getString("amnout");
                String date = json_data.getString("date");
                Deposit deposit = new Deposit(id, amount, date);
                list.add(deposit);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }


}
