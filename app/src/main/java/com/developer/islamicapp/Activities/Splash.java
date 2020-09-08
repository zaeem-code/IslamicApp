package com.developer.islamicapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Toast;

import com.developer.islamicapp.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;

public class Splash extends AppCompatActivity {
    private static final int REQUEST_WRITE_STORAGE = 112;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        FirebaseMessaging.getInstance().subscribeToTopic("APP_master");
        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener( this,  new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult instanceIdResult)
            {
                String newToken = instanceIdResult.getToken();

                FirebaseMessaging.getInstance().subscribeToTopic("APP_master");
            }
        });



        String str = "android.permission.WRITE_EXTERNAL_STORAGE";
        if (!(ContextCompat.checkSelfPermission(this, str) == 0))
        {
            ActivityCompat.requestPermissions(this, new String[]{str}, 112);
        }
        else {
            new Handler().postDelayed(new Runnable() {
                public void run()
                {
              startActivity(new Intent(getApplicationContext(), MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK
                    ));
                    finish();
                }

            }, 2500);
        }
    }



    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 112) {
            if (grantResults.length <= 0 || grantResults[0] != 0) {
                Toast.makeText(this, "The application can't start without this permission", Toast.LENGTH_LONG).show();
                finish();
                return;
            }
            new Handler().postDelayed(new Runnable() {
                public void run() {
                 startActivity(new Intent(getApplicationContext(), MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK
                    ));
                    finish();
                }
            }, 2500);
        }
    }
}
