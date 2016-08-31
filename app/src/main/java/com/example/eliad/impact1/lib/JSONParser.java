package com.example.eliad.impact1.lib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class JSONParser {

    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";
    Context context;
    // constructor
    public JSONParser() {

    }

    public JSONParser(Context context) {
        this.context=context;
    }


    public InputStream OpenHttpConnection(String urlString) throws IOException {
        InputStream in = null;
        int responce = -1;

        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();


        if (!(conn instanceof HttpURLConnection))
            throw new IOException("Not an Http connection");

        try {
            HttpURLConnection httpConn = (HttpURLConnection) conn;
            httpConn.setAllowUserInteraction(false);
            httpConn.setInstanceFollowRedirects(true);
            httpConn.setRequestMethod("POST");
            //httpConn.setDoInput(true);
            httpConn.connect();

            //int length = httpConn.getContentLength();
            responce = httpConn.getResponseCode();
            if (responce == HttpURLConnection.HTTP_OK) {
                in = httpConn.getInputStream();

            }//httpConn.setRequestProperty(field, newValue)

        }catch(Exception ex) {
            ex.printStackTrace();
            throw new IOException("Error Connecting");
        }
        return in;
    }

    public Bitmap DownloadImage(String url) {
        Bitmap bitmap = null;
        InputStream in = null;

        try {
            in = OpenHttpConnection(url);
            bitmap = BitmapFactory.decodeStream(in);
            in.close();
        }catch(IOException e1) {

        }
        return bitmap;
    }



    // function get json from url
    // by making HTTP POST or GET mehtod
    public JSONObject makeHttpRequest(String url, String method,List<NameValuePair> params) {

        // Making HTTP request
        try {

            // check for request method
            if(method == "POST"){
                // request method is POST
                // defaultHttpClient
                DefaultHttpClient httpClient = new DefaultHttpClient();

                HttpPost httpPost = new HttpPost(url);
                httpPost.setEntity(new UrlEncodedFormEntity(params, "utf-8"));

//                httpPost.setEntity(new UrlEncodedFormEntity(params));


                HttpResponse httpResponse = httpClient.execute(httpPost);
                HttpEntity httpEntity = httpResponse.getEntity();
                is = httpEntity.getContent();


            }else if(method == "GET"){

                // request method is GET
                DefaultHttpClient httpClient = new DefaultHttpClient();
                String paramString = URLEncodedUtils.format(params, "utf-8");
                url += "?" + paramString;
                HttpGet httpGet = new HttpGet(url);

                HttpResponse httpResponse = httpClient.execute(httpGet);
                HttpEntity httpEntity = httpResponse.getEntity();
                is = httpEntity.getContent();
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();

        }

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            json = sb.toString();

        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }

        // try parse the string to a JSON object
        try {
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }

        // return JSON String

        return jObj;

    }
}