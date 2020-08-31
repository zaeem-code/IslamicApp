package com.developer.islamicapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.developer.islamicapp.Adapter.AdapterParahandSurah_title_list;
import com.developer.islamicapp.R;
import com.developer.islamicapp.utils.Typcastregular;

import java.util.ArrayList;

public class QuranActivity extends AppCompatActivity implements View.OnClickListener {
private Button parah,surah;
private RecyclerView recyclerView;
private String chk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quran);
        Typcastregular.Typcastregular(getApplicationContext(), "SERIF", "Poppins-Regular.otf");
        parah=findViewById(R.id.parah);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        surah=findViewById(R.id.surah);
        findViewById(R.id.parah).setOnClickListener(this);
        findViewById(R.id.surah).setOnClickListener(this);
        findViewById(R.id.back).setOnClickListener(this);

        recyclerView=findViewById(R.id.rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setDrawingCacheEnabled(true);

        //by def parah
        chk="Parah";
        parah.setTextColor(Color.WHITE);
        surah.setTextColor(Color.parseColor("#Ecc73a"));
        setupREC(chk);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){



            case R.id.parah:
                chk="Parah";
                parah.setTextColor(Color.WHITE);
                surah.setTextColor(Color.parseColor("#Ecc73a"));
                setupREC(chk);
                break;


            case R.id.surah:
                chk="Surah";
                surah.setTextColor(Color.WHITE);
                parah.setTextColor(Color.parseColor("#Ecc73a"));
                setupREC(chk);
                break;
            case R.id.back:
                finish();
                break;
        }
    }

    private void setupREC(String chk)
    {
        recyclerView.setAdapter(new AdapterParahandSurah_title_list(this, loadData(chk), chk.trim()));
    }


    private ArrayList<String> loadData(String chk)
    {

        ArrayList<String> data = new ArrayList<>();

        Log.v("islamicERROR","----in----"+chk);

     if (chk.trim().equals("Surah"))
     {
         //

         data.add("١ ٱلْفَاتِحَة ");
         data.add("٢  ٱلْبَقَرَة ");
         data.add("٣ آلِ عِمْرَان");
         data.add("٤   ٱلنِّسَاء");
         data.add("٥  ٱلْمَائِدَة ");
         data.add("٦ ٱلْأَنْعَام  ");
         data.add("٧ ٱلْأَعْرَاف ");
         data.add("٨ ٱلْأَنْفَال  ");
         data.add("٩ ٱلتَّوْبَة  ");
         data.add("١٠ يُونُس ");
         data.add("١١ هُود  ");
         data.add("١٢ يُوسُف ");
         data.add("١٣ ٱلرَّعْد  ");
         data.add("١٤ إِبْرَاهِيم ");
         data.add("١٥ ٱلْحِجْر  ");
         data.add("١٦ ٱلنَّحْل  ");
         data.add("١٧ ٱلْإِسْرَاء ");
         data.add("١٨ ٱلْكَهْف  ");
         data.add("١٩ مَرْيَم   ");
         data.add("٢٠ طه    ");
         data.add("٢١ ٱلْأَنْبِيَاء  ");
         data.add("٢٢ ٱلْحَجّ   ");
         data.add("٢٣ ٱلْمُؤْمِنُون ");
         data.add("٢٤ ٱلنُّور   ");
         data.add("٢٥ ٱلْفُرْقَان  ");
         data.add("٢٦ ٱلشُّعَرَاء ");
         data.add("٢٧ ٱلنَّمْل   ");
         data.add("٢٨ ٱلْقَصَص ");
         data.add("٢٩ ٱلْعَنْكَبُوت ");
         data.add("٣٠ ٱلرُّوم   ");
         data.add("٣١ لُقْمَان   ");
         data.add("٣٢ ٱلسَّجْدَة  ");
         data.add("٣٣ ٱلْأَحْزَاب  ");
         data.add("٣٤ سَبَأ    ");
         data.add("٣٥ فَاطِر   ");
         data.add("٣٦ يس    ");
         data.add("٣٧ ٱلصَّافَّات  ");
         data.add("٣٨ ص    ");
         data.add("٣٩ ٱلزُّمَر   ");
         data.add("٤٠ غَافِر    ");
         data.add("٤١ فُصِّلَت   ");
         data.add("٤٢ ٱلشُّورىٰ  ");
         data.add("٤٣ ٱلْزُّخْرُف  ");
         data.add("٤٤ ٱلدُّخَان  ");
         data.add("٤٥ لْجَاثِيَة   ");
         data.add("٤٦ ٱلْأَحْقَاف  ");
         data.add("٤٧ مُحَمَّد   ");
         data.add("٤٨ ٱلْفَتْح   ");
         data.add("٤٩ ٱلْحُجُرَات ");
         data.add("٥٠ ق     ");
         data.add("٥١ ٱلذَّارِيَات  ");
         data.add("٥٢ ٱلطُّور   ");
         data.add("٥٣ ٱلنَّجْم    ");
         data.add("٥٤ ٱلْقَمَر    ");
         data.add("٥٥ ٱلرَّحْمَٰن   ");
         data.add("٥٦ ٱلْوَاقِعَة   ");
         data.add("٥٧ ٱلْحَدِيد   ");
         data.add("٥٨ ٱلْمُجَادِلَة  ");
         data.add("٥٩ ٱلْحَشْر   ");
         data.add("٦٠ ٱلْمُمْتَحَنَة  ");
         data.add("٦١ ٱلصَّفّ   ");
         data.add("٦٢ ٱلْجُمُعَة   ");
         data.add("٦٣ ٱلْمُنَافِقُون  ");
         data.add("٦٤ ٱلتَّغَابُن   ");
         data.add("٦٥ ٱلطَّلَاق   ");
         data.add("٦٦ ٱلتَّحْرِيم   ");
         data.add("٦٧ ٱلْمُلْك    ");
         data.add("٦٨ ٱلْقَلَم    ");
         data.add("٦٩ ٱلْحَاقَّة   ");
         data.add("٧٠ ٱلْمَعَارِج  ");
         data.add("٧١ نُوح    ");
         data.add("٧٢ ٱلْجِنّ    ");
         data.add("٧٣ ٱلْمُزَّمِّل   ");
         data.add("٧٤ ٱلْمُدَّثِّر   ");
         data.add("٧٥ ٱلْقِيَامَة   ");
         data.add("٧٦ ٱلْإِنْسَان   ");
         data.add("٧٧ المرسلا   ");
         data.add("٧٨ ٱلنَّبَأ     ");
         data.add("٧٩ ٱلنَّازِعَا    ");
         data.add("٨٠ عَبَسَ     ");
         data.add("٨١ ٱلتَّكْوِير    ");
         data.add("٨٢ ٱلْإِنْفِطَار    ");
         data.add("٨٣ ٱلْمُطَفِّفِين   ");
         data.add("٨٤ ٱلْإِنْشِقَاق   ");
         data.add("٨٥ ٱلْبُرُوج    ");
         data.add("٨٦ ٱلطَّارِق    ");
         data.add("٨٧ ٱلْأَعْلَىٰ    ");
         data.add("٨٨ ٱلْغَاشِيَة    ");
         data.add("٨٩ ٱلْفَجْر     ");
         data.add("٩٠ ٱلْبَلَد      ");
         data.add("٩١ ٱلشَّمْس    ");
         data.add("٩٢ ٱللَّيْل      ");
         data.add("٩٣ ٱلضُّحَى     ");
         data.add("٩٤ ٱلشَّرْح     ");
         data.add("٩٥ ٱلتِّين      ");
         data.add("٩٦ ٱلْعَلَق      ");
         data.add("٩٧ ٱلْقَدْر      ");
         data.add("٩٨ ٱلْبَيِّنة      ");
         data.add("٩٩ الزلزلة     ");
         data.add("١٠٠ العاديات    ");
         data.add("١٠١ القارعة    ");
         data.add("١٠٢ ٱلتَّكَاثُر    ");
         data.add("١٠٣ ٱلْعَصْر    ");
         data.add("١٠٤ ٱلْهُمَزَة    ");
         data.add("١٠٥ ٱلْفِيل     ");
         data.add("١٠٦ قُرَيْش    ");
         data.add("١٠٧ ٱلْمَاعُون   ");
         data.add("١٠٨ ٱلْكَوْثَر    ");
         data.add("١٠٩ ٱلْكَافِرُون   ");
         data.add("١١٠ ٱلنَّصْر    ");
         data.add("١١١ المسد     ");
         data.add("١١٢ ٱلْإِخْلَاص   ");
         data.add("١١٣ ٱلْفَلَق     ");
         data.add("١١٤ ٱلنَّاس     ");
         return data;


     }
     else
         {
             data.clear();

         data.clear();
             data.add("١         الم ");
             data.add("٢       سَيَقُولُ ");
             data.add("٣    تِلْكَ الرُّسُلُ ");
             data.add("٤     لَنْ تَنَالُوا ");
             data.add("٥    وَالْمُحْصَنَاتُ ");
             data.add("٦   لَا يُحِبُّ اللَّهُ ");
             data.add("٧    وَإِذَا سَمِعُوا ");
             data.add("٨      وَلَوْ أَنَّنَا ");
             data.add("٩     قَالَ الْمَلَأُ ");
             data.add("١٠     وَاعْلَمُوا ");
             data.add("١١     يَعْتَذِرُونَ ");
             data.add("١٢  وَمَا مِنْ دَابَّةٍ ");
             data.add("١٣    وَمَا أُبَرِّئُ ");
             data.add("١٤       رُبَمَا ");
             data.add("١٥  سُبْحَانَ الَّذِي ");
             data.add("١٦     قَالَ أَلَمْ ");
             data.add("١٧      اقْتَرَبَ ");
             data.add("١٨     قَدْ أَفْلَحَ ");
             data.add("١٩   وَقَالَ الَّذِينَ ");
             data.add("٢٠    أَمَّنْ خَلَقَ ");
             data.add("٢١  اتْلُ مَا أُوحِيَ ");
             data.add("٢٢    وَمَنْ يَقْنُتْ ");
             data.add("٢٣      وَمَا لِيَ ");
             data.add("٢٤     فَمَنْ أَظْلَمُ ");
             data.add("٢٥      إِلَيْهِ يُرَدُّ ");
             data.add("٢٦         حم ");
             data.add("٢٧  قَالَ فَمَا خَطْبُكُمْ ");
             data.add("٢٨   قَدْ سَمِعَ اللَّهُ ");
             data.add("٢٩    تَبَارَكَ الَّذِي ");
             data.add("٣٠   عَمَّ يَتَسَاءَلُونَ ");

                return data;


        }
    }




}