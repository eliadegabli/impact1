package com.example.eliad.impact1;

/**
 * Created by Eliad on 05/01/2016.
 */
        import android.app.Activity;
        import android.content.Context;
        import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

        import com.example.eliad.impact1.lib.Api;
        import com.example.eliad.impact1.lib.User;

        import java.util.HashMap;

public class ScolarGridViewActivity  extends Activity {

    Context context = ScolarGridViewActivity.this;
    TextView userName;
    ImageButton log_out_bt;
    private HashMap<String, String> valuse = new HashMap<String, String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scolar_grid_view);
        Intent i = getIntent();
      // GridView gridView = (GridView) findViewById(R.id.gridview);
        userName = (TextView)findViewById(R.id.text_view_user_name);
        log_out_bt =(ImageButton)findViewById(R.id.log_out);


        userName.setText(User.getLname() +" "+User.getFname());

        log_out_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User.logOut();
                context.startActivity(new Intent(context, homeScreen.class));


            }
        });

    }

    public void onClickLetter(View v) {
        if (v.getId() == R.id.two_btn) {
            String tag = "getDeposits";
            valuse.put("userid", User.getId());
            valuse.put("action", "getDeposits");
            Api api = new Api(valuse, context, 2, tag, "Get Deposits");
            api.execute();


        }
    }

    public void OnclickConnect(View v) {
        if (v.getId() == R.id.TV_EMAIL_USER_PROFILE) {
            Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
            emailIntent.setType("text/plain");
            emailIntent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"impact@gmail.com"});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "For: ");
            startActivity(emailIntent);
        }
    }

    public void OnClickOne_btn(View v) {
        if (v.getId() == R.id.one_btn) {
            Intent i = new Intent(ScolarGridViewActivity.this,volentter_info.class);
            startActivity(i);
        }
    }

    public void OnClickUser_info(View v) {
        if (v.getId() == R.id.three_btn) {
            Intent i = new Intent(ScolarGridViewActivity.this,User_info.class);
            startActivity(i);
        }
    }

    public void onClickNotification(View v){
        if (v.getId() == R.id.seven_btn) {
                    String tag = "getNotifications";
                    valuse.put("userid", User.getId());
                    valuse.put("action", "getNotifications");
                    Api api = new Api(valuse, context, 4, tag, "Get Notifications...");
                    api.execute();
            }
        }


    public void Onclickfive_btn(View v) {
        if (v.getId() == R.id.five_btn) {
            Intent i = new Intent(ScolarGridViewActivity.this,etz_dahat.class);
            startActivity(i);
        }
    }
}
