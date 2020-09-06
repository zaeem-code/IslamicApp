package com.developer.islamicapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.developer.islamicapp.Activities.Read_quran_Activity;
import com.developer.islamicapp.Model.data_model_arabicandurdu;
import com.developer.islamicapp.R;
import com.developer.islamicapp.utils.Typcast;

import java.util.ArrayList;


public class AdapterNamazact extends RecyclerView.Adapter<AdapterNamazact.ViewHolder> {

    private LayoutInflater mInflater;
    ArrayList<data_model_arabicandurdu> data;
    Context context;
    String chk;

    public AdapterNamazact(Context context, ArrayList<data_model_arabicandurdu> data) {
        this.context = context;
        this.data = data;
        this.mInflater = LayoutInflater.from(context);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.rec_item_extra_reading, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        holder.textView.setText(data.get(position).ENG);
        if (position!=0){
            holder.textView.setTextSize(15f);
        }


    }

    @Override
    public int getItemCount() {
        return data.size();
    }





    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        ViewHolder(View itemView) {
            super(itemView);
            textView =itemView.findViewById(R.id.textx);

            textView.setTypeface(new Typcast().Typcast(context,"BB"));
            textView.setTextColor(Color.parseColor("#FFD700"));
        }
    }




}