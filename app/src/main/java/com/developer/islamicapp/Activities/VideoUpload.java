package com.developer.islamicapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.developer.islamicapp.R;
import com.developer.islamicapp.utils.Typcastregular;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class VideoUpload extends AppCompatActivity {

    StorageReference mStorageRef;
    FirebaseStorage firebaseStorage;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Typcastregular.Typcastregular(getApplicationContext(), "SERIF", "Poppins-Regular.otf");
        setContentView(R.layout.activity_video_upload);

firebaseStorage=FirebaseStorage.getInstance();
mStorageRef=firebaseStorage.getReference().child("video");




mStorageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
    @Override
    public void onSuccess(Uri uri) {

//        Toast.makeText(VideoUpload.this, ""+uri.toString(), Toast.LENGTH_SHORT).show();



    }
});



    }





    public void set_data()
    {
        databaseReference= FirebaseDatabase.getInstance().getReference().child("");


    }


}