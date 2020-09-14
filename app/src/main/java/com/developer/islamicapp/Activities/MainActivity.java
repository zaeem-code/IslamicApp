package com.developer.islamicapp.Activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.developer.islamicapp.Api.SAU_date_Api;
import com.developer.islamicapp.Calander.HGDate;
import com.developer.islamicapp.Calander.NumbersLocal;
import com.developer.islamicapp.Fragments.HomeFragment;
import com.developer.islamicapp.Fragments.IbadatFragment;
import com.developer.islamicapp.Fragments.LiberaryFragment;
import com.developer.islamicapp.Fragments.LiveFragment;
import com.developer.islamicapp.Fragments.QuranFragment;
import com.developer.islamicapp.Model.NotficationCounter;
import com.developer.islamicapp.R;
import com.developer.islamicapp.utils.Typcastregular;
import com.developer.islamicapp.utils.share;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hassanjamil.hqibla.CompassActivity;
import com.hassanjamil.hqibla.Constants;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String asr,sun_set,sun_rise;
    TextView homeT,quranT,libraryT,ibadatT,liveT;
    TextView ayat_of_day;
    Bundle bundle;
    String country_chk="";
    TextView curr_namaz;
    TextView event;
    String fajr="";
    TextView gorgeon,home_txt;
    String curr_Time="";
    TextView hadees_of_day;
    ImageView home;
    ImageView ibadat;
    String isha="";
    TextView islamic_D_T;
    String l_date="";
    TextView l_georgeon_D_T;
    String l_time="";
    ImageView liberary;
    ImageView live;
    String m_date="";
    String m_time="";
    TextView madina_D_T;
    String magrib="";
    TextView mahfil_of_day;
    TextView namaz_of_year;
    String name_chk;
    TextView next_namaz;
    String phone_chk;
    SharedPreferences prefs;
    SharedPreferences prefs_get_count;

    ImageView quran,qibla;
    TextView signUp,counter;
    TextView wazifa,Sun_set,Sun_rise;
    String zohr="";
    String get_name="";
    String get_pass="";
    String get_number="";

    SimpleDateFormat _24HourSDF;
    SimpleDateFormat _12HourSDF;
    Date _24HourDt;
    LinearLayout back_img;

    ImageView notification;
    NotficationCounter notficationCounter;
    RelativeLayout relativeLayout;
    CardView cardView;


    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Typcastregular.Typcastregular(getApplicationContext(), "SERIF", "Poppins-Regular.otf");
        setContentView(R.layout.activity_main);

        try {


            this.bundle = getIntent().getExtras();}catch (Exception e){

        }  View_layout();

        bottomNav_Click();

        String str = "";

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        home_txt = findViewById(R.id.home_text);

        findViewById(R.id.home_text).setOnClickListener(this);
        findViewById(R.id.home).setOnClickListener(this);
        findViewById(R.id.homelyt).setOnClickListener(this);
        findViewById(R.id.share).setOnClickListener(this);
        findViewById(R.id.sharetxt).setOnClickListener(this);
        findViewById(R.id.About).setOnClickListener(this);
        findViewById(R.id.Abouttxt).setOnClickListener(this);
        findViewById(R.id.Bstatuseslyt).setOnClickListener(this);

        findViewById(R.id.About1).setOnClickListener(this);
        findViewById(R.id.Abouttxt1).setOnClickListener(this);
        findViewById(R.id.Bstatuseslyt1).setOnClickListener(this);

        findViewById(R.id.About2).setOnClickListener(this);
        findViewById(R.id.Abouttxt2).setOnClickListener(this);
        findViewById(R.id.Bstatuseslyt2).setOnClickListener(this);


        findViewById(R.id.About3).setOnClickListener(this);
        findViewById(R.id.Abouttxt3).setOnClickListener(this);
        findViewById(R.id.Bstatuseslyt3).setOnClickListener(this);

        relativeLayout = findViewById(R.id.card);
//        cardView=findViewById(R.id.card);
findViewById(R.id.signoutpic).setOnClickListener(this);
        findViewById(R.id.signouttxt).setOnClickListener(this);
        findViewById(R.id.signuppic).setOnClickListener(this);
        findViewById(R.id.signuptxt).setOnClickListener(this);

        back_img = findViewById(R.id.back_img);
        notification = findViewById(R.id.notification);
        counter = findViewById(R.id.counter);

        greetings();
        try {

        prefs = getSharedPreferences("login", MODE_PRIVATE);
        get_name = prefs.getString("name", "");//"No name defined" is the default value.
        get_pass = prefs.getString("country", "");//"No name defined" is the default value.
        get_number = prefs.getString("phone", "");//"No name defined" is the default value.

            getUser();
    }catch (Exception e){

        }

        Get_budge_database();
        get_alert();
        calander_upoad();


        notification.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                relativeLayout.setVisibility(View.INVISIBLE);
                prefs_get_count = getSharedPreferences("count", MODE_PRIVATE);
                prefs_get_count.edit().remove("count").apply();

                startActivity(new Intent(getApplicationContext(),Notificaton_Activity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));


            }
        });





        if (get_name.equals("")  && get_number.equals(""))
        {

//            Toast.makeText(this, ""+get_name+get_number, Toast.LENGTH_SHORT).show();

            openFragment(new HomeFragment());
            homeT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorText, null));
            libraryT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorWhite, null));
            quranT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorWhite, null));
            ibadatT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorWhite, null));
            liveT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorWhite, null));



        }
        else
        {

//            Toast.makeText(this, ""+get_name+get_number, Toast.LENGTH_SHORT).show();

            openFragment(HomeFragment.newInstance(get_name,get_number,get_pass));
            homeT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorText, null));
            libraryT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorWhite, null));
            quranT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorWhite, null));
            ibadatT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorWhite, null));
            liveT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorWhite, null));



        }









        qibla=findViewById(R.id.qibla);


        Toolbar toolbar = findViewById(R.id.tool);
        toolbar.setTitle(str);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        qibla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, CompassActivity.class);
                intent.putExtra(Constants.TOOLBAR_TITLE, "Qibla");		// Toolbar Title
                intent.putExtra(Constants.TOOLBAR_BG_COLOR, "#035E6A");		// Toolbar Background color
                intent.putExtra(Constants.TOOLBAR_TITLE_COLOR, "#000000");	// Toolbar Title color
                intent.putExtra(Constants.COMPASS_BG_COLOR, "#035E6A");		// Compass background color
                intent.putExtra(Constants.ANGLE_TEXT_COLOR, "#000000");		// Angle Text color
//                intent.putExtra(Constants.DRAWABLE_DIAL, R.drawable.qiblacompus1);	// Your dial drawable resource
                intent.putExtra(Constants.DRAWABLE_QIBLA, R.drawable.qiblacompus1); 	// Your qibla indicator drawable resource
                intent.putExtra(Constants.FOOTER_IMAGE_VISIBLE, View.VISIBLE|View.INVISIBLE|View.GONE);	// Footer World Image visibility
                intent.putExtra(Constants.LOCATION_TEXT_VISIBLE, View.VISIBLE|View.INVISIBLE|View.GONE); // Location Text visibility
                startActivity(intent);
            }
        });




        georgeon_Date();

        Date_Time_of_Any_Country("Asia/Riyadh","SAU");
        Date_Time_of_Any_Country("Asia/Karachi","PK");

        GetPrayer_api();
        GetPrayer_hijri();




        Locale locale = new Locale("ar");
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM dd, yyy", locale);
        Date currDate = new Date();
        String formattedDate = sdf.format(currDate);
        l_georgeon_D_T.setText(formattedDate);


//        final Handler mHandler = new Handler();
//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
//                mHandler.post(new Runnable() {
//                    public void run() {
//                        // do UI stuff
//
//                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
//                        {
//
//
//
//
//
//                        }
//
//
//
//
//
//
//
//
//
//                    }
//                });
//            }
//        }, 1000, 1000);
//




        Database("Book 1");
        Database("Book 2");
        Database("Book 3");
        Database("Book 4");
        Database("Book 5");
        Database("Book 6");
        Database("Book 7");
        Database("Book 8");
        Database("Book 9");
        Database("Book 10");
        Database("Book 11");
        Database("Book 12");




  store_date_firebase();
        set_islamic_date();


    }


    public void store_date_firebase()
    {



        for (int i=0;i<2;i++)
        {

          DatabaseReference  databaseReference= FirebaseDatabase.getInstance().getReference().child("data_url")
                    .child("videoUrl_"+i);


            HashMap hashMap=new HashMap();
            hashMap.put("download_status","fail");
            hashMap.put("pos",i);
            hashMap.put("key","videoUrl_"+i+"");

            if (i==0)
            {
                hashMap.put("url","https://firebasestorage.googleapis.com/v0/b/islamicapp-c372d.appspot.com/o/video%2FVid.mp4?alt=media&token=bab7058e-8c78-47e3-b44f-108d1ec4f806");
            }
            else
            {
                hashMap.put("url","https://firebasestorage.googleapis.com/v0/b/islamicapp-c372d.appspot.com/o/video%2Ftamil.mp4?alt=media&token=869473d8-e63d-4433-a523-4b8f54e6dc98");
            }

            databaseReference.updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                @Override
                public void onSuccess(Object o)
                {

//                   Toast.makeText(getApplicationContext(), "data_upload", Toast.LENGTH_SHORT).show();
                }
            });

        }



    }




    public void Database(final String child)
    {

        final DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference()
                .child("Book_data").child(child);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.hasChildren())
                {
                    String name=dataSnapshot.child("file_name").getValue().toString();

                    SharedPreferences.Editor editor = getSharedPreferences("pre", MODE_PRIVATE).edit();
                    editor.putString(child,name);
                    editor.apply();


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    }




//
//    private void GetPrayer_api() {
//        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
//        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, PrayerApi.prayer_Time, null, new Response.Listener<JSONObject>() {
//            public void onResponse(JSONObject response) {
//
//                try {
//                    JSONObject jsonObject = null;
//                    JSONArray enter = response.getJSONArray("data");
//                    for (int i=0; i<enter.length(); i++){
//                        jsonObject= enter.getJSONObject(i);
//
//                    }
//
//                    Log.v("hassan","resp"+jsonObject);
//                    fajr = jsonObject.getJSONObject("timings").getString("Fajr");
//                    zohr = jsonObject.getJSONObject("timings").getString("Dhuhr");
//                    asr = jsonObject.getJSONObject("timings").getString("Asr");
//                    magrib = jsonObject.getJSONObject("timings").getString("Maghrib");
//                    isha = jsonObject.getJSONObject("timings").getString("Isha");
//                    sun_set= jsonObject.getJSONObject("timings").getString("Sunset");
//                    sun_rise = jsonObject.getJSONObject("timings").getString("Sunrise");
//
//
//                    _24HourSDF = new SimpleDateFormat("HH:mm");
//                    _12HourSDF = new SimpleDateFormat("hh:mm a");
//                    _24HourDt = _24HourSDF.parse(sun_set);
//                    Sun_set.setText(_12HourSDF.format(_24HourDt));
//
//
//                    _24HourSDF = new SimpleDateFormat("HH:mm");
//                    _12HourSDF = new SimpleDateFormat("hh:mm a");
//                    _24HourDt = _24HourSDF.parse(sun_rise);
//
//
//                    Sun_rise.setText(_12HourSDF.format(_24HourDt));
//
//
//
//
////                    _24HourSDF = new SimpleDateFormat("HH:mm");
////                    _12HourSDF = new SimpleDateFormat("hh:mm a");
////                    _24HourDt = _24HourSDF.parse(isha);
////
////                    isha=_12HourSDF.format(_24HourDt);
////
////                    _24HourSDF = new SimpleDateFormat("HH:mm");
////                    _12HourSDF = new SimpleDateFormat("hh:mm a");
////                    _24HourDt = _24HourSDF.parse(fajr);
////                    fajr=_12HourSDF.format(_24HourDt);
////
////
////                    _24HourSDF = new SimpleDateFormat("HH:mm");
////                    _12HourSDF = new SimpleDateFormat("hh:mm a");
////                    _24HourDt = _24HourSDF.parse(zohr);
////                    zohr=_12HourSDF.format(_24HourDt);
////
////
////                    _24HourSDF = new SimpleDateFormat("HH:mm");
////                    _12HourSDF = new SimpleDateFormat("hh:mm a");
////                    _24HourDt = _24HourSDF.parse(asr);
////                    asr=_12HourSDF.format(_24HourDt);
////
////
////                    _24HourSDF = new SimpleDateFormat("HH:mm");
////                    _12HourSDF = new SimpleDateFormat("hh:mm a");
////                    _24HourDt = _24HourSDF.parse(magrib);
////                    magrib=_12HourSDF.format(_24HourDt);
//
//
//
//
//
//
//
//
//                     curr_Time = new SimpleDateFormat("HH:mm").format(new Date());
//
//
//                    if (curr_Time.compareTo(fajr) >= 0 && curr_Time.compareTo(zohr) < 0)
//                    {
//
//                        _24HourSDF = new SimpleDateFormat("HH:mm");
//                    _12HourSDF = new SimpleDateFormat("hh:mm a");
//                    _24HourDt = _24HourSDF.parse(fajr);
//                    fajr=_12HourSDF.format(_24HourDt);
//
//
//                    _24HourSDF = new SimpleDateFormat("HH:mm");
//                    _12HourSDF = new SimpleDateFormat("hh:mm a");
//                    _24HourDt = _24HourSDF.parse(zohr);
//                    zohr=_12HourSDF.format(_24HourDt);
//
//
//
//                        next_namaz.setText("zoher"+" "+zohr);
//                        curr_namaz.setText("fajer"+" "+fajr);
//
//                    }
//
//                    else  if (curr_Time.compareTo(zohr) >= 0 && curr_Time.compareTo(asr) < 0)
//                    {
//
//
//                        _24HourSDF = new SimpleDateFormat("HH:mm");
//                        _12HourSDF = new SimpleDateFormat("hh:mm a");
//                        _24HourDt = _24HourSDF.parse(zohr);
//                        zohr=_12HourSDF.format(_24HourDt);
//
//                        _24HourSDF = new SimpleDateFormat("HH:mm");
//                        _12HourSDF = new SimpleDateFormat("hh:mm a");
//                        _24HourDt = _24HourSDF.parse(asr);
//                         asr=_12HourSDF.format(_24HourDt);
//
//                        next_namaz.setText("aser"+" "+asr);
//                        curr_namaz.setText("zoher"+" "+zohr);
//
//                    }
//
//                    else  if (curr_Time.compareTo(asr) >= 0 && curr_Time.compareTo(magrib) < 0)
//                        {
//
//                            _24HourSDF = new SimpleDateFormat("HH:mm");
//                    _12HourSDF = new SimpleDateFormat("hh:mm a");
//                    _24HourDt = _24HourSDF.parse(asr);
//                    asr=_12HourSDF.format(_24HourDt);
//
//
//                    _24HourSDF = new SimpleDateFormat("HH:mm");
//                    _12HourSDF = new SimpleDateFormat("hh:mm a");
//                    _24HourDt = _24HourSDF.parse(magrib);
//                    magrib=_12HourSDF.format(_24HourDt);
//
//
//                            next_namaz.setText("magrib"+" "+magrib);
//                            curr_namaz.setText("aser"+" "+asr);
//
//                        }
//
//                       else if (curr_Time.compareTo(magrib) >= 0 && curr_Time.compareTo(isha) < 0)
//
//                       {
//
//                           _24HourSDF = new SimpleDateFormat("HH:mm");
//                           _12HourSDF = new SimpleDateFormat("hh:mm a");
//                           _24HourDt = _24HourSDF.parse(magrib);
//                           magrib=_12HourSDF.format(_24HourDt);
//
//                           _24HourSDF = new SimpleDateFormat("HH:mm");
//                           _12HourSDF = new SimpleDateFormat("hh:mm a");
//                           _24HourDt = _24HourSDF.parse(isha);
//                           isha=_12HourSDF.format(_24HourDt);
//
//
//                            next_namaz.setText("isha"+" "+isha);
//                            curr_namaz.setText("magrib"+" "+magrib);
//                        }
//
//                       else if (curr_Time.compareTo(isha) >= 0)
//
//                       {
//
//                           _24HourSDF = new SimpleDateFormat("HH:mm");
//                           _12HourSDF = new SimpleDateFormat("hh:mm a");
//                           _24HourDt = _24HourSDF.parse(fajr);
//                            fajr=_12HourSDF.format(_24HourDt);
//
//
//                           _24HourSDF = new SimpleDateFormat("HH:mm");
//                           _12HourSDF = new SimpleDateFormat("hh:mm a");
//                           _24HourDt = _24HourSDF.parse(isha);
//                           isha=_12HourSDF.format(_24HourDt);
//
//
//                            next_namaz.setText("fajer"+" "+fajr);
//                            curr_namaz.setText("isha"+" "+isha);
//                        }
//
//                       else {
//
//
//                        _24HourSDF = new SimpleDateFormat("HH:mm");
//                        _12HourSDF = new SimpleDateFormat("hh:mm a");
//                        _24HourDt = _24HourSDF.parse(fajr);
//                        fajr=_12HourSDF.format(_24HourDt);
//
//
//                        _24HourSDF = new SimpleDateFormat("HH:mm");
//                        _12HourSDF = new SimpleDateFormat("hh:mm a");
//                        _24HourDt = _24HourSDF.parse(isha);
//                        isha=_12HourSDF.format(_24HourDt);
//
//                        next_namaz.setText("fajer"+" "+fajr);
//                        curr_namaz.setText("isha"+" "+isha);
//
//                            }
//
//
//
//                    }
//                catch (JSONException ex)
//                {
//                    Toast.makeText(MainActivity.this, ""+ex.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
////                Toast.makeText(MainActivity.this, "error volly", Toast.LENGTH_SHORT).show();
//            }
//        }
//
//
//        );
//        requestQueue.add(objectRequest);
//    }

    private void GetPrayer_api() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, SAU_date_Api.DATE_API, null, new Response.Listener<JSONObject>() {
            public void onResponse(JSONObject response) {

                try {
                    JSONObject enter = response.getJSONObject("data").getJSONObject("timings");
                    fajr = enter.getString("Fajr");
                    zohr = enter.getString("Dhuhr");
                    asr = enter.getString("Asr");
String hr=String.valueOf(Integer.parseInt(asr.substring(0,2))+1);
                String min=    asr.substring(2, 5).trim();
                asr=hr+min;

                    Log.v("Hassan","ASAR :    "+asr);
                    magrib = enter.getString("Maghrib");
                    isha = enter.getString("Isha");
                    sun_set= enter.getString("Sunset");
                    sun_rise = enter.getString("Sunrise");


                    _24HourSDF = new SimpleDateFormat("HH:mm");
                    _12HourSDF = new SimpleDateFormat("hh:mm a");
                    _24HourDt = _24HourSDF.parse(sun_set);
                    Sun_set.setText(_12HourSDF.format(_24HourDt));


                    _24HourSDF = new SimpleDateFormat("HH:mm");
                    _12HourSDF = new SimpleDateFormat("hh:mm a");
                    _24HourDt = _24HourSDF.parse(sun_rise);


                    Sun_rise.setText(_12HourSDF.format(_24HourDt));




//                    _24HourSDF = new SimpleDateFormat("HH:mm");
//                    _12HourSDF = new SimpleDateFormat("hh:mm a");
//                    _24HourDt = _24HourSDF.parse(isha);
//
//                    isha=_12HourSDF.format(_24HourDt);
//
//                    _24HourSDF = new SimpleDateFormat("HH:mm");
//                    _12HourSDF = new SimpleDateFormat("hh:mm a");
//                    _24HourDt = _24HourSDF.parse(fajr);
//                    fajr=_12HourSDF.format(_24HourDt);
//
//
//                    _24HourSDF = new SimpleDateFormat("HH:mm");
//                    _12HourSDF = new SimpleDateFormat("hh:mm a");
//                    _24HourDt = _24HourSDF.parse(zohr);
//                    zohr=_12HourSDF.format(_24HourDt);
//
//
//                    _24HourSDF = new SimpleDateFormat("HH:mm");
//                    _12HourSDF = new SimpleDateFormat("hh:mm a");
//                    _24HourDt = _24HourSDF.parse(asr);
//                    asr=_12HourSDF.format(_24HourDt);
//
//
//                    _24HourSDF = new SimpleDateFormat("HH:mm");
//                    _12HourSDF = new SimpleDateFormat("hh:mm a");
//                    _24HourDt = _24HourSDF.parse(magrib);
//                    magrib=_12HourSDF.format(_24HourDt);








                    curr_Time = new SimpleDateFormat("HH:mm").format(new Date());


                    if (curr_Time.compareTo(fajr) >= 0 && curr_Time.compareTo(zohr) < 0)
                    {

                        _24HourSDF = new SimpleDateFormat("HH:mm");
                        _12HourSDF = new SimpleDateFormat("hh:mm a");
                        _24HourDt = _24HourSDF.parse(fajr);
                        fajr=_12HourSDF.format(_24HourDt);


                        _24HourSDF = new SimpleDateFormat("HH:mm");
                        _12HourSDF = new SimpleDateFormat("hh:mm a");
                        _24HourDt = _24HourSDF.parse(zohr);
                        zohr=_12HourSDF.format(_24HourDt);



                        next_namaz.setText("zoher"+" "+zohr);
                        curr_namaz.setText("fajer"+" "+fajr);

                    }

                    else  if (curr_Time.compareTo(zohr) >= 0 && curr_Time.compareTo(asr) < 0)
                    {


                        _24HourSDF = new SimpleDateFormat("HH:mm");
                        _12HourSDF = new SimpleDateFormat("hh:mm a");
                        _24HourDt = _24HourSDF.parse(zohr);
                        zohr=_12HourSDF.format(_24HourDt);

                        _24HourSDF = new SimpleDateFormat("HH:mm");
                        _12HourSDF = new SimpleDateFormat("hh:mm a");
                        _24HourDt = _24HourSDF.parse(asr);
                        asr=_12HourSDF.format(_24HourDt);

                        next_namaz.setText("aser"+" "+asr);
                        curr_namaz.setText("zoher"+" "+zohr);

                    }

                    else  if (curr_Time.compareTo(asr) >= 0 && curr_Time.compareTo(magrib) < 0)
                    {

                        _24HourSDF = new SimpleDateFormat("HH:mm");
                        _12HourSDF = new SimpleDateFormat("hh:mm a");
                        _24HourDt = _24HourSDF.parse(asr);
                        asr=_12HourSDF.format(_24HourDt);


                        _24HourSDF = new SimpleDateFormat("HH:mm");
                        _12HourSDF = new SimpleDateFormat("hh:mm a");
                        _24HourDt = _24HourSDF.parse(magrib);
                        magrib=_12HourSDF.format(_24HourDt);


                        next_namaz.setText("magrib"+" "+magrib);
                        curr_namaz.setText("aser"+" "+asr);

                    }

                    else if (curr_Time.compareTo(magrib) >= 0 && curr_Time.compareTo(isha) < 0)

                    {

                        _24HourSDF = new SimpleDateFormat("HH:mm");
                        _12HourSDF = new SimpleDateFormat("hh:mm a");
                        _24HourDt = _24HourSDF.parse(magrib);
                        magrib=_12HourSDF.format(_24HourDt);

                        _24HourSDF = new SimpleDateFormat("HH:mm");
                        _12HourSDF = new SimpleDateFormat("hh:mm a");
                        _24HourDt = _24HourSDF.parse(isha);
                        isha=_12HourSDF.format(_24HourDt);


                        next_namaz.setText("isha"+" "+isha);
                        curr_namaz.setText("magrib"+" "+magrib);
                    }

                    else if (curr_Time.compareTo(isha) >= 0)

                    {

                        _24HourSDF = new SimpleDateFormat("HH:mm");
                        _12HourSDF = new SimpleDateFormat("hh:mm a");
                        _24HourDt = _24HourSDF.parse(fajr);
                        fajr=_12HourSDF.format(_24HourDt);


                        _24HourSDF = new SimpleDateFormat("HH:mm");
                        _12HourSDF = new SimpleDateFormat("hh:mm a");
                        _24HourDt = _24HourSDF.parse(isha);
                        isha=_12HourSDF.format(_24HourDt);


                        next_namaz.setText("fajer"+" "+fajr);
                        curr_namaz.setText("isha"+" "+isha);
                    }

                    else {


                        _24HourSDF = new SimpleDateFormat("HH:mm");
                        _12HourSDF = new SimpleDateFormat("hh:mm a");
                        _24HourDt = _24HourSDF.parse(fajr);
                        fajr=_12HourSDF.format(_24HourDt);


                        _24HourSDF = new SimpleDateFormat("HH:mm");
                        _12HourSDF = new SimpleDateFormat("hh:mm a");
                        _24HourDt = _24HourSDF.parse(isha);
                        isha=_12HourSDF.format(_24HourDt);

                        next_namaz.setText("fajer"+" "+fajr);
                        curr_namaz.setText("isha"+" "+isha);

                    }



                }
                catch (JSONException ex)
                {
//                    Toast.makeText(MainActivity.this, ""+ex.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                } catch (ParseException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

//                Toast.makeText(MainActivity.this, "error volly", Toast.LENGTH_SHORT).show();
            }
        }


        );
        requestQueue.add(objectRequest);
    }
    private void GetPrayer_hijri() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, SAU_date_Api.DATE_API, null, new Response.Listener<JSONObject>() {
            public void onResponse(JSONObject response) {

                try {
                    JSONObject enter = response.getJSONObject("data").getJSONObject("date");
                    JSONObject jsonObject=enter.getJSONObject("hijri");

                    String get_hijri=jsonObject.getString("date");
                     gorgeon.setText(get_hijri);


                }
                catch (JSONException ex)
                {
//                    Toast.makeText(MainActivity.this, ""+ex.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

//                Toast.makeText(MainActivity.this, "error volly", Toast.LENGTH_SHORT).show();
            }
        }


        );
        requestQueue.add(objectRequest);
    }




    public void View_layout() {
        home = findViewById(R.id.homee);
        liberary = findViewById(R.id.liberaryy);
        live = findViewById(R.id.livee);
        quran = findViewById(R.id.gurann);
        ibadat = findViewById(R.id.ibadatt);
        islamic_D_T = findViewById(R.id.pak_time);
        madina_D_T = findViewById(R.id.madina_time);
        curr_namaz = findViewById(R.id.current_namaz);
        next_namaz = findViewById(R.id.next_namaz);
        gorgeon = findViewById(R.id.gorgion);
        l_georgeon_D_T = findViewById(R.id.islamic_geo);
        qibla=findViewById(R.id.qibla);
        Sun_set=findViewById(R.id.sun_set);
        Sun_rise=findViewById(R.id.sun_rise);


        homeT = findViewById(R.id.home);
        libraryT = findViewById(R.id.liberary);
        liveT = findViewById(R.id.live);
        quranT = findViewById(R.id.quran);
        ibadatT = findViewById(R.id.ibadat);

        MainActivity.this.openFragment(new LiberaryFragment());
        MainActivity.this.homeT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorWhite, null));
        MainActivity.this.libraryT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorWhite, null));
        MainActivity.this.quranT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorWhite, null));
        MainActivity.this.ibadatT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorWhite, null));
        MainActivity.this.liveT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorWhite, null));

    }

    public void Date_Time_of_Any_Country(String id,String code)
    {
        if (Build.VERSION.SDK_INT >= 26)
        {


            if (id.equals("Asia/Karachi"))
            {

                ZoneId z = ZoneId.of( id ) ;

                LocalTime localTime = LocalTime.now( z ) ;
                Locale locale_en_US = Locale.forLanguageTag(code);
                DateTimeFormatter formatterUS = DateTimeFormatter.ofLocalizedTime( FormatStyle.SHORT ).withLocale( locale_en_US ) ;
                String output = localTime.format( formatterUS ) ;

                LocalDate locale_date= LocalDate.now(z);
                Locale locale_SAU_date = Locale.forLanguageTag(code);

                DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale( locale_SAU_date ) ;
                String output2 = locale_date.format( formatter ) ;


                _24HourSDF = new SimpleDateFormat("HH:mm");
                _12HourSDF = new SimpleDateFormat("hh:mm a");
                try {
                    _24HourDt = _24HourSDF.parse(output);
                    islamic_D_T.setText(_12HourSDF.format(_24HourDt)+"\n"+output2);

                } catch (ParseException e) {
                    e.printStackTrace();
                }



            }
            else if (id.equals("Asia/Riyadh"))
            {
//                ZonedDateTime zdt2 = ZonedDateTime.now(denverTimeZone);
//                m_time = zdt2.toLocalTime().toString();
//                m_date = zdt2.toLocalDate().toString();



                ZoneId z = ZoneId.of( id ) ;

                LocalTime localTime = LocalTime.now( z ) ;
                Locale locale_en_US = Locale.forLanguageTag(code);
                DateTimeFormatter formatterUS = DateTimeFormatter.ofLocalizedTime( FormatStyle.SHORT ).withLocale( locale_en_US ) ;
                String outputUS = localTime.format( formatterUS ) ;

                LocalDate locale_date= LocalDate.now(z);
                Locale locale_SAU_date = Locale.forLanguageTag(code);

                DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale( locale_SAU_date ) ;
                String outputUS2 = locale_date.format( formatter ) ;



                _24HourSDF = new SimpleDateFormat("HH:mm");
                _12HourSDF = new SimpleDateFormat("hh:mm a");
                try {
                    _24HourDt = _24HourSDF.parse(outputUS);
                    madina_D_T.setText(_12HourSDF.format(_24HourDt)+"\n"+outputUS2);

                } catch (ParseException e) {
                    e.printStackTrace();
                }



            }















        }






    }




    public void georgeon_Date()
    {
        HGDate hgDate = new HGDate();
        hgDate.toHigri();
//        TextView textView = this.gorgeon;
        StringBuilder sb = new StringBuilder();
        sb.append(NumbersLocal.convertNumberType(getApplicationContext(), String.valueOf(hgDate.getDay()).trim()));
        String str = " ";
        sb.append(str);
//        sb.append(Dates.islamicMonthName(getApplicationContext(), Integer.valueOf(hgDate.getMonth()).intValue() - 1).trim());
//        textView.setText(sb.toString());












    }





    public void bottomNav_Click()
    {
        this.home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {


                if (get_name.equals(""))
                {
                    openFragment(new HomeFragment());
                }
                else
                {
                    openFragment(HomeFragment.newInstance(get_name,get_number,get_pass));

                }


                home_txt.setText("Home");
                MainActivity.this.homeT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorText, null));
                MainActivity.this.libraryT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorWhite, null));
                MainActivity.this.quranT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorWhite, null));
                MainActivity.this.ibadatT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorWhite, null));
                MainActivity.this.liveT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorWhite, null));

                final int sdk = android.os.Build.VERSION.SDK_INT;
                if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN)
                {
                    back_img.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.home_bg) );
                } else {
                    back_img.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.home_bg));
                }


            }
        });
        this.liberary.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.openFragment(new LiberaryFragment());
                MainActivity.this.homeT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorWhite, null));
                MainActivity.this.libraryT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorText, null));
                MainActivity.this.quranT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorWhite, null));
                MainActivity.this.ibadatT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorWhite, null));
                MainActivity.this.liveT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorWhite, null));


                final int sdk = android.os.Build.VERSION.SDK_INT;
                if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN)
                {
                    back_img.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.bg_liberary) );
                }
                else
                    {
                    back_img.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.bg_liberary));
                   }


                home_txt.setText("Liberary");


            }
        });
        this.quran.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.openFragment(new QuranFragment());
                MainActivity.this.homeT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorWhite, null));
                MainActivity.this.libraryT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorWhite, null));
                MainActivity.this.quranT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorText, null));
                MainActivity.this.ibadatT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorWhite, null));
                MainActivity.this.liveT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorWhite, null));


                final int sdk = android.os.Build.VERSION.SDK_INT;
                if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN)
                {
                    back_img.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.bg_quran) );
                } else {
                    back_img.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.bg_quran));
                }


                home_txt.setText("Quran");

            }
        });
        this.live.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                MainActivity.this.openFragment(new LiveFragment());

                MainActivity.this.homeT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorWhite, null));
                MainActivity.this.libraryT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorWhite, null));
                MainActivity.this.quranT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorWhite, null));
                MainActivity.this.ibadatT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorWhite, null));
                MainActivity.this.liveT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorText, null));


                final int sdk = android.os.Build.VERSION.SDK_INT;
                if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN)
                {
                    back_img.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.bg_live) );
                } else {
                    back_img.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.bg_live));
                }




                home_txt.setText("Live");


            }
        });
        this.ibadat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.openFragment(new IbadatFragment());
                MainActivity.this.homeT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorWhite, null));
                MainActivity.this.libraryT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorWhite, null));
                MainActivity.this.quranT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorWhite, null));
                MainActivity.this.ibadatT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorText, null));
                MainActivity.this.liveT.setTextColor(ResourcesCompat.getColor(MainActivity.this.getResources(), R.color.colorWhite, null));

                final int sdk = android.os.Build.VERSION.SDK_INT;
                if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN)
                {
                    back_img.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.bg_ibadat) );
                } else {
                    back_img.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.bg_ibadat));
                }



                home_txt.setText("Ibadat");



            }
        });
    }

    public void openFragment(Fragment fragment)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void onBackPressed() {
        super.onBackPressed();
        ActivityCompat.finishAffinity(this);
//        Process.killProcess(Process.myPid());
    }

    @Override
    public void onClick(View v) {



        switch (v.getId()){


            case R.id.About:
            case R.id.Abouttxt:
            case R.id.Bstatuseslyt:

                startActivity(new Intent(this,aboutActivity.class));
                break;
            case R.id.signoutpic:
            case R.id.signoutlyt:
            case R.id.signouttxt:
                unsuscribe();
                break;
            case R.id.signuppic:
            case R.id.signuplyt:
            case R.id.signuptxt:
                startActivity(new Intent(getApplicationContext(), SignupActivity.class).putExtra("chk","main")
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK).addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY));

                break;
            case R.id.share:
            case R.id.sharetxt:
                 new share(this);
                break;



            case R.id.home_text:
            case R.id.home:
            case R.id.homelyt:


                startActivity(new Intent(this,MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

                break;

            case R.id.About1:
            case R.id.Abouttxt1:
            case R.id.Bstatuseslyt1:

            getOpenFacebookIntent("211680932500811");

//                Toast.makeText(this, "hahhaha", Toast.LENGTH_SHORT).show();


                break;


            case R.id.About2:
            case R.id.Abouttxt2:
            case R.id.Bstatuseslyt2:

                Intent intent=null;
                try {
                    intent =new Intent(Intent.ACTION_VIEW);
                    intent.setPackage("com.google.android.youtube");
                    intent.setData(Uri.parse("https://www.youtube.com/channel/UCmV5CFC6bbZmMhqTUqZdlrg?view_as=subscriber"));
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.youtube.com/channel/UCmV5CFC6bbZmMhqTUqZdlrg?view_as=subscriber"));
                    startActivity(intent);
                }
                    break;



            case R.id.About3:
            case R.id.Abouttxt3:
            case R.id.Bstatuseslyt3:

                Toast.makeText(this, "3D view not avail", Toast.LENGTH_SHORT).show();
                break;

        }




    }




    public void calander_upoad()
    {
        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference();
        HashMap hashMap=new HashMap();
        hashMap.put("name","islamic-converted.pdf");
        hashMap.put("uri","https://firebasestorage.googleapis.com/v0/b/islamicapp-c372d.appspot.com/o/pdf%2Fislamic-converted.pdf?alt=media&token=ca53525c-c797-4e60-9b86-649b661ba665");
        databaseReference.child("pdf").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
            @Override
            public void onSuccess(Object o) {

            }
        });

    }





    public void  getOpenFacebookIntent(String id)
    {

        try {
//
        Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("fb://page/"+id));
        startActivity(intent);


        } catch (Exception e)
        {

            Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/"+id));
            startActivity(intent);

        }
    }





    public void get_alert()
    {

        if (!get_number.equals(""))
        {

            DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference()
                    .child("alert").child(get_number);
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    if (dataSnapshot.hasChildren())
                    {
                        String noti=dataSnapshot.child("notification").getValue().toString();
                        if (noti.equals("success"))
                        {
                            relativeLayout.setVisibility(View.VISIBLE);

                        }
                        else
                        {
                            relativeLayout.setVisibility(View.INVISIBLE);
                        }

                    }
                    else
                    {
//                        Toast.makeText(MainActivity.this, "no child", Toast.LENGTH_SHORT).show();
                    }


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }


    }



    public void Get_budge_database()
    {

        if (!get_number.equals(""))
        {

            DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference()
                    .child("notification");
//
//            DatabaseReference databaseReference1=FirebaseDatabase.getInstance().getReference()
//                    .child("notification").child(get_number);


            databaseReference.child(get_number).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                {

                    if (dataSnapshot.hasChildren())
                    {
                        for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                        {
                            String budge= String.valueOf(dataSnapshot1.child("count").getValue());
                            String noti=dataSnapshot1.child("notification").getValue().toString();

//                            Toast.makeText(MainActivity.this, ""+budge, Toast.LENGTH_LONG).show();


                            counter.setText(budge);


                        }

                    }
                    else
                    {
//                        Toast.makeText(MainActivity.this, "no", Toast.LENGTH_SHORT).show();
                    }





                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });


        }



    }


    private  void set_islamic_date(){
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Admin_DATA");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                     try {

                        if ( dataSnapshot.hasChild("K_6")){
                            String x=     dataSnapshot.child("K_6").getValue().toString().trim();
                            if (!TextUtils.isEmpty(x)){
                                l_georgeon_D_T.setText(x);


                            }
                        }else {
                            l_georgeon_D_T.setText("N/A");

                        } }catch (Exception e)
                     {
                        Log.v("Hassan","Book error: "+e );

                }
            }

            @Override
            public void onCancelled(DatabaseError error)
            {

            }
        });
    }
    private void greetings(){

        try {  MediaPlayer mp = MediaPlayer.create(this, R.raw.asa);

            if(! mp.isPlaying()){
                mp.start();}
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(mp!=null){

                        if(mp.isPlaying()){
                            mp.stop();
                        }
                        mp.release();

                    }
                }
            }, 5000);
        }catch (Exception e){}
    }
    private void getUser(){
        if (TextUtils.isEmpty(get_number)){
            Log.v("k","--->user not vailibel: "+get_name+", "+get_number);
            findViewById(R.id.signoutlyt).setVisibility(View.GONE);
            findViewById(R.id.signuplyt).setVisibility(View.VISIBLE);
        }else {

            Log.v("k","---->user vailibel: "+get_name+", "+get_number);
            findViewById(R.id.signoutlyt).setVisibility(View.VISIBLE);
            findViewById(R.id.signuplyt).setVisibility(View.GONE);
        }
    }
    private void unsuscribe(){


        if (!get_number.equals("")){

        remove_user_record(get_number);

        Log.v("k","user to unsuscribe: "+get_name+", "+get_number);
    }else {

            Log.v("k","No user to unsuscribe: "+get_name+", "+get_number);
        }
    }

    public void remove_user_record(String num)
    {

        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference()
                .child("user_record");



        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dsp:dataSnapshot.getChildren()){
                    if (dsp.hasChildren()){

                        Log.v("k"," num in db: "+num+" num in shp: "+dsp.child("phone").getValue());
                        if (dsp.child("phone").getValue().toString().equals(num)){
                            Log.v("k","delled___> num in db: "+num+" num in shp: "+dsp.child("phone").getValue());
                                dataSnapshot.getRef().removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        getSharedPreferences("login", MODE_PRIVATE).edit().clear().apply();

                                        startActivity(new Intent(getApplicationContext(),MainActivity.class).putExtra("chk","main")
                                                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                                                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                                                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                                .addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY));
                                        Toast.makeText(MainActivity.this, "Signout Successful", Toast.LENGTH_SHORT).show();
                                    }
                                });


                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

    @Override
    protected void onResume() {
        getUser();
        super.onResume();
    }
}
