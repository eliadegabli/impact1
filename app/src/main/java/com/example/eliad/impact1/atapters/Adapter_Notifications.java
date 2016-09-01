package com.example.eliad.impact1.atapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.eliad.impact1.R;
import com.example.eliad.impact1.lib.Houre;
import com.example.eliad.impact1.lib.Notification;

import java.util.ArrayList;

/**
 * Created by Eliad on 01/09/2016.
 */
public class Adapter_Notifications extends ArrayAdapter<Houre> {

    private Context context;
    public View vi;
    ArrayList<Notification> notifications;
    private static LayoutInflater inflater=null;
    static Adapter_Notifications adapterInstance ;

    public Adapter_Notifications(Context context, int resource, ArrayList<Notification> notification) {
        super(context, resource);
        this.notifications = new ArrayList<Notification>();
        this.context = context;
        this.notifications.addAll(notification);
        Adapter_Notifications.adapterInstance = this;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public int getCount() {
        return notifications.size();
    }



    public void add(Notification user) {
        this.notifications.add(user);
    }

    public void addAll(ArrayList<Notification> user){
        this.notifications = user;
    }

    public Notification getItem1(int position) {
        return notifications.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(final  int position, View convertView, ViewGroup parent)  {
        vi=convertView;
        final Notification notification =  notifications.get(position);
        vi = inflater.inflate(R.layout.notification, null);

        TextView message =  (TextView)vi.findViewById(R.id.TV_MESSAGE);
        message.setText(notification.getMessage());

        TextView date =  (TextView)vi.findViewById(R.id.TV_DATE1);
        date.setText(notification.getDate());

        return vi;

    }

}