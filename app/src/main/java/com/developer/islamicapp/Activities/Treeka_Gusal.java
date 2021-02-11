package com.developer.islamicapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.developer.islamicapp.Adapter.SliderAdapter;
import com.developer.islamicapp.R;
import com.developer.islamicapp.utils.Typcastregular;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;

import java.util.ArrayList;

public class Treeka_Gusal extends AppCompatActivity {
    private com.smarteist.autoimageslider.SliderView slider2;

    SliderAdapter sliderAdapter;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Typcastregular.Typcastregular(getApplicationContext(), "SERIF", "Poppins-Regular.otf");
        setContentView(R.layout.activity_treeka__gusal);

        slider2=findViewById(R.id.slider2);
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        sliderAdapter=new SliderAdapter(getApplicationContext(),getdata2());
        slider2.setSliderAdapter(sliderAdapter);
        slider2.setCurrentPagePosition(sliderAdapter.getCount()-1);

        slider2.setIndicatorAnimation(IndicatorAnimations.THIN_WORM);
        slider2.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        slider2.setScrollTimeInSec(1200); //set scroll delay in seconds :
        slider2.startAutoCycle();



    }

    private ArrayList<Integer> getdata2() {

        ArrayList<Integer> fldrData=new ArrayList<>();

        fldrData.add(R.drawable.end);
        fldrData.add(R.drawable.salatp18);
        fldrData.add(R.drawable.salatp17);
        fldrData.add(R.drawable.salatp16);
        fldrData.add(R.drawable.salatp15);
        fldrData.add(R.drawable.salatp14);

        fldrData.add(R.drawable.salatp13);
        fldrData.add(R.drawable.salatp12);
        fldrData.add(R.drawable.salatp10);
        fldrData.add(R.drawable.salatp9);
        fldrData.add(R.drawable.salatp8);

        fldrData.add(R.drawable.salatp7);
        fldrData.add(R.drawable.salatp6);
        fldrData.add(R.drawable.salatp5);
        fldrData.add(R.drawable.salatp4);
        fldrData.add(R.drawable.salatp3);

        fldrData.add(R.drawable.salatp2);
        fldrData.add(R.drawable.salatp1);



        return  fldrData;
    }

}