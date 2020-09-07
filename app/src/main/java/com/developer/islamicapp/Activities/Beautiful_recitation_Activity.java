package com.developer.islamicapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.developer.islamicapp.Adapter.VideoAdapter;
import com.developer.islamicapp.Model.Fire_model;
import com.developer.islamicapp.Network.NetworkState;
import com.developer.islamicapp.R;
import com.developer.islamicapp.utils.Typcastregular;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Beautiful_recitation_Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    VideoAdapter videoAdapter;
ArrayList<String>uri=new ArrayList<>();

    DatabaseReference databaseReference_rec,databaseReference_urdu;
    ArrayList<Fire_model> filesList = new ArrayList<>();
  ImageView back;

    String chk="rec";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Typcastregular.Typcastregular(getApplicationContext(), "SERIF", "Poppins-Regular.otf");
        setContentView(R.layout.activity_beautiful_);

        try {
            chk=getIntent().getStringExtra("process");
        }catch (Exception e){ }

        recyclerView=findViewById(R.id.recycle);

         back=findViewById(R.id.back);
         back.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 finish();
             }
         });


if (chk.equals("rec")){
    fetch_Recitation_firebase();
}else {

    fetch_urdu_firebase();
}




    }










    public void fetch_urdu_firebase()
    {
try {


        databaseReference_urdu= FirebaseDatabase.getInstance().getReference().child("urdu_data");
        databaseReference_urdu.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot2:dataSnapshot.getChildren())
                {

                    String url=dataSnapshot2.child("url").getValue().toString();
                    Log.v("hassan",url);


if (!TextUtils.isEmpty(url)){

                   uri.add(url);}




                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                {
                    if (NetworkState.isOnline(getApplicationContext()))
                    {
                        Log.v("hassan","url total size : "+uri.size());
                    SetUpRecyclerView();

                    }
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

//                Toast.makeText(getApplicationContext(), "Sorry!\n Currently no urdu Translation available", Toast.LENGTH_SHORT).show();
                Log.v("hassan",chk+": error : "+databaseError);
            }
        });





        if (uri==null){
            Toast.makeText(getApplicationContext(), "Sorry!\n Currently no urdu Translation available", Toast.LENGTH_SHORT).show();

        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            if (NetworkState.isOnline(getApplicationContext()))
            {
//                SetUpRecyclerView();

            }
            else
            {
                SetUpRecyclerView_Offline();
            }
        }
}catch (Exception e){
//    Toast.makeText(this, "Sorry!\n Currently no urdu Translation available", Toast.LENGTH_SHORT).show();
    Log.v("hassan",chk+": exp : "+e);

}

    }
    public void fetch_Recitation_firebase()
    {

        databaseReference_rec= FirebaseDatabase.getInstance().getReference().child("video_data");
        databaseReference_rec.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {

                    String url=dataSnapshot1.child("url").getValue().toString();
                    Log.v("hassan",url);


                    if (!TextUtils.isEmpty(url)){

                        uri.add(url);}




                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                {
                    if (NetworkState.isOnline(getApplicationContext()))
                    {
                        Log.v("hassan","url total size : "+uri.size());
                        SetUpRecyclerView();

                    }
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            if (NetworkState.isOnline(getApplicationContext()))
            {
//                SetUpRecyclerView();

            }
            else
            {
                SetUpRecyclerView_Offline();
            }
        }

    }



    public void SetUpRecyclerView()
    {

          recyclerView.setLayoutManager(new LinearLayoutManager(this));


            videoAdapter = new VideoAdapter(this, uri);
            recyclerView.setAdapter(videoAdapter);
            videoAdapter.notifyDataSetChanged();


    }

    public void SetUpRecyclerView_Offline()
    {
        filesList.clear();
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);

        filesList.add(new Fire_model("","","",""));
///iska backup bana ha file ka
//        videoAdapter = new VideoAdapter(this, filesList);
        recyclerView.setAdapter(videoAdapter);
        videoAdapter.notifyDataSetChanged();


    }




}