package com.developer.islamicapp.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;

public class Typcast {
    public Typeface Typcast(Context context, String chk)
    {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            switch (chk)
            {

                case "A":
                    return Typeface.createFromAsset(context.getAssets(), "Jameel_Noori_Nastaleeq_Kasheeda.ttf");


                case "B":
                    return Typeface.createFromAsset(context.getAssets(), "Poppins-Bold.otf");

                case "BB":
                    return Typeface.createFromAsset(context.getAssets(), "Poppins-ExtraBold.otf");
                default:
                    return Typeface.createFromAsset(context.getAssets(), "Poppins-Regular.otf");

            }

        }else {
            return null;
        }

    }
}





