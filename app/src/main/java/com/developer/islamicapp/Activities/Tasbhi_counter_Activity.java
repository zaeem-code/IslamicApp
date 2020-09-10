package com.developer.islamicapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.developer.islamicapp.R;
import com.developer.islamicapp.utils.Typcastregular;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Tasbhi_counter_Activity extends AppCompatActivity implements View.OnClickListener {
    TextView counter, counter2, Text_data;
    int count = 0;
    Bundle bundle2;
    Bundle bundle;

    ImageView reset,speaker;

    FrameLayout frameLayout;
    int store = 0;
    int store2 = 0;
    int store3 = 0;
    int store4 = 0;
    int store5 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Typcastregular.Typcastregular(getApplicationContext(), "SERIF", "Poppins-Regular.otf");
        setContentView(R.layout.activity_tasbhi_counter_);
        findViewById(R.id.Tcount).setOnClickListener(this);

        speaker=   findViewById(R.id.spkr);
        speaker.setOnClickListener(this);
        reset = findViewById(R.id.fresh);
        findViewById(R.id.back).setOnClickListener(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        frameLayout = findViewById(R.id.Tcount);
        counter = findViewById(R.id.tsdbhi_counter);
        counter2 = findViewById(R.id.tsdbhi_counter2);
        Text_data = findViewById(R.id.Text_data);

        bundle2 = getIntent().getExtras();

        fetch_data();



        if (bundle2 != null)
        {
            String str = "activity";
            String str2 = "btn1";
            String str3 = "Total = ";
            String str4 = "loc";

            if (bundle2.getString(str).equals(str2))
            {







                int i = getSharedPreferences("count", MODE_PRIVATE).getInt(str4, 0);
                this.store = i;
                this.counter.setText(String.valueOf(i));
                TextView textView4 = this.counter2;
                StringBuilder sb = new StringBuilder();
                sb.append(str3);
                sb.append(this.store);
                textView4.setText(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(this.store);

                this.reset.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        getSharedPreferences("count", MODE_PRIVATE).edit().clear().apply();
                        counter.setText("0");
                        counter2.setText("Total = 0");
                    }
                });
                return;
            }


            String str5 = "btn2";
            if (this.bundle2.getString(str).equals(str5))
            {

                int i2 = getSharedPreferences("count_2", MODE_PRIVATE).getInt(str4, 0);
                this.store2 = i2;
                this.counter.setText(String.valueOf(i2));
                TextView textView5 = this.counter2;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str3);
                sb3.append(this.store2);
                textView5.setText(sb3.toString());

                this.reset.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
//                        imageView.setEnabled(true);
                        getSharedPreferences("count_2", MODE_PRIVATE).edit().clear().apply();
                        counter.setText("0");
                        counter2.setText("Total = 0");
                    }
                });
                return;
            }




            String str6 = "btn3";
            if (this.bundle2.getString(str).equals(str6))
            {
                int i3 = getSharedPreferences("count_3", 0).getInt(str4, 0);
                this.store3 = i3;
                this.counter.setText(String.valueOf(i3));
                TextView textView6 = this.counter2;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str3);
                sb4.append(this.store3);
                textView6.setText(sb4.toString());
                this.reset.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v)
                    {
//                        Counter.this.imageView.setEnabled(true);
                        getSharedPreferences("count_3", MODE_PRIVATE).edit().clear().apply();
                        counter.setText("0");
                        counter2.setText("Total = 0");
                    }
                });
                return;
            }




            String str7 = "btn4";
            if (bundle2.getString(str).equals(str7)) {

                int i4 = getSharedPreferences("count_4", MODE_PRIVATE).getInt(str4, 0);
                this.store4 = i4;
                counter.setText(String.valueOf(i4));
                TextView textView7 = this.counter2;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str3);
                sb5.append(this.store4);
                textView7.setText(sb5.toString());
                this.reset.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
//                        Counter.this.imageView.setEnabled(true);
                        getSharedPreferences("count_4", MODE_PRIVATE).edit().clear().apply();
                        counter.setText("0");
                        counter2.setText("Total = 0");
                    }
                });
                return;
            }




            String str8 = "btn5";
            if (bundle2.getString(str).equals(str8))
            {

                int i5 = getSharedPreferences("count_5", MODE_PRIVATE).getInt(str4, 0);
                this.store5 = i5;
                counter.setText(String.valueOf(i5));
                TextView textView8 = this.counter2;
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str3);
                sb6.append(this.store5);
                textView8.setText(sb6.toString());
                this.reset.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
//                        Counter.this.imageView.setEnabled(true);
                        getSharedPreferences("count_5", MODE_PRIVATE).edit().clear().apply();
                        counter.setText("0");
                        counter2.setText("Total = 0");
                    }
                });
            }









        }






    }
boolean silent=false;
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.spkr:
                if (silent){
                    //unsilent
                    speaker.setImageResource(R.drawable.volume_full_24);
                    silent=false;
                }else {
//silent lagao
                    speaker.setImageResource(R.drawable.volume_24);
                    silent=true;
                }
                break;
            case R.id.back:
                finish();
                break;


            case R.id.Tcount:

                bundle2 = getIntent().getExtras();
                bundle = getIntent().getExtras();

if (!silent){
                playClick();}
                shakeItBaby();


                if (bundle2 != null)
                {

                    String str = "activity";
                    String str2 = "Total = ";
                    String str3 = "loc";
                    if (bundle2.getString(str).equals("btn1"))

                    {
                        String str4 = "count";
                        if (this.store == 0) {
                            int i = this.count + 1;
                            this.count = i;
                            counter.setText(String.valueOf(i));
                            TextView textView2 = this.counter2;
                            StringBuilder sb = new StringBuilder();
                            sb.append(str2);
                            sb.append(this.count);
                            textView2.setText(sb.toString());
                            getSharedPreferences(str4, MODE_PRIVATE).edit().putInt(str3, this.count).apply();
                            this.store = getSharedPreferences(str4, MODE_PRIVATE).getInt(str3, 0);
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("st");
                            sb2.append(this.store);
                        }

                        else
                            {
                            int i2 = getSharedPreferences(str4, MODE_PRIVATE).getInt(str3, 0);
                            this.store = i2;
                            this.store = i2 + 1;
                            getSharedPreferences(str4, MODE_PRIVATE).edit().putInt(str3, this.store).apply();
                            this.counter.setText(String.valueOf(this.store));
                            TextView textView3 = this.counter2;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(str2);
                            sb3.append(this.store);
                            textView3.setText(sb3.toString());
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("ut");
                            sb4.append(this.store);

                            if (this.store == 33) {
//                                this.imageView.setEnabled(false);

                            }
                        }
                    }



                    if (bundle2.getString(str).equals("btn2"))
                    {
                        String str5 = "count_2";
                        if (this.store2 == 0) {
                            int i3 = this.count + 1;
                            this.count = i3;
                            this.counter.setText(String.valueOf(i3));
                            TextView textView4 = this.counter2;
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(str2);
                            sb5.append(this.count);
                            textView4.setText(sb5.toString());
                            getSharedPreferences(str5, MODE_PRIVATE).edit().putInt(str3, this.count).apply();
                            this.store2 = getSharedPreferences(str5, MODE_PRIVATE).getInt(str3, 0);
                        } else {
                            int i4 = getSharedPreferences(str5, MODE_PRIVATE).getInt(str3, 0);
                            this.store2 = i4;
                            this.store2 = i4 + 1;
                            getSharedPreferences(str5, MODE_PRIVATE).edit().putInt(str3, this.store2).apply();
                            this.counter.setText(String.valueOf(this.store2));
                            TextView textView5 = this.counter2;
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append(str2);
                            sb6.append(this.store2);
                            textView5.setText(sb6.toString());
                            if (this.store2 == 33)
                            {

//                                this.imageView.setEnabled(false);
                            }
                        }
                    }



                    if (bundle2.getString(str).equals("btn3")) {
                        String str6 = "count_3";
                        if (this.store3 == 0)
                        {
                            int i5 = this.count + 1;
                            this.count = i5;
                            counter.setText(String.valueOf(i5));
                            TextView textView6 = this.counter2;
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append(str2);
                            sb7.append(this.count);
                            textView6.setText(sb7.toString());
                            getSharedPreferences(str6, MODE_PRIVATE).edit().putInt(str3, this.count).apply();
                            this.store3 = getSharedPreferences(str6, MODE_PRIVATE).getInt(str3, 0);
                        }
                        else
                            {
                            int i6 = getSharedPreferences(str6, MODE_PRIVATE).getInt(str3, 0);
                            this.store3 = i6;
                            this.store3 = i6 + 1;
                            getSharedPreferences(str6, MODE_PRIVATE).edit().putInt(str3, this.store3).apply();
                            counter.setText(String.valueOf(this.store3));
                            TextView textView7 = this.counter2;
                            StringBuilder sb8 = new StringBuilder();
                            sb8.append(str2);
                            sb8.append(this.store3);
                            textView7.setText(sb8.toString());
                            if (this.store3 == 33)
                            {
//                                this.imageView.setEnabled(false);
                            }
                        }
                    }





                    if (bundle2.getString(str).equals("btn4")) {
                        String str7 = "count_4";
                        if (this.store4== 0)
                        {
                            int i8 = this.count + 1;
                            this.count = i8;
                            this.counter.setText(String.valueOf(i8));
                            TextView textView8 = this.counter2;
                            StringBuilder sb9 = new StringBuilder();
                            sb9.append(str2);
                            sb9.append(this.count);
                            textView8.setText(sb9.toString());
                            getSharedPreferences(str7, MODE_PRIVATE).edit().putInt(str3, this.count).apply();
                            this.store4 = getSharedPreferences(str7, MODE_PRIVATE).getInt(str3, 0);
                        }
                        else {
//                            this.store4 = i7 + 1;
                            int i9=getSharedPreferences(str7, MODE_PRIVATE).getInt(str3,0);
                            this.store4 = i9;
                            this.store4 = i9 + 1;
                            getSharedPreferences(str7, MODE_PRIVATE).edit().putInt(str3, this.store4).apply();
                            counter.setText(String.valueOf(this.store4));
                            TextView textView9 = this.counter2;
                            StringBuilder sb10 = new StringBuilder();
                            sb10.append(str2);
                            sb10.append(this.store4);
                            textView9.setText(sb10.toString());
                            if (this.store4 == 33)
                            {
//                                this.imageView.setEnabled(false);

                            }
                        }
                    }



                    if (bundle2.getString(str).equals("btn5"))
                    {
                        String str8 = "count_5";
                        if (this.store5 == 0)
                        {
                            int i9 = this.count + 1;
                            this.count = i9;
                            this.counter.setText(String.valueOf(i9));
                            TextView textView10 = this.counter2;
                            StringBuilder sb11 = new StringBuilder();
                            sb11.append(str2);
                            sb11.append(this.count);
                            textView10.setText(sb11.toString());
                            getSharedPreferences(str8, MODE_PRIVATE).edit().putInt(str3, this.count).apply();
                            this.store5 = getSharedPreferences(str8, MODE_PRIVATE).getInt(str3, 0);
                            return;
                        }
                        int i10 = getSharedPreferences(str8, MODE_PRIVATE).getInt(str3, 0);
                        this.store5 = i10;
                        this.store5 = i10 + 1;
                        getSharedPreferences(str8, MODE_PRIVATE).edit().putInt(str3, this.store5).apply();
                        this.counter.setText(String.valueOf(this.store5));
                        TextView textView11 = this.counter2;
                        StringBuilder sb12 = new StringBuilder();
                        sb12.append(str2);
                        sb12.append(this.store5);
                        textView11.setText(sb12.toString());

                        if (this.store5 == 33)
                        {
//                            this.imageView.setEnabled(false);

                        }
                    }



                }





                    break;
                }


        }




    private void playClick()
    {
        //    MediaPlayer mp = MediaPlayer.create(this, R.raw.soun_mp);
        AudioManager am = (AudioManager) getSystemService(AUDIO_SERVICE);
        try{
            am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
            float vol = 1f;
            am.playSoundEffect(AudioManager.FX_KEY_CLICK, vol);
            // mp.start();
        }catch (Exception e){
            Log.i("sound","error"+e);
        }
        return;
    }



    private void shakeItBaby()
    {
        Vibrator v = (Vibrator) getSystemService(getApplicationContext().VIBRATOR_SERVICE);
        long[] pattern = {0, 100, 1000};


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
//            v.vibrate(VibrationEffect.createOneShot(5, VibrationEffect.DEFAULT_AMPLITUDE));

            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(VibrationEffect.createOneShot(20,10));
        }
        else
        {
            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(30);
//                v.vibrate(5);

        }
    }






    public void fetch_data()
    {

        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("Admin_DATA");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.hasChildren())
                {
                    String k_1=dataSnapshot.child("K_1").getValue().toString();
                    String k_2=dataSnapshot.child("K_2").getValue().toString();
                    String k_3=dataSnapshot.child("K_3").getValue().toString();
                    String k_4=dataSnapshot.child("K_4").getValue().toString();
                    String k_5=dataSnapshot.child("K_5").getValue().toString();

                    if (bundle2.getString("activity").equals("btn1"))
                    {

                            Text_data.setText(k_1);
                    }
                    else if (bundle2.getString("activity").equals("btn2"))
                    {
                           Text_data.setText(k_2);
                    }

                    else if (bundle2.getString("activity").equals("btn3"))
                    {
                        Text_data.setText(k_3);
                    }
                    else if (bundle2.getString("activity").equals("btn4"))
                    {
                        Text_data.setText(k_4);
                    }
                    else if (bundle2.getString("activity").equals("btn5"))
                    {
                        Text_data.setText(k_5);
                    }



                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    }




}

