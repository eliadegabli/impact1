package com.example.eliad.impact1;

import android.annotation.TargetApi;
import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.RemoteViews;

import com.example.eliad.impact1.lib.Const;
import com.google.android.gms.gcm.GoogleCloudMessaging;

import java.util.List;

public class GCMNotificationIntentService extends IntentService {

    public static final int NOTIFICATION_ID = 1;
    private NotificationManager mNotificationManager;
    static String message ;
    static String type;
    static String post_id;
    static int count = 0 ;
    static String userImage = "";
    static boolean isRating = false;
    static Intent notificationIntent ;
    static PendingIntent contentIntent;

    public GCMNotificationIntentService() {
        super("GcmIntentService");
    }

    public static final String TAG = "GCMNotificationIntentService";

    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);

        String messageType = gcm.getMessageType(intent);
        Log.e("test recieve", "------------------------------ Catch");

        if (!extras.isEmpty()) {
            if (GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR
                    .equals(messageType)) {
                sendNotification("Send error: " + extras.toString());
            } else if (GoogleCloudMessaging.MESSAGE_TYPE_DELETED
                    .equals(messageType)) {
                sendNotification("Deleted messages on server: "
                        + extras.toString());
            } else if (GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE
                    .equals(messageType)) {

                for (int i = 0; i < 3; i++) {
                    Log.i(TAG,
                            "Working... " + (i + 1) + "/5 @ "
                                    + SystemClock.elapsedRealtime());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                    }

                }
                Log.i(TAG, "Completed work @ " + SystemClock.elapsedRealtime());
                count++;

                sendNotification("" + extras.get(Const.MESSAGE_KEY));
                Log.i(TAG, "Received: " + extras.toString());

            }
        }
        GcmBroadcastReceiver.completeWakefulIntent(intent);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void sendNotification(String message) {
        System.out.println("aa "+message);
        Log.d(TAG, "Preparing to send notification...: " + message);
        mNotificationManager = (NotificationManager) this
                .getSystemService(Context.NOTIFICATION_SERVICE);

        /*
        *
        *
        *  String launcherClassName = getLauncherClassName(this);
        if (launcherClassName == null) {
            return;
        }

        Intent intentt = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
      //  intentt.putExtra("badge_count", Notifications.getTotal());
        intentt.putExtra("badge_count_package_name", this.getPackageName());
        intentt.putExtra("badge_count_class_name", launcherClassName);
        this.sendBroadcast(intentt);

        if (type.equals("RATING")){
            isRating = true;
        }
        *
        *
        *
        *
        *
        * */



        NotificationManager  mNotificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);


        RemoteViews remoteViews = new RemoteViews(this.getPackageName(), R.layout.notification);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);



        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
                this).setSmallIcon(R.mipmap.ic_launcher)
                .setContent(remoteViews)
                .setAutoCancel(true);


        remoteViews.setTextViewText(R.id.TV_NOTIFICATION, message);
     //   remoteViews.setImageViewBitmap(R.id.IV_NOTIFICATIONIMG, ImagesDownloader.downloadBitmap(userImage));
        mBuilder.setDefaults(NotificationCompat.DEFAULT_VIBRATE);


        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
        r.play();






        mBuilder.setContentIntent(contentIntent);
        mNotificationManager.notify(0, mBuilder.build());

    }

    public static String getLauncherClassName(Context context) {
        PackageManager pm = context.getPackageManager();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> resolveInfos = pm.queryIntentActivities(intent, 0);
        for (ResolveInfo resolveInfo : resolveInfos) {
            String pkgName = resolveInfo.activityInfo.applicationInfo.packageName;
            if (pkgName.equalsIgnoreCase(context.getPackageName())) {
                String className = resolveInfo.activityInfo.name;
                return className;
            }
        }
        return null;
    }
}
