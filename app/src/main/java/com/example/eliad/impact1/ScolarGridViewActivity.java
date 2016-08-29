package com.example.eliad.impact1;

/**
 * Created by Eliad on 05/01/2016.
 */
        import android.app.Activity;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.preference.PreferenceManager;
        import android.view.View;
        import android.widget.ImageButton;
        import android.widget.TextView;

public class ScolarGridViewActivity  extends Activity {


    TextView userName;
    ImageButton log_out_bt;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scolar_grid_view);
        Intent i = getIntent();
      // GridView gridView = (GridView) findViewById(R.id.gridview);
        userName = (TextView)findViewById(R.id.text_view_user_name);
        log_out_bt =(ImageButton)findViewById(R.id.log_out);


        userName.setText(Scolar.name + " " + "שלום");        userName.setTextColor(Color.WHITE);


        log_out_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPrefs = PreferenceManager
                        .getDefaultSharedPreferences(getApplicationContext());
                sharedPrefs.edit().putBoolean("isEnteredToApp",false).commit();

                startActivity(new Intent(getApplicationContext(), homeScreen.class));
                finish();


            }
        });

    }

    public void onClickLetter(View v) {
        if (v.getId() == R.id.two_btn) {
            Intent i = new Intent(ScolarGridViewActivity.this,letter.class);
            startActivity(i);
        }
    }

    public void OnClickOne_btn(View v) {
        if (v.getId() == R.id.one_btn) {
            Intent i = new Intent(ScolarGridViewActivity.this,volentter_info.class);
            startActivity(i);
        }
    }


    public void Onclickfive_btn(View v) {
        if (v.getId() == R.id.five_btn) {
            Intent i = new Intent(ScolarGridViewActivity.this,etz_dahat.class);
            startActivity(i);
        }
    }
}
