package com.developer.islamicapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.developer.islamicapp.R;
import com.developer.islamicapp.utils.Typcastregular;

public class NamazActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_namaz);
        Typcastregular.Typcastregular(getApplicationContext(), "SERIF", "Jameel_Noori_Nastaleeq_Kasheeda.ttf");
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        findViewById(R.id.back).setOnClickListener(this);
        findViewById(R.id.TN).setOnClickListener(this);
        findViewById(R.id.TW).setOnClickListener(this);
        findViewById(R.id.TG).setOnClickListener(this);
        findViewById(R.id.NE).setOnClickListener(this);
        findViewById(R.id.NJ).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
switch (v.getId()){
    case R.id.back:
        finish();
        break;
    case R.id.TN:
        startActivity(new Intent(this,Treeka_Gusal.class));



        break;
    case R.id.TW:
        startActivity(new Intent(this,NamazActivit_details.class).putExtra("chk","TW"));


        break;
    case R.id.TG:
        startActivity(new Intent(this,NamazActivit_details.class).putExtra("chk","TG"));



        break;
    case R.id.NE:
        startActivity(new Intent(this,NamazActivit_details.class).putExtra("chk","NE"));


        break;
    case R.id.NJ:
        startActivity(new Intent(this,NamazActivit_details.class).putExtra("chk","NJ"));


        break;






}
    }
}