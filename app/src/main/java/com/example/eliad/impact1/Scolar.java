package com.example.eliad.impact1;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eliad.impact1.lib.Api;
import com.example.eliad.impact1.lib.Const;
import com.example.eliad.impact1.lib.User;
import com.google.android.gms.gcm.GoogleCloudMessaging;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Eliad on 02/01/2016.
 */
public class Scolar extends Activity {
    static String name;
    EditText etName, etPassword;
    Button btnConnect;
    HttpPost httppost;
    StringBuffer buffer;
    HttpResponse response;
    HttpClient httpclient;
    List<NameValuePair> nameValuePairs;
    ProgressDialog dialog = null;
    static String  regId = "" ;
    Context  context = Scolar.this;
    public static final String MyPREFERENCES = "MyPrefs";
    SharedPreferences sharedpreferences;
    GCM_API api_gcm = new GCM_API();
    private HashMap<String, String> valuse = new HashMap<String, String>();
    String tag = "checkLogin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scolar);
        if (User.isLogin){
            context.startActivity(new Intent(context, ScolarGridViewActivity.class));
        }

        api_gcm.execute();
        etName = (EditText) findViewById(R.id.nameEditText);
        etPassword = (EditText) findViewById(R.id.passwordEditText);
        btnConnect = (Button) findViewById(R.id.onSystemButton);
        btnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etName.getText().toString().equals("")) {
                    Toast.makeText(context, "Please enter user name", Toast.LENGTH_LONG).show();
                    return ;

                }

                if (etPassword.getText().toString().equals("")) {
                    Toast.makeText(context, "Please enter password", Toast.LENGTH_LONG).show();
                    return ;

                }
                System.out.println("ttttt "+regId);

                valuse.put("username", etName.getText().toString());
                valuse.put("pass", etPassword.getText().toString());
                valuse.put("registry_id", regId);
                valuse.put("action", tag);
                Api api = new Api(valuse, context, 1, tag, "Check Login ...");
                api.execute();


            }
        });
    }


    public class GCM_API extends AsyncTask<String, String, String> {

        public GCM_API() {
            super();
        }


        @Override
        public String doInBackground(String... arg0) {
            GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(Scolar.this);
            try {
                regId = gcm.register(Const.SENDER_ID);


            }catch (Exception e){

            }

            return (null);
        }

        protected void onPostExecute(String result) {


        }

        protected void onProgressUpdate() {

        }


        @Override
        protected void onPreExecute() {

        }
    }

}
