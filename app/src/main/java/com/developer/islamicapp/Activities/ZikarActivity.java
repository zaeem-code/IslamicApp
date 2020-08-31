package com.developer.islamicapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.developer.islamicapp.Adapter.SliderAdapter;
import com.developer.islamicapp.R;
import com.developer.islamicapp.utils.Typcast;
import com.developer.islamicapp.utils.Typcastregular;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;

import java.util.ArrayList;

public class ZikarActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;

    private com.smarteist.autoimageslider.SliderView slider2;
    SliderAdapter sliderAdapter;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Typcastregular.Typcastregular(getApplicationContext(), "SERIF", "Poppins-Regular.otf");
        setContentView(R.layout.activity_zikar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

//        findViewById(R.id.Msdua).setOnClickListener(this);
        findViewById(R.id.back).setOnClickListener(this);

        slider2=findViewById(R.id.slider2);

        sliderAdapter=new SliderAdapter(getApplicationContext(),getdata2());
        slider2.setSliderAdapter(sliderAdapter);
        slider2.setCurrentPagePosition(sliderAdapter.getCount()-1);

        slider2.setIndicatorAnimation(IndicatorAnimations.THIN_WORM);
        slider2.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        slider2.setScrollTimeInSec(1200); //set scroll delay in seconds :
        slider2.startAutoCycle();
        //




    }

    private ArrayList<Integer> getdata2() {

        ArrayList<Integer> fldrData=new ArrayList<>();
        fldrData.add(R.drawable.im_1);
        fldrData.add(R.drawable.im_2);
        fldrData.add(R.drawable.im_3);
        fldrData.add(R.drawable.im_4);
        fldrData.add(R.drawable.im_5);
        fldrData.add(R.drawable.im_6);
        fldrData.add(R.drawable.im_7);
        fldrData.add(R.drawable.im_8);
        fldrData.add(R.drawable.im_9);
        fldrData.add(R.drawable.im_10);
        fldrData.add(R.drawable.im_11);
        fldrData.add(R.drawable.im_12);
        fldrData.add(R.drawable.im_13);
        fldrData.add(R.drawable.im_14);
        fldrData.add(R.drawable.im_15);
        fldrData.add(R.drawable.im_16);
        fldrData.add(R.drawable.im_18);
        fldrData.add(R.drawable.im_19);
        fldrData.add(R.drawable.im_20);
        fldrData.add(R.drawable.im_21);
        fldrData.add(R.drawable.im_22);
        fldrData.add(R.drawable.im_23);
        fldrData.add(R.drawable.im_24);
        fldrData.add(R.drawable.im_25);
        fldrData.add(R.drawable.im_26);
        fldrData.add(R.drawable.im_27);
        fldrData.add(R.drawable.im_28);
        fldrData.add(R.drawable.im_29);
        fldrData.add(R.drawable.im_30);
        fldrData.add(R.drawable.im_31);
        fldrData.add(R.drawable.im_32);
        fldrData.add(R.drawable.im_33);
        fldrData.add(R.drawable.im_34);
        fldrData.add(R.drawable.im_35);
        fldrData.add(R.drawable.im_36);
        fldrData.add(R.drawable.im_37);
        fldrData.add(R.drawable.im_38);
        fldrData.add(R.drawable.im_39);
        fldrData.add(R.drawable.im_40);
        fldrData.add(R.drawable.im_41);
        fldrData.add(R.drawable.im_42);
        fldrData.add(R.drawable.im_43);
        fldrData.add(R.drawable.im_44);
        fldrData.add(R.drawable.im_45);
        fldrData.add(R.drawable.im_46);
        fldrData.add(R.drawable.im_47);
        fldrData.add(R.drawable.im_48);
        fldrData.add(R.drawable.im_49);
        fldrData.add(R.drawable.im_50);
        fldrData.add(R.drawable.im_51);
        fldrData.add(R.drawable.im_52);
        fldrData.add(R.drawable.im_53);
        fldrData.add(R.drawable.im_54);
        fldrData.add(R.drawable.im_55);
        fldrData.add(R.drawable.im_56);
        fldrData.add(R.drawable.im_57);
        fldrData.add(R.drawable.im_58);
        fldrData.add(R.drawable.im_59);

        return  fldrData;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){


            case R.id.Msdua:
                startActivity(new Intent(this,SlideMasnon.class));

                break;

            case R.id.back:
                finish();
                break;
        }

    }
}