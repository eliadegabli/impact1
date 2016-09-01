package com.example.eliad.impact1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.eliad.impact1.atapters.Adapter_Deposits;
import com.example.eliad.impact1.atapters.houers;
import com.example.eliad.impact1.lib.Deposit;
import com.example.eliad.impact1.lib.Houre;

public class volunteerHours extends AppCompatActivity {

    public ListView feeds  = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_hours);

        feeds = (ListView)findViewById(R.id.LV_HUORE);

        System.out.println("size " + Houre.getList().size());
        houers houer = new houers(volunteerHours.this, R.layout.houre, Houre.getList());
        feeds.setAdapter(houer);
        houer.notifyDataSetChanged();
    }
}
