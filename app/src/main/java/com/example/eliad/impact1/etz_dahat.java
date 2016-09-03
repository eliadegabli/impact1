package com.example.eliad.impact1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class etz_dahat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.etz_dahat);
    }

    public void onClickprocedure(View v){
        if (v.getId() == R.id.procedure) {
            Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
            emailIntent.setType("text/plain");
            emailIntent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"yoav@ehc.co.il"});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "I want to register for the SADNA on: ");
            startActivity(emailIntent);
        }
    }

    public void onClickformat(View v){
        if (v.getId() == R.id.formatLetter) {
            Intent i = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://82.80.37.66/impact/pdf/sadnaotImun.pdf"));
            startActivity(i);
        }
    }
}
