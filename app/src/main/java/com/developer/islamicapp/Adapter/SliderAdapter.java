package com.developer.islamicapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.developer.islamicapp.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapter extends
        SliderViewAdapter<SliderAdapter.SliderAdapterVH> {

    private List<Integer> fldrItems = new ArrayList<>();

    public SliderAdapter(Context context, List<Integer> fldrItems)
    {
        this.fldrItems = fldrItems;
    }




    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(final SliderAdapterVH viewHolder, int position)
    {


        viewHolder.slider_item_img.setImageResource(fldrItems.get(position));
    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return fldrItems.size();
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