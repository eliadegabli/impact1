package com.example.eliad.impact1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.eliad.impact1.atapters.Adapter_Deposits;
import com.example.eliad.impact1.atapters.Adapter_Notifications;
import com.example.eliad.impact1.lib.Deposit;
import com.example.eliad.impact1.lib.Notification;

public class notificationActivity extends AppCompatActivity {

    public ListView feeds  = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        feeds = (ListView)findViewById(R.id.LV_NOTIFICATION);


        Adapter_Notifications adapter_notifications = new Adapter_Notifications(notificationActivity.this, R.layout.notification, Notification.getList());
        feeds.setAdapter(adapter_notifications);
        adapter_notifications.notifyDataSetChanged();

        Notification.clearList();
    }
}
