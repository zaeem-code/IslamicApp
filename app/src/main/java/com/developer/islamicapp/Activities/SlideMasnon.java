package com.developer.islamicapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.developer.islamicapp.Adapter.SliderAdapter;
import com.developer.islamicapp.R;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;

import java.util.ArrayList;

public class SlideMasnon extends AppCompatActivity {
    private com.smarteist.autoimageslider.SliderView slider2;
    SliderAdapter sliderAdapter;
    ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_masnon);

        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        slider2=findViewById(R.id.slider2);

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
        fldrData.add(R.drawable.i_1);
        fldrData.add(R.drawable.i_2);
        fldrData.add(R.drawable.i_3);
        fldrData.add(R.drawable.i_4);
        fldrData.add(R.drawable.i_5);
        fldrData.add(R.drawable.i_6);
        fldrData.add(R.drawable.i_7);
        fldrData.add(R.drawable.i_8);
        fldrData.add(R.drawable.i_9);
        fldrData.add(R.drawable.i_10);
        fldrData.add(R.drawable.i_11);
        fldrData.add(R.drawable.i_12);
        fldrData.add(R.drawable.i_13);
        fldrData.add(R.drawable.i_14);
        fldrData.add(R.drawable.i_15);
        fldrData.add(R.drawable.i_16);
        fldrData.add(R.drawable.i_17);
        fldrData.add(R.drawable.i_18);
        fldrData.add(R.drawable.i_19);
        fldrData.add(R.drawable.i_20);
        fldrData.add(R.drawable.i_21);
        fldrData.add(R.drawable.i_22);
        fldrData.add(R.drawable.i_23);
        fldrData.add(R.drawable.i_24);
        fldrData.add(R.drawable.i_25);
        fldrData.add(R.drawable.i_26);
        fldrData.add(R.drawable.i_27);
        fldrData.add(R.drawable.i_28);
        fldrData.add(R.drawable.i_29);
        fldrData.add(R.drawable.i_30);
        fldrData.add(R.drawable.i_31);
        fldrData.add(R.drawable.i_32);
        fldrData.add(R.drawable.i_33);
        fldrData.add(R.drawable.i_34);
        fldrData.add(R.drawable.i_35);
        fldrData.add(R.drawable.i_36);
        fldrData.add(R.drawable.i_37);
        fldrData.add(R.drawable.i_38);
        fldrData.add(R.drawable.i_39);
        fldrData.add(R.drawable.i_40);
        fldrData.add(R.drawable.i_41);
        fldrData.add(R.drawable.i_42);
        fldrData.add(R.drawable.i_43);
        fldrData.add(R.drawable.i_44);
        fldrData.add(R.drawable.i_45);
        fldrData.add(R.drawable.i_46);
        fldrData.add(R.drawable.i_47);
        fldrData.add(R.drawable.i_48);
        fldrData.add(R.drawable.i_49);
        fldrData.add(R.drawable.i_50);
        fldrData.add(R.drawable.i_51);
        fldrData.add(R.drawable.i_52);
        fldrData.add(R.drawable.i_53);
        fldrData.add(R.drawable.i_54);
        fldrData.add(R.drawable.i_55);
        fldrData.add(R.drawable.i_56);
        fldrData.add(R.drawable.i_57);
        fldrData.add(R.drawable.i_58);
        fldrData.add(R.drawable.i_59);
        fldrData.add(R.drawable.i_60);
        fldrData.add(R.drawable.i_61);
        fldrData.add(R.drawable.i_62);
        fldrData.add(R.drawable.i_63);
        fldrData.add(R.drawable.i_64);
        fldrData.add(R.drawable.i_65);
        fldrData.add(R.drawable.i_66);
        fldrData.add(R.drawable.i_67);
        fldrData.add(R.drawable.i_68);
        fldrData.add(R.drawable.i_69);
        fldrData.add(R.drawable.i_70);
        fldrData.add(R.drawable.i_71);
        fldrData.add(R.drawable.i_72);
        fldrData.add(R.drawable.i_73);
        fldrData.add(R.drawable.i_74);
        fldrData.add(R.drawable.i_75);
        fldrData.add(R.drawable.i_76);
        fldrData.add(R.drawable.i_77);
        fldrData.add(R.drawable.i_78);
        fldrData.add(R.drawable.i_79);
        fldrData.add(R.drawable.i_80);


        return  fldrData;
    }

}