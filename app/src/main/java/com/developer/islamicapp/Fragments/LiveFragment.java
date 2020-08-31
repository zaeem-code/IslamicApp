package com.developer.islamicapp.Fragments;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developer.islamicapp.Activities.Youtube_video;
import com.developer.islamicapp.R;
import com.developer.islamicapp.utils.Typcastregular;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.net.URL;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LiveFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LiveFragment extends Fragment implements View.OnClickListener {
String URLX;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LiveFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LiveFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LiveFragment newInstance(String param1, String param2) {
        LiveFragment fragment = new LiveFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
View v;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Typcastregular.Typcastregular(getContext(), "SERIF", "Poppins-Regular.otf");

        v= inflater.inflate(R.layout.fragment_live, container, false);
        v.findViewById(R.id.FB).setOnClickListener(this);
        v.findViewById(R.id.YT).setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.FB:
//
                String id="211680932500811";
                try {
//
                    Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("fb://page/"+id));
                    startActivity(intent);


                } catch (Exception e)
                {

                    Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/"+id));
                    startActivity(intent);

                }
                break;

            case R.id.YT:
                Intent intent=null;
                try {
                    intent =new Intent(Intent.ACTION_VIEW);
                    intent.setPackage("com.google.android.youtube");
                    if (!TextUtils.isEmpty(URLX)){
                        intent.setData(Uri.parse( URLX));

                    }else {

                        intent.setData(Uri.parse("https://www.youtube.com/channel/UCmV5CFC6bbZmMhqTUqZdlrg?view_as=subscriber"));
                    }
                     startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    intent = new Intent(Intent.ACTION_VIEW);
                    if (!TextUtils.isEmpty(URLX)){
                        intent.setData(Uri.parse( URLX));

                    }else {

                        intent.setData(Uri.parse("https://www.youtube.com/channel/UCmV5CFC6bbZmMhqTUqZdlrg?view_as=subscriber"));
                    }  startActivity(intent);
                }

//           startActivity(new Intent(getContext(), Youtube_video.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                break;


        }
    }
    private void getYoutube(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Admin_DATA");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.child("Youtube").getValue().toString().trim();

URLX=value;










             }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

    }
}