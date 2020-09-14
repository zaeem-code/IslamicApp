package com.developer.islamicapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.developer.islamicapp.R;
import com.developer.islamicapp.utils.Typcastregular;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText name, phone, cntry;
    private String Snme, Sphn, Scountry;
    private CheckBox checkBox;
    private Button signup_button;

    Bundle bundle;
String chk="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Typcastregular.Typcastregular(getApplicationContext(), "SERIF", "Poppins-Regular.otf");
        setContentView(R.layout.activity_signup);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        cntry = findViewById(R.id.city);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        checkBox = findViewById(R.id.checkBox);
chk=getIntent().getStringExtra("chk");

        bundle=new Bundle();


        signup_button = findViewById(R.id.signup_button);
        signup_button.setOnClickListener(this);
        findViewById(R.id.back).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.back:
                if (TextUtils.isEmpty(chk)){
                finish();}else {
                    startActivity(new Intent(getApplicationContext(),MainActivity.class).putExtra("chk","main")
                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                            .addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY));
                }
                break;
            case R.id.signup_button:

                if (checkBox.isChecked())
                {

                    Snme=name.getText().toString().trim();
                    Sphn=phone.getText().toString().trim();
                    Scountry = cntry.getText().toString().trim();

                    if(TextUtils.isEmpty(Snme))
                    {
                        name.setError("Name is Required");
                        name.setFocusable(true);
                        Snme="";
                    }
                    else if(TextUtils.isEmpty(Sphn)||Sphn.length()<11||Sphn.length()>13)
                        {

                        phone.setError("Phone is invalid");
                        phone.setFocusable(true);
                        Sphn="";
                    }

                    else if(TextUtils.isEmpty(Scountry))
                    {
                        cntry.setError("Country is Required");
                        cntry.setFocusable(true);
                        Scountry ="";
                    }
                    else
                        {

                            //do all athe processing here
                            SharedPreferences.Editor editor = getSharedPreferences("login", MODE_PRIVATE).edit();
                            editor.putString("name", Snme);
                            editor.putString("phone", Sphn);
                            editor.putString("country", Scountry);
                            editor.apply();

                            add_user_record(Snme,Sphn, Scountry);
                            startActivity(new Intent(this, MainActivity.class));



                        }



//

                }

                else {
                    Toast.makeText(this, "You need to agree with our terms\n please check the box", Toast.LENGTH_LONG).show();
                }

                break;
        }
    }




    public void add_user_record(String name,String num,String country)
    {
        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference()
                .child("user_record");



        HashMap hashMap=new HashMap();
        hashMap.put("name",name);
        hashMap.put("phone",num);
        hashMap.put("country",country);


        databaseReference.push().updateChildren(hashMap).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {

        startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });




    }


}