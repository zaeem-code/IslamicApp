package com.developer.islamicapp.utils;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.developer.islamicapp.Activities.MainActivity;
import com.developer.islamicapp.R;

import java.util.Random;

public class FCMnotification
{

    private final String ADMIN_CHANNEL_ID ="admin_channel";
    public FCMnotification(Context context,String title,String msg)
    {
        final Intent intent = new Intent(context, MainActivity.class);
        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);
        int notificationID = new Random().nextInt(3000);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            stupChnl(notificationManager,title,msg);
        }

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context , 0, intent,
                PendingIntent.FLAG_ONE_SHOT);

        Bitmap largeIcon = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.kalmachannellogo);


        int number=0;
        number=number++;

        Uri notificationSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder
                (context, ADMIN_CHANNEL_ID)
                .setSmallIcon(R.drawable.kalma_logo)
                .setLargeIcon(largeIcon)
                .setContentTitle(title)
                .setContentText(msg)
                .setAutoCancel(true)
                .setSound(notificationSoundUri)
                .setContentIntent(pendingIntent);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            notificationBuilder.setColor(context.getResources().getColor(R.color.colorText));
        }
        notificationManager.notify(notificationID, notificationBuilder.build());



    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void stupChnl(NotificationManager notificationManager, String title, String msg)
    {

        NotificationChannel notificationChannelx;
        notificationChannelx = new NotificationChannel
                (ADMIN_CHANNEL_ID, title, NotificationManager.IMPORTANCE_HIGH);
        notificationChannelx.setDescription( "  \n "+msg);
        notificationChannelx.enableLights(true);
        notificationChannelx.setLightColor(Color.GREEN);
        notificationChannelx.enableVibration(true);
        if (notificationManager != null)
        {
            notificationManager.createNotificationChannel(notificationChannelx);
        }



    }


}
