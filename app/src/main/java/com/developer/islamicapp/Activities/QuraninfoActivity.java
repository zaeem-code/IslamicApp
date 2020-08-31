package com.developer.islamicapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.developer.islamicapp.R;
import com.developer.islamicapp.utils.Typcastregular;

public class QuraninfoActivity extends AppCompatActivity implements View.OnClickListener {

int chk=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Typcastregular.Typcastregular(getApplicationContext(), "SERIF", "Poppins-Regular.otf");
        setContentView(R.layout.activity_quraninfo);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        findViewById(R.id.back).setOnClickListener(this);
        findViewById(R.id.Hadeesbook1).setOnClickListener(this);
        findViewById(R.id.KD).setOnClickListener(this);
        findViewById(R.id.DA).setOnClickListener(this);
        findViewById(R.id.book1C).setOnClickListener(this);
        findViewById(R.id.book1D).setOnClickListener(this);
        findViewById(R.id.book1E).setOnClickListener(this);
        findViewById(R.id.book1F).setOnClickListener(this);
        findViewById(R.id.book1G).setOnClickListener(this);
        findViewById(R.id.book1H).setOnClickListener(this);
        findViewById(R.id.book1I).setOnClickListener(this);
        findViewById(R.id.book1J).setOnClickListener(this);
        findViewById(R.id.book1K).setOnClickListener(this);
        findViewById(R.id.book1l).setOnClickListener(this);
        findViewById(R.id.book1m).setOnClickListener(this);
        findViewById(R.id.book1n).setOnClickListener(this);


        findViewById(R.id.Hadeesbook2).setOnClickListener(this);
    findViewById(R.id.Hadeesbook3).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                if (chk==0){

                    finish();
                }else {
                    chk=0;

                    otherBook1vis();
                    subBook1gone();
                }
                break;
            case R.id.Hadeesbook1:
                otehrbooksGone();
                subBook1visble();
                chk++;
                 break;


                case R.id.KD:     startActivity(new Intent(this,ReadingBookActivity.class).putExtra("book","book1A"));

                break;

                case R.id.DA:     startActivity(new Intent(this,ReadingBookActivity.class).putExtra("book","book1B"));

                break;

                case R.id.book1C:     startActivity(new Intent(this,ReadingBookActivity.class).putExtra("book","book1C"));

                break;
                ///

            case R.id.book1D:     startActivity(new Intent(this,ReadingBookActivity.class).putExtra("book","book1D"));

                break;
            case R.id.book1E:     startActivity(new Intent(this,ReadingBookActivity.class).putExtra("book","book1E"));

                break;
            case R.id.book1F:     startActivity(new Intent(this,ReadingBookActivity.class).putExtra("book","book1F"));

                break;
            case R.id.book1G:     startActivity(new Intent(this,ReadingBookActivity.class).putExtra("book","book1G"));

                break;
            case R.id.book1H:     startActivity(new Intent(this,ReadingBookActivity.class).putExtra("book","book1H"));

                break;
            case R.id.book1I:     startActivity(new Intent(this,ReadingBookActivity.class).putExtra("book","book1I"));

                break;
            case R.id.book1J:     startActivity(new Intent(this,ReadingBookActivity.class).putExtra("book","book1J"));

                break;
            case R.id.book1K:     startActivity(new Intent(this,ReadingBookActivity.class).putExtra("book","book1k"));

                break;
            case R.id.book1l:     startActivity(new Intent(this,ReadingBookActivity.class).putExtra("book","book1l"));

                break;
            case R.id.book1m:     startActivity(new Intent(this,ReadingBookActivity.class).putExtra("book","book1m"));

                break;
            case R.id.book1n:     startActivity(new Intent(this,ReadingBookActivity.class).putExtra("book","book1n"));

                break;



            case R.id.Hadeesbook2:    startActivity(new Intent(this,ReadingBookActivity.class).putExtra("book","book3"));

                break;
            case R.id.Hadeesbook3:
                startActivity(new Intent(this,ReadingBookActivity.class).putExtra("book","book2"));

                break;


        }
    }
    private  void  subBook1gone(){

        findViewById(R.id.KD).setVisibility(View.GONE);
        findViewById(R.id.DA).setVisibility(View.GONE);
        findViewById(R.id.book1C).setVisibility(View.GONE);
        findViewById(R.id.book1D).setVisibility(View.GONE);
        findViewById(R.id.book1E).setVisibility(View.GONE);
        findViewById(R.id.book1F).setVisibility(View.GONE);
        findViewById(R.id.book1G).setVisibility(View.GONE);
        findViewById(R.id.book1H).setVisibility(View.GONE);
        findViewById(R.id.book1I).setVisibility(View.GONE);
        findViewById(R.id.book1J).setVisibility(View.GONE);
        findViewById(R.id.book1K).setVisibility(View.GONE);
        findViewById(R.id.book1l).setVisibility(View.GONE);
        findViewById(R.id.book1m).setVisibility(View.GONE);
        findViewById(R.id.book1n).setVisibility(View.GONE);



    }

    private  void  subBook1visble(){

        findViewById(R.id.KD).setVisibility(View.VISIBLE);
        findViewById(R.id.DA).setVisibility(View.VISIBLE);
        findViewById(R.id.book1C).setVisibility(View.VISIBLE);
        findViewById(R.id.book1D).setVisibility(View.VISIBLE);
        findViewById(R.id.book1E).setVisibility(View.VISIBLE);
        findViewById(R.id.book1F).setVisibility(View.VISIBLE);
        findViewById(R.id.book1G).setVisibility(View.VISIBLE);
        findViewById(R.id.book1H).setVisibility(View.VISIBLE);
        findViewById(R.id.book1I).setVisibility(View.VISIBLE);
        findViewById(R.id.book1J).setVisibility(View.VISIBLE);
        findViewById(R.id.book1K).setVisibility(View.VISIBLE);
        findViewById(R.id.book1l).setVisibility(View.VISIBLE);
        findViewById(R.id.book1m).setVisibility(View.VISIBLE);
        findViewById(R.id.book1n).setVisibility(View.VISIBLE);


    }

    private  void  otehrbooksGone(){

        findViewById(R.id.c1).setVisibility(View.GONE);
        findViewById(R.id.c2).setVisibility(View.GONE);
        findViewById(R.id.c3).setVisibility(View.GONE);

    }private  void  otherBook1vis()
    {

        findViewById(R.id.c1).setVisibility(View.VISIBLE);
        findViewById(R.id.c2).setVisibility(View.VISIBLE);
        findViewById(R.id.c3).setVisibility(View.VISIBLE);

    }
}