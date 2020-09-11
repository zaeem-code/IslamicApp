package com.developer.islamicapp.Api;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.developer.islamicapp.DB.AsyncTaskRunner;
import com.developer.islamicapp.Model.data_model_arabicandurdu;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class volleyprocess_quran_fetcher {
    int stepsEnd, stepsStart;
    Context context;
    ProgressDialog progressDialog;
    String DB;
    int attempt = 0;
    ArrayList<Temp_data> arabicDATA, urduDATA;String ParahorNumber;
    String SurahNumber, chk_if_suparah_or_surah;


    public volleyprocess_quran_fetcher(int stepsEnd, int stepsStart, Context context, String DB,String ParahorNumber,String SurahNumber,String chk_if_suparah_or_surah) {
        this.stepsEnd = stepsEnd;
        this.context = context;
        this.stepsStart = stepsStart;
        this.SurahNumber=SurahNumber;
        this.chk_if_suparah_or_surah =chk_if_suparah_or_surah;
        this.DB = DB;
        this.ParahorNumber =ParahorNumber;
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("fetching Data");
        progressDialog.show();
        fetch_quran_txt(stepsStart, stepsEnd);


    }

    private class Temp_data {
        String text, item;

        public Temp_data(String text, String item) {
            this.text = text;
            this.item = item;
        }
    }

    int count = 0;
    String URL;

    public void fetch_quran_txt(final int stps, final int stpe)
    {


        if (chk_if_suparah_or_surah.equals("Parah"))
        {
            if (count == 0)
            {
                URL = "http://api.alquran.cloud/v1/juz/"+ ParahorNumber.trim()+"/quran-uthmani";

                arabicDATA = new ArrayList<>();
            } else {
                URL = "http://api.alquran.cloud/v1/juz/"+ ParahorNumber.trim()+"/ur.ahmedali";

                urduDATA = new ArrayList<>();
            }



        }
        else
        {

            if (count == 0)
            {
                URL = "http://api.alquran.cloud/v1/surah/"+ParahorNumber.trim()+"/quran-uthmani";

                arabicDATA = new ArrayList<>();
            } else {

                URL = "http://api.alquran.cloud/v1/surah/"+ParahorNumber.trim()+"/ur.ahmedali";

                urduDATA = new ArrayList<>();
            }

        }




        final RequestQueue requestQueue = Volley.newRequestQueue(context);
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject jsonObject = response.getJSONObject("data");
                            JSONArray jsonArray = jsonObject.getJSONArray("ayahs");
                            Log.v("mydbgx", "Chk ->>>:" + DB);

                            if (!DB.equals("Surah")){
//parah
                                Log.v("mydbgx", "Chk para n0 ->>>:" + ParahorNumber);

                                for (int i = 0; i < jsonArray.length(); i++)
                                {
//                                    Toast.makeText(context, "" + count, Toast.LENGTH_SHORT).show();
                                    JSONObject finl_response = jsonArray.getJSONObject(i);
                                    String text = finl_response.getString("text");
                                    String number = finl_response.getString("number");
                                    String page = finl_response.getString("page");
number=String.valueOf(Integer.parseInt(number)-1);
                                    if (count == 0)
                                    {
                                        if (number.equals("0")){

                                            arabicDATA.add(new Temp_data(text  , number));

                                            Log.v("hassanx","1:"+arabicDATA.get(i).text);
                                        }else
if (number.equals("7")) {
    text=text.replace("الٓمٓ"," ");
    arabicDATA.add(new Temp_data(text  , convertNumber(number)));
    Log.v("hassanx","7:"+arabicDATA.get(i).text);
    Log.v("mydbgx", text + "\n number:" + number + "\npage:" + page + "\ncount:" + count);
}else if (number.equals("8")) {


    text="الٓمٓ(٧)۞"+"\n\n\n"+"ذَٰلِكَ ٱلْكِتَٰبُ لَا رَيْبَ ۛ فِيهِ ۛ هُدًۭى لِّلْمُتَّقِينَُ"   ;
    arabicDATA.add(new Temp_data(text +"❲" + convertNumber(number) + "❳۞", number));
    Log.v("mydbgx", text + "\n number:" + number + "\npage:" + page + "\ncount:" + count);

    Log.v("hassanx","8:"+arabicDATA.get(i).text);
}else  if (number.equals("10")){

    text="وَالَّذِينَ يُؤْمِنُونَ بِمَا أُنزِلَ إِلَيْكَ وَمَا أُنزِلَ مِن قَبْلِكَ وَبِالْآخِرَةِ هُمْ يُوقِنُونَ";

    arabicDATA.add(new Temp_data(text + "❲" + convertNumber(number) + "❳۞", number));

    Log.v("hassanx","10:"+arabicDATA.get(i).text);
}

else

if (arabicDATA.contains("بِسْمِ ٱللَّهِ ٱلرَّحْمَٰنِ ٱلرَّحِيمِ")){


    arabicDATA.add(new Temp_data(text  , number));

    Log.v("hassanx","bimila"+arabicDATA.get(i).text);
                                    }else{

    arabicDATA.add(new Temp_data(text + "❲" + convertNumber(number) + "❳۞", number));
    Log.v("mydbgx", text + "\n number:" + number + "\npage:" + page + "\ncount:" + count);

    Log.v("hassanx","ran:"+arabicDATA.get(i).text);
}



                                        if (i == jsonArray.length() - 1)
                                        {

                                            Log.v("mydbgx", text + "\n at :" + i + "aray size:" + arabicDATA.size());


                                            count++;


                                            fetch_quran_txt(stps, stpe);
                                            break;
                                        }
                                    }
                                    else
                                        {

                                            if (!number.equals("7")) {
                                                urduDATA.add(new Temp_data(text, number));
                                                Log.v("mydbgx", text + "\n number:" + number + "\npage:" + page);
                                            }else {
                                                text="شُروع اَللہ کے پاک نام سے جو بڑا مہر بان نہايت رحم والا ہے";
                                                urduDATA.add(new Temp_data(text, number));
                                                Log.v("mydbgx", text + "\n number:" + number + "\npage:" + page);}


                                        if (i == jsonArray.length()  - 1) {
                                            Log.v("mydbgx", text + "\n at :" + i + "aray size:" + urduDATA.size());

                                            count = 0;

                                            writeDB();

                                        }
                                    }

                                }


                            }
                            else
                                {


                                Log.v("mydbgx", "Chk sura n0 ->>>:" + ParahorNumber);

                                for (int i = stps; i < stpe; i++)

                                {
                                    Toast.makeText(context, "" + count, Toast.LENGTH_SHORT).show();
                                    JSONObject finl_response = jsonArray.getJSONObject(i);
                                    String text = finl_response.getString("text");
                                    String number = finl_response.getString("number");
                                    String page = finl_response.getString("page");

                                    if (count == 0) {
if (number.equals("8")){

    text=text.replace("الٓمٓ"," ");

    arabicDATA.add(new Temp_data(text, number));
}  else if (number.equals("9")){

    text="الٓمٓ۞"+"\n\n"+" ذَٰلِكَ ٱلْكِتَٰبُ لَا رَيْبَ ۛ فِيهِ ۛ هُدًۭى لِّلْمُتَّقِينَُ";

    arabicDATA.add(new Temp_data(text+" ۞ ", number));
}else if (number.equals("11")){

    text="وَالَّذِينَ يُؤْمِنُونَ بِمَا أُنزِلَ إِلَيْكَ وَمَا أُنزِلَ مِن قَبْلِكَ وَبِالْآخِرَةِ هُمْ يُوقِنُونَ";

    arabicDATA.add(new Temp_data(text+" ۞ ", number));
}else
if (arabicDATA.contains("بِسْمِ ٱللَّهِ ٱلرَّحْمَٰنِ ٱلرَّحِيمِ")){


    arabicDATA.add(new Temp_data(text  , number));
}else {

    arabicDATA.add(new Temp_data(text+" ۞ ", number));
}

                                        Log.v("mydbgx", text + "\n number:" + number + "\npage:" + page + "\ncount:" + count);


                                        if (i == stpe - 1)
                                        {

                                            Log.v("mydbgx", text + "\n at :" + i + "aray size:" + arabicDATA.size());


                                            count++;


                                            fetch_quran_txt(stps, stpe);
                                            break;
                                        }
                                    } else {
                                       if (number.equals("8")){
                                            text="شُروع اَللہ کے پاک نام سے جو بڑا مہر بان نہايت رحم والا ہے";
                                            urduDATA.add(new Temp_data(text, number));
                                            Log.v("mydbgx", text + "\n number:" + number + "\npage:" + page);}else {



                                        urduDATA.add(new Temp_data(text, number));}
                                        Log.v("mydbgx", text + "\n number:" + number + "\npage:" + page);

                                        if (i == stpe - 1) {
                                            Log.v("mydbgx", text + "\n at :" + i + "aray size:" + urduDATA.size());

                                            count = 0;

                                            writeDB();
                                        }
                                    }

                                }


                            }



                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(context, "masla", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(context, "internet error\n trying again", Toast.LENGTH_SHORT).show();
                if (attempt <= 5) {
                    attempt++;
                    progressDialog.setMessage("Retrying " + attempt + "/5");
                    progressDialog.show();

                    fetch_quran_txt(stepsStart, stepsEnd);
                } else {
                    Toast.makeText(context, "Failed to load\n try again latter", Toast.LENGTH_SHORT).show();
                }
            }
        });
        requestQueue.add(objectRequest);

    }

    private void writeDB() {

        Log.v("mydbgx", arabicDATA.size() + "in write" + urduDATA.size());
        ArrayList<data_model_arabicandurdu> data = new ArrayList<>();
        data_model_arabicandurdu d;
        Temp_data itemarabic, itemurdu;
        for (int i = 0; i < arabicDATA.size(); i++) {
            itemarabic = arabicDATA.get(i);
            itemurdu = urduDATA.get(i);
            data.add(new data_model_arabicandurdu(itemarabic.text, itemarabic.item, itemurdu.text, 0));
            d = data.get(i);

            if (i == arabicDATA.size() - 1) {

                Log.v("mydbgx", "async start" + data.get(i));
                if (progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
                AsyncTaskRunner myTask = new AsyncTaskRunner(context);


                if (!DB.equals("Surah"))
                {

                    Log.v("hassan","Parameters: "+":"+ParahorNumber+":"+chk_if_suparah_or_surah);

                    Log.v("mydbgx", "aparah stored chk   stored in as :" +DB+"  ------> "+ParahorNumber);
                    myTask.execute(data, ParahorNumber, chk_if_suparah_or_surah);

                }else {
                    Log.v("mydbgx", "aparah stored chk   stored in as :" +DB+"  ------> "+SurahNumber);

                Log.v("hassan","Parameters: "+":"+SurahNumber+":"+chk_if_suparah_or_surah);
                    myTask.execute(data, SurahNumber, chk_if_suparah_or_surah);
                }

            }


        }
    }

    private String convertNumber(String number){
        String convertednumber = "";

        for (int i=0; i<number.length(); i++){

            Log.v("Hassan",i+": char at number : "+number.charAt(i));
            switch (String.valueOf(number.charAt(i))){
                case "0":
                    convertednumber=convertednumber+"٥";
                    break;
                case "1":
                    convertednumber=convertednumber+"١";
                    break;
                case "2":
                    convertednumber=convertednumber+"٢";
                    break;
                case "3":
                    convertednumber=convertednumber+"٣";
                    break;
                case "4":
                    convertednumber=convertednumber+"٤";
                    break;
                case "5":
                    convertednumber=convertednumber+"٥";
                    break;
                case "6":
                    convertednumber=convertednumber+"٦";
                    break;
                case "7":
                    convertednumber=convertednumber+"٧";
                    break;
                case "8":
                    convertednumber=convertednumber+"٨";
                    break;
                case "9":
                    convertednumber=convertednumber+"٩";
                    break;
                default:
                    break;


            }
        }

        return convertednumber;
    }
}