package com.example.eliad.impact1.atapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.eliad.impact1.R;
import com.example.eliad.impact1.lib.Houre;
import com.example.eliad.impact1.lib.User;

import java.util.ArrayList;

/**
 * Created by Eliad on 31/08/2016.
 */
public class houers extends ArrayAdapter<Houre> {

    private Context context;
    public View vi;
    ArrayList<Houre> houres;
    private static LayoutInflater inflater=null;
    static houers adapterInstance ;

    public houers(Context context, int resource, ArrayList<Houre> houre) {
        super(context, resource);
        this.houres = new ArrayList<Houre>();
        this.context = context;
        this.houres.addAll(houre);
        houers.adapterInstance = this;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public int getCount() {
        return houres.size();
    }



    public void add(Houre user) {
        this.houres.add(user);
    }

    public void addAll(ArrayList<Houre> user){
        this.houres = user;
    }

    public Houre getItem(int position) {
        return houres.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(final  int position, View convertView, ViewGroup parent)  {
        vi=convertView;
        final Houre houre =  houres.get(position);
        vi = inflater.inflate(R.layout.houre, null);

       TextView houres =  (TextView)vi.findViewById(R.id.TV_HOURE);
        houres.setText(houre.getHoure());

        TextView date =  (TextView)vi.findViewById(R.id.TV_DATE);
        date.setText(houre.getDate());

        return vi;

    }

}
