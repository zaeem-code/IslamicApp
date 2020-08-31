package com.developer.islamicapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

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

public class Beautiful_Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    VideoAdapter videoAdapter;


    DatabaseReference databaseReference;
    ArrayList<Fire_model> filesList = new ArrayList<>();
  ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Typcastregular.Typcastregular(getApplicationContext(), "SERIF", "Poppins-Regular.otf");
        setContentView(R.layout.activity_beautiful_);
         recyclerView=findViewById(R.id.recycle);

         back=findViewById(R.id.back);
         back.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 finish();
             }
         });



//         store_date_firebase();

         fetch_url_firebase();



    }










    public void fetch_url_firebase()
    {

        databaseReference= FirebaseDatabase.getInstance().getReference().child("data_url");
        databaseReference.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {

                    String url=dataSnapshot1.child("url").getValue().toString();
                    String download_status=dataSnapshot1.child("download_status").getValue().toString();
                    String pos=dataSnapshot1.child("pos").getValue().toString();
                    String key=dataSnapshot1.child("key").getValue().toString();




                   filesList.add(new Fire_model(url,download_status,pos,key));




                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                {
                    if (NetworkState.isOnline(getApplicationContext()))
                    {
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

        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);


            videoAdapter = new VideoAdapter(this, filesList);
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

        videoAdapter = new VideoAdapter(this, filesList);
        recyclerView.setAdapter(videoAdapter);
        videoAdapter.notifyDataSetChanged();


    }




}