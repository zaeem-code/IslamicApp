package com.developer.islamicapp.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.developer.islamicapp.Model.Quran_words_search;
import com.developer.islamicapp.R;
import com.developer.islamicapp.utils.Typcast;

import java.util.ArrayList;


public class AdapterWordSearch extends RecyclerView.Adapter<AdapterWordSearch.ViewHolder> {

    public Quran_words_search item;
    private LayoutInflater mInflater;
    ArrayList<Quran_words_search> data;
    Context context;
    View view;


    public AdapterWordSearch(Context context, ArrayList<Quran_words_search> data) {
        this.context = context;
        this.data = data;
        this.mInflater = LayoutInflater.from(context);

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view  = mInflater.inflate(R.layout.rec_item_parah_reading, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        item = data.get(position);
        holder.textView.setText(item.arabic);

        holder.textView_urdu.setText("\n"+item.name+"\n"+"ayat #"+item.surah+", "+"surah #"+item.ayat);

    }


    @Override
    public int getItemCount() {
        return data.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView, textView_urdu;
        ImageView sound;


        ViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textx);
               textView_urdu=itemView.findViewById(R.id.texty);
            sound = itemView.findViewById(R.id.sound);
//            textView_urdu.setTextColor(Color.parseColor("#006400"));
            textView.setTypeface(new Typcast().Typcast(itemView.getContext(), "BB"));
               textView_urdu.setTypeface(new Typcast().Typcast(context,"A"));

        }
        }




}