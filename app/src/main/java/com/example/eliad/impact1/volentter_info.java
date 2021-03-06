package com.example.eliad.impact1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.eliad.impact1.lib.Api;
import com.example.eliad.impact1.lib.User;

import java.util.HashMap;

public class volentter_info extends AppCompatActivity {

    Context context=volentter_info.this;
    private HashMap<String, String> valuse = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volentter_info);
    }

    public void OnClickVolunteerHours(View v){
        if (v.getId() == R.id.six_btn){
            String tag = "getVolunteerHours";
            valuse.put("userid", User.getId());
            valuse.put("action", "getVolunteerHours");
            Api api = new Api(valuse, context, 3, tag, "Get Volunteer Hours...");
            api.execute();
        }
    }

    public void OnClickPlaces(View v) {
        if (v.getId() == R.id.five_btn) {
            Intent i = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://82.80.37.66/impact/AWIS_MENU_PAGE.ASP"));
            startActivity(i);
        }
    }

    public void onClickNohalVolenteer(View v){
        if (v.getId() == R.id.nohalVolenteer) {
            Intent i = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://82.80.37.66/impact/pdf/Procedure_Volunteering.pdf"));
            startActivity(i);
        }
    }
}
