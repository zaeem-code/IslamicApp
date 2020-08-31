package com.developer.islamicapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.developer.islamicapp.Model.data_model_arabicandurdu;

import java.util.ArrayList;


public class DB extends SQLiteOpenHelper {
 String tablex, ParahorSurah_check;
 String number_of_aya_or_para;
 Context context;

    public DB(Context context, String tablename,String ParahorSurah_check) {
        super(context, "MyDatabase", null,1);
        this.ParahorSurah_check =ParahorSurah_check;
        this.context=context;

        number_of_aya_or_para =tablename;
        tablex =ParahorSurah_check+tablename;
    }


    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ tablex +"(Id INTEGER PRIMARY KEY AUTOINCREMENT,Arabic TEXT,item TEXT,Urdu TEXt)");

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS "+ tablex);

        // Create tables again
        onCreate(db);
    }

    // code to add the new contact
    void adddata(ArrayList<data_model_arabicandurdu> data) {
Log.v("mydbgx",""+tablex);
        data_model_arabicandurdu item;

        ContentValues values = new ContentValues();
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+tablex);
try {
onCreate(db);
    db.execSQL("delete from "+ tablex);
    db.execSQL("vacuum");


}catch (Exception e){

}


        for (int i=0; i<data.size(); i++){
            item=data.get(i);
            values.put("Arabic", item.Arabic);
            values.put("item", item.itemnumber);
            values.put("Urdu", item.Urdu);


            // Inserting Row
            if ( db.insert(tablex, null, values)!=-1){

                Log.v("mydbgx", "while writen______>>successs");
            }


        }
        Log.v("hassan", "---> saved item in db as hassan: "+ tablex +"  --"+ ParahorSurah_check +"---> "+ number_of_aya_or_para);

        context.getSharedPreferences("DB",Context.MODE_PRIVATE).edit().putString(tablex, number_of_aya_or_para).apply();

        db.close();
    }


    public ArrayList<data_model_arabicandurdu> getAll() {
        ArrayList<data_model_arabicandurdu> data = new ArrayList<>();
        data.clear();
        SQLiteDatabase database=getReadableDatabase();



        Cursor cursor=database.rawQuery("SELECT *FROM "+tablex.trim(),null);

        Log.v("mydbgx", "while reading item coiunt>>: "+cursor.getCount());
        while (cursor.moveToNext())
        {
            String text_arab=cursor.getString(1);
            String number=cursor.getString(2);
            String text_urdu=cursor.getString(3);

            data.add(new data_model_arabicandurdu(text_arab,number,text_urdu));

        }
        return  data;



    }

    public void dellDB(){

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM "+ tablex);
        db.close();


    }



}