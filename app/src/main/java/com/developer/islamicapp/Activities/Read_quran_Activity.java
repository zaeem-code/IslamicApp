package com.developer.islamicapp.Activities;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.developer.islamicapp.Adapter.AdapterParah_and_surah_Reader;
import com.developer.parahfiles.PARAH11TO17;
import com.developer.parahfiles.PARAH18TO24;
import com.developer.parahfiles.PARAH1TO10;
import com.developer.parahfiles.PARAH25TO30;
import com.developer.surahfiles.SURAH16TO30;
import com.developer.surahfiles.SURAH1TO15;
import com.developer.surahfiles.SURAH31TO60;
import com.developer.surahfiles.SURAH61TO114;
import com.developer.islamicapp.R;
import com.developer.islamicapp.utils.Typcastregular;

import java.util.ArrayList;

public class Read_quran_Activity extends AppCompatActivity implements View.OnClickListener {
    String chk, chk_parrah_or_surahnumber, DBx;
    RecyclerView recyclerView;
    FrameLayout bg;
    int i=0;
    RelativeLayout bgx;
    int REcent=0;
    LinearLayoutManager linearLayoutManager;

    ArrayList<Integer> indexxx=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Typcastregular.Typcastregular(getApplicationContext(), "SERIF", "Poppins-Regular.otf");
        setContentView(R.layout.activity_read_quran);
        chk="parh";
        bg=findViewById(R.id.bg1);
        bgx=findViewById(R.id.bgx);
        findViewById(R.id.back).setOnClickListener(this);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        try {
            DBx =getIntent().getStringExtra("DB");
            chk=DBx;
        }catch (Exception e){}
        try {
            chk_parrah_or_surahnumber =getIntent().getStringExtra("Datafetch");
        }
        catch (Exception e)
        {
            chk_parrah_or_surahnumber ="1";
        }
        if (!DBx.isEmpty())
        {
            linearLayoutManager = new LinearLayoutManager(this);
            recyclerView=findViewById(R.id.rec);
            recyclerView.setLayoutManager(linearLayoutManager);
//where last tme left get it by shp or whaterever



            Log.v("hassan","Parameters read auto: "+":"+DBx+":"+ chk_parrah_or_surahnumber);

process(DBx);

        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                finish();
                break;
        }
    }
    private void askforRecent(  int REcentx){
        bgx.setVisibility(View.VISIBLE);
        findViewById(R.id.yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    recyclerView.removeAllViewsInLayout();
                    if (Integer.parseInt(chk_parrah_or_surahnumber)<=10) {

                        recyclerView.setAdapter(new AdapterParah_and_surah_Reader(Read_quran_Activity.this, DBx, new PARAH1TO10().Data(chk_parrah_or_surahnumber),  chk_parrah_or_surahnumber, REcent, fillSurahnumbers(stating(chk_parrah_or_surahnumber),new PARAH1TO10().Data(chk_parrah_or_surahnumber).size())));


                    } else if (Integer.parseInt(chk_parrah_or_surahnumber)>10 && Integer.parseInt(chk_parrah_or_surahnumber)<=17) {
                        recyclerView.setAdapter(new AdapterParah_and_surah_Reader(Read_quran_Activity.this, DBx, new PARAH11TO17().Data(chk_parrah_or_surahnumber), chk_parrah_or_surahnumber, REcent,        fillSurahnumbers(stating(chk_parrah_or_surahnumber),new PARAH11TO17().Data(chk_parrah_or_surahnumber).size())));
                    }else if (Integer.parseInt(chk_parrah_or_surahnumber)>17 && Integer.parseInt(chk_parrah_or_surahnumber)<=24) {
                        recyclerView.setAdapter(new AdapterParah_and_surah_Reader(Read_quran_Activity.this, DBx, new PARAH18TO24().Data(chk_parrah_or_surahnumber), chk_parrah_or_surahnumber, REcent,        fillSurahnumbers(stating(chk_parrah_or_surahnumber),new PARAH18TO24().Data(chk_parrah_or_surahnumber).size())));

                    }else if (Integer.parseInt(chk_parrah_or_surahnumber)>25 && Integer.parseInt(chk_parrah_or_surahnumber)<=30) {
                        recyclerView.setAdapter(new AdapterParah_and_surah_Reader(Read_quran_Activity.this, DBx, new PARAH25TO30().Data(chk_parrah_or_surahnumber), chk_parrah_or_surahnumber, REcent,        fillSurahnumbers(stating(chk_parrah_or_surahnumber),new PARAH25TO30().Data(chk_parrah_or_surahnumber).size())));

                    }
                    linearLayoutManager.scrollToPosition(REcentx);
                    bgx.setVisibility(View.GONE);
                }
                catch (Exception e){
//                    Toast.makeText(Read_quran_Activity.this, ""+e, Toast.LENGTH_SHORT).show();
                }
            }
        });
        findViewById(R.id.No).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                bgx.setVisibility(View.GONE);
                getSharedPreferences(chk_parrah_or_surahnumber,MODE_PRIVATE).edit().clear().apply();
            }
        });
    }

    private void process( String chk){
        switch (chk){
            case "Surah":
                if (Integer.parseInt(chk_parrah_or_surahnumber)<=15) {
                    recyclerView.setAdapter(new AdapterParah_and_surah_Reader(Read_quran_Activity.this, DBx, new SURAH1TO15(this).Data(chk_parrah_or_surahnumber), chk_parrah_or_surahnumber, REcent, null));
                }else if (Integer.parseInt(chk_parrah_or_surahnumber)>15 && Integer.parseInt(chk_parrah_or_surahnumber)<=30) {
                    recyclerView.setAdapter(new AdapterParah_and_surah_Reader(Read_quran_Activity.this, DBx, new SURAH16TO30(this).Data(chk_parrah_or_surahnumber), chk_parrah_or_surahnumber, REcent, null));

                }else if (Integer.parseInt(chk_parrah_or_surahnumber)>30 && Integer.parseInt(chk_parrah_or_surahnumber)<=60) {
                    recyclerView.setAdapter(new AdapterParah_and_surah_Reader(Read_quran_Activity.this, DBx, new SURAH31TO60(this).Data(chk_parrah_or_surahnumber), chk_parrah_or_surahnumber, REcent, null));

                }else if (Integer.parseInt(chk_parrah_or_surahnumber)>60 && Integer.parseInt(chk_parrah_or_surahnumber)<=114) {
                    recyclerView.setAdapter(new AdapterParah_and_surah_Reader(Read_quran_Activity.this, DBx, new SURAH61TO114(this).Data(chk_parrah_or_surahnumber), chk_parrah_or_surahnumber, REcent, null));

                }


                break;

            default:
                //parah
                try {
                    REcent=getSharedPreferences(chk_parrah_or_surahnumber,MODE_PRIVATE).getInt("Recent",0);
                }catch (Exception e){
                }

                if (REcent>0)
                {
                    askforRecent(REcent);
                }

                if (Integer.parseInt(chk_parrah_or_surahnumber)<=10) {
                   recyclerView.setAdapter(new AdapterParah_and_surah_Reader(Read_quran_Activity.this, DBx, new PARAH1TO10().Data(chk_parrah_or_surahnumber),  chk_parrah_or_surahnumber, REcent, fillSurahnumbers(stating(chk_parrah_or_surahnumber),new PARAH1TO10().Data(chk_parrah_or_surahnumber).size())));
                } else if (Integer.parseInt(chk_parrah_or_surahnumber)>10 && Integer.parseInt(chk_parrah_or_surahnumber)<=17) {
                    recyclerView.setAdapter(new AdapterParah_and_surah_Reader(Read_quran_Activity.this, DBx, new PARAH11TO17().Data(chk_parrah_or_surahnumber), chk_parrah_or_surahnumber, REcent,        fillSurahnumbers(stating(chk_parrah_or_surahnumber),new PARAH11TO17().Data(chk_parrah_or_surahnumber).size())));
                }else if (Integer.parseInt(chk_parrah_or_surahnumber)>17 && Integer.parseInt(chk_parrah_or_surahnumber)<=24) {
                    recyclerView.setAdapter(new AdapterParah_and_surah_Reader(Read_quran_Activity.this, DBx, new PARAH18TO24().Data(chk_parrah_or_surahnumber), chk_parrah_or_surahnumber, REcent,        fillSurahnumbers(stating(chk_parrah_or_surahnumber),new PARAH18TO24().Data(chk_parrah_or_surahnumber).size())));

                }else if (Integer.parseInt(chk_parrah_or_surahnumber)>25 && Integer.parseInt(chk_parrah_or_surahnumber)<=30) {
                    recyclerView.setAdapter(new AdapterParah_and_surah_Reader(Read_quran_Activity.this, DBx, new PARAH25TO30().Data(chk_parrah_or_surahnumber), chk_parrah_or_surahnumber, REcent,        fillSurahnumbers(stating(chk_parrah_or_surahnumber),new PARAH25TO30().Data(chk_parrah_or_surahnumber).size())));

                }

                break;




        }
    }
    private int stating(String parah){
        switch (parah){
            case "1":
                return 0;
            case "2":
                return 148;
            case "3":
                return 148+111;
            case "4":
            return 148+111+125;
            case "5":
                return 148+111+125+132;
            case "6":
                return 148+111+125+132+124;
            case "7":
                return 148+111+125+132+124+111;

            case "8":
                return 148+111+125+132+124+111+148;
            case "9":
                return 148+111+125+132+124+111+148+143;
            case "10":
                return 148+111+125+132+124+111+148+143+159;
            case "11":
                return 148+111+125+132+124+111+148+143+159+128;
            case "12":
                return 148+111+125+132+124+111+148+143+159+128+150;
            case "13":
                return 148+111+125+132+124+111+148+143+159+128+150+170;
            case "14":
                return 148+111+125+132+124+111+148+143+159+128+150+170+155;
            case "15":
                return 148+111+125+132+124+111+148+143+159+128+150+170+155+266;
            case "16":
                return 148+111+125+132+124+111+148+143+159+128+150+170+155+266+185;
            case "17":
                return 148+111+125+132+124+111+148+143+159+128+150+170+155+266+185+269;
            case "18":
                return 148+111+125+132+124+111+148+143+159+128+150+170+155+266+185+269+190;
            case "19":
                return 148+111+125+132+124+111+148+143+159+128+150+170+155+266+185+269+190+202;
            case "20":
                return 148+111+125+132+124+111+148+143+159+128+150+170+155+266+185+269+190+202+343;
            case "21":
                return 148+111+125+132+124+111+148+143+159+128+150+170+155+266+185+269+190+202+343+166;
            case "22":
                return 148+111+125+132+124+111+148+143+159+128+150+170+155+266+185+269+190+202+343+166+179;
            case "23":
                return 148+111+125+132+124+111+148+143+159+128+150+170+155+266+185+269+190+202+343+166+179+163;
            case "24":
                return 148+111+125+132+124+111+148+143+159+128+150+170+155+266+185+269+190+202+343+166+179+163+363;
            case "25":
                return 148+111+125+132+124+111+148+143+159+128+150+170+155+266+185+269+190+202+343+166+179+163+363+175;
            case "26":
                return 148+111+125+132+124+111+148+143+159+128+150+170+155+266+185+269+190+202+343+166+179+163+363+175+246;
            case "27":
                return 148+111+125+132+124+111+148+143+159+128+150+170+155+266+185+269+190+202+343+166+179+163+363+175+246+195;
            case "28":
                return 148+111+125+132+124+111+148+143+159+128+150+170+155+266+185+269+190+202+343+166+179+163+363+175+246+195+399;
            case "29":
                return 148+111+125+132+124+111+148+143+159+128+150+170+155+266+185+269+190+202+343+166+179+163+363+175+246+195+399+137;
            case "30":
                return 148+111+125+132+124+111+148+143+159+128+150+170+155+266+185+269+190+202+343+166+179+163+363+175+246+195+399+137+431;

            default:

                return 0;

        }

    }
    private ArrayList<Integer> fillSurahnumbers(int startx,int endx){

        indexxx.clear();


        for ( i=0;i<=endx; i++){
            indexxx.add((i+startx));
            Log.v("TPX"," start at : "+startx+", will end at : "+endx+", currently :----->: "+indexxx.get(i));
                                        }


        return indexxx;

    }
}