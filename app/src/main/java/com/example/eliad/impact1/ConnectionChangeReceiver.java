package com.example.eliad.impact1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class ConnectionChangeReceiver extends BroadcastReceiver {
	public static boolean isConnection;
	
@Override
  public void onReceive( Context context, Intent intent ){
	    getConnectivityStatus(context);

  } 

public static boolean getConnectivityStatus(Context context) {
    ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
    if (null != activeNetwork) {
        if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI){
        	isConnection = true;
            return isConnection;
        }
        if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
        	return isConnection = true;
    }
    isConnection = false;
    return isConnection;
    }

}