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
import com.developer.islamicapp.DB.DB;
import com.developer.islamicapp.R;
import com.developer.islamicapp.utils.Typcastregular;

public class Read_quran_Activity extends AppCompatActivity implements View.OnClickListener {
    String chk, chk_parrah_or_surahnumber, DBx;
    RecyclerView recyclerView;
    FrameLayout bg;
    RelativeLayout bgx;
    int REcent=0;
    LinearLayoutManager linearLayoutManager;
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
                        recyclerView.setAdapter(new AdapterParah_and_surah_Reader(getApplicationContext(), DBx, new PARAH1TO10().Data(chk_parrah_or_surahnumber), chk_parrah_or_surahnumber, REcent));
                    } else if (Integer.parseInt(chk_parrah_or_surahnumber)>10 && Integer.parseInt(chk_parrah_or_surahnumber)<=17) {
                        recyclerView.setAdapter(new AdapterParah_and_surah_Reader(getApplicationContext(), DBx, new PARAH11TO17().Data(chk_parrah_or_surahnumber), chk_parrah_or_surahnumber, REcent));

                    }else if (Integer.parseInt(chk_parrah_or_surahnumber)>17 && Integer.parseInt(chk_parrah_or_surahnumber)<=24) {
                        recyclerView.setAdapter(new AdapterParah_and_surah_Reader(getApplicationContext(), DBx, new PARAH18TO24().Data(chk_parrah_or_surahnumber), chk_parrah_or_surahnumber, REcent));

                    }else if (Integer.parseInt(chk_parrah_or_surahnumber)>25 && Integer.parseInt(chk_parrah_or_surahnumber)<=30) {
                        recyclerView.setAdapter(new AdapterParah_and_surah_Reader(getApplicationContext(), DBx, new PARAH25TO30().Data(chk_parrah_or_surahnumber), chk_parrah_or_surahnumber, REcent));

                    }
                    linearLayoutManager.scrollToPosition(REcentx);
                    bgx.setVisibility(View.GONE);
                }
                catch (Exception e){
                    Toast.makeText(Read_quran_Activity.this, ""+e, Toast.LENGTH_SHORT).show();
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
                    recyclerView.setAdapter(new AdapterParah_and_surah_Reader(this, DBx, new SURAH1TO15(this).Data(chk_parrah_or_surahnumber), chk_parrah_or_surahnumber, REcent));
                }else if (Integer.parseInt(chk_parrah_or_surahnumber)>15 && Integer.parseInt(chk_parrah_or_surahnumber)<=30) {
                    recyclerView.setAdapter(new AdapterParah_and_surah_Reader(this, DBx, new SURAH16TO30(this).Data(chk_parrah_or_surahnumber), chk_parrah_or_surahnumber, REcent));

                }else if (Integer.parseInt(chk_parrah_or_surahnumber)>30 && Integer.parseInt(chk_parrah_or_surahnumber)<=60) {
                    recyclerView.setAdapter(new AdapterParah_and_surah_Reader(this, DBx, new SURAH31TO60(this).Data(chk_parrah_or_surahnumber), chk_parrah_or_surahnumber, REcent));

                }else if (Integer.parseInt(chk_parrah_or_surahnumber)>60 && Integer.parseInt(chk_parrah_or_surahnumber)<=114) {
                    recyclerView.setAdapter(new AdapterParah_and_surah_Reader(this, DBx, new SURAH61TO114(this).Data(chk_parrah_or_surahnumber), chk_parrah_or_surahnumber, REcent));

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
                    recyclerView.setAdapter(new AdapterParah_and_surah_Reader(this, DBx, new PARAH1TO10().Data(chk_parrah_or_surahnumber), chk_parrah_or_surahnumber, REcent));
                }
                else if (Integer.parseInt(chk_parrah_or_surahnumber)>10 && Integer.parseInt(chk_parrah_or_surahnumber)<=17) {
                    recyclerView.setAdapter(new AdapterParah_and_surah_Reader(this, DBx, new PARAH11TO17().Data(chk_parrah_or_surahnumber), chk_parrah_or_surahnumber, REcent));

                }else if (Integer.parseInt(chk_parrah_or_surahnumber)>17 && Integer.parseInt(chk_parrah_or_surahnumber)<=24) {
                    recyclerView.setAdapter(new AdapterParah_and_surah_Reader(this, DBx, new PARAH18TO24().Data(chk_parrah_or_surahnumber), chk_parrah_or_surahnumber, REcent));

                }else if (Integer.parseInt(chk_parrah_or_surahnumber)>24 && Integer.parseInt(chk_parrah_or_surahnumber)<=30) {
                    recyclerView.setAdapter(new AdapterParah_and_surah_Reader(this, DBx, new PARAH25TO30().Data(chk_parrah_or_surahnumber), chk_parrah_or_surahnumber, REcent));

                }

                break;




        }
    }
}