package com.example.eliad.impact1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.eliad.impact1.atapters.Adapter_Deposits;
import com.example.eliad.impact1.atapters.houers;
import com.example.eliad.impact1.lib.Deposit;
import com.example.eliad.impact1.lib.Houre;

public class volunteerHours extends AppCompatActivity {

    TextView project;
    TextView totalHoures;

    public ListView feeds  = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_hours);

        project=(TextView) findViewById(R.id.TV_PROJECT);
        project.setText("Project Name: "+Houre.getProject());
        totalHoures=(TextView)findViewById(R.id.TV_TOTAL);
        totalHoures.setText("TOTAL: "+ Houre.getSumOfHoures());

        feeds = (ListView)findViewById(R.id.LV_HUORE);



        System.out.println("size " + Houre.getList().size());
        houers houer = new houers(volunteerHours.this, R.layout.houre, Houre.getList());
        feeds.setAdapter(houer);
        houer.notifyDataSetChanged();
        Houre.clearList();
        Houre.clearSumOfHours();
    }


}
