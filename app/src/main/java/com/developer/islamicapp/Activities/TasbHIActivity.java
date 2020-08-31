package com.developer.islamicapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.developer.islamicapp.R;
import com.developer.islamicapp.utils.Typcastregular;

public class TasbHIActivity extends AppCompatActivity implements View.OnClickListener {

    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Typcastregular.Typcastregular(getApplicationContext(), "SERIF", "Poppins-Regular.otf");
        setContentView(R.layout.activity_tasbhi);


        bundle=new Bundle();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        findViewById(R.id.KD).setOnClickListener(this);
        findViewById(R.id.DA).setOnClickListener(this);
        findViewById(R.id.back).setOnClickListener(this);
        findViewById(R.id.bk3).setOnClickListener(this);
        findViewById(R.id.bk4).setOnClickListener(this);
        findViewById(R.id.bk5).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.DA:

                bundle.putString("activity", "btn2");
                startActivity(new Intent(this, Tasbhi_counter_Activity.class).putExtras(bundle));

                break;


            case R.id.KD:
                bundle.putString("activity", "btn1");

                startActivity(new Intent(this, Tasbhi_counter_Activity.class).putExtras(bundle));


                break;


            case R.id.bk3:
                bundle.putString("activity", "btn3");

                startActivity(new Intent(this, Tasbhi_counter_Activity.class).putExtras(bundle));


                break;

            case R.id.bk4:
                bundle.putString("activity", "btn4");

                startActivity(new Intent(this, Tasbhi_counter_Activity.class).putExtras(bundle));


                break;

            case R.id.bk5:
                bundle.putString("activity", "btn5");

                startActivity(new Intent(this, Tasbhi_counter_Activity.class).putExtras(bundle));


                break;


            case R.id.back:
              finish();
                break;



        }
    }
}