package com.developer.islamicapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.developer.islamicapp.Activities.Beautiful_recitation_Activity;
import com.developer.islamicapp.Activities.Youtube_video;
import com.developer.islamicapp.Model.Config;
import com.developer.islamicapp.R;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ProgHolder>
{

    long enqueID;

    Context context;
    String vid;

    ArrayList<String> filesList;
    String chk_status;


    public VideoAdapter(Beautiful_recitation_Activity beautiful_recitation_activity, ArrayList<String> uri) {

        this.context = beautiful_recitation_activity;
        this.filesList = uri;
    }


    @NonNull
    @Override
    public ProgHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(context).inflate(R.layout.youtubethumnail,parent,false);

        return new ProgHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final ProgHolder holder, final int position)
    {
        final YouTubeThumbnailLoader.OnThumbnailLoadedListener  onThumbnailLoadedListener = new YouTubeThumbnailLoader.OnThumbnailLoadedListener(){
            @Override
            public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {

            }

            @Override
            public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {
                youTubeThumbnailView.setVisibility(View.VISIBLE);
                holder.relativeLayoutOverYouTubeThumbnailView.setVisibility(View.VISIBLE);
            }
        };

        holder.youTubeThumbnailView.initialize(Config.YOUTUBE_API_KEY, new YouTubeThumbnailView.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {

                youTubeThumbnailLoader.setVideo(filesList.get(position));
                youTubeThumbnailLoader.setOnThumbnailLoadedListener(onThumbnailLoadedListener);
            }

            @Override
            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {
                //In case of failure
            }
        });






    }

    @Override
    public int getItemCount()

    {
        return filesList.size();
    }

    public class ProgHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected RelativeLayout relativeLayoutOverYouTubeThumbnailView;
        YouTubeThumbnailView youTubeThumbnailView;
        protected ImageView playButton;

        public ProgHolder(View itemView) {
            super(itemView);
            playButton = itemView.findViewById(R.id.btnYoutube_player);
            playButton.setOnClickListener(this);
            relativeLayoutOverYouTubeThumbnailView = itemView.findViewById(R.id.relativeLayout_over_youtube_thumbnail);
            youTubeThumbnailView = itemView.findViewById(R.id.youtube_thumbnail);
        }

        @Override
        public void onClick(View view) {

           context. startActivity(new Intent(context, Youtube_video.class).putExtra("uri",filesList.get(getAdapterPosition())));
        }
    }









}
