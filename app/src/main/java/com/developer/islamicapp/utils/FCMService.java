package com.developer.islamicapp.utils;

import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;

import com.developer.islamicapp.Model.NotficationCounter;
import com.developer.islamicapp.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.HashMap;

public class FCMService extends FirebaseMessagingService {

    int count=0;

    SharedPreferences.Editor editor;
    SharedPreferences prefs;
    SharedPreferences.Editor mEditor;
    int count_get,count_get_2;
    SharedPreferences prefs1;
    String get_name,get_pass,get_number;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage)
    {
        new FCMnotification(this,remoteMessage.getData().get("title")
                ,remoteMessage.getData().get("message"));


        editor = getSharedPreferences("count", MODE_PRIVATE).edit();


        Notification_save(remoteMessage.getData().get("message"),remoteMessage.getMessageId()
                ,remoteMessage.getData().get("time"),remoteMessage.getData().get("title")
                ,remoteMessage.getData().get("date"));





    }



    public void Notification_save(String msg, String msg_id, String get_from, String title,String date)
    {

        prefs = getSharedPreferences("count", MODE_PRIVATE);
        count_get = prefs.getInt("count", 0);



        prefs1 = getSharedPreferences("login", MODE_PRIVATE);
        get_name = prefs1.getString("name", "");//"No name defined" is the default value.
        get_pass = prefs1.getString("country", "");//"No name defined" is the default value.
        get_number= prefs1.getString("phone", "");//"No name defined" is the default value.


        if (!get_number.equals(""))
        {


            DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference()
                    .child("notification").child(get_number);

            DatabaseReference databaseReference1= FirebaseDatabase.getInstance().getReference()
                    .child("alert").child(get_number);




            HashMap hashMap=new HashMap();
            hashMap.put("message",msg);
            hashMap.put("title",title);
            hashMap.put("time",get_from);
            hashMap.put("id",msg_id);
            hashMap.put("date",date);
            hashMap.put("notification","enter");

            if (String.valueOf(count_get).equals(""))
            {
                count++;
                editor.putInt("count", count);
                editor.apply();

                hashMap.put("count",count_get);
                hashMap.put("pos",count_get);


            }
            else
            {
                count_get++;

                editor.putInt("count",count_get);
                editor.apply();


                hashMap.put("count",count_get);
                hashMap.put("pos",count_get);



            }




            databaseReference.push().updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                @Override
                public void onSuccess(Object o) {





                }
            });




            HashMap hashMap1=new HashMap();
            hashMap1.put("notification","success");

            databaseReference1.updateChildren(hashMap1).addOnSuccessListener(new OnSuccessListener() {
                @Override
                public void onSuccess(Object o) {

                }
            });



        }






    }


}