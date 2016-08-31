package com.example.eliad.impact1.lib;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.eliad.impact1.ScolarGridViewActivity;
import com.example.eliad.impact1.letter;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


    public class Api extends AsyncTask<String, String, String> {
        private HashMap<String, String> valuse = new HashMap<String, String>();
        private int action;
        private Context context;
        private ProgressDialog pDialog;
        private JSONParser jsonParser;
        private JSONObject jsonObj = null;
        private JSONArray jArray;
        private JSONObject pages_obj = null;
        private JSONObject results;
        private String error;
        private String tag;
        private String API;
        private String loadingMsg ;

        public Api(HashMap<String, String> valuse, Context context, int action, String tag, String loadingMsg) {
            super();
            this.valuse = valuse;
            this.context = context;
            this.action = action;
            this.loadingMsg = loadingMsg;
            this.API = Const.API;
        }


        @Override
        public String doInBackground(String... arg0) {
            jsonParser = new JSONParser(context);
            List<NameValuePair> params = new ArrayList<NameValuePair>();

            System.out.println( this.API);

            for (String key : valuse.keySet()) {
                String value = valuse.get(key);
                System.out.println(key+" = "+value);
                params.add(new BasicNameValuePair(key, value));

            }
            JSONObject json = jsonParser.makeHttpRequest(API, "POST", params);
            jsonObj = json;
            return (null);
        }

        @SuppressLint("NewApi") protected void onPostExecute(String result) {
            pDialog.dismiss();
            switch (action) {
                case 1:// login
                    try {
                        error = jsonObj.getString(Const.API_RESULTS_ERROR);

                        if (error.equals("1")) {
                            Toast.makeText(context, "Log in fail " , Toast.LENGTH_LONG).show();

                        } else {
                            String user = jsonObj.getString(Const.TAG_USER);
                            User.setUser(user);
                            User.isLogin = true ;
                            context.startActivity(new Intent(context, ScolarGridViewActivity.class));
                        }


                    }catch (Exception e){

                    }



                    break;

                case 2:// getDepostis
                    try {
                        error = jsonObj.getString(Const.API_RESULTS_ERROR);

                        if (error.equals("1")) {
                            Toast.makeText(context, "Fail to get Depostis " , Toast.LENGTH_LONG).show();

                        } else {
                            String deposits = jsonObj.getString(Const.TAG_DEPOSTIS);
                            System.out.println(deposits);
                            Deposit.setDeposits(deposits);
                            context.startActivity(new Intent(context, letter.class));
                        }


                    }catch (Exception e){

                    }



                    break;

            }
        }


        protected void onProgressUpdate() {

        }

        @Override
        protected void onPreExecute() {
            pDialog = new ProgressDialog(context);
            pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pDialog.setMessage(loadingMsg);
            pDialog.setMax(90);
            pDialog.show();
        }

}
