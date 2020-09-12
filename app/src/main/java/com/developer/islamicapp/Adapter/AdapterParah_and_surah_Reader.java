package com.developer.islamicapp.Adapter;

import android.app.Dialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.developer.islamicapp.Activities.Read_quran_Activity;
import com.developer.islamicapp.Model.data_model_arabicandurdu;
import com.developer.islamicapp.Network.NetworkState;
import com.developer.islamicapp.R;
import com.developer.islamicapp.utils.Typcast;

import java.io.File;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;
import static android.content.Context.POWER_SERVICE;


public class AdapterParah_and_surah_Reader extends RecyclerView.Adapter<AdapterParah_and_surah_Reader.ViewHolder> {

    public data_model_arabicandurdu item;
    private LayoutInflater mInflater;
    ArrayList<data_model_arabicandurdu> data=new ArrayList<>();
    ArrayList<Integer> indexxx=new ArrayList<>();
    Context context;
    String bism="بِسْمِ ٱللَّهِ ٱلرَّحْمَٰنِ ٱلرَّحِيمِ ";
String apndArabi,apndurdu;
    String chk;
    View view;
    File audio;
    String vid;
    Read_quran_Activity read_quran_activity;
    String numb,pre_pos;
     Dialog dialog;
    ProgressBar progressBar;
    long enqueID;
    DownloadManager downloadManager;
    ProgressDialog progressDialog;

    SharedPreferences.Editor editor;
    SharedPreferences prefs;
    private int selectedPos = RecyclerView.NO_POSITION;
    String Uri_audio;
    TextView start,end;
    ImageView play,recently;
    SeekBar seekBar;
    Handler handler=new Handler();
    MediaPlayer mediaPlayer;
    String timer_string="",second_string;
    String download_status="not_success";
    int Recent;
    String TEMP;
    int ayatnumber=0;
            String TEMP_urdu;
int star_of_para_surah_number;


    public AdapterParah_and_surah_Reader(Read_quran_Activity read_quran_activity, String DBx, ArrayList<data_model_arabicandurdu> data, String numb, int REcent,     ArrayList<Integer> indexxx)
    {
        this.context = read_quran_activity.getApplicationContext();
        this.read_quran_activity=read_quran_activity;
        this.data = data;
        this.mInflater = LayoutInflater.from(context);
        this.numb=numb;
        chk= DBx;
        this.Recent=REcent;

        this.indexxx=indexxx;

        Log.v("parah_surah_number",star_of_para_surah_number+" got");

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        if (chk.equals("Surah"))
        {
            view  = mInflater.inflate(R.layout.rec_item_surah_reading, parent, false);

        }
        else
            {

        view  = mInflater.inflate(R.layout.rec_item_parah_reading, parent, false);
        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        editor = context.getSharedPreferences("previous", MODE_PRIVATE).edit();
        prefs = context.getSharedPreferences("previous", MODE_PRIVATE);


//        Log.v("hassan","Parameters read auto: "+" adap   :"+":"+ numb);

        if (chk.equals("Surah"))
        {
            if (position==0) {


                for (int i = 0; i < data.size(); i++) {


                    item = data.get(i);

                    if (i != 0) {
//                    apndArabi=apndArabi+"\n"+ item.Arabic.trim()+" ";
//                    apndurdu=apndurdu+"  "+ item.Urdu.trim();

                        TEMP = TEMP +"\n"+ "\n" + item.Arabic.trim().replace("<img src=http://www.irfan-ul-quran.com/quran/images/waqf-lazim_mim_sm.png>","  ")+"❲" + (i)+ "❳ ۞" + "\n" + item.Urdu.trim();


                    } else {

                        TEMP =item.Arabic.trim().replace("<img src=http://www.irfan-ul-quran.com/quran/images/waqf-lazim_mim_sm.png>","  ")+" ۞" + "\n" + item.Urdu.trim();


                    }
//
//                    Log.v("Hassan", "main Data  manipulate:throughout::--:" + item.Arabic);
//                    Log.v("Hassan", "main Data  manipulate:throughout urdu::--:" + item.Urdu);
                }

                holder.textView.setText(TEMP);
                // holder.textView_urdu.setText(apndurdu);
            }





        }
        else
            {

                item = data.get(position);
//if (indexxx!=null){
//         ayatnumber=   indexxx.get(position);
//Log.v("TPX","aray size"+indexxx.size());
//}else {
//
//    Log.v("TPX","aray is null");
//}
                ayatnumber=item.Ayat_number;

                if (ayatnumber != 0) {

                        holder.textView.setText(item.Arabic.trim() + "❲" + (ayatnumber) + "❳ ۞");
                        holder.textView_urdu.setText( " " + item.Urdu);
                    }else{
                            holder.textView.setText(item.Arabic.trim());
                            holder.textView_urdu.setText( " " + item.Urdu);

                    Log.v("hassan","index is 0");
 }








//                if (star_of_para_surah_number != 0) {
//                    if (index.isEmpty()) {
//                        holder.textView.setText(item.Arabic.trim() + "❲" + (star_of_para_surah_number++) + "❳ ۞");
//                        holder.textView_urdu.setText("\n" + " " + item.Urdu);
//                        index.add(star_of_para_surah_number);
//                        Log.v("hassan","index is empty");
//                    }else{
//
//                        int num=0;
//                        try {
//
//                            num=index.get(position);
//                        }catch (Exception e){
//
//                        }
//                        Log.v("hassan","index is not empty: "+num );
//
//                        if (num>0) {
//                            Log.v("hassan","index is not empty: "+num+ " >0");
//
//                            holder.textView.setText(item.Arabic.trim() + "❲" + (numb) + "❳ ۞");
//                            holder.textView_urdu.setText("\n" + " " + item.Urdu);
//                        }else {
//                            holder.textView.setText(item.Arabic.trim() + "❲" + (star_of_para_surah_number++) + "❳ ۞");
//                            holder.textView_urdu.setText("\n" + " " + item.Urdu);
//                            index.add(star_of_para_surah_number);
//
//                            Log.v("hassan","index is not empty: "+num+ " <0");
//
//                        }
//                    }
//                }else {
//
//                    if (index.isEmpty()) {
//                        holder.textView.setText(item.Arabic.trim());
//                        holder.textView_urdu.setText("\n" + " " + item.Urdu);
//
//                        star_of_para_surah_number++;
//                        index.add(star_of_para_surah_number);
//                    }else{
//                        int num=0;
//                        try {
//
//                            num=index.get(position);
//                        }catch (Exception e){
//
//                        }
//                        if (num>0) {
//
//                            holder.textView.setText(item.Arabic.trim());
//                            holder.textView_urdu.setText("\n" + " " + item.Urdu);
//
//                            star_of_para_surah_number++;      }else {
//                            holder.textView.setText(item.Arabic.trim() + "❲" + (star_of_para_surah_number++) + "❳ ۞");
//
//                            holder.textView.setText(item.Arabic.trim());
//                            holder.textView_urdu.setText("\n" + " " + item.Urdu);
//
//                            star_of_para_surah_number++;
//                            index.add(star_of_para_surah_number);
//
//                        }
//                    }
//                    }
//                holder.textView.setText(item.Arabic.trim()+ "❲"+(star_of_para_surah_number++)+"❳ ۞");
//                holder.textView_urdu.setText("\n"+" "+item.Urdu);

                Log.v("parah_surah_number",": runtime"+star_of_para_surah_number);






                if (!chk.equals("Surah"))
                {



                    if (Recent>0 && Recent==position)
                    {
                        holder.textView.setTextColor(Color.parseColor("#006400"));
                        holder.textView_urdu.setTextColor(Color.parseColor("#006400"));
                    }
                    else {

                        holder.textView.setTextColor(Color.parseColor("#FFD700"));
                        holder.textView_urdu.setTextColor(Color.parseColor("#FFD700"));

                    }


                    pre_pos = prefs.getString("pre_pos1", "");
//                    Toast.makeText(context, ""+pre_pos, Toast.LENGTH_LONG).show();



                    holder.textView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v)

                        {
                            //
context.getSharedPreferences(numb,MODE_PRIVATE).edit().putInt("Recent",position).apply();


                            if (numb.equals("1"))


                            {
//

                                    vid = "audioUrl_" + (position+ 1) + ".mp3";






                                audio = new File( Environment.getExternalStorageDirectory()
                                        .getAbsolutePath()+"/Download/"+vid);
                                editor.putString("pre_pos1", String.valueOf(position+1));
                                editor.apply();

//                                Toast.makeText(context, ""+(holder.getAdapterPosition()+1), Toast.LENGTH_SHORT).show();

                            }
                            else if (numb.equals("2"))
                            {
                                vid="audioUrl_"+ (position + 149) +".mp3";
                                audio = new File( Environment.getExternalStorageDirectory()
                                        .getAbsolutePath()+"/Download/"+vid);
                                editor.putString("pre_pos1", String.valueOf(position+149));
                                editor.apply();


                            }
                            else if (numb.equals("3"))
                            {
                                vid="audioUrl_"+ (position + 260) +".mp3";
                                audio = new File( Environment.getExternalStorageDirectory()
                                        .getAbsolutePath()+"/Download/"+vid);

                                editor.putString("pre_pos1", String.valueOf(position+260));
                                editor.apply();


                            }

                            else if (numb.equals("4"))
                            {
                                vid="audioUrl_"+ (position + 385) +".mp3";
                                audio = new File( Environment.getExternalStorageDirectory()
                                        .getAbsolutePath()+"/Download/"+vid);

                                editor.putString("pre_pos1", String.valueOf(position+385));
                                editor.apply();

                            }

                            else if (numb.equals("5"))
                            {
                                vid="audioUrl_"+ (position + 517) +".mp3";
                                audio = new File( Environment.getExternalStorageDirectory()
                                        .getAbsolutePath()+"/Download/"+vid);

                                editor.putString("pre_pos1", String.valueOf(position+517));
                                editor.apply();
                            }

                            else if (numb.equals("6"))
                            {
                                vid="audioUrl_"+ (position + 641) +".mp3";
                                audio = new File( Environment.getExternalStorageDirectory()
                                        .getAbsolutePath()+"/Download/"+vid);

                                editor.putString("pre_pos1", String.valueOf(position+641));
                                editor.apply();
                            }
                            else if (numb.equals("7"))
                            {
                                vid="audioUrl_"+ (position + 752) +".mp3";
                                audio = new File( Environment.getExternalStorageDirectory()
                                        .getAbsolutePath()+"/Download/"+vid);

                                editor.putString("pre_pos1", String.valueOf(position+752));
                                editor.apply();
                            }
                            else if (numb.equals("8"))
                            {
                                vid="audioUrl_"+ (position + 900) +".mp3";
                                audio = new File( Environment.getExternalStorageDirectory()
                                        .getAbsolutePath()+"/Download/"+vid);

                                editor.putString("pre_pos1", String.valueOf(position+900));
                                editor.apply();
                            }
                            else if (numb.equals("9"))
                            {
                                vid="audioUrl_"+ (position + 1042) +".mp3";
                                audio = new File( Environment.getExternalStorageDirectory()
                                        .getAbsolutePath()+"/Download/"+vid);

                                editor.putString("pre_pos1", String.valueOf(position+1042));
                                editor.apply();
                            }
                            else if (numb.equals("10"))
                            {
                                vid="audioUrl_"+ (position + 1201) +".mp3";
                                audio = new File( Environment.getExternalStorageDirectory()
                                        .getAbsolutePath()+"/Download/"+vid);

                                editor.putString("pre_pos1", String.valueOf(position+1201));
                                editor.apply();
                            }
                            else if (numb.equals("11"))
                            {
                                vid="audioUrl_"+ (position + 1329) +".mp3";
                                audio = new File( Environment.getExternalStorageDirectory()
                                        .getAbsolutePath()+"/Download/"+vid);

                                editor.putString("pre_pos1", String.valueOf(position+1329));
                                editor.apply();
                            }
                            else if (numb.equals("12"))
                            {
                                vid="audioUrl_"+ (position + 1479) +".mp3";
                                audio = new File( Environment.getExternalStorageDirectory()
                                        .getAbsolutePath()+"/Download/"+vid);

                                editor.putString("pre_pos1", String.valueOf(position+1479));
                                editor.apply();
                            }

                            else if (numb.equals("13"))
                            {
                                vid="audioUrl_"+ (position + 1649) +".mp3";
                                audio = new File( Environment.getExternalStorageDirectory()
                                        .getAbsolutePath()+"/Download/"+vid);

                                editor.putString("pre_pos1", String.valueOf(position+1649));
                                editor.apply();
                            }

                            else if (numb.equals("14"))
                            {
                                vid="audioUrl_"+ (position+1804) +".mp3";
                                audio = new File( Environment.getExternalStorageDirectory()
                                        .getAbsolutePath()+"/Download/"+vid);

                                editor.putString("pre_pos1", String.valueOf(position+1804));
                                editor.apply();
                            }


                            else if (numb.equals("15"))
                            {
                                vid="audioUrl_"+ (position + 2030) +".mp3";
                                audio = new File( Environment.getExternalStorageDirectory()
                                        .getAbsolutePath()+"/Download/"+vid);

                                editor.putString("pre_pos1", String.valueOf(position+2030));
                                editor.apply();
                            }
                            else if (numb.equals("16"))
                            {
                                vid="audioUrl_"+ (position + 2215) +".mp3";
                                audio = new File( Environment.getExternalStorageDirectory()
                                        .getAbsolutePath()+"/Download/"+vid);

                                editor.putString("pre_pos1", String.valueOf(position+2215));
                                editor.apply();
                            }
                            else if (numb.equals("17"))
                            {
                                vid="audioUrl_"+ (position + 2484) +".mp3";
                                audio = new File( Environment.getExternalStorageDirectory()
                                        .getAbsolutePath()+"/Download/"+vid);

                                editor.putString("pre_pos1", String.valueOf(position+2484));
                                editor.apply();
                            }

                            else if (numb.equals("18"))
                            {
                                vid="audioUrl_"+ (position + 2674) +".mp3";
                                audio = new File( Environment.getExternalStorageDirectory()
                                        .getAbsolutePath()+"/Download/"+vid);

                                editor.putString("pre_pos1", String.valueOf(position+2674));
                                editor.apply();
                            }
                            else if (numb.equals("19"))
                            {
                                vid="audioUrl_"+ (position + 2876) +".mp3";
                                audio = new File( Environment.getExternalStorageDirectory()
                                        .getAbsolutePath()+"/Download/"+vid);

                                editor.putString("pre_pos1", String.valueOf(position+2876));
                                editor.apply();
                            }
                            else if (numb.equals("20"))
                            {
                                vid="audioUrl_"+ (position + 3219) +".mp3";
                                audio = new File( Environment.getExternalStorageDirectory()
                                        .getAbsolutePath()+"/Download/"+vid);

                                editor.putString("pre_pos1", String.valueOf(position+3215));
                                editor.apply();
                            }

                            else if (numb.equals("21"))
                            {
                                vid="audioUrl_"+ (position + 3385) +".mp3";
                                audio = new File( Environment.getExternalStorageDirectory()
                                        .getAbsolutePath()+"/Download/"+vid);

                                editor.putString("pre_pos1", String.valueOf(position+3386));
                                editor.apply();
                            }
                            else if (numb.equals("22"))
                            {
                                vid="audioUrl_"+ (position + 3564) +".mp3";
                                audio = new File( Environment.getExternalStorageDirectory()
                                        .getAbsolutePath()+"/Download/"+vid);

                                editor.putString("pre_pos1", String.valueOf(position+3564));
                                editor.apply();
                            }
                            else if (numb.equals("23"))
                            {
                                vid="audioUrl_"+ (position + 3727) +".mp3";
                                audio = new File( Environment.getExternalStorageDirectory()
                                        .getAbsolutePath()+"/Download/"+vid);


                                editor.putString("pre_pos1", String.valueOf(position+3733));
                                editor.apply();
                            }

                            else if (numb.equals("24"))
                            {
                                vid="audioUrl_"+ (position + 4090) +".mp3";
                                audio = new File( Environment.getExternalStorageDirectory()
                                        .getAbsolutePath()+"/Download/"+vid);

                                editor.putString("pre_pos1", String.valueOf(position+4090));
                                editor.apply();
                            }

                            else if (numb.equals("25"))
                            {
                                vid="audioUrl_"+ (position + 4265) +".mp3";
                                audio = new File( Environment.getExternalStorageDirectory()
                                        .getAbsolutePath()+"/Download/"+vid);

                                editor.putString("pre_pos1", String.valueOf(position+4265));
                                editor.apply();
                            }

                            else if (numb.equals("26"))
                            {
                                vid="audioUrl_"+ (position + 4511) +".mp3";
                                audio = new File( Environment.getExternalStorageDirectory()
                                        .getAbsolutePath()+"/Download/"+vid);

                                editor.putString("pre_pos1", String.valueOf(position+4511));
                                editor.apply();
                            }
                            else if (numb.equals("27"))
                            {
                                vid="audioUrl_"+ (position + 4706) +".mp3";
                                audio = new File( Environment.getExternalStorageDirectory()
                                        .getAbsolutePath()+"/Download/"+vid);

                                editor.putString("pre_pos1", String.valueOf(position+4706));
                                editor.apply();
                            }
                            else if (numb.equals("28"))
                            {
                                vid="audioUrl_"+ (position + 5105) +".mp3";
                                audio = new File( Environment.getExternalStorageDirectory()
                                        .getAbsolutePath()+"/Download/"+vid);

                                editor.putString("pre_pos1", String.valueOf(position+5105));
                                editor.apply();
                            }
                            else if (numb.equals("29"))
                            {
                                vid="audioUrl_"+ (position + 5242) +".mp3";
                                audio = new File( Environment.getExternalStorageDirectory()
                                        .getAbsolutePath()+"/Download/"+vid);

                                editor.putString("pre_pos1", String.valueOf(position+5242));
                                editor.apply();
                            }
                            else if (numb.equals("30"))
                            {
                                vid="audioUrl_"+ (position + 5673) +".mp3";
                                audio = new File( Environment.getExternalStorageDirectory()
                                        .getAbsolutePath()+"/Download/"+vid);

                                editor.putString("pre_pos1", String.valueOf(position+5673));
                                editor.apply();
                            }


                              dialog = new Dialog(read_quran_activity, R.style.Theme_AppCompat_DayNight_Dialog);
                              dialog.setContentView(R.layout.activity_sound2);
                              dialog.setTitle("Audio...");
                              dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


                             play = dialog.findViewById(R.id.play);
                             start = dialog.findViewById(R.id.start);
                             end = dialog.findViewById(R.id.end);
                             seekBar = dialog.findViewById(R.id.seek);

                             progressBar=dialog.findViewById(R.id.progress);



                             mediaPlayer = new MediaPlayer();
                             mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                             seekBar.setMax(100);


                             dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                 @Override
                                 public void onDismiss(DialogInterface dialog) {

                                     mediaPlayer.reset();
                                     prepare_media_player(String.valueOf(position + 1));


                                 }
                             });







                             play.setOnClickListener(new View.OnClickListener()
                             {
                                 @Override
                                 public void onClick(View v) {


                                     if (mediaPlayer.isPlaying())
                                     {

                                         play.setImageResource(R.drawable.play_sound);
                                         handler.removeCallbacks(updater);
                                         mediaPlayer.pause();


                                     } else
                                     {

//                                         Toast.makeText(context, "play", Toast.LENGTH_SHORT).show();



                                         mediaPlayer.start();
                                         upate_seekbar();
                                         play.setImageResource(R.drawable.pause);

                                     }




                                 }
                             });





                             if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                                 if (NetworkState.isOnline(context))
                                 {

                                     if (audio.exists())
                                     {

                                         prepare_media_player(String.valueOf(position + 1));
                                         mediaPlayer.start();
                                         upate_seekbar();
//                                         Toast.makeText(context, "exist", Toast.LENGTH_SHORT).show();


                                     }
                                     else
                                     {

                                         if (numb.equals("1"))
                                         {
                                             Toast.makeText(context, "Downloading start", Toast.LENGTH_SHORT).show();
                                             download_file
                                                     ("https://cdn.islamic.network/quran/audio/64/ar.alafasy/"
                                                                     + (position + 1)
                                                                     +".mp3",
                                                             vid);



                                         }
                                         else if (numb.equals("2"))
                                         {

                                             Toast.makeText(context, "Downloading start", Toast.LENGTH_SHORT).show();
                                             download_file
                                                     ("https://cdn.islamic.network/quran/audio/64/ar.alafasy/"
                                                                     + (position + 149)
                                                                     +".mp3",
                                                             vid);


                                         }

                                         else if (numb.equals("3"))
                                         {

                                             Toast.makeText(context, "Downloading start", Toast.LENGTH_SHORT).show();
                                             download_file
                                                     ("https://cdn.islamic.network/quran/audio/64/ar.alafasy/"
                                                                     + (position + 260)
                                                                     +".mp3",
                                                             vid);



                                         }


                                         else if (numb.equals("4"))
                                         {

                                             Toast.makeText(context, "Downloading start", Toast.LENGTH_SHORT).show();
                                             download_file
                                                     ("https://cdn.islamic.network/quran/audio/64/ar.alafasy/"
                                                                     + (position + 385)
                                                                     +".mp3",
                                                             vid);

                                         }

                                         else if (numb.equals("5"))
                                         {

                                             Toast.makeText(context, "Downloading start", Toast.LENGTH_SHORT).show();
                                             download_file
                                                     ("https://cdn.islamic.network/quran/audio/64/ar.alafasy/"
                                                                     + (position + 517)
                                                                     +".mp3",
                                                             vid);



                                         }
                                         else if (numb.equals("6"))
                                         {

                                             Toast.makeText(context, "Downloading start", Toast.LENGTH_SHORT).show();
                                             download_file
                                                     ("https://cdn.islamic.network/quran/audio/64/ar.alafasy/"
                                                                     + (position + 641)
                                                                     +".mp3",
                                                             vid);


                                         }

                                         else if (numb.equals("7"))
                                         {

                                             Toast.makeText(context, "Downloading start", Toast.LENGTH_SHORT).show();
                                             download_file
                                                     ("https://cdn.islamic.network/quran/audio/64/ar.alafasy/"
                                                                     + (position + 752)
                                                                     +".mp3",
                                                             vid);



                                         }

                                         else if (numb.equals("8"))
                                         {

                                             Toast.makeText(context, "Downloading start", Toast.LENGTH_SHORT).show();
                                             download_file
                                                     ("https://cdn.islamic.network/quran/audio/64/ar.alafasy/"
                                                                     + (position + 900)
                                                                     +".mp3",
                                                             vid);


                                         }


                                         else if (numb.equals("9"))
                                         {

                                             Toast.makeText(context, "Downloading start", Toast.LENGTH_SHORT).show();
                                             download_file
                                                     ("https://cdn.islamic.network/quran/audio/64/ar.alafasy/"
                                                                     + (position + 1042)
                                                                     +".mp3",
                                                             vid);


                                         }


                                         else if (numb.equals("10"))
                                         {

                                             Toast.makeText(context, "Downloading start", Toast.LENGTH_SHORT).show();
                                             download_file
                                                     ("https://cdn.islamic.network/quran/audio/64/ar.alafasy/"
                                                                     + (position + 1201)
                                                                     +".mp3",
                                                             vid);




                                         }

                                         else if (numb.equals("11"))
                                         {

                                             Toast.makeText(context, "Downloading start", Toast.LENGTH_SHORT).show();
                                             download_file
                                                     ("https://cdn.islamic.network/quran/audio/64/ar.alafasy/"
                                                                     + (position + 1329)
                                                                     +".mp3",
                                                             vid);



                                         }

                                         else if (numb.equals("12"))
                                         {

                                             Toast.makeText(context, "Downloading start", Toast.LENGTH_SHORT).show();
                                             download_file
                                                     ("https://cdn.islamic.network/quran/audio/64/ar.alafasy/"
                                                                     + (position + 1479)
                                                                     +".mp3",
                                                             vid);



                                         }

                                         else if (numb.equals("13"))
                                         {

                                             Toast.makeText(context, "Downloading start", Toast.LENGTH_SHORT).show();
                                             download_file
                                                     ("https://cdn.islamic.network/quran/audio/64/ar.alafasy/"
                                                                     + (position + 1649)
                                                                     +".mp3",
                                                             vid);


                                         }
                                         else if (numb.equals("14"))
                                         {

                                             Toast.makeText(context, "Downloading start", Toast.LENGTH_SHORT).show();
                                             download_file
                                                     ("https://cdn.islamic.network/quran/audio/64/ar.alafasy/"
                                                                     + (position + 1804)
                                                                     +".mp3",
                                                             vid);




                                         }

                                         else if (numb.equals("15"))
                                         {

                                             Toast.makeText(context, "Downloading start", Toast.LENGTH_SHORT).show();
                                             download_file
                                                     ("https://cdn.islamic.network/quran/audio/64/ar.alafasy/"
                                                                     + (position + 2030)
                                                                     +".mp3",
                                                             vid);



                                         }


                                         else if (numb.equals("16"))
                                         {

                                             Toast.makeText(context, "Downloading start", Toast.LENGTH_SHORT).show();
                                             download_file
                                                     ("https://cdn.islamic.network/quran/audio/64/ar.alafasy/"
                                                                     + (position + 2215)
                                                                     +".mp3",
                                                             vid);



                                         }

                                         else if (numb.equals("17"))
                                         {

                                             Toast.makeText(context, "Downloading start", Toast.LENGTH_SHORT).show();
                                             download_file
                                                     ("https://cdn.islamic.network/quran/audio/64/ar.alafasy/"
                                                                     + (position + 2484)
                                                                     +".mp3",
                                                             vid);

                                         }
                                         else if (numb.equals("18"))
                                         {

                                             Toast.makeText(context, "Downloading start", Toast.LENGTH_SHORT).show();
                                             download_file
                                                     ("https://cdn.islamic.network/quran/audio/64/ar.alafasy/"
                                                                     + (position + 2674)
                                                                     +".mp3",
                                                             vid);



                                         }

                                         else if (numb.equals("19"))
                                         {

                                             Toast.makeText(context, "Downloading start", Toast.LENGTH_SHORT).show();
                                             download_file
                                                     ("https://cdn.islamic.network/quran/audio/64/ar.alafasy/"
                                                                     + (position + 2876)
                                                                     +".mp3",
                                                             vid);



                                         }



                                         else if (numb.equals("20"))
                                         {

                                             Toast.makeText(context, "Downloading start", Toast.LENGTH_SHORT).show();
                                             download_file
                                                     ("https://cdn.islamic.network/quran/audio/64/ar.alafasy/"
                                                                     + (position + 3219)
                                                                     +".mp3",
                                                             vid);


                                         }

                                         else if (numb.equals("21"))
                                         {

                                             Toast.makeText(context, "Downloading start", Toast.LENGTH_SHORT).show();
                                             download_file
                                                     ("https://cdn.islamic.network/quran/audio/64/ar.alafasy/"
                                                                     + (position + 3385)
                                                                     +".mp3",
                                                             vid);


                                         }
                                         else if (numb.equals("22"))
                                         {

                                             Toast.makeText(context, "Downloading start", Toast.LENGTH_SHORT).show();
                                             download_file
                                                     ("https://cdn.islamic.network/quran/audio/64/ar.alafasy/"
                                                                     + (position + 3564)
                                                                     +".mp3",
                                                             vid);


                                         }
                                         else if (numb.equals("23"))
                                         {

                                             Toast.makeText(context, "Downloading start", Toast.LENGTH_SHORT).show();
                                             download_file
                                                     ("https://cdn.islamic.network/quran/audio/64/ar.alafasy/"
                                                                     + (position + 3727)
                                                                     +".mp3",
                                                             vid);



                                         }

                                         else if (numb.equals("24"))
                                         {

                                             Toast.makeText(context, "Downloading start", Toast.LENGTH_SHORT).show();
                                             download_file
                                                     ("https://cdn.islamic.network/quran/audio/64/ar.alafasy/"
                                                                     + (position + 4090)
                                                                     +".mp3",
                                                             vid);



                                         }
                                         else if (numb.equals("25"))
                                         {

                                             Toast.makeText(context, "Downloading start", Toast.LENGTH_SHORT).show();
                                             download_file
                                                     ("https://cdn.islamic.network/quran/audio/64/ar.alafasy/"
                                                                     + (position + 4265)
                                                                     +".mp3",
                                                             vid);



                                         }
                                         else if (numb.equals("26"))
                                         {

                                             Toast.makeText(context, "Downloading start", Toast.LENGTH_SHORT).show();
                                             download_file
                                                     ("https://cdn.islamic.network/quran/audio/64/ar.alafasy/"
                                                                     + (position + 4511)
                                                                     +".mp3",
                                                             vid);


                                         }

                                         else if (numb.equals("27"))
                                         {

                                             Toast.makeText(context, "Downloading start", Toast.LENGTH_SHORT).show();
                                             download_file
                                                     ("https://cdn.islamic.network/quran/audio/64/ar.alafasy/"
                                                                     + (position + 4706)
                                                                     +".mp3",
                                                             vid);


                                         }

                                         else if (numb.equals("28"))
                                         {

                                             Toast.makeText(context, "Downloading start", Toast.LENGTH_SHORT).show();
                                             download_file
                                                     ("https://cdn.islamic.network/quran/audio/64/ar.alafasy/"
                                                                     + (position + 5105)
                                                                     +".mp3",
                                                             vid);




                                         }
                                         else if (numb.equals("29"))
                                         {

                                             Toast.makeText(context, "Downloading start", Toast.LENGTH_SHORT).show();
                                             download_file
                                                     ("https://cdn.islamic.network/quran/audio/64/ar.alafasy/"
                                                                     + (position + 5242)
                                                                     +".mp3",
                                                             vid);


                                         }

                                         else if (numb.equals("30"))
                                         {

                                             Toast.makeText(context, "Downloading start", Toast.LENGTH_SHORT).show();
                                             download_file
                                                     ("https://cdn.islamic.network/quran/audio/64/ar.alafasy/"
                                                                     + (position + 5673)
                                                                     +".mp3",
                                                             vid);


                                         }


                                     }




                                 }

                                 else
                                 {
                                     if (audio.exists())
                                     {
                                         prepare_media_player(String.valueOf(position + 1));
                                         mediaPlayer.start();
                                         upate_seekbar();


                                     }
                                     else
                                     {

                                         Toast.makeText(context, "turn on internet to download", Toast.LENGTH_SHORT).show();


                                     }

                                 }




                             }







                             seekBar.setOnTouchListener(new View.OnTouchListener() {
                                 @Override
                                 public boolean onTouch(View v, MotionEvent event) {
                                     SeekBar seekBar = (SeekBar) v;
                                     int play_pos = (mediaPlayer.getDuration() / 100) * seekBar.getProgress();
                                     mediaPlayer.seekTo(play_pos);
                                     start.setText(milli_second_to_timer(mediaPlayer.getCurrentPosition()));

                                     return false;
                                 }
                             });


                             mediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
                                 @Override
                                 public void onBufferingUpdate(MediaPlayer mp, int percent) {

                                     seekBar.setSecondaryProgress(percent);

                                 }
                             });


                             mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                 @Override
                                 public void onCompletion(MediaPlayer mp) {

                                     seekBar.setProgress(0);
                                     start.setText("0:00");
                                     end.setText("0:00");
                                     mediaPlayer.reset();
                                     prepare_media_player(String.valueOf(position + 1));

                                 }
                             });


                             dialog.show();






//

                             ///////////////////////////////////////



                             //////////////










                            //////////////////////////////////////




                        }
                    });






                }

            }








        BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
            @Override
            public void onReceive(final Context context, Intent intent) {


                String action=intent.getAction();
                if (DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(action))
                {
try {


    DownloadManager.Query req_query = new DownloadManager.Query();
    req_query.setFilterById(enqueID);
    Cursor cursor = downloadManager.query(req_query);


    if (cursor.moveToFirst()) {
        int columIndex = cursor.getColumnIndex(DownloadManager.COLUMN_STATUS);

        if (DownloadManager.STATUS_SUCCESSFUL == cursor.getInt(columIndex)) {

            Toast.makeText(context, "download complete press play", Toast.LENGTH_SHORT).show();



            ////////////////////////
        }

    }
}catch (Exception e){
    Toast.makeText(context, "in adapter and surah cursor error ha line 2174"+e, Toast.LENGTH_SHORT).show();
}
                }
            }
        };


try {

    context.registerReceiver(broadcastReceiver, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
}catch (Exception e){

}
//////////////////////////////







    }

    @Override
    public int getItemCount() {
        if (chk.equals("Surah"))
        {

            return 1;

        }
        else
            {

            return data.size();        }
    }





    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView,textView_urdu;
        ImageView sound;


        ViewHolder(View itemView)
        {
            super(itemView);

            textView =itemView.findViewById(R.id.textx);
            textView_urdu=itemView.findViewById(R.id.texty);
            sound=itemView.findViewById(R.id.sound);
            textView.setTypeface(new Typcast().Typcast(context,"BB"));
            textView_urdu.setTypeface(new Typcast().Typcast(context,"A"));




        }



    }







    public void prepare_media_player(String pos)
    {


//        try {
//            mediaPlayer.setDataSource("https://cdn.islamic.network/quran/audio/64/ar.alafasy/"+pos+".mp3");
//            mediaPlayer.prepare();
////            mediaPlayer.prepareAsync();
//            end.setText(milli_second_to_timer(mediaPlayer.getDuration()));
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        if (audio.exists())
        {
            Uri uri = FileProvider.getUriForFile(context,
                    "com.developer.islamicapp.provider",audio);
try {



            mediaPlayer=MediaPlayer.create(context,uri);
            end.setText(milli_second_to_timer(mediaPlayer.getDuration()));}catch (Exception e){

            }

        }



    }

    private Runnable updater=new Runnable() {
        @Override
        public void run() {

            upate_seekbar();
            long current_duration=mediaPlayer.getCurrentPosition();
            start.setText(milli_second_to_timer(current_duration));


        }
    };

    private void upate_seekbar()
    {
        if (mediaPlayer.isPlaying())
        {
            seekBar.setProgress((int)(((float)mediaPlayer.getCurrentPosition()/mediaPlayer.getDuration()) *100));
            handler.postDelayed(updater,1000);

        }


    }


    private String milli_second_to_timer(long milli_second)
    {


        int hour=(int)(milli_second/(1000*60*60));
        int minute=(int)(milli_second % (1000*60*60))/(1000*60);
        int second=(int)((milli_second %(1000*60*60)) % (1000*60) / 1000);

        if (hour>0)
        {
            timer_string=hour+":";

        }

        if (second<10)
        {

            second_string="0" + second;
        }
        else
        {
            second_string="" + second;
        }


        timer_string=timer_string + minute + ":" + second_string;


        return timer_string;

    }



    public void download_file(String url,String name)
    {
        DownloadManager.Request download = new DownloadManager.Request(Uri.parse(url));
        String fileName = URLUtil.guessFileName(url, null, MimeTypeMap.getFileExtensionFromUrl(url));
        download.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
        download.setTitle(fileName);
        download.setDescription("Downloading file");
        download.allowScanningByMediaScanner();
        download.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        download.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, name);
        downloadManager = (DownloadManager)context.getSystemService(Context.DOWNLOAD_SERVICE);
        enqueID =downloadManager.enqueue(download);

    }

//private  int getayattnum(int position, int star_of_para_surah_numberx){
//        int val;
//
//        try {
//            val=indexxx.get(position);
//
//        }catch (Exception e){
//            indexxx.add(position,star_of_para_surah_numberx);
//            val=indexxx.get(position);
//            this.star_of_para_surah_number++;
//        }
//        Log.v("hassan","> val:   "+val+", at pos:  "+position);
//        return val;
//
//}

}