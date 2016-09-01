package com.example.eliad.impact1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.eliad.impact1.atapters.Adapter_Deposits;
import com.example.eliad.impact1.lib.Deposit;

/**
 * Created by Eliad on 08/08/2016.
 */
public class letter extends Activity {



    public ListView feeds  = null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.letter);

        feeds = (ListView)findViewById(R.id.LV_DEPOSTIES);

        System.out.println("size "+Deposit.getList().size());
        Adapter_Deposits deposits_adapter = new Adapter_Deposits(letter.this, R.layout.deposit, Deposit.getList());
        feeds.setAdapter(deposits_adapter);
        deposits_adapter.notifyDataSetChanged();

        Deposit.clearList();

    }


}