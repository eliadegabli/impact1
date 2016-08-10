package com.example.eliad.impact1;

/**
 * Created by Eliad on 05/01/2016.
 */
        import android.app.Activity;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.graphics.Color;
        import android.net.Uri;
        import android.os.Bundle;
        import android.preference.PreferenceManager;
        import android.view.MotionEvent;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.AdapterView.OnItemClickListener;
        import android.widget.Button;
        import android.widget.GridView;
        import android.widget.ImageButton;
        import android.widget.TextView;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

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
        // Instance of ImageAdapter Class
        //gridView.setAdapter(new ImageAdapter(this));

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
}
