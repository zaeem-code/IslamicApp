package com.developer.islamicapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.developer.islamicapp.Adapter.AdapterWordSearch;
import com.developer.islamicapp.Api.volleyprocess_quran_fetcher;
import com.developer.islamicapp.Api.volleyprocess_word_search;
import com.developer.islamicapp.Model.Quran_words_search;
import com.developer.islamicapp.R;
import com.developer.islamicapp.callbacks.Search_Result;
import com.developer.islamicapp.utils.Typcastregular;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements Search_Result,TextWatcher, View.OnClickListener , AdapterView.OnItemSelectedListener{
private RecyclerView recyclerView;
ArrayList<String> data = new ArrayList<>();
Spinner spinner;
String serchedDATA;

AutoCompleteTextView serchTXT;
    EditText searchWord;
    TextView totl;
    String word;
    Button searchFeature,StartSearch,space;
    int i=0;
    ProgressDialog progressDialog;
    int lyt_chk =0;
    RelativeLayout lyt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Typcastregular.Typcastregular(getApplicationContext(), "SERIF", "Poppins-Regular.otf");
        setContentView(R.layout.activity_search);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        spinner = findViewById(R.id.spinner);
        recyclerView=findViewById(R.id.rec);
        serchTXT=findViewById(R.id.search_ed);
        findViewById(R.id.back).setOnClickListener(this);
        serchTXT.addTextChangedListener(this);
        lyt1=findViewById(R.id.l2);
        recyclerView = findViewById(R.id.rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        serchTXT=findViewById(R.id.search_ed);
        searchWord=findViewById(R.id.WordSearch);
        searchFeature=findViewById(R.id.feature);
        searchFeature.setOnClickListener(this);
        StartSearch=findViewById(R.id.searchstart);
        StartSearch.setOnClickListener(this);
        totl=findViewById(R.id.total);
        space=findViewById(R.id.space);


        space.setTextColor(ResourcesCompat.getColor(SearchActivity.this.getResources()
                , R.color.colorWhite, null));

        searchFeature.setTextColor(ResourcesCompat.getColor(SearchActivity.this.getResources()
                , R.color.colorText, null));



        space.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                space.setTextColor(ResourcesCompat.getColor(SearchActivity.this.getResources()
                        , R.color.colorWhite, null));

                searchFeature.setTextColor(ResourcesCompat.getColor(SearchActivity.this.getResources()
                        , R.color.colorText, null));

                Hidefeature();

            }
        });

        settingspinner();

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading....");









    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                if (lyt_chk ==0){
                    finish(); }else {
                    lyt_chk =0;
                    HideRC();
                }
                break;
            case R.id.feature:



                showfeature();
//                    Hidefeature();
                    i=0;
                    searchFeature.setText("Search by Word");



                    space.setTextColor(ResourcesCompat.getColor(SearchActivity.this.getResources()
                            , R.color.colorText, null));

                    searchFeature.setTextColor(ResourcesCompat.getColor(SearchActivity.this.getResources()
                            , R.color.colorWhite, null));




                break;
            case R.id.searchstart:

                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                 word=searchWord.getText().toString().trim();

                 if (!TextUtils.isEmpty(word))
                {
                    new volleyprocess_word_search(getApplicationContext(),SearchActivity.this,word);


                }else {
                    searchWord.setError("Empty!");
                }
                break;
        }
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        serchedDATA="";
        if (!(position ==0))
        {
serchedDATA= (String) parent.getItemAtPosition(position);
serchedDATA=serchedDATA.substring(serchedDATA.length()-4).trim();
ssearching(serchedDATA);

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


    }



    private void settingspinner()
    {





        data.add("Surah name/number");
        data.add("ٱلْفَاتِحَة   1");
        data.add("ٱلْبَقَرَة   2");
        data.add("آلِ عِمْرَان   3");

         data.add("ٱلنِّسَاء   4");

        data.add("ٱلْمَائِدَة   5");
        data.add("ٱلْأَنْعَام   6");
        data.add("ٱلْأَعْرَاف   7");
        data.add("ٱلْأَنْفَال   8");
        data.add("ٱلتَّوْبَة   9");
        data.add("يُونُس   10");
        data.add("هُود   11");
        data.add("يُوسُف   12");
        data.add("ٱلرَّعْد   13");
        data.add("إِبْرَاهِيم   14");
        data.add("ٱلْحِجْر   15");
        data.add("ٱلنَّحْل   16");
        data.add("ٱلْإِسْرَاء   17");
        data.add("ٱلْكَهْف   18");
        data.add("مَرْيَم   19");
        data.add("طه   20");
        data.add("ٱلْأَنْبِيَاء   21");
        data.add("ٱلْحَجّ   22");
        data.add("ٱلْمُؤْمِنُون   23");
        data.add("ٱلنُّور   24");
        data.add("ٱلْفُرْقَان   25");
        data.add("ٱلشُّعَرَاء   26");
        data.add("ٱلنَّمْل   27");
        data.add("ٱلْقَصَص   28");
        data.add("ٱلْعَنْكَبُوت   29");
        data.add("ٱلرُّوم   30");
        data.add("لُقْمَان   31");
        data.add("ٱلسَّجْدَة   32");
        data.add("ٱلْأَحْزَاب   33");
        data.add("سَبَأ   34");
        data.add("فَاطِر     35");
        data.add("يس      36");
        data.add("ٱلصَّافَّات    37");
        data.add("ص      38");
        data.add("ٱلزُّمَر     39");
        data.add("غَافِر     40");
        data.add("فُصِّلَت   41");
        data.add("ٱلشُّورىٰ    42");
        data.add("ٱلْزُّخْرُف    43");
        data.add("ٱلدُّخَان    44");
        data.add("ٱلْجَاثِيَة    45");
        data.add("ٱلْأَحْقَاف   46");
        data.add("مُحَمَّد    47");
        data.add("ٱلْفَتْح    48");
        data.add("ٱلْحُجُرَات   49");
        data.add("ق       50");
        data.add("ٱلذَّارِيَات   51");
        data.add("ٱلطُّور    52");
        data.add("ٱلنَّجْم     53");
        data.add("ٱلْقَمَر     54");
        data.add("ٱلرَّحْمَٰن     55");
        data.add("ٱلْوَاقِعَة    56");
        data.add("ٱلْحَدِيد    57");
        data.add("ٱلْمُجَادِلَة   58");
        data.add("ٱلْحَشْر    59");
        data.add("ٱلْمُمْتَحَنَة   60");
        data.add("ٱلصَّفّ    61");
        data.add("ٱلْجُمُعَة    62");
        data.add("ٱلْمُنَافِقُون   63");
        data.add("ٱلتَّغَابُن    64");
        data.add("ٱلطَّلَاق    65");
        data.add("ٱلتَّحْرِيم   66");
        data.add("ٱلْمُلْك    67");
        data.add("ٱلْقَلَم     68");
        data.add("ٱلْحَاقَّة     69");
        data.add("ٱلْمَعَارِج   70");
        data.add("نُوح     71");
        data.add("ٱلْجِنّ     72");
        data.add("ٱلْمُزَّمِّل   73");
        data.add("ٱلْمُدَّثِّر    74");
        data.add("ٱلْقِيَامَة    75");
        data.add("ٱلْإِنْسَان    76");
        data.add("المرسلا   77");
        data.add("ٱلنَّبَأ      78");
        data.add("ٱلنَّازِعَات   79");
        data.add("عَبَسَ     80");
        data.add("ٱلتَّكْوِير    81");
        data.add("ٱلْإِنْفِطَار   82");
        data.add("ٱلْمُطَفِّفِين   83");
        data.add("ٱلْإِنْشِقَاق   84");
        data.add("ٱلْبُرُوج     85");
        data.add("ٱلطَّارِق    86");
        data.add("ٱلْأَعْلَىٰ    87");
        data.add("ٱلْغَاشِيَة   88");
        data.add("ٱلْفَجْر     89");
        data.add("ٱلْبَلَد      90");
        data.add("ٱلشَّمْس   91");
        data.add("ٱللَّيْل     92");
        data.add("ٱلضُّحَى    ٰ93");
        data.add("ٱلشَّرْح    94");
        data.add("ٱلتِّين     95");
        data.add("ٱلْعَلَق    96");
        data.add("ٱلْقَدْر    97");
        data.add("ٱلْبَيِّنة    98");
        data.add("ٱلزَّلْزَلة   99");
        data.add("ٱلزَّلْزَلَة   100");
        data.add("ٱلزَّلْزَلَة  101");
        data.add("ٱلتَّكَاثُر    102");
        data.add("ٱلْعَصْر    103");
        data.add("ٱلْهُمَزَة    104");
        data.add("ٱلْفِيل      105");
        data.add("قُرَيْش    106");
        data.add("ٱلْمَاعُون   107");
        data.add("ٱلْكَوْثَر    108");
        data.add("ٱلْكَافِرُون     109");
        data.add("ٱلنَّصْر     110");
        data.add("ٱلْمَسَد    111");
        data.add("ٱلْإِخْلَاص   112");
        data.add("ٱلْفَلَق   113");
        data.add("ٱلنَّاس   114");


        autocompletetextsearch();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,data);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

    }


    private void autocompletetextsearch(){

        serchTXT.setThreshold(1);


        final ArrayAdapter adapter=new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                data);



        serchTXT.setAdapter(adapter);
        serchTXT.setTextColor(Color.parseColor("#Ecc73a"));
        serchTXT.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                   serchedDATA="";
                serchedDATA=serchTXT.getAdapter().getItem(position).toString();
                try {
                    serchedDATA=serchedDATA.substring(serchedDATA.length()-4).trim();
                    ssearching(serchedDATA);
                }catch (Exception e)
                {

                }

            }
        });


    }




private void ssearching(String surah){
    switch (surah)
    {
        case "1":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+1,"null").trim().equals("1"))
            {
                new volleyprocess_quran_fetcher(7, 0,this, "surah","1","1","surah");
            }
            else
                {
                    startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","1"));
                }
            break;

        case "2":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+2,"null").trim().equals("2"))
            {
                new volleyprocess_quran_fetcher(286, 0,this, "surah","2","2","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","2"));
            }
            break;



        case "3":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+3,"null").trim().equals("3"))
            {
                new volleyprocess_quran_fetcher(200, 0,this, "surah","3","3","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","3"));
            }
            break;


        case "4":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+4,"null").trim().equals("4"))
            {
                new volleyprocess_quran_fetcher(176, 0,this, "surah","4","4","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","4"));
            }
            break;


        case "5":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+5,"null").trim().equals("5"))
            {
                new volleyprocess_quran_fetcher(120, 0,this, "surah","5","5","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","5"));
            }
            break;

        case "6":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+6,"null").trim().equals("6"))
            {
                new volleyprocess_quran_fetcher(165, 0,this, "surah","6","6","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","6"));
            }
            break;



        case "7":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+7,"null").trim().equals("7"))
            {
                new volleyprocess_quran_fetcher(206, 0,this, "surah","7","7","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","7"));
            }
            break;



        case "8":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+8,"null").trim().equals("8"))
            {
                new volleyprocess_quran_fetcher(75, 0,this, "surah","8","8","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","8"));
            }
            break;



        case "9":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+9,"null").trim().equals("9"))
            {
                new volleyprocess_quran_fetcher(129, 0,this, "surah","9","9","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","9"));
            }
            break;


        case "10":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+10,"null").trim().equals("10"))
            {
                new volleyprocess_quran_fetcher(109, 0,this, "surah","10","10","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","10"));
            }
            break;


        case "11":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+11,"null").trim().equals("1"))
            {
                new volleyprocess_quran_fetcher(123, 0,this, "surah","11","11","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","11"));
            }
            break;

        case "12":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+12,"null").trim().equals("12"))
            {
                new volleyprocess_quran_fetcher(111, 0,this, "surah","12","12","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","12"));
            }
            break;



        case "13":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+13,"null").trim().equals("13"))
            {
                new volleyprocess_quran_fetcher(43, 0,this, "surah","13","13","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","13"));
            }
            break;



        case "14":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+14,"null").trim().equals("14"))
            {
                new volleyprocess_quran_fetcher(52, 0,this, "surah","14","14","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","14"));
            }
            break;



        case "15":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+15,"null").trim().equals("15"))
            {
                new volleyprocess_quran_fetcher(99, 0,this, "surah","15","15","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","15"));
            }
            break;

        case "16":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+16,"null").trim().equals("16"))
            {
                new volleyprocess_quran_fetcher(128, 0,this, "surah","16","16","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","16"));
            }
            break;



        case "17":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+17,"null").trim().equals("17"))
            {
                new volleyprocess_quran_fetcher(111, 0,this, "surah","17","17","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","17"));
            }
            break;




        case "18":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+18,"null").trim().equals("18"))
            {
                new volleyprocess_quran_fetcher(110, 0,this, "surah","18","18","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","18"));
            }
            break;


        case "19":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+19,"null").trim().equals("19"))
            {
                new volleyprocess_quran_fetcher(98, 0,this, "surah","19","19","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","19"));
            }
            break;



        case "20":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+20,"null").trim().equals("20"))
            {
                new volleyprocess_quran_fetcher(135, 0,this, "surah","20","20","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","20"));
            }
            break;


        case "21":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+21,"null").trim().equals("21"))
            {
                new volleyprocess_quran_fetcher(112, 0,this, "surah","21","21","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","21"));
            }
            break;


        case "22":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+22,"null").trim().equals("22"))
            {
                new volleyprocess_quran_fetcher(78, 0,this, "surah","22","22","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","22"));
            }
            break;



        case "23":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+23,"null").trim().equals("23"))
            {
                new volleyprocess_quran_fetcher(118, 0,this, "surah","23","23","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","23"));
            }
            break;




        case "24":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+24,"null").trim().equals("24"))
            {
                new volleyprocess_quran_fetcher(64, 0,this, "surah","24","24","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","24"));
            }
            break;




        case "25":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+25,"null").trim().equals("25"))
            {
                new volleyprocess_quran_fetcher(77, 0,this, "surah","25","25","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","25"));
            }
            break;


        case "26":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+26,"null").trim().equals("26"))
            {
                new volleyprocess_quran_fetcher(227, 0,this, "surah","26","26","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","26"));
            }
            break;



        case "27":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+27,"null").trim().equals("27"))
            {
                new volleyprocess_quran_fetcher(93, 0,this, "surah","27","27","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","27"));
            }
            break;




        case "28":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+28,"null").trim().equals("28"))
            {
                new volleyprocess_quran_fetcher(94, 0,this, "surah","28","28","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","28"));
            }
            break;



        case "29":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+29,"null").trim().equals("29"))
            {
                new volleyprocess_quran_fetcher(53, 0,this, "surah","29","29","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","29"));
            }
            break;



        case "30":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+30,"null").trim().equals("30"))
            {
                new volleyprocess_quran_fetcher(60, 0,this, "surah","30","30","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","30"));
            }
            break;




        case "31":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+31,"null").trim().equals("31"))
            {
                new volleyprocess_quran_fetcher(34, 0,this, "surah","31","31","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","31"));
            }
            break;




        case "32":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+32,"null").trim().equals("32"))
            {
                new volleyprocess_quran_fetcher(30, 0,this, "surah","32","32","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","32"));
            }
            break;




        case "33":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+33,"null").trim().equals("33"))
            {
                new volleyprocess_quran_fetcher(73, 0,this, "surah","33","33","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","33"));
            }
            break;




        case "34":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+34,"null").trim().equals("34"))
            {
                new volleyprocess_quran_fetcher(54, 0,this, "surah","34","34","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","34"));
            }
            break;




        case "35":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+35,"null").trim().equals("35"))
            {
                new volleyprocess_quran_fetcher(45, 0,this, "surah","35","35","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","35"));
            }
            break;




        case "36":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+36,"null").trim().equals("36"))
            {
                new volleyprocess_quran_fetcher(83, 0,this, "surah","36","36","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","36"));
            }
            break;


        case "37":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+37,"null").trim().equals("37"))
            {
                new volleyprocess_quran_fetcher(182, 0,this, "surah","37","37","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","37"));
            }
            break;






        case "38":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+38,"null").trim().equals("38"))
            {
                new volleyprocess_quran_fetcher(88, 0,this, "surah","38","38","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","38"));
            }
            break;



        case "39":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+39,"null").trim().equals("39"))
            {
                new volleyprocess_quran_fetcher(75, 0,this, "surah","39","39","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","39"));
            }
            break;



        case "40":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+40,"null").trim().equals("40"))
            {
                new volleyprocess_quran_fetcher(85, 0,this, "surah","40","40","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","40"));
            }
            break;


        case "41":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+41,"null").trim().equals("41"))
            {
                new volleyprocess_quran_fetcher(54, 0,this, "surah","41","41","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","41"));
            }
            break;



        case "42":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+42,"null").trim().equals("42"))
            {
                new volleyprocess_quran_fetcher(53, 0,this, "surah","42","42","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","42"));
            }
            break;


        case "43":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+43,"null").trim().equals("43"))
            {
                new volleyprocess_quran_fetcher(89, 0,this, "surah","43","43","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","43"));
            }
            break;





        case "44":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+44,"null").trim().equals("44"))
            {
                new volleyprocess_quran_fetcher(59, 0,this, "surah","44","44","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","44"));
            }
            break;




        case "45":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+45,"null").trim().equals("45"))
            {
                new volleyprocess_quran_fetcher(37, 0,this, "surah","45","45","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","45"));
            }
            break;



        case "46":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+46,"null").trim().equals("46"))
            {
                new volleyprocess_quran_fetcher(35, 0,this, "surah","46","46","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","46"));
            }
            break;



        case "47":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+47,"null").trim().equals("47"))
            {
                new volleyprocess_quran_fetcher(38, 0,this, "surah","47","47","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","47"));
            }
            break;


        case "48":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+48,"null").trim().equals("48"))
            {
                new volleyprocess_quran_fetcher(29, 0,this, "surah","48","48","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","48"));
            }
            break;




        case "49":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+49,"null").trim().equals("49"))
            {
                new volleyprocess_quran_fetcher(18, 0,this, "surah","49","49","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","49"));
            }
            break;




        case "50":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+50,"null").trim().equals("50"))
            {
                new volleyprocess_quran_fetcher(45, 0,this, "surah","50","50","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","50"));
            }
            break;



        case "51":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+51,"null").trim().equals("51"))
            {
                new volleyprocess_quran_fetcher(60, 0,this, "surah","51","51","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","51"));
            }
            break;





        case "52":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+52,"null").trim().equals("52"))
            {
                new volleyprocess_quran_fetcher(49, 0,this, "surah","52","52","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","52"));
            }
            break;




        case "53":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+53,"null").trim().equals("53"))
            {
                new volleyprocess_quran_fetcher(62, 0,this, "surah","53","53","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","53"));
            }
            break;


        case "54":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+54,"null").trim().equals("54"))
            {
                new volleyprocess_quran_fetcher(55, 0,this, "surah","54","54","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","54"));
            }
            break;



        case "55":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+55,"null").trim().equals("55"))
            {
                new volleyprocess_quran_fetcher(70, 0,this, "surah","55","55","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","55"));
            }
            break;




        case "56":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+56,"null").trim().equals("56"))
            {
                new volleyprocess_quran_fetcher(104, 0,this, "surah","56","56","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","56"));
            }
            break;




        case "57":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+57,"null").trim().equals("57"))
            {
                new volleyprocess_quran_fetcher(29, 0,this, "surah","57","57","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","57"));
            }
            break;




        case "58":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+58,"null").trim().equals("58"))
            {
                new volleyprocess_quran_fetcher(22, 0,this, "surah","58","58","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","58"));
            }
            break;




        case "59":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+59,"null").trim().equals("59"))
            {
                new volleyprocess_quran_fetcher(24, 0,this, "surah","59","59","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","59"));
            }
            break;


        case "60":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+60,"null").trim().equals("60"))
            {
                new volleyprocess_quran_fetcher(13, 0,this, "surah","60","60","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","60"));
            }
            break;




        case "61":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+61,"null").trim().equals("61"))
            {
                new volleyprocess_quran_fetcher(14, 0,this, "surah","61","61","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","61"));
            }
            break;



        case "62":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+62,"null").trim().equals("62"))
            {
                new volleyprocess_quran_fetcher(11, 0,this, "surah","62","62","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","62"));
            }
            break;



        case "63":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+63,"null").trim().equals("63"))
            {
                new volleyprocess_quran_fetcher(11, 0,this, "surah","63","63","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","63"));
            }
            break;



        case "64":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+64,"null").trim().equals("64"))
            {
                new volleyprocess_quran_fetcher(18, 0,this, "surah","64","64","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","64"));
            }
            break;




        case "65":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+65,"null").trim().equals("65"))
            {
                new volleyprocess_quran_fetcher(12, 0,this, "surah","65","65","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","65"));
            }
            break;


        case "66":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+66,"null").trim().equals("66"))
            {
                new volleyprocess_quran_fetcher(12, 0,this, "surah","66","66","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","66"));
            }
            break;





        case "67":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+67,"null").trim().equals("67"))
            {
                new volleyprocess_quran_fetcher(30, 0,this, "surah","67","67","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","67"));
            }
            break;





        case "68":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+68,"null").trim().equals("68"))
            {
                new volleyprocess_quran_fetcher(52, 0,this, "surah","68","68","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","68"));
            }
            break;




        case "69":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+69,"null").trim().equals("69"))
            {
                new volleyprocess_quran_fetcher(52, 0,this, "surah","69","69","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","69"));
            }
            break;



        case "70":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+70,"null").trim().equals("70"))
            {
                new volleyprocess_quran_fetcher(44, 0,this, "surah","70","70","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","70"));
            }
            break;






        case "71":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+71,"null").trim().equals("71"))
            {
                new volleyprocess_quran_fetcher(28, 0,this, "surah","71","71","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","71"));
            }
            break;




        case "72":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+72,"null").trim().equals("72"))
            {
                new volleyprocess_quran_fetcher(28, 0,this, "surah","72","72","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","72"));
            }
            break;





        case "73":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+73,"null").trim().equals("73"))
            {
                new volleyprocess_quran_fetcher(20, 0,this, "surah","73","73","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","73"));
            }
            break;


        case "74":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+74,"null").trim().equals("74"))
            {
                new volleyprocess_quran_fetcher(56, 0,this, "surah","74","74","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","74"));
            }
            break;



        case "75":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+75,"null").trim().equals("75"))
            {
                new volleyprocess_quran_fetcher(40, 0,this, "surah","75","75","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","75"));
            }
            break;




        case "76":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+76,"null").trim().equals("76"))
            {
                new volleyprocess_quran_fetcher(31, 0,this, "surah","76","76","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","76"));
            }
            break;




        case "77":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+77,"null").trim().equals("77"))
            {
                new volleyprocess_quran_fetcher(50, 0,this, "surah","77","77","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","77"));
            }
            break;





        case "78":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+78,"null").trim().equals("78"))
            {
                new volleyprocess_quran_fetcher(40, 0,this, "surah","78","78","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","78"));
            }
            break;






        case "79":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+79,"null").trim().equals("79"))
            {
                new volleyprocess_quran_fetcher(46, 0,this, "surah","79","79","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","79"));
            }
            break;





        case "80":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+80,"null").trim().equals("80"))
            {
                new volleyprocess_quran_fetcher(42, 0,this, "surah","80","80","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","80"));
            }
            break;



        case "81":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+81,"null").trim().equals("81"))
            {
                new volleyprocess_quran_fetcher(29, 0,this, "surah","81","81","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","81"));
            }
            break;





        case "82":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+82,"null").trim().equals("82"))
            {
                new volleyprocess_quran_fetcher(19, 0,this, "surah","82","82","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","82"));
            }
            break;




        case "83":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+83,"null").trim().equals("83"))
            {
                new volleyprocess_quran_fetcher(36, 0,this, "surah","83","83","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","83"));
            }
            break;



        case "84":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+84,"null").trim().equals("84"))
            {
                new volleyprocess_quran_fetcher(25, 0,this, "surah","84","84","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","84"));
            }
            break;




        case "85":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+85,"null").trim().equals("85"))
            {
                new volleyprocess_quran_fetcher(22, 0,this, "surah","85","85","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","85"));
            }
            break;


        case "86":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+86,"null").trim().equals("86"))
            {
                new volleyprocess_quran_fetcher(17, 0,this, "surah","86","86","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","86"));
            }
            break;




        case "87":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+87,"null").trim().equals("87"))
            {
                new volleyprocess_quran_fetcher(19, 0,this, "surah","87","87","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","87"));
            }
            break;




        case "88":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+88,"null").trim().equals("88"))
            {
                new volleyprocess_quran_fetcher(26, 0,this, "surah","88","88","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","88"));
            }
            break;




        case "89":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+89,"null").trim().equals("89"))
            {
                new volleyprocess_quran_fetcher(30, 0,this, "surah","89","89","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","89"));
            }
            break;



        case "90":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+90,"null").trim().equals("90"))
            {
                new volleyprocess_quran_fetcher(20, 0,this, "surah","90","90","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","90"));
            }
            break;


        case "91":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+91,"null").trim().equals("91"))
            {
                new volleyprocess_quran_fetcher(15, 0,this, "surah","91","91","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","91"));
            }
            break;




        case "92":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+92,"null").trim().equals("92"))
            {
                new volleyprocess_quran_fetcher(21, 0,this, "surah","92","92","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","92"));
            }
            break;



        case "93":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+93,"null").trim().equals("93"))
            {
                new volleyprocess_quran_fetcher(11, 0,this, "surah","93","93","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","93"));
            }
            break;



        case "94":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+94,"null").trim().equals("94"))
            {
                new volleyprocess_quran_fetcher(8, 0,this, "surah","94","94","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","94"));
            }
            break;




        case "95":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+95,"null").trim().equals("95"))
            {
                new volleyprocess_quran_fetcher(8, 0,this, "surah","95","95","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","95"));
            }
            break;



        case "96":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+96,"null").trim().equals("96"))
            {
                new volleyprocess_quran_fetcher(19, 0,this, "surah","96","96","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","96"));
            }
            break;





        case "97":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+97,"null").trim().equals("97"))
            {
                new volleyprocess_quran_fetcher(5, 0,this, "surah","97","97","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","97"));
            }
            break;




        case "98":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+98,"null").trim().equals("98"))
            {
                new volleyprocess_quran_fetcher(8, 0,this, "surah","98","98","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","98"));
            }
            break;




        case "99":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+99,"null").trim().equals("99"))
            {
                new volleyprocess_quran_fetcher(8, 0,this, "surah","99","99","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","99"));
            }
            break;



        case "100":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+100,"null").trim().equals("100"))
            {
                new volleyprocess_quran_fetcher(100, 0,this, "surah","100","100","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","100"));
            }
            break;





        case "101":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+101,"null").trim().equals("101"))
            {
                new volleyprocess_quran_fetcher(11, 0,this, "surah","101","101","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","101"));
            }
            break;




        case "102":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+102,"null").trim().equals("102"))
            {
                new volleyprocess_quran_fetcher(8, 0,this, "surah","102","102","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","102"));
            }
            break;



        case "103":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+103,"null").trim().equals("103"))
            {
                new volleyprocess_quran_fetcher(3, 0,this, "surah","103","103","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","103"));
            }
            break;




        case "104":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+104,"null").trim().equals("104"))
            {
                new volleyprocess_quran_fetcher(9, 0,this, "surah","104","104","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","104"));
            }
            break;




        case "105":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+105,"null").trim().equals("105"))
            {
                new volleyprocess_quran_fetcher(5, 0,this, "surah","105","105","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","105"));
            }
            break;




        case "106":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+106,"null").trim().equals("106"))
            {
                new volleyprocess_quran_fetcher(4, 0,this, "surah","106","106","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","106"));
            }
            break;




        case "107":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+107,"null").trim().equals("107"))
            {
                new volleyprocess_quran_fetcher(7, 0,this, "surah","107","107","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","107"));
            }
            break;




        case "108":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+108,"null").trim().equals("108"))
            {
                new volleyprocess_quran_fetcher(3, 0,this, "surah","108","108","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","108"));
            }
            break;



        case "109":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+109,"null").trim().equals("109"))
            {
                new volleyprocess_quran_fetcher(6, 0,this, "surah","109","109","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","109"));
            }
            break;



        case "110":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+110,"null").trim().equals("110"))
            {
                new volleyprocess_quran_fetcher(3, 0,this, "surah","110","110","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","110"));
            }
            break;





        case "111":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+111,"null").trim().equals("111"))
            {
                new volleyprocess_quran_fetcher(5, 0,this, "surah","111","111","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","111"));
            }
            break;




        case "112":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+112,"null").trim().equals("112"))
            {
                new volleyprocess_quran_fetcher(4, 0,this, "surah","112","112","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","112"));
            }
            break;


        case "113":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+113,"null").trim().equals("113"))
            {
                new volleyprocess_quran_fetcher(5, 0,this, "surah","113","113","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","113"));
            }
            break;





        case "114":
            if (!getSharedPreferences("DB", Context.MODE_PRIVATE).getString("surah"+114,"null").trim().equals("114"))
            {
                new volleyprocess_quran_fetcher(6, 0,this, "surah","114","114","surah");
            }
            else
            {
                startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","surah").putExtra("Datafetch","114"));
            }
            break;






































    }








}


    @Override
    protected void onResume() {

        spinner.setSelection(0);

        super.onResume();

    }
    private void Hidefeature(){

        StartSearch.setVisibility(View.GONE);
        searchWord.setVisibility(View.GONE);
        lyt1.setVisibility(View.VISIBLE);
    }
    private void showfeature(){

        StartSearch.setVisibility(View.VISIBLE);
        searchWord.setVisibility(View.VISIBLE);
        lyt1.setVisibility(View.GONE);



    }
    private void ShowRC(){
        space.setVisibility(View.INVISIBLE);
        lyt1.setVisibility(View.INVISIBLE);
        totl.setVisibility(View.VISIBLE);
        Hidefeature();
        searchFeature.setVisibility(View.GONE);
        spinner.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);

        progressDialog.dismiss();
    }
    private void HideRC(){
      showfeature();

        space.setVisibility(View.INVISIBLE);
        totl.setVisibility(View.GONE);
        lyt1.setVisibility(View.VISIBLE);
        searchFeature.setVisibility(View.VISIBLE);
        spinner.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void data(ArrayList<Quran_words_search> data, String count) {
        if (data!=null){
            progressDialog.show();

            lyt_chk++;
            AdapterWordSearch adapterWordSearch=new AdapterWordSearch(this,data );
            recyclerView.setAdapter(adapterWordSearch);
            adapterWordSearch.notifyDataSetChanged();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    ShowRC();

                    totl.setText("  appeared #"+count+" times in Quran "+word);
                }
            }, 1000);


        }else {
            progressDialog.dismiss();
        //    Toast.makeText(this, "Sorry Unable to find !", Toast.LENGTH_SHORT).show();
        }
    }
}