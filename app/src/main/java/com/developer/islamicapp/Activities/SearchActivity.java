package com.developer.islamicapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.ProgressDialog;
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
import android.widget.TextView;

import com.developer.islamicapp.Adapter.AdapterWordSearch;
import com.developer.islamicapp.Api.volleyprocess_word_search;
import com.developer.islamicapp.Model.Quran_words_search;
import com.developer.islamicapp.R;
import com.developer.islamicapp.callbacks.Search_Result;
import com.developer.islamicapp.utils.Typcastregular;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements Search_Result,TextWatcher, View.OnClickListener , AdapterView.OnItemSelectedListener{
private RecyclerView recyclerView;
ArrayList<String> data = new ArrayList<>();
//Spinner spinner_surahs_select;
String serchedDATA;

AutoCompleteTextView search_edtv;
    EditText WordSearch_editext_volley;
    TextView totl;
    String word;
    Button search_by_worrd_btn, start_search_btn, search_by_surah_btn;
    int i=0;
    ProgressDialog progressDialog;
    int lyt_chk =0;
    RelativeLayout lyt_containing_search_bybtns_edittext_lyt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Typcastregular.Typcastregular(getApplicationContext(), "SERIF", "Poppins-Regular.otf");
        setContentView(R.layout.activity_search);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


//        spinner_surahs_select = findViewById(R.id.spinner_surahs_select);
        recyclerView=findViewById(R.id.rec);
        search_edtv =findViewById(R.id.search_edtv);
        findViewById(R.id.back).setOnClickListener(this);
        search_edtv.addTextChangedListener(this);
        lyt_containing_search_bybtns_edittext_lyt =findViewById(R.id.lyt_containing_search_bybtns_edittext_lyt);
        recyclerView = findViewById(R.id.rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        search_edtv =findViewById(R.id.search_edtv);
        WordSearch_editext_volley =findViewById(R.id.WordSearch_editext);
        search_by_worrd_btn =findViewById(R.id.search_by_worrd_btn);
        search_by_worrd_btn.setOnClickListener(this);
        start_search_btn =findViewById(R.id.start_search_btn);
        start_search_btn.setOnClickListener(this);
        totl=findViewById(R.id.total);
        search_by_surah_btn =findViewById(R.id.search_by_surah_btn);


        search_by_surah_btn.setTextColor(ResourcesCompat.getColor(SearchActivity.this.getResources()
                , R.color.colorWhite, null));

        search_by_worrd_btn.setTextColor(ResourcesCompat.getColor(SearchActivity.this.getResources()
                , R.color.colorText, null));



        search_by_surah_btn.setOnClickListener(this);

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
            case R.id.search_by_worrd_btn:



                search_by_worrd_btn_SETUP();



                    search_by_surah_btn.setTextColor(ResourcesCompat.getColor(SearchActivity.this.getResources(), R.color.colorText, null));

                    search_by_worrd_btn.setTextColor(ResourcesCompat.getColor(SearchActivity.this.getResources(), R.color.colorWhite, null));




                break;
            case R.id.search_by_surah_btn:



                search_by_surah_btn_SETUP();
                i=0;
                search_by_worrd_btn.setText("Search by Surah");



                search_by_surah_btn.setTextColor(ResourcesCompat.getColor(SearchActivity.this.getResources(), R.color.colorWhite, null));

                search_by_worrd_btn.setTextColor(ResourcesCompat.getColor(SearchActivity.this.getResources(), R.color.colorText, null));




                break;
            case R.id.start_search_btn:

                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                 word= WordSearch_editext_volley.getText().toString().trim();

                 if (!TextUtils.isEmpty(word))
                {
                    new volleyprocess_word_search(getApplicationContext(),SearchActivity.this,word);


                }else {
                    WordSearch_editext_volley.setError("Empty!");
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

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item,data);
//
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner_surahs_select.setAdapter(adapter);
//
//        spinner_surahs_select.setOnItemSelectedListener(this);

    }


    private void autocompletetextsearch(){

        search_edtv.setThreshold(1);


        final ArrayAdapter adapter=new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                data);



        search_edtv.setAdapter(adapter);
        search_edtv.setTextColor(Color.parseColor("#Ecc73a"));
        search_edtv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                   serchedDATA="";
                serchedDATA= search_edtv.getAdapter().getItem(position).toString();
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

    startActivity(new Intent(this, Read_quran_Activity.class).putExtra("DB","Surah").putExtra("Datafetch",surah));
//



}


    @Override
    protected void onResume() {

//        spinner_surahs_select.setSelection(0);

        super.onResume();

    }

    private void search_by_surah_btn_SETUP(){

        start_search_btn.setVisibility(View.GONE);
        WordSearch_editext_volley.setVisibility(View.GONE);
        lyt_containing_search_bybtns_edittext_lyt.setVisibility(View.VISIBLE);

        search_by_surah_btn.setVisibility(View.VISIBLE);
        search_by_worrd_btn.setVisibility(View.VISIBLE);
    }
    private void search_by_worrd_btn_SETUP(){

        start_search_btn.setVisibility(View.VISIBLE);
        WordSearch_editext_volley.setVisibility(View.VISIBLE);
        lyt_containing_search_bybtns_edittext_lyt.setVisibility(View.GONE);
        search_by_surah_btn.setVisibility(View.VISIBLE);
        search_by_worrd_btn.setVisibility(View.VISIBLE);


    }
    private void ShowRC(){

        start_search_btn.setVisibility(View.GONE);
        WordSearch_editext_volley.setVisibility(View.GONE);
        lyt_containing_search_bybtns_edittext_lyt.setVisibility(View.GONE);
        search_by_worrd_btn.setVisibility(View.GONE);
        start_search_btn.setVisibility(View.GONE);
        WordSearch_editext_volley.setVisibility(View.GONE);
        search_by_surah_btn.setVisibility(View.GONE);

        totl.setVisibility(View.VISIBLE);

//        spinner_surahs_select.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);

        progressDialog.dismiss();
    }
    private void HideRC(){
    search_by_worrd_btn_SETUP();

        totl.setVisibility(View.GONE);
//        spinner_surahs_select.setVisibility(View.VISIBLE); mn
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