package com.example.eliad.impact1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.URL;

public class homeScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
      /*  SharedPreferences sharedPrefs = PreferenceManager
                .getDefaultSharedPreferences(this);

      if(sharedPrefs.getBoolean("isEnteredToApp",false)){
          startActivity(new Intent(this, ScolarGridViewActivity.class));
      }*/

    }

    public void onClickScol(View v) {

        if (v.getId() == R.id.scolarButton) {
            Intent i = new Intent(homeScreen.this, Scolar.class);
            startActivity(i);

        }

    }

    public void candid(View v) {
        if (v.getId() == R.id.candidateButton) {
            Intent i = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://82.80.37.66/impact/pdf/howToApplay.pdf"));
            startActivity(i);
        }
    }

    public void onClickgrad(View v) {
        if (v.getId() == R.id.gradubutton1) {
            Intent i = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.impactbogrim.org.il"));
            startActivity(i);
        }
    }
}
