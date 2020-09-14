package com.developer.islamicapp.Fragments;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.developer.islamicapp.Activities.SignupActivity;
import com.developer.islamicapp.Model.Constants;
import com.developer.islamicapp.Model.StoryModel;
import com.developer.islamicapp.Network.NetworkState;
import com.developer.islamicapp.R;
import com.developer.islamicapp.utils.Typcastregular;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;

import static android.content.Context.MODE_PRIVATE;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private  TextView itla_e_mehfil_text,
            hadeesoftheday_text
            ,ayatoftheday_txt,
            wazifa_text,
            eventoftheday_text,
            islamicdate_text,admin_calander,counter;

     DatabaseReference databaseReference,databaseReferenceIMG;
     ArrayList<String> image_uri_array=new ArrayList<>();
    long enqueID;
    DownloadManager downloadManager;
    private  View view;
    String event_admin,hadese_admin,mahfil_admin,namaz_time_admin,ques_admin,wazifa_admin,islamic_cal,isamic_count;
    String ayat_admin="";
LottieAnimationView l1,l2,l3,l4,l5,l6;


    private Button signup_button;
    RelativeLayout signUp_lyt,admin_lyt;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    EditText answer_admin;
    TextView counter_admin;
    LinearLayout linearLayout;

    private String mParam1;
    private String mParam2;
    private String mParam3;
    SimpleDateFormat _24HourSDF;
    SimpleDateFormat _12HourSDF;
    Date _24HourDt;
    TextView admin_ques;
    ImageView calandr_img;
    EditText admin_ans;
    RelativeLayout relativeLayout;
    TextView signUp;
    Button submit_btn;
    String get_name,get_pass,get_number;
    CountDownTimer countDownTimer;
     StoryModel f;
    String output2;





    public static HomeFragment newInstance(String param1, String param2, String param3)
    {

        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
        fragment.setArguments(args);

        return fragment;
    }

    public HomeFragment()
    {
        // Required empty public constructor
    }


    @Override
    public void onResume() {
        super.onResume();
        Database_admin();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_home, container, false);

        Typcastregular.Typcastregular(getContext(), "SERIF", "Poppins-Regular.otf");


        l1=view.findViewById(R.id.loading1);
        l2=view.findViewById(R.id.loading2);
        l3=view.findViewById(R.id.loading3);
        l4=view.findViewById(R.id.loading4);
        l5=view.findViewById(R.id.loading5);
        l6=view.findViewById(R.id.loading6);


        itla_e_mehfil_text=view.findViewById(R.id.itla_e_mehfil_text);
        hadeesoftheday_text=view.findViewById(R.id.hadeesoftheday_text);
        ayatoftheday_txt=view.findViewById(R.id.ayatoftheday_txt);
        wazifa_text=view.findViewById(R.id.wazifa_text);
        eventoftheday_text=view.findViewById(R.id.eventoftheday_text);
        islamicdate_text=view.findViewById(R.id.islamicdate_text);
        admin_calander=view.findViewById(R.id.admin_calander);
        submit_btn=view.findViewById(R.id.submit_ans);
        signup_button=view.findViewById(R.id.signup_button);
        signup_button.setOnClickListener(this);
        signUp_lyt=view.findViewById(R.id.signup_lyt);
        admin_lyt=view.findViewById(R.id.admin_lyt);
        admin_ques=view.findViewById(R.id.admin_ques);
        admin_ans=view.findViewById(R.id.admin_answer);
        counter=view.findViewById(R.id.counter_admin);
        calandr_img=view.findViewById(R.id.calander_img);

        f = new StoryModel();

        calandr_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fetch_pdf("islamic-converted.pdf");


//                if (f.getFilename().equals("not exist"))
//                {
//                    view_calander();
//                }
//                else
//                {
//                    Intent intent = new Intent(Intent.ACTION_VIEW);
//                    intent.setDataAndType(f.getUri(), "application/pdf");
//                    intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//                    startActivity(intent);
//
//
//                }


            }
        });

//        countDownTimer=new CountDownTimer(10000,1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//
//                counter.setText("Time Left: "+ millisUntilFinished / 1000);
////
//
//
//            }
//
//            @Override
//            public void onFinish() {
//                QuestionNotAvailible(" ");
//
//
//                counter.setText("Time to answer the question is over");
//                counter.setVisibility(View.GONE);
//            }
//        };










        if (getArguments() != null)
        {

            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
//
//            admin_lyt.setVisibility(View.VISIBLE); Database_admin decidwes k show karna ha admin_lyt ko ya ni

            signUp_lyt.setVisibility(View.GONE);
//            Toast.makeText(getContext(), "ha"+mParam1, Toast.LENGTH_SHORT).show();

            Database_admin();





        }
        else
        {
//
            admin_lyt.setVisibility(View.GONE);
            signUp_lyt.setVisibility(View.VISIBLE);


//            Toast.makeText(getContext(), "nhi"+mParam1, Toast.LENGTH_SHORT).show();


        }




        Date_Time_of_Any_Country("Asia/Karachi","PK");



        return  view  ;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.signup_button:
                getActivity().startActivity(new Intent(getActivity(), SignupActivity.class).putExtra("chk","main")
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK).addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY));

                break;


        }
    }





    public void Database_admin()
    {
        loadingstart();

         databaseReference= FirebaseDatabase.getInstance().getReference().child("Admin_DATA");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               if (dataSnapshot.hasChildren())
                {
                    try{
                        ayat_admin=dataSnapshot.child("Ayat of the Day").getValue().toString();
                      event_admin=dataSnapshot.child("Event of the day").getValue().toString();
                      hadese_admin=dataSnapshot.child("hadees of the day").getValue().toString();
                      mahfil_admin=dataSnapshot.child("Itlaa e Mahfil").getValue().toString();
                      namaz_time_admin=dataSnapshot.child("Namaze Time of the Year").getValue().toString();
                      ques_admin=dataSnapshot.child("Question of the day").getValue().toString();
                      wazifa_admin=dataSnapshot.child("Wazifa of the day").getValue().toString();
                      islamic_cal=dataSnapshot.child("IslamicCalander").getValue().toString();
                      isamic_count=dataSnapshot.child("second").getValue().toString();}
                    catch (Exception e){}
if (TextUtils.isEmpty(ayat_admin)){
    ayat_admin="NA";
}

                    if (TextUtils.isEmpty(event_admin)){
                        event_admin="NA";
                    }
                    if (TextUtils.isEmpty(hadese_admin)){
                        hadese_admin="NA";
                    }
                    if (TextUtils.isEmpty(mahfil_admin)){
                        mahfil_admin="NA";
                    }
                    if (TextUtils.isEmpty(namaz_time_admin)){
                        namaz_time_admin="NA";
                    }
                    if (TextUtils.isEmpty(ques_admin)){
                        ques_admin="NA";
                    }else {
                        if (chkUserSiginState()){
                        QuestionAvailible();

                            admin_ques.setText(ques_admin);}

//                        String x;
//                        try {
//
//                              x=getContext().getSharedPreferences("same", Context.MODE_PRIVATE).getString("las",ques_admin);
//                            if (! (x.trim().equals(ques_admin.trim()))){
//
//                                getContext().getSharedPreferences("answered", Context.MODE_PRIVATE).edit().putBoolean("chk",true).apply();
//                                Log.v("dell","answer not same");
//                            }
//                        }catch (Exception e){
//                            x=e.toString();
//                        }

                    }
                    if (TextUtils.isEmpty(wazifa_admin)){
                        wazifa_admin="NA";
                    }if (TextUtils.isEmpty(islamic_cal)){
                    islamic_cal="NA";
                }if (TextUtils.isEmpty(isamic_count)){
                    isamic_count="NA";
                }else {

                    counter.setText("Time Left: "+ isamic_count);
                }


                    ayatoftheday_txt.setText(ayat_admin);
                    eventoftheday_text.setText(event_admin);
                    itla_e_mehfil_text.setText(mahfil_admin);
                    itla_e_mehfil_text.setVisibility(View.VISIBLE);
                    hadeesoftheday_text.setText(hadese_admin);
                    wazifa_text.setText(wazifa_admin);
                    admin_calander.setText(islamic_cal);

                    if (!ayat_admin.isEmpty()||!hadese_admin.isEmpty()||!wazifa_admin.isEmpty()){
                        loadingover();
                      }


//isko less then one karna ha
                    if (chkUserSiginState()){

                    if (Integer.parseInt(isamic_count)<=1)
                    {
//                        view.findViewById(R.id.admin_lyt).setVisibility(View.GONE);
                       QuestionTimeisOVER();

                        counter.setText("Time to answer the question is over");
                    }
                    else
                    {
                        //if ans not submittes and ans availible
try {


    if (getActivity().getSharedPreferences("answered", MODE_PRIVATE).getBoolean("chk", true) && !TextUtils.isEmpty(ques_admin))
    {
        QuestionNotAnswered();

        Log.v("dell", "answer not answed");
        Log.v("dell", "conditions:  chk if needed to ans: " + getContext().getSharedPreferences("answered", MODE_PRIVATE).getBoolean("chk", true)
                + ", ques: " + ques_admin);


        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (getArguments() != null) {
                    mParam1 = getArguments().getString(ARG_PARAM1);
                    mParam2 = getArguments().getString(ARG_PARAM2);

                    if (TextUtils.isEmpty(admin_ans.getText().toString().trim())) {
                        admin_ans.setError("Please fill up your answer");
                    } else {


                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                            ZoneId z = ZoneId.of("Asia/Karachi");
                            LocalTime localTime = LocalTime.now(z);
                            LocalDate locale_date = LocalDate.now(z);
                            Locale locale_SAU_date = Locale.forLanguageTag("PK");

                            DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(locale_SAU_date);
                            output2 = locale_date.format(formatter);


                        }

                        String curr_Time = new SimpleDateFormat("HH:mm").format(new Date());

                        try {

                            _24HourSDF = new SimpleDateFormat("HH:mm");
                            _12HourSDF = new SimpleDateFormat("hh:mm a");
                            _24HourDt = _24HourSDF.parse(curr_Time);

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }


                        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference()
                                .child("Admin_Ans");

                        HashMap hashMap = new HashMap();
                        hashMap.put("name", mParam1);
                        hashMap.put("phone", mParam2);
                        hashMap.put("answer", admin_ans.getText().toString());
                        hashMap.put("time", _12HourSDF.format(_24HourDt));
                        hashMap.put("date", output2);


                        databaseReference.push().updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {
                                QuestionAnswered();

                                Log.v("dell", "anser written");
                                Toast.makeText(getContext(), "Thank You!\nyour answer has been submitted", Toast.LENGTH_SHORT).show();

                            }
                        });


                    }

                }

            }
        });
    }



    else

        {

            QuestionAnswered();

        Log.v("dell", "answer  answed");
        Log.v("dell", "conditions:  chk if needed to ans: " +
                getContext().getSharedPreferences("answered", MODE_PRIVATE).getBoolean("chk", true)
                + ", ques: " + ques_admin + ", same as prev ?: "
                + getContext().getSharedPreferences("same", MODE_PRIVATE).getString("las", ques_admin).equals(ques_admin) + ", prev q: " + getContext().getSharedPreferences("same", MODE_PRIVATE).getString("las", ques_admin));

    }
}catch (Exception e){

}
                             }



                    }














                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




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

                DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale( locale_SAU_date ) ;
                String output2 = locale_date.format( formatter ) ;


                islamicdate_text.setText(output2);




            }















        }






    }





    public void view_calander()
    {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {

            if (NetworkState.isOnline(getContext()))
            {
                DatabaseReference databaseReference=FirebaseDatabase.getInstance()
                        .getReference().child("pdf");
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if (dataSnapshot.hasChildren())
                        {
                            String cal_uri=dataSnapshot.child("uri").getValue().toString();
                            String name=dataSnapshot.child("name").getValue().toString();
                            download_file(cal_uri,name);
                            Toast.makeText(getContext(), "staring downloading", Toast.LENGTH_SHORT).show();


                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
            else
            {

                Toast.makeText(getContext(), "no internet avail", Toast.LENGTH_SHORT).show();
            }
        }


    }

    public  void  fetch_pdf(String book_name)
    {


        File file = new File(Environment.getExternalStorageDirectory(),
                Constants.FOLDER_NAME2 + "/" + book_name);


        if (file.exists())
        {



            f.setFilename("exist");
//             Uri uri = FileProvider.getUriForFile(getContext(), getContext().getPackageName(),file);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            {

                Uri uri= FileProvider.getUriForFile(Objects.requireNonNull(getContext()),
                        getContext().getPackageName() + ".provider", file);
                f.setUri(uri);

                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(uri, "application/pdf");
                    intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(intent);

//                Toast.makeText(getContext(), "exist", Toast.LENGTH_LONG).show();

            }
            else
            {
//                Toast.makeText(getActivity(), "version issue", Toast.LENGTH_SHORT).show();
            }

        }
        else
        {
            f.setFilename("not exist");
//            Toast.makeText(getContext(), "not exist", Toast.LENGTH_LONG).show();


            view_calander();

        }

    }



    public void download_file(String url, String file_name)
    {
        DownloadManager.Request download = new DownloadManager.Request(Uri.parse(url));
        String fileName = URLUtil.guessFileName(url, null, MimeTypeMap.getFileExtensionFromUrl(url));
        download.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
        download.setTitle(fileName);
        download.setDescription("Downloading file");
        download.allowScanningByMediaScanner();
        download.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        download.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, file_name);
        downloadManager = (DownloadManager)getContext().getSystemService(getContext().DOWNLOAD_SERVICE);
        enqueID =downloadManager.enqueue(download);

    }

private void QuestionAvailible(){
        submit_btn.setVisibility(View.VISIBLE);
    admin_ans.setVisibility(View.VISIBLE);
    counter.setVisibility(View.VISIBLE);
    submit_btn.setEnabled(true);
    admin_ans.setEnabled(true);

    view.findViewById(R.id.done).setVisibility(View.GONE);
    view.findViewById(R.id.note).setVisibility(View.GONE);
 admin_lyt.setVisibility(View.VISIBLE);
    Log.v("dell","QuestionAvailible");
}
    private void QuestionNotAvailible(String answered) {

        submit_btn.setVisibility(View.GONE);
        admin_ans.setVisibility(View.GONE);
        counter.setVisibility(View.VISIBLE);
        submit_btn.setEnabled(false);
        admin_ans.setEnabled(false);
        Log.v("dell","QuestionNotAvailible");

        ////

        admin_ans.setText("");
        if (TextUtils.isEmpty(answered)){
            admin_ques.setText("Question for umrah tickets will be announced soon");
    }

    }
    private void QuestionNotAnswered(){

        Log.v("dell","QuestionNotAnswered");
       QuestionAvailible();

    } private void QuestionAnswered(){
        Log.v("dell","QuestionAnswered");

        QuestionNotAvailible("answered");
        getContext().getSharedPreferences("answered", MODE_PRIVATE).edit().putBoolean("chk",false).apply();
//        getContext().getSharedPreferences("same", Context.MODE_PRIVATE).edit().putString("las", ques_admin).apply();
view.findViewById(R.id.done).setVisibility(View.VISIBLE);
view.findViewById(R.id.note).setVisibility(View.VISIBLE);


    }
    private void QuestionTimeisOVER(){

        admin_lyt.setVisibility(View.GONE);
        try {
            getActivity().getSharedPreferences("answered", MODE_PRIVATE).edit().putBoolean("chk", true).apply();
        }catch ( Exception e){

        }

       //        getContext().getSharedPreferences("same", Context.MODE_PRIVATE).edit().putString("las", ques_admin).apply();
        QuestionNotAvailible(" ");
    }
    private void loadingstart(){  admin_calander.setVisibility(View.GONE);
        itla_e_mehfil_text.setVisibility(View.GONE);
        hadeesoftheday_text.setVisibility(View.GONE);
        ayatoftheday_txt.setVisibility(View.GONE);
        wazifa_text.setVisibility(View.GONE);
        eventoftheday_text.setVisibility(View.GONE);

        l1.setVisibility(View.VISIBLE);
        l1.playAnimation();
        if (!l1.isAnimating()){
        l1.resumeAnimation();}

        l2.setVisibility(View.VISIBLE);
        l2.playAnimation();
        if (!l2.isAnimating()){
        l2.resumeAnimation();}

        l3.setVisibility(View.VISIBLE);

        l3.playAnimation();
        if (!l3.isAnimating()) {

            l3.resumeAnimation();
        }
        l4.setVisibility(View.VISIBLE);
        l4.playAnimation();
        if (!l4.isAnimating()){
            l4.resumeAnimation();
        }

        l4.resumeAnimation();
        l5.setVisibility(View.VISIBLE);
        l5.playAnimation();

        if (!l5.isAnimating()){
            l5.resumeAnimation();
        }

        l6.setVisibility(View.VISIBLE);
        l6.playAnimation();

        if (!l6.isAnimating()){
            l6.resumeAnimation();
        }
        admin_calander.setVisibility(View.GONE);
        itla_e_mehfil_text.setVisibility(View.GONE);
                hadeesoftheday_text.setVisibility(View.GONE);
                ayatoftheday_txt.setVisibility(View.GONE);
                wazifa_text.setVisibility(View.GONE);
                eventoftheday_text.setVisibility(View.GONE);
    }
    private void loadingover(){
        l1.setVisibility(View.GONE);
        l1.pauseAnimation();


        l2.setVisibility(View.GONE);
        l2.pauseAnimation();

        l3.setVisibility(View.GONE);
        l3.pauseAnimation();

        l4.setVisibility(View.GONE);
        l4.pauseAnimation();

        l5.setVisibility(View.GONE);
        l5.pauseAnimation();

        l6.setVisibility(View.GONE);
       l6.pauseAnimation();

        admin_calander.setVisibility(View.VISIBLE);
        itla_e_mehfil_text.setVisibility(View.VISIBLE);
        hadeesoftheday_text.setVisibility(View.VISIBLE);
        ayatoftheday_txt.setVisibility(View.VISIBLE);
        wazifa_text.setVisibility(View.VISIBLE);
        eventoftheday_text.setVisibility(View.VISIBLE);
    }
    private boolean chkUserSiginState(){
        String user="";
        try {
            user=    getActivity().getSharedPreferences("login", MODE_PRIVATE).getString("phone", "");

        }catch (Exception e){
            return false;
        }
      if (!TextUtils.isEmpty(user) ){

           Log.v("k","user ->>>>>>> ha :    "+user);
           return  true;

       }else {

           Log.v("k","user ->>>>>>>ni  ha :    "+user);
           return false;

       }


    }
}