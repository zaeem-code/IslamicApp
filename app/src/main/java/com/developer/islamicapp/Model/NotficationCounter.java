package com.developer.islamicapp.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.developer.islamicapp.Activities.MainActivity;
import com.developer.islamicapp.R;

public class NotficationCounter
{

TextView textView;

private final int Max_number=99;
private int notification_number=0;


public NotficationCounter(View view)
{
    textView=view.findViewById(R.id.counter);

}

public void increase_number()
{
notification_number++;
if (notification_number>Max_number)
{


}
else
{

    textView.setText(String.valueOf(notification_number));

}


}


}
