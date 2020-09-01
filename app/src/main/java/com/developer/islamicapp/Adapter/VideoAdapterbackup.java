package com.developer.islamicapp.Adapter;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.developer.islamicapp.Activities.Video_view;
import com.developer.islamicapp.Model.Constants;
import com.developer.islamicapp.Model.Fire_model;
import com.developer.islamicapp.Model.StoryModel;
import com.developer.islamicapp.Network.NetworkState;
import com.developer.islamicapp.R;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class VideoAdapterbackup extends RecyclerView.Adapter<VideoAdapterbackup.ProgHolder>
{

    long enqueID;
    DownloadManager downloadManager;
    String pos_get;
    ArrayList<Object> get_array = new ArrayList<>();

    Context context;
    String vid;
    File video;

    ArrayList<Fire_model> filesList;
    String chk_status,chk_place,chk_pre_pos;
    File[] files;
    StoryModel f;

    public VideoAdapterbackup(Context context, ArrayList<Fire_model> filesList)
    {
        this.context = context;
        this.filesList = filesList;

    }



    @NonNull
    @Override
    public ProgHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(context).inflate(R.layout.desin_bautiful,parent,false);




        return new ProgHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final ProgHolder holder, final int position)
    {


//        final StoryModel files = (StoryModel) filesList.get(position);

         final Fire_model fire_model =filesList.get(position);



        Glide.with(context)
                .load(fire_model.getUrl())
                .into(holder.videoView);


















        holder.videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                vid="videoUrl_"+ position +".mp4";

                video = new File( Environment.getExternalStorageDirectory()
                        .getAbsolutePath() + "/Alarms/"+vid);


                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                {
                    if (NetworkState.isOnline(context)) {


                        chk_pre_pos = String.valueOf(position);


                        if (fire_model.getPos().equals(String.valueOf(position)))
                        {

//                            Toast.makeText(context, ""+vid, Toast.LENGTH_SHORT).show();






                            if(video.exists())
                            {

                                Uri uri = FileProvider.getUriForFile(context, "com.developer.islamicapp.provider",video);
                                Toast.makeText(context, ""+uri, Toast.LENGTH_LONG).show();


                                context.startActivity(new Intent(context, Video_view.class)
                                        .putExtra("vid_pos",vid)


                                );


                            }else {
//                                Toast.makeText(context, "File don't exist", Toast.LENGTH_SHORT).show();
                                    Toast.makeText(context, "download", Toast.LENGTH_SHORT).show();
                                    download_file(fire_model.getUrl(), fire_model.getKey() + ".mp4");
//

                            }





//
//                            if (chk_status.equals("exist"))
//                            {
//
//                                context.startActivity(new Intent(context, Video_view.class)
//                                        .putExtra("vid_pos",vid)
//                                );
//
//                            }
//                            else
//                            {
//
//
//                                    Toast.makeText(context, "download", Toast.LENGTH_SHORT).show();
//                                    download_file(fire_model.getUrl(), fire_model.getKey() + ".mp4");
//
//
//                            }




                    }



                    }
                    else
                    {


                          getData(vid);



//                        Toast.makeText(context, ""+f.getFilename(), Toast.LENGTH_SHORT).show();

                        if(video.exists())
                        {

                            Uri uri = FileProvider.getUriForFile(context, "com.developer.islamicapp.provider",video);
                            Toast.makeText(context, ""+uri, Toast.LENGTH_LONG).show();


                            context.startActivity(new Intent(context, Video_view.class)
                                    .putExtra("vid_pos",vid)


                            );


                        }
                        else
                        {
                            Toast.makeText(context, "connect your internet to download", Toast.LENGTH_SHORT).show();
                        }






                    }
                }














            }
        });








        BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
            @Override
            public void onReceive(final Context context, Intent intent) {


                String action=intent.getAction();
                if (DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(action))
                {

                    DownloadManager.Query req_query = new DownloadManager.Query();
                    req_query.setFilterById(enqueID);
                    Cursor cursor = downloadManager.query(req_query);


                    if (cursor.moveToFirst() )
                    {
                        int columIndex =cursor.getColumnIndex(DownloadManager.COLUMN_STATUS);

                        if (DownloadManager.STATUS_SUCCESSFUL==cursor.getInt(columIndex))
                        {



//                            f.setFilename("exist");

                            ////////////////////////
                        }

                    }
                }
            }
        };


        context.registerReceiver(broadcastReceiver,new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
//////////////////////////////







    }

    @Override
    public int getItemCount()

    {
        return filesList.size();
    }

    public class ProgHolder extends RecyclerView.ViewHolder
    {

        ImageView videoView;
        ImageView button;
        RelativeLayout frameeLayout;
        ImageView play;
        public ProgHolder(@NonNull View itemView)
        {
            super(itemView);

            videoView=itemView.findViewById(R.id.video_custom);
//            button=itemView.findViewById(R.id.video_download);
            frameeLayout =itemView.findViewById(R.id.layout_custom_video);
//            play=itemView.findViewById(R.id.play_custom_video);

        }







    }


    public void Video_start(String position)
    {



    }


    public void download_file(String url, String file_name)
    {
        DownloadManager.Request download = new DownloadManager.Request(Uri.parse(url));
        String fileName = URLUtil.guessFileName(url, null, MimeTypeMap.getFileExtensionFromUrl(url));
        download.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
        download.setTitle(fileName);
        download.setDescription("Downloading file");
        download.allowScanningByMediaScanner();
        download.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        download.setDestinationInExternalPublicDir(Environment.DIRECTORY_ALARMS, file_name);
        downloadManager = (DownloadManager)context.getSystemService(Context.DOWNLOAD_SERVICE);
        enqueID =downloadManager.enqueue(download);

    }








    public void getData(String name)
    {
//        StoryModel f;

        String targetPath = Environment.getExternalStorageDirectory().getAbsolutePath() + Constants.FOLDER_NAME;
        File targetDirector = new File(targetPath);
        files = targetDirector.listFiles();





        if (files == null)
        {
//
            Toast.makeText(context, "null ha", Toast.LENGTH_SHORT).show();
        }
        try {

            Arrays.sort(files, new Comparator()
            {
                public int compare(Object o1, Object o2)
                {

                    if (((File) o1).lastModified() > ((File) o2).lastModified())
                    {
                        return -1;
                    }
                    else if (((File) o1).lastModified() < ((File) o2).lastModified()) {
                        return +1;
                    }
                    else
                    {
                        return 0;
                    }
                }

            });


            for (int i=0; i < files.length; i++)
            {

                if(files[i].getName().contains(vid))
                {


                    File file = files[i];

                    StoryModel f = new StoryModel();
                    f.setName(String.valueOf(i));
                    f.setUri(Uri.fromFile(file));
                    f.setPath(files[i].getAbsolutePath());
                    f.setFilename("exist");
                    chk_status="exist";

//                    Toast.makeText(context, ""+files[i].getName(), Toast.LENGTH_SHORT).show();



                }
                else
                {

//                    f.setFilename("not exist");
                    chk_status="not exist";

                    Toast.makeText(context, "not exist", Toast.LENGTH_SHORT).show();


                }


            }














        } catch (Exception e)
        {
            e.printStackTrace();
        }










    }







}
