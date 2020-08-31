package com.developer.islamicapp.DB;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.developer.islamicapp.Activities.Read_quran_Activity;
import com.developer.islamicapp.Model.data_model_arabicandurdu;

import java.util.ArrayList;


public class AsyncTaskRunner extends  AsyncTask<Object, Void, Void>{
Context context;
String dbname;
ProgressDialog progressDialog;
String ParahorSurah_check;
ArrayList<data_model_arabicandurdu> data=new ArrayList<>();

    public AsyncTaskRunner(Context context) {
        this.context = context;

        progressDialog = new ProgressDialog(context);
    }

    @Override
protected Void doInBackground(Object... objects) {
        // TODO Auto-generated method stub


    data = (ArrayList<data_model_arabicandurdu>) objects[0];

    dbname= (String) objects[1];
    ParahorSurah_check =(String) objects[2];
        Log.v("hassan","Parameters: "+":"+dbname+":"+ParahorSurah_check);
        new DB(context, dbname,ParahorSurah_check).adddata(data);


        return null;
        }


    @Override
    protected void onPostExecute(Void aVoid) {
        Toast.makeText(context, "updated"+dbname, Toast.LENGTH_SHORT).show();

           if (progressDialog.isShowing()){ progressDialog.dismiss();}

      context.startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB",ParahorSurah_check).putExtra("Datafetch", dbname).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

        super.onPostExecute(aVoid);
    }

    @Override
protected void onPreExecute() {

        progressDialog.setMessage("writing DB");
        progressDialog.show();
        }



}
