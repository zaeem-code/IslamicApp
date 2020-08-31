package com.developer.islamicapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.developer.islamicapp.Activities.MainActivity;
import com.developer.islamicapp.Model.NotficationCounter;
import com.developer.islamicapp.Model.Notif_data;
import com.developer.islamicapp.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class Notification_adapter extends RecyclerView.Adapter<Notification_adapter.Progholder>
{


    Context context;
    ArrayList<Notif_data> arrayList;
    LayoutInflater inflater;
    NotficationCounter notficationCounter;
    SharedPreferences prefs;
    String get_number;
    int pos;
    public Notification_adapter(Context context, ArrayList<Notif_data> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Progholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view= LayoutInflater.from(context).inflate(R.layout.noti_design,parent,false);



        return new Progholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Progholder holder, int position) {

        Notif_data notif_data=arrayList.get(position);


        holder.body.setText(notif_data.getMessage());
        holder.title.setText(notif_data.getTitle());
        holder.time.setText(notif_data.getTime());
        holder.date.setText(notif_data.getDate());



        prefs = context.getSharedPreferences("login", MODE_PRIVATE);
        get_number= prefs.getString("phone", "");

        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference()
                        .child("notification").child(get_number);
                DatabaseReference databaseReference1= FirebaseDatabase.getInstance().getReference()
                        .child("notification").child(get_number);
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                        {

                            String count=String.valueOf(dataSnapshot1.child("count").getValue());

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });






            }
        });



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Progholder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        TextView title,body,time,date;
        ImageView imageView;
        Button remove;


        public Progholder(@NonNull View itemView) {
            super(itemView);



       time=itemView.findViewById(R.id.time);
       title=itemView.findViewById(R.id.title);
       body=itemView.findViewById(R.id.body);
       date=itemView.findViewById(R.id.date);
       imageView=itemView.findViewById(R.id.img_des);
       remove=itemView.findViewById(R.id.remove);
       itemView.setOnClickListener(this);







        }

        @Override
        public void onClick(View v)
        {

            context.startActivity(new Intent(context,MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));



        }
    }
}
