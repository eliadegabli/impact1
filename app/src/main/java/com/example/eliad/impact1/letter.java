package com.example.eliad.impact1;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

/**
 * Created by Eliad on 08/08/2016.
 */
public class letter extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.letter);
        SharedPreferences sharedPrefs = PreferenceManager
                .getDefaultSharedPreferences(this);


    }

    public void onClickprocedure(View v) {
        if (v.getId() == R.id.procedure) {
            Intent i = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://82.80.37.66/impact/pdf/Procedure_Letter_Donor.pdf"));
            startActivity(i);
        }
    }

}