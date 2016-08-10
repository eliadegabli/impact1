package com.example.eliad.impact1;

import android.view.LayoutInflater;
import android.widget.BaseAdapter;

/**
 * Created by Eliad on 05/01/2016.
 */
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.pic_1, R.drawable.pic_2,
            R.drawable.pic_3, R.drawable.pic_4,
            R.drawable.pic_5, R.drawable.pic_6,
            R.drawable.pic_7, R.drawable.pic_8,
            R.drawable.pic_9
    };
    public String[] web;


    // Constructor
    public ImageAdapter(Context c) {
        mContext = c;
       initText();
    }

    private void initText() {

        web = new String[9];

        web[0] = mContext.getResources().getString(R.string.grid1);
                web[1] = mContext.getResources().getString(R.string.grid2);
                web[2] = mContext.getResources().getString(R.string.grid3);
                web[3] = mContext.getResources().getString(R.string.grid4);
                web[4] = mContext.getResources().getString(R.string.grid5);
                web[5] = mContext.getResources().getString(R.string.grid6);
                web[6] = mContext.getResources().getString(R.string.grid7);
                web[7] = mContext.getResources().getString(R.string.grid8);
                web[8] = mContext.getResources().getString(R.string.grid9);
    }



    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_item, null);
            TextView textView = (TextView) grid.findViewById(R.id.title);
            ImageView imageView = (ImageView) grid.findViewById(R.id.image);
            textView.setText(web[position]);
            imageView.setImageResource(mThumbIds[position]);
        } else {
            grid = (View) convertView;
        }

        return grid;
    }

       /* ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(70, 70));
        return imageView;*/
}



