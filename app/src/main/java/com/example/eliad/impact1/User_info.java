package com.example.eliad.impact1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.eliad.impact1.lib.User;

public class User_info extends AppCompatActivity {

    EditText id;
    EditText name;
    EditText email;
    EditText mobile;
    EditText address;
    EditText city;
    EditText university;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info);

        id=(EditText)findViewById(R.id.TV_ID);
        name=(EditText)findViewById(R.id.TV_NAME);
        email=(EditText)findViewById(R.id.TV_EMAIL);
        mobile=(EditText)findViewById(R.id.TV_MOBILE);
        address=(EditText)findViewById(R.id.TV_ADDRESS);
        city=(EditText)findViewById(R.id.TV_CITY);
        university=(EditText)findViewById(R.id.TV_UNIVERSITY);

        id.setText(User.getId());
        name.setText(User.getFname() + " " +  User.getLname());
        email.setText(User.getEmail());
        mobile.setText(User.getMobile());
        address.setText(User.getAddress());
        city.setText(User.getCity());
        university.setText(User.getUniversity());

    }
}
