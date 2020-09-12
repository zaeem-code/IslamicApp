package com.developer.islamicapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.developer.islamicapp.Adapter.Notification_adapter;
import com.developer.islamicapp.Model.Notif_data;
import com.developer.islamicapp.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class Notificaton_Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    Notification_adapter adapter;
    ImageView back;
    ArrayList<Notif_data> arrayList=new ArrayList<>();
    ProgressDialog progressDialog;
    SharedPreferences prefs1;
    String get_name,get_pass,get_number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaton_);




        back=findViewById(R.id.back);
        recyclerView=findViewById(R.id.zaeembutt);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);


        prefs1 = getSharedPreferences("login", MODE_PRIVATE);
        get_name = prefs1.getString("name", "");//"No name defined" is the default value.
        get_pass = prefs1.getString("country", "");//"No name defined" is the default value.
        get_number= prefs1.getString("phone", "");//"No name defined" is the default value.




        progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Loading");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        get_notifi_data();



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });





        update_noti();


    }



    public void get_notifi_data()
    {


        if (!get_name.equals(""))
        {
            DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();

            databaseReference .child("notification").child(get_number).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    if (dataSnapshot.hasChildren())
                    {
                        for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                        {

                            progressDialog.dismiss();
                            Notif_data notif_data=dataSnapshot1.getValue(Notif_data.class);
                            arrayList.add(notif_data);

                        }


                        adapter=new Notification_adapter(getApplicationContext(),arrayList);
                        adapter.notifyDataSetChanged();

                        recyclerView.setAdapter(adapter);

                    }
                    else
                    {
                        progressDialog.dismiss();
//                        Toast.makeText(Notificaton_Activity.this, "empty notification", Toast.LENGTH_LONG).show();
                    }


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                    progressDialog.dismiss();
                    Toast.makeText(Notificaton_Activity.this, "internet error", Toast.LENGTH_SHORT).show();

                }
            });
        }
        else
        {
            progressDialog.dismiss();
            Toast.makeText(this, "login first", Toast.LENGTH_SHORT).show();
        }






    }


    public void   update_noti()
    {
        DatabaseReference databaseReference=FirebaseDatabase.getInstance()
                .getReference().child("alert").child(get_number);

        HashMap hashMap=new HashMap();
        hashMap.put("notification","fail");
        databaseReference.updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
            @Override
            public void onSuccess(Object o) {

            }
        });




    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

    finish();
    }
}