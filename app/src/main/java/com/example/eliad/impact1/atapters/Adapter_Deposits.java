package com.example.eliad.impact1.atapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.eliad.impact1.R;
import com.example.eliad.impact1.lib.Deposit;

import java.util.ArrayList;

/**
 * Created by asafjonathan on 30/08/16.
 */
public class Adapter_Deposits extends ArrayAdapter<Deposit> {
    private Context context;
    public View vi;
    ArrayList<Deposit> deposits;
    private static LayoutInflater inflater=null;
    static Adapter_Deposits adapterInstance ;

    public Adapter_Deposits(Context context, int resource, ArrayList<Deposit> deposits) {
        super(context, resource);
        this.deposits = new ArrayList<Deposit>();
        this.context = context;
        this.deposits.addAll(deposits);
        Adapter_Deposits.adapterInstance = this;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public int getCount() {
        return deposits.size();
    }

    public void remove(Deposit deposit) {
        this.deposits.remove(deposit);
        super.notifyDataSetChanged();
    }

    public void add(Deposit deposit) {
        this.deposits.add(deposit);

    }
    public void addAll(ArrayList<Deposit>deposits){
        this.deposits = deposits;
    }

    public Deposit getItem(int position) {
        return deposits.get(position);
    }

    public long getItemId(int position) {
        return position;
    }


    public View getView(final  int position, View convertView, ViewGroup parent)  {
        vi=convertView;
        final Deposit deposit =  deposits.get(position);
        vi = inflater.inflate(R.layout.deposit, null);

        TextView id =  (TextView)vi.findViewById(R.id.TV_ID);
        id.setText(deposit.getId());

        TextView amount =  (TextView)vi.findViewById(R.id.TV_AMOUNT);
        amount.setText(deposit.getAmount()+" $");

        TextView date =  (TextView)vi.findViewById(R.id.TV_DATE);
        date.setText(deposit.getDate());

        return vi;

    }





}
