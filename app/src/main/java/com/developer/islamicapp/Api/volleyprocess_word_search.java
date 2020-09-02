package com.developer.islamicapp.Api;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.developer.islamicapp.Activities.SearchActivity;
import com.developer.islamicapp.Model.Quran_words_search;
import com.developer.islamicapp.callbacks.Search_Result;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class volleyprocess_word_search {
    Context context;
    ProgressDialog progressDialog;
    String word;
    int attempt = 0;
    Search_Result search_result;
ArrayList<Quran_words_search> data=new ArrayList<>();
    public volleyprocess_word_search(Context context, SearchActivity cnt, String Word) {
         this.context = context;
         this.word=Word;
         search_result=cnt;

        progressDialog = new ProgressDialog(cnt);
        progressDialog.setMessage("Searching Word");
        progressDialog.show();
        fetch_ressult_of_txt();

    }



    String URL;

    public void fetch_ressult_of_txt()
    {

      URL = "https://api.alquran.cloud/v1/search/"+word+"/all/ar";







        final RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
             //   Toast.makeText(context, ""+response, Toast.LENGTH_SHORT).show();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("matches");

for (int i=0; i<jsonArray.length(); i++){

    JSONObject finl_response = jsonArray.getJSONObject(i);

    data.add(new Quran_words_search(finl_response.getString("text"),finl_response.getString("numberInSurah"),
            finl_response.getJSONObject("surah").getString("number"), finl_response.getJSONObject("surah").getString("name")
    ));
  //  Quran_words_search item =data.get(i);
    Log.v("hassan",finl_response+"" );
}

if (data!=null){
 //   Toast.makeText(context, "fill", Toast.LENGTH_SHORT).show();

    search_result.data(data,jsonObject.getJSONObject("data").getString("count"));
}else {
    data.add(new Quran_words_search("No such world found","No such world found",
           "No such world found", "No such world found"
    ));

    search_result.data(data,jsonObject.getJSONObject("data").getString("count"));
}

                }catch (Exception e){

                    data.add(new Quran_words_search("Sorry \n Server is currently down","Please try again latter",
                            "NA", "NA"

                    ));

                    search_result.data(data,"0");
                    Log.v("hassan",e.toString());
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();

                Log.v("hassan",error.toString());
                Toast.makeText(context, "internet error\n trying again", Toast.LENGTH_SHORT).show();
                if (attempt <= 5) {
                    attempt++;
                    progressDialog.setMessage("Retrying " + attempt + "/5");
                    progressDialog.show();

                    fetch_ressult_of_txt();
                } else {
                    Toast.makeText(context, "Failed to load\n try again latter", Toast.LENGTH_SHORT).show();
                }
            }
        });
        requestQueue.add(request);

    }
    private void RCSHOW(){

    }

}