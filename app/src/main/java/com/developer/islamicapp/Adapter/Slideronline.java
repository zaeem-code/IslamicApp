package com.developer.islamicapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.developer.islamicapp.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class Slideronline extends SliderViewAdapter<Slideronline.SliderAdapterVH> {

    private ArrayList<String> online_url;
    public Slideronline(ArrayList<String> image_uri_array) {

        this.online_url = image_uri_array;
    }




    @Override
    public Slideronline.SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item, null);
        return new Slideronline.SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {
        Glide.with(viewHolder.itemView)
                .load(online_url.get(position))
                .fitCenter()
                .into(viewHolder.slider_item_img);
    }



    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return online_url.size();
    }

    static class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView slider_item_img;

        public SliderAdapterVH(View itemView) {
            super(itemView);


            slider_item_img = itemView.findViewById(R.id.slider_img);
            this.itemView = itemView;
        }




    }










}