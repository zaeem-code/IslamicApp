package com.developer.islamicapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.developer.islamicapp.Model.Constants;
import com.developer.islamicapp.Model.StoryModel;
import com.developer.islamicapp.R;
import com.developer.islamicapp.utils.Typcastregular;
import com.google.firebase.database.DatabaseReference;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class Video_view extends AppCompatActivity {

    File[] files;
    StoryModel f;
    File video;

    DatabaseReference databaseReference;

    MediaController mediaController;
    String getPath;
    VideoView videoView;
    Intent intent;
    String vid_pos;
    String get_uri;
    LinearLayout linearLayout;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Typcastregular.Typcastregular(getApplicationContext(), "SERIF", "Poppins-Regular.otf");
        setContentView(R.layout.activity_video_view);

        videoView=findViewById(R.id.img);
//        linearLayout=findViewById(R.id.design);
//        button=findViewById(R.id.ok);

        intent=getIntent();
        f=new StoryModel();

        vid_pos=intent.getStringExtra("vid_pos");



//        getData();



        get_internal_data();

        mediaController=new MediaController(this);
        videoView.setVideoURI(f.getUri());
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        setDimension();
        videoView.start();





    }





    private void getData()
    {
//        StoryModel f;

        String targetPath = Environment.getExternalStorageDirectory().getAbsolutePath() + Constants.FOLDER_NAME;
        File targetDirector = new File(targetPath);
        files = targetDirector.listFiles();



        if (files == null)
        {
//

        }
        try {
            Arrays.sort(files, new Comparator()
            {
                public int compare(Object o1, Object o2) {

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

            for (int i = 0; i < files.length; i++)
            {



                if(files[i].getName().contains(vid_pos))
                {

                    File file = files[i];
//                    f = new StoryModel();
                    f.setName("Status: "+(i));
                    f.setUri(Uri.fromFile(file));
                    f.setPath(files[i].getAbsolutePath());
                    f.setFilename(file.getName());


//                    Toast.makeText(this, ""+Uri.fromFile(file), Toast.LENGTH_SHORT).show();




                }
                else
                {


//                    Toast.makeText(this, "hahahah", Toast.LENGTH_SHORT).show();


                }





            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    private void get_internal_data()
    {

        video = new File( Environment.getExternalStorageDirectory()
                .getAbsolutePath() + "/Alarms/"+vid_pos);

        if(video.exists())
        {

            Uri uri = FileProvider.getUriForFile(this, "com.developer.islamicapp.provider",
                    video);

            f.setUri(uri);


        }



    }



    private void setDimension() {
        // Adjust the size of the video
        // so it fits on the screen
        float videoProportion = getVideoProportion();
        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        int screenHeight = getResources().getDisplayMetrics().heightPixels;
        float screenProportion = (float) screenHeight / (float) screenWidth;
        android.view.ViewGroup.LayoutParams lp = videoView.getLayoutParams();

        if (videoProportion < screenProportion)
        {
            lp.height= screenHeight;
            lp.width = (int) ((float) screenHeight / videoProportion);
        }
        else {
            lp.width = screenWidth;
            lp.height = (int) ((float) screenWidth * videoProportion);
        }
        videoView.setLayoutParams(lp);
    }

    private float getVideoProportion()
    {
        return 3f;
    }




}