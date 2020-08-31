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
import com.developer.islamicapp.DB.DB;
import com.developer.islamicapp.R;
import com.developer.islamicapp.utils.Typcastregular;

public class Read_quran_Activity extends AppCompatActivity implements View.OnClickListener {
    String chk, chk_if_suparah_or_surah, DBx;
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
            chk_if_suparah_or_surah =getIntent().getStringExtra("Datafetch");
        }
        catch (Exception e)
        {
            chk_if_suparah_or_surah ="1";
        }
        if (!DBx.isEmpty())
        {
            linearLayoutManager = new LinearLayoutManager(this);
            recyclerView=findViewById(R.id.rec);
            recyclerView.setLayoutManager(linearLayoutManager);
//where last tme left get it by shp or whaterever
            if (chk.equals("Surah"))

            {
//                recyclerView.setAdapter(new AdapterParah_and_surah_Reader(this, DBx,new DB(this, fetchdata,DBx).getAll(),fetchdata,REcent));
                Toast.makeText(this, "surah"+DBx, Toast.LENGTH_SHORT).show();
            }
            else
                {

                    Toast.makeText(this, "parah--->"+DBx, Toast.LENGTH_SHORT).show();
                try {
                    REcent=getSharedPreferences(chk_if_suparah_or_surah,MODE_PRIVATE).getInt("Recent",0);
                }catch (Exception e){
                }

               if (REcent>=0)
                {
                    askforRecent(chk_if_suparah_or_surah, DBx,REcent);
                }


                }

            Log.v("hassan","Parameters read auto: "+":"+DBx+":"+ chk_if_suparah_or_surah);
try {
    recyclerView.setAdapter(new AdapterParah_and_surah_Reader(this, DBx,new DB(this, chk_if_suparah_or_surah,DBx).getAll(),chk_if_suparah_or_surah,REcent));

    Log.v("hassan","Parameters read auto: "+" try   :"+"1");
}catch (Exception e){
    recyclerView.setAdapter(new AdapterParah_and_surah_Reader(this, DBx,new DB(this, DBx,chk_if_suparah_or_surah).getAll(),chk_if_suparah_or_surah,REcent));

    Log.v("hassan","Parameters read auto: "+" try   :"+"2");
}
//                recyclerView.setAdapter(new AdapterParah_and_surah_Reader(this, DBx,new DB(this, fetchdata,DBx).getAll(),fetchdata,REcent));
//            new DB(context, dbname,ParahorSurah_check).adddata(data);

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
    private void askforRecent(String fetchdatax, String DBxx, int REcentx){
        bgx.setVisibility(View.VISIBLE);
        findViewById(R.id.yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    recyclerView.removeAllViewsInLayout();
                    AdapterParah_and_surah_Reader adp= new AdapterParah_and_surah_Reader
                            (Read_quran_Activity.this, DBxx,
                            new DB(getApplicationContext(),fetchdatax, DBxx).getAll(), fetchdatax, REcentx);
                    recyclerView.setAdapter(adp);
                    adp.notifyDataSetChanged();
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
                getSharedPreferences(chk_if_suparah_or_surah,MODE_PRIVATE).edit().clear().apply();
            }
        });
    }
}