package com.developer.islamicapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.developer.islamicapp.Activities.Read_quran_Activity;
import com.developer.islamicapp.Api.volleyprocess_quran_fetcher;
import com.developer.islamicapp.R;
import com.developer.islamicapp.utils.Typcast;

import java.util.ArrayList;


public class AdapterParahandSurah_title_list extends RecyclerView.Adapter<AdapterParahandSurah_title_list.ViewHolder> {

    private LayoutInflater mInflater;
    ArrayList<String> data;
    Context context;
    String chk;

    public AdapterParahandSurah_title_list(Context context, ArrayList<String> data, String chk) {
        this.context = context;
        this.data = data;
        this.mInflater = LayoutInflater.from(context);
        this.chk=chk;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.rec_item_parahandsurah_titles, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        holder.textView.setText(data.get(position));


    }

    @Override
    public int getItemCount() {
        return data.size();
    }





    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView;

        ViewHolder(View itemView) {
            super(itemView);
            textView =itemView.findViewById(R.id.textx);

            textView.setTypeface(new Typcast().Typcast(context,"BB"));
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.v("mydbgx", " click---->"+chk);
            if (chk.equals("Surah"))
            {
                Log.v("mydbgx", "Surah click");

//                OnclickSurah(data.get(getAdapterPosition()));

                OnclickSurah( String.valueOf(getAdapterPosition()+1));

            }else {
                Log.v("mydbgx", "Parah click");
             //   OnclickParah(data.get(getAdapterPosition()));

                OnclickParah( String.valueOf(getAdapterPosition()+1));

            }

            notifyDataSetChanged();

        }
    }


    private void OnclickParah(String chk2){

        Log.v("mydbgx", "Parah: "+chk2);
       // Log.v("mydbgx", "sub string in Parah "+Parah.substring(Parah.length()-3).trim());
        context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB",chk.trim()).putExtra("Datafetch",chk2));

//        switch (chk2)
//        {
//

//            case "1":
//                //chk if db mai phly hi sava ha ya ni?
//
//
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(chk.trim()+"1","null").trim().equals("1")) {
//                    new volleyprocess_quran_fetcher(149, 1,context, chk.trim(),"1","","Parah");
//                }
//                else {
//                  context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB",chk.trim()).putExtra("Datafetch","1"));
//
//                }
//           //     Log.v("mydbgx", "sub string in Parah "+Parah.substring(0,2).trim() );
//                break;
//
//            case "2": //Parah number 2
//                //chk if db mai phly hi sava ha ya ni?
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(chk.trim()+"2","null").trim().equals("2")) {
//                    new volleyprocess_quran_fetcher(260, 149,context, chk.trim(),"2","","Parah"); //2nd para 149 to onward steps/Surahnumber
//                }else {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB",chk.trim()).putExtra("Datafetch","2"));
//
//                }
//           //     Log.v("mydbgx", "sub string in Parah "+Parah.substring(0,2).trim() );
//                break;
//
//
//
//
//
//            case "3": //Parah number 2
//                //chk if db mai phly hi sava ha ya ni?
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(chk.trim()+"3","null").trim().equals("3")) {
//                    new volleyprocess_quran_fetcher(386, 260,context, chk.trim(),"3","","Parah"); //2nd para 149 to onward steps/Surahnumber
//                }else {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB",chk.trim()).putExtra("Datafetch","3"));
//
//                }
//              //  Log.v("mydbgx", "sub string in Parah "+Parah.substring(0,2).trim() );
//                break;
//
//
//
//
//
//
//            case "4": //Parah number 2
//                //chk if db mai phly hi sava ha ya ni?
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(chk.trim()+"4","null").trim().equals("4")) {
//                    new volleyprocess_quran_fetcher(517, 386,context, chk.trim(),"4","","Parah"); //2nd para 149 to onward steps/Surahnumber
//                }
//                else
//
//                    {
//                        context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB",chk.trim()).putExtra("Datafetch","4"));
//                    }
//             //   Log.v("mydbgx", "sub string in Parah "+Parah.substring(0,2).trim() );
//                break;
//
//
//            case "5": //Parah number 2
//                //chk if db mai phly hi sava ha ya ni?
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(chk.trim()+"5","null").trim().equals("5")) {
//                    new volleyprocess_quran_fetcher(641, 517,context, chk.trim(),"5","","Parah"); //2nd para 149 to onward steps/Surahnumber
//                }else {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB",chk.trim()).putExtra("Datafetch","5"));
//
//                }
//          //      Log.v("mydbgx", "sub string in Parah "+Parah.substring(0,2).trim() );
//                break;
//
//            case "6": //Parah number 2
//                //chk if db mai phly hi sava ha ya ni?
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(chk.trim()+"6","null").trim().equals("6")) {
//                    new volleyprocess_quran_fetcher(751, 641,context, chk.trim(),"6","","Parah"); //2nd para 149 to onward steps/Surahnumber
//                }else {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB",chk.trim()).putExtra("Datafetch","6"));
//
//                }
//                Log.v("mydbgx", "sub string in Parah "+Parah.substring(0,2).trim() );
//                break;
//
//
//
//
//            case "7": //Parah number 2
//                //chk if db mai phly hi sava ha ya ni?
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(chk.trim()+"7","null").trim().equals("7")) {
//                    new volleyprocess_quran_fetcher(900, 751,context, chk.trim(),"7","","Parah"); //2nd para 149 to onward steps/Surahnumber
//                }else {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB",chk.trim()).putExtra("Datafetch","7"));
//
//                }
//                Log.v("mydbgx", "sub string in Parah "+Parah.substring(0,2).trim() );
//                break;
//
//
//            case "8": //Parah number 2
//                //chk if db mai phly hi sava ha ya ni?
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(chk.trim()+"8","null").trim().equals("8")) {
//                    new volleyprocess_quran_fetcher(1042, 900,context, chk.trim(),"8","","Parah"); //2nd para 149 to onward steps/Surahnumber
//                }else {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB",chk.trim()).putExtra("Datafetch","8"));
//
//                }
//                Log.v("mydbgx", "sub string in Parah "+Parah.substring(0,2).trim() );
//                break;
//
//
//
//            case "9": //Parah number 2
//                //chk if db mai phly hi sava ha ya ni?
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(chk.trim()+"9","null").trim().equals("9")) {
//                    new volleyprocess_quran_fetcher(1201, 1042,context, chk.trim(),"9","","Parah"); //2nd para 149 to onward steps/Surahnumber
//                }else {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB",chk.trim()).putExtra("Datafetch","9"));
//
//                }
//                Log.v("mydbgx", "sub string in Parah "+Parah.substring(0,2).trim() );
//                break;
//
//
//
//
//
//            case "10": //Parah number 2
//                //chk if db mai phly hi sava ha ya ni?
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(chk.trim()+"10","null").trim().equals("10")) {
//                    new volleyprocess_quran_fetcher(1328, 1201,context, chk.trim(),"10","","Parah"); //2nd para 149 to onward steps/Surahnumber
//                }else {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB",chk.trim()).putExtra("Datafetch","10"));
//
//                }
//                Log.v("mydbgx", "sub string in Parah "+Parah.substring(0,2).trim() );
//                break;
//
//
//
//
//            case "11": //Parah number 2
//                //chk if db mai phly hi sava ha ya ni?
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(chk.trim()+"11","null").trim().equals("11")) {
//                    new volleyprocess_quran_fetcher(1479, 1328,context, chk.trim(),"11","","Parah"); //2nd para 149 to onward steps/Surahnumber
//                }else {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB",chk.trim()).putExtra("Datafetch","11"));
//
//                }
//                Log.v("mydbgx", "sub string in Parah "+Parah.substring(0,2).trim() );
//                break;
//
//
//
//
//
//            case "12": //Parah number 2
//                //chk if db mai phly hi sava ha ya ni?
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(chk.trim()+"12","null").trim().equals("12")) {
//                    new volleyprocess_quran_fetcher(1649, 1479,context, chk.trim(),"12","","Parah"); //2nd para 149 to onward steps/Surahnumber
//                }else {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB",chk.trim()).putExtra("Datafetch","12"));
//
//                }
//                Log.v("mydbgx", "sub string in Parah "+Parah.substring(0,2).trim() );
//                break;
//
//
//
//            case "13": //Parah number 2
//                //chk if db mai phly hi sava ha ya ni?
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(chk.trim()+"13","null").trim().equals("13")) {
//                    new volleyprocess_quran_fetcher(1803, 1649,context, chk.trim(),"13","","Parah"); //2nd para 149 to onward steps/Surahnumber
//                }else {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB",chk.trim()).putExtra("Datafetch","13"));
//
//                }
//                Log.v("mydbgx", "sub string in Parah "+Parah.substring(0,2).trim() );
//                break;
//
//
//
//            case "14": //Parah number 2
//                //chk if db mai phly hi sava ha ya ni?
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(chk.trim()+"14","null").trim().equals("14")) {
//                    new volleyprocess_quran_fetcher(2030, 1803,context, chk.trim(),"14","","Parah"); //2nd para 149 to onward steps/Surahnumber
//                }else {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB",chk.trim()).putExtra("Datafetch","14"));
//
//                }
//                Log.v("mydbgx", "sub string in Parah "+Parah.substring(0,2).trim() );
//                break;
//
//
//            case "15": //Parah number 2
//                //chk if db mai phly hi sava ha ya ni?
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(chk.trim()+"15","null").trim().equals("15")) {
//                    new volleyprocess_quran_fetcher(2215, 2030,context, chk.trim(),"15","","Parah"); //2nd para 149 to onward steps/Surahnumber
//                }else {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB",chk.trim()).putExtra("Datafetch","15"));
//
//                }
//                Log.v("mydbgx", "sub string in Parah "+Parah.substring(0,2).trim() );
//                break;
//
//
//
//
//            case "16": //Parah number 2
//                //chk if db mai phly hi sava ha ya ni?
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(chk.trim()+"16","null").trim().equals("16")) {
//                    new volleyprocess_quran_fetcher(2484, 2215,context, chk.trim(),"16","","Parah"); //2nd para 149 to onward steps/Surahnumber
//                }else {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB",chk.trim()).putExtra("Datafetch","16"));
//
//                }
//                Log.v("mydbgx", "sub string in Parah "+Parah.substring(0,2).trim() );
//                break;
//
//
//
//            case "17": //Parah number 2
//                //chk if db mai phly hi sava ha ya ni?
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(chk.trim()+"17","null").trim().equals("17")) {
//                    new volleyprocess_quran_fetcher(2674, 2484,context, chk.trim(),"17","","Parah"); //2nd para 149 to onward steps/Surahnumber
//                }else {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB",chk.trim()).putExtra("Datafetch","17"));
//
//                }
//                Log.v("mydbgx", "sub string in Parah "+Parah.substring(0,2).trim() );
//                break;
//
//
//
//            case "18": //Parah number 2
//                //chk if db mai phly hi sava ha ya ni?
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(chk.trim()+"18","null").trim().equals("18")) {
//                    new volleyprocess_quran_fetcher(2876, 2674,context, chk.trim(),"18","","Parah"); //2nd para 149 to onward steps/Surahnumber
//                }else {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB",chk.trim()).putExtra("Datafetch","18"));
//
//                }
//                Log.v("mydbgx", "sub string in Parah "+Parah.substring(0,2).trim() );
//                break;
//
//
//
//            case "19": //Parah number 2
//                //chk if db mai phly hi sava ha ya ni?
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(chk.trim()+"19","null").trim().equals("19")) {
//                    new volleyprocess_quran_fetcher(3215, 2876,context, chk.trim(),"19","","Parah"); //2nd para 149 to onward steps/Surahnumber
//                }else {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB",chk.trim()).putExtra("Datafetch","19"));
//
//                }
//                Log.v("mydbgx", "sub string in Parah "+Parah.substring(0,2).trim() );
//                break;
//
//
//
//
//            case "20": //Parah number 2
//                //chk if db mai phly hi sava ha ya ni?
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(chk.trim()+"20","null").trim().equals("20")) {
//                    new volleyprocess_quran_fetcher(3386, 3215,context, chk.trim(),"20","","Parah"); //2nd para 149 to onward steps/Surahnumber
//                }else {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB",chk.trim()).putExtra("Datafetch","20"));
//
//                }
//                Log.v("mydbgx", "sub string in Parah "+Parah.substring(0,2).trim() );
//                break;
//
//
//
//            case "21": //Parah number 2
//                //chk if db mai phly hi sava ha ya ni?
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(chk.trim()+"21","null").trim().equals("21")) {
//                    new volleyprocess_quran_fetcher(3564, 3386,context, chk.trim(),"21","","Parah"); //2nd para 149 to onward steps/Surahnumber
//                }else {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB",chk.trim()).putExtra("Datafetch","21"));
//
//                }
//                Log.v("mydbgx", "sub string in Parah "+Parah.substring(0,2).trim() );
//                break;
//
//
//
//            case "22": //Parah number 2
//                //chk if db mai phly hi sava ha ya ni?
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(chk.trim()+"22","null").trim().equals("22")) {
//                    new volleyprocess_quran_fetcher(3733, 3564,context, chk.trim(),"22","","Parah"); //2nd para 149 to onward steps/Surahnumber
//                }else {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB",chk.trim()).putExtra("Datafetch","22"));
//
//                }
//                Log.v("mydbgx", "sub string in Parah "+Parah.substring(0,2).trim() );
//                break;
//
//
//
//            case "23": //Parah number 2
//                //chk if db mai phly hi sava ha ya ni?
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(chk.trim()+"23","null").trim().equals("23")) {
//                    new volleyprocess_quran_fetcher(4090, 3733,context, chk.trim(),"23","","Parah"); //2nd para 149 to onward steps/Surahnumber
//                }else {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB",chk.trim()).putExtra("Datafetch","23"));
//
//                }
//                Log.v("mydbgx", "sub string in Parah "+Parah.substring(0,2).trim() );
//                break;
//
//
//            case "24": //Parah number 2
//                //chk if db mai phly hi sava ha ya ni?
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(chk.trim()+"24","null").trim().equals("24")) {
//                    new volleyprocess_quran_fetcher(4265, 4090,context, chk.trim(),"24","","Parah"); //2nd para 149 to onward steps/Surahnumber
//                }else {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB",chk.trim()).putExtra("Datafetch","24"));
//
//                }
//                Log.v("mydbgx", "sub string in Parah "+Parah.substring(0,2).trim() );
//                break;
//
//
//
//            case "25": //Parah number 2
//                //chk if db mai phly hi sava ha ya ni?
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(chk.trim()+"25","null").trim().equals("25")) {
//                    new volleyprocess_quran_fetcher(4511, 4265,context, chk.trim(),"25","","Parah"); //2nd para 149 to onward steps/Surahnumber
//                }else {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB",chk.trim()).putExtra("Datafetch","25"));
//
//                }
//                Log.v("mydbgx", "sub string in Parah "+Parah.substring(0,2).trim() );
//                break;
//            case "26": //Parah number 2
//                //chk if db mai phly hi sava ha ya ni?
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(chk.trim()+"26","null").trim().equals("26")) {
//                    new volleyprocess_quran_fetcher(4706, 4511,context, chk.trim(),"26","","Parah"); //2nd para 149 to onward steps/Surahnumber
//                }else {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB",chk.trim()).putExtra("Datafetch","26"));
//
//                }
//                Log.v("mydbgx", "sub string in Parah "+Parah.substring(0,2).trim() );
//                break;
//
//
//
//            case "27": //Parah number 2
//                //chk if db mai phly hi sava ha ya ni?
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(chk.trim()+"27","null").trim().equals("27")) {
//                    new volleyprocess_quran_fetcher(5105, 4706,context, chk.trim(),"27","",""); //2nd para 149 to onward steps/Surahnumber
//                }else {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB",chk.trim()).putExtra("Datafetch","27"));
//
//                }
//                Log.v("mydbgx", "sub string in Parah "+Parah.substring(0,2).trim() );
//                break;
//
//
//
//            case "28": //Parah number 2
//                //chk if db mai phly hi sava ha ya ni?
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(chk.trim()+"28","null").trim().equals("28")) {
//                    new volleyprocess_quran_fetcher(5242, 5105,context, chk.trim(),"28","","Parah"); //2nd para 149 to onward steps/Surahnumber
//                }else {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB",chk.trim()).putExtra("Datafetch","28"));
//
//                }
//                Log.v("mydbgx", "sub string in Parah "+Parah.substring(0,2).trim() );
//                break;
//
//
//
//            case "29": //Parah number 2
//                //chk if db mai phly hi sava ha ya ni?
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(chk.trim()+"29","null").trim().equals("29")) {
//                    new volleyprocess_quran_fetcher(5673, 5242,context, chk.trim(),"29","","Parah"); //2nd para 149 to onward steps/Surahnumber
//                }else {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB",chk.trim()).putExtra("Datafetch","29"));
//
//                }
//                Log.v("mydbgx", "sub string in Parah "+Parah.substring(0,2).trim() );
//                break;
//
//
//
//            case "30": //Parah number 2
//                //chk if db mai phly hi sava ha ya ni?
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(chk.trim()+"30","null").trim().equals("30")) {
//                    new volleyprocess_quran_fetcher(6237, 5673,context, chk.trim(),"30","","Parah"); //2nd para 149 to onward steps/Surahnumber
//                }else {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB",chk.trim()).putExtra("Datafetch","30"));
//
//                }
////                Log.v("mydbgx", "sub string in Parah "+Parah.substring(0,2).trim() );
//                break;
//
//
//  }


    }


    private void OnclickSurah(String chk2)
    {

        context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch",chk2));

//          switch (chk2) {
//
//
//
//
//
//
//
//            case "1":
//                Log.v("mydbgx", "---> saved item in db as : "+ context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+1,"null").trim().equals("1") +"  --"+context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim(),"null").trim()+"---> "+ this.chk);
//
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"1","null").trim().equals("1"))
//                {
//                    new volleyprocess_quran_fetcher(7, 0,context, this.chk.trim(),"1","1","Surah");
//                }
//                else
//                    {
//                        context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","1"));
//
//                    }
//
//
//                break;
//            case "2":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"2","null").trim().equals("2")) {
//                    new volleyprocess_quran_fetcher(286, 0,context, this.chk.trim(),"2","2","Surah");          }
//                //Surah ending aya number ...
//                else
//                    {
//                        context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","2"));
//
//                    }
//
//                break;
//
//
//            case "3":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"3","null").trim().equals("3")) {
//                    new volleyprocess_quran_fetcher(200, 0,context, this.chk.trim(),"3","3","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","3"));
//
//                }
//
//                break;
//
//            case "4":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"4","null").trim().equals("4")) {
//                    new volleyprocess_quran_fetcher(176, 0,context, this.chk.trim(),"4","4","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","4"));
//
//                }
//
//                break;
//
//
//            case "5":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"5","null").trim().equals("5")) {
//                    new volleyprocess_quran_fetcher(120, 0,context, this.chk.trim(),"5","5","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","5"));
//
//                }
//
//                break;
//
//
//            case "6":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"6","null").trim().equals("6")) {
//                    new volleyprocess_quran_fetcher(165, 0,context, this.chk.trim(),"6","6","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","6"));
//
//                }
//
//                break;
//
//
//            case "7":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"7","null").trim().equals("7")) {
//                    new volleyprocess_quran_fetcher(206, 0,context, this.chk.trim(),"7","7","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","7"));
//
//                }
//
//                break;
//
//
//            case "8":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"8","null").trim().equals("8")) {
//                    new volleyprocess_quran_fetcher(75, 0,context, this.chk.trim(),"8","8","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","8"));
//
//                }
//
//                break;
//
//            case "9":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"9","null").trim().equals("9")) {
//                    new volleyprocess_quran_fetcher(129, 0,context, this.chk.trim(),"9","9","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","9"));
//
//                }
//
//                break;
//
//
//
//            case "10":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"10","null").trim().equals("10")) {
//                    new volleyprocess_quran_fetcher(109, 0,context, this.chk.trim(),"10","10","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","10"));
//
//                }
//
//                break;
//
//
//
//            case "11":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"11","null").trim().equals("11")) {
//                    new volleyprocess_quran_fetcher(123, 0,context, this.chk.trim(),"11","11","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","11"));
//
//                }
//
//                break;
//
//
//
//
//            case "12":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"12","null").trim().equals("12")) {
//                    new volleyprocess_quran_fetcher(111, 0,context, this.chk.trim(),"12","12","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","12"));
//
//                }
//
//                break;
//
//            case "13":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"13","null").trim().equals("13")) {
//                    new volleyprocess_quran_fetcher(43, 0,context, this.chk.trim(),"13","13","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","13"));
//
//                }
//
//                break;
//
//
//            case "14":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"14","null").trim().equals("14")) {
//                    new volleyprocess_quran_fetcher(52, 0,context, this.chk.trim(),"14","14","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","14"));
//
//                }
//
//                break;
//
//
//
//            case "15":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"15","null").trim().equals("15")) {
//                    new volleyprocess_quran_fetcher(99, 0,context, this.chk.trim(),"15","15","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","15"));
//
//                }
//
//                break;
//
//
//
//            case "16":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"16","null").trim().equals("16")) {
//                    new volleyprocess_quran_fetcher(128, 0,context, this.chk.trim(),"16","16","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","16"));
//
//                }
//
//                break;
//
//
//
//            case "17":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"17","null").trim().equals("17")) {
//                    new volleyprocess_quran_fetcher(111, 0,context, this.chk.trim(),"17","17","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","17"));
//
//                }
//
//                break;
//
//
//
//
//            case "18":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"18","null").trim().equals("18")) {
//                    new volleyprocess_quran_fetcher(110, 0,context, this.chk.trim(),"18","18","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","18"));
//
//                }
//
//                break;
//
//
//
//
//            case "19":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"19","null").trim().equals("19")) {
//                    new volleyprocess_quran_fetcher(98, 0,context, this.chk.trim(),"19","19","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","19"));
//
//                }
//
//                break;
//
//
//
//
//
//            case "20":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"20","null").trim().equals("20")) {
//                    new volleyprocess_quran_fetcher(135, 0,context, this.chk.trim(),"20","20","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","20"));
//
//                }
//
//                break;
//
//
//
//            case "21":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"21","null").trim().equals("21")) {
//                    new volleyprocess_quran_fetcher(112, 0,context, this.chk.trim(),"21","21","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","21"));
//
//                }
//
//                break;
//
//            case "22":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"22","null").trim().equals("22")) {
//                    new volleyprocess_quran_fetcher(78, 0,context, this.chk.trim(),"22","22","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","22"));
//
//                }
//
//                break;
//
//
//
//
//            case "23":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"23","null").trim().equals("23")) {
//                    new volleyprocess_quran_fetcher(118, 0,context, this.chk.trim(),"23","23","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","23"));
//
//                }
//
//                break;
//
//
//            case "24":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"24","null").trim().equals("24")) {
//                    new volleyprocess_quran_fetcher(64, 0,context, this.chk.trim(),"24","24","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","24"));
//
//                }
//
//                break;
//
//
//
//
//            case "25":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"25","null").trim().equals("25")) {
//                    new volleyprocess_quran_fetcher(77, 0,context, this.chk.trim(),"25","25","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","25"));
//
//                }
//
//                break;
//
//
//
//
//            case "26":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"26","null").trim().equals("26")) {
//                    new volleyprocess_quran_fetcher(227, 0,context, this.chk.trim(),"26","26","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","26"));
//
//                }
//
//                break;
//
//
//
//
//            case "27":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"27","null").trim().equals("27")) {
//                    new volleyprocess_quran_fetcher(93, 0,context, this.chk.trim(),"27","27","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","27"));
//
//                }
//
//                break;
//
//
//
//            case "28":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"28","null").trim().equals("28")) {
//                    new volleyprocess_quran_fetcher(94, 0,context, this.chk.trim(),"28","28","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","28"));
//
//                }
//
//                break;
//
//
//
//
//            case "29":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"29","null").trim().equals("29")) {
//                    new volleyprocess_quran_fetcher(63, 0,context, this.chk.trim(),"29","29","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","29"));
//
//                }
//
//                break;
//
//            case "30":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"30","null").trim().equals("30")) {
//                    new volleyprocess_quran_fetcher(60, 0,context, this.chk.trim(),"30","30","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","30"));
//
//                }
//
//                break;
//
//
//
//
//            case "31":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"31","null").trim().equals("31")) {
//                    new volleyprocess_quran_fetcher(34, 0,context, this.chk.trim(),"31","31","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","31"));
//
//                }
//
//                break;
//
//
//
//
//            case "32":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"32","null").trim().equals("32")) {
//                    new volleyprocess_quran_fetcher(30, 0,context, this.chk.trim(),"32","32","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","32"));
//
//                }
//
//                break;
//
//
//            case "33":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"33","null").trim().equals("33")) {
//                    new volleyprocess_quran_fetcher(73, 0,context, this.chk.trim(),"33","33","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","33"));
//
//                }
//
//                break;
//
//
//            case "34":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"34","null").trim().equals("34")) {
//                    new volleyprocess_quran_fetcher(54, 0,context, this.chk.trim(),"34","34","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","34"));
//
//                }
//
//                break;
//
//
//
//            case "35":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"35","null").trim().equals("35")) {
//                    new volleyprocess_quran_fetcher(45, 0,context, this.chk.trim(),"35","35","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","35"));
//
//                }
//
//                break;
//
//
//
//
//
//            case "36":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"36","null").trim().equals("36")) {
//                    new volleyprocess_quran_fetcher(83, 0,context, this.chk.trim(),"36","36","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","36"));
//
//                }
//
//                break;
//
//
//            case "37":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"37","null").trim().equals("37")) {
//                    new volleyprocess_quran_fetcher(182, 0,context, this.chk.trim(),"37","37","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","37"));
//
//                }
//
//                break;
//
//
//
//            case "38":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"38","null").trim().equals("38")) {
//                    new volleyprocess_quran_fetcher(88, 0,context, this.chk.trim(),"38","38","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","38"));
//
//                }
//
//                break;
//
//
//
//            case "39":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"39","null").trim().equals("39")) {
//                    new volleyprocess_quran_fetcher(75, 0,context, this.chk.trim(),"39","39","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","39"));
//
//                }
//
//                break;
//
//
//
//
//
//            case "40":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"40","null").trim().equals("40")) {
//                    new volleyprocess_quran_fetcher(85, 0,context, this.chk.trim(),"40","40","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","40"));
//
//                }
//
//                break;
//
//
//
//
//
//
//
//            case "41":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"41","null").trim().equals("41")) {
//                    new volleyprocess_quran_fetcher(54, 0,context, this.chk.trim(),"41","41","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","41"));
//
//                }
//
//                break;
//
//
//
//
//            case "42":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"42","null").trim().equals("42")) {
//                    new volleyprocess_quran_fetcher(53, 0,context, this.chk.trim(),"42","42","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","42"));
//
//                }
//
//                break;
//
//
//
//
//            case "43":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"43","null").trim().equals("43")) {
//                    new volleyprocess_quran_fetcher(89, 0,context, this.chk.trim(),"43","43","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","43"));
//
//                }
//
//                break;
//
//
//
//
//            case "44":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"44","null").trim().equals("44")) {
//                    new volleyprocess_quran_fetcher(59, 0,context, this.chk.trim(),"44","44","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","44"));
//
//                }
//
//                break;
//
//
//
//
//            case "45":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"45","null").trim().equals("45")) {
//                    new volleyprocess_quran_fetcher(37, 0,context, this.chk.trim(),"45","45","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","45"));
//
//                }
//
//                break;
//
//
//
//            case "46":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"46","null").trim().equals("46")) {
//                    new volleyprocess_quran_fetcher(35, 0,context, this.chk.trim(),"46","46","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","46"));
//
//                }
//
//                break;
//
//
//
//            case "47":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"47","null").trim().equals("47")) {
//                    new volleyprocess_quran_fetcher(38, 0,context, this.chk.trim(),"47","47","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","47"));
//
//                }
//
//                break;
//
//
//
//            case "48":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"48","null").trim().equals("48")) {
//                    new volleyprocess_quran_fetcher(29, 0,context, this.chk.trim(),"48","48","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","48"));
//
//                }
//
//                break;
//
//
//
//            case "49":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"49","null").trim().equals("49")) {
//                    new volleyprocess_quran_fetcher(18, 0,context, this.chk.trim(),"49","49","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","49"));
//
//                }
//
//                break;
//
//
//
//            case "50":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"50","null").trim().equals("50")) {
//                    new volleyprocess_quran_fetcher(45, 0,context, this.chk.trim(),"50","50","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","50"));
//
//                }
//
//                break;
//
//
//
//            case "51":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"51","null").trim().equals("51")) {
//                    new volleyprocess_quran_fetcher(60, 0,context, this.chk.trim(),"51","51","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","51"));
//
//                }
//
//                break;
//
//
//
//            case "52":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"52","null").trim().equals("52")) {
//                    new volleyprocess_quran_fetcher(49, 0,context, this.chk.trim(),"52","52","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","52"));
//
//                }
//
//                break;
//
//
//            case "53":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"53","null").trim().equals("53")) {
//                    new volleyprocess_quran_fetcher(62, 0,context, this.chk.trim(),"53","53","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","53"));
//
//                }
//
//                break;
//
//
//
//            case "54":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"54","null").trim().equals("54")) {
//                    new volleyprocess_quran_fetcher(55, 0,context, this.chk.trim(),"54","54","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","54"));
//
//                }
//
//                break;
//
//
//            case "55":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"55","null").trim().equals("55")) {
//                    new volleyprocess_quran_fetcher(70, 0,context, this.chk.trim(),"55","55","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","55"));
//
//                }
//
//                break;
//
//
//            case "56":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"56","null").trim().equals("56")) {
//                    new volleyprocess_quran_fetcher(104, 0,context, this.chk.trim(),"56","56","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","56"));
//
//                }
//
//                break;
//
//
//
//            case "57":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"57","null").trim().equals("57")) {
//                    new volleyprocess_quran_fetcher(29, 0,context, this.chk.trim(),"57","57","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","57"));
//
//                }
//
//                break;
//
//
//
//            case "58":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"58","null").trim().equals("58")) {
//                    new volleyprocess_quran_fetcher(22, 0,context, this.chk.trim(),"58","58","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","58"));
//
//                }
//
//                break;
//
//
//
//
//
//            case "59":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"59","null").trim().equals("59")) {
//                    new volleyprocess_quran_fetcher(24, 0,context, this.chk.trim(),"59","59","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","59"));
//
//                }
//
//                break;
//
//
//
//
//            case "60":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"60","null").trim().equals("60")) {
//                    new volleyprocess_quran_fetcher(13, 0,context, this.chk.trim(),"60","60","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","60"));
//
//                }
//
//                break;
//
//
//
//            case "61":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"61","null").trim().equals("61")) {
//                    new volleyprocess_quran_fetcher(14, 0,context, this.chk.trim(),"61","61","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","61"));
//
//                }
//
//                break;
//
//            case "62":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"62","null").trim().equals("62")) {
//                    new volleyprocess_quran_fetcher(11, 0,context, this.chk.trim(),"62","62","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","62"));
//
//                }
//
//                break;
//
//
//            case "63":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"63","null").trim().equals("63")) {
//                    new volleyprocess_quran_fetcher(11, 0,context, this.chk.trim(),"63","63","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","63"));
//
//                }
//
//                break;
//
//
//
//
//            case "64":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"64","null").trim().equals("64")) {
//                    new volleyprocess_quran_fetcher(18, 0,context, this.chk.trim(),"64","64","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","64"));
//
//                }
//
//                break;
//
//
//
//            case "65":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"65","null").trim().equals("65")) {
//                    new volleyprocess_quran_fetcher(12, 0,context, this.chk.trim(),"65","65","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","65"));
//
//                }
//
//                break;
//
//
//
//
//            case "66":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"66","null").trim().equals("66")) {
//                    new volleyprocess_quran_fetcher(12, 0,context, this.chk.trim(),"66","66","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","66"));
//
//                }
//
//                break;
//
//
//
//
//            case "67":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"67","null").trim().equals("67")) {
//                    new volleyprocess_quran_fetcher(30, 0,context, this.chk.trim(),"67","67","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","67"));
//
//                }
//
//                break;
//
//
//
//
//            case "68":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"68","null").trim().equals("68")) {
//                    new volleyprocess_quran_fetcher(52, 0,context, this.chk.trim(),"68","68","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","68"));
//
//                }
//
//                break;
//
//
//
//            case "69":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"69","null").trim().equals("69")) {
//                    new volleyprocess_quran_fetcher(52, 0,context, this.chk.trim(),"69","69","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","69"));
//
//                }
//
//                break;
//
//
//
//            case "70":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"70","null").trim().equals("70")) {
//                    new volleyprocess_quran_fetcher(44, 0,context, this.chk.trim(),"70","70","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","70"));
//
//                }
//
//                break;
//
//
//
//            case "71":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"71","null").trim().equals("71")) {
//                    new volleyprocess_quran_fetcher(28, 0,context, this.chk.trim(),"71","71","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","71"));
//
//                }
//
//                break;
//
//
//            case "72":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"72","null").trim().equals("72")) {
//                    new volleyprocess_quran_fetcher(28, 0,context, this.chk.trim(),"72","72","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","72"));
//
//                }
//
//                break;
//
//
//
//
//            case "73":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"73","null").trim().equals("73")) {
//                    new volleyprocess_quran_fetcher(20, 0,context, this.chk.trim(),"73","73","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","73"));
//
//                }
//
//                break;
//
//
//
//
//            case "74":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"74","null").trim().equals("74")) {
//                    new volleyprocess_quran_fetcher(56, 0,context, this.chk.trim(),"74","74","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","74"));
//
//                }
//
//                break;
//
//
//
//            case "75":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"75","null").trim().equals("75")) {
//                    new volleyprocess_quran_fetcher(40, 0,context, this.chk.trim(),"75","75","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","75"));
//
//                }
//
//                break;
//
//
//
//
//
//
//
//            case "76":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"76","null").trim().equals("76")) {
//                    new volleyprocess_quran_fetcher(31, 0,context, this.chk.trim(),"76","76","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","76"));
//
//                }
//
//                break;
//
//
//
//            case "77":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"77","null").trim().equals("77")) {
//                    new volleyprocess_quran_fetcher(50, 0,context, this.chk.trim(),"77","77","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","77"));
//
//                }
//
//                break;
//
//
//            case "78":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"78","null").trim().equals("78")) {
//                    new volleyprocess_quran_fetcher(40, 0,context, this.chk.trim(),"78","78","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","78"));
//
//                }
//
//                break;
//
//
//            case "79":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"79","null").trim().equals("79")) {
//                    new volleyprocess_quran_fetcher(46, 0,context, this.chk.trim(),"79","79","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","79"));
//
//                }
//
//                break;
//
//
//
//
//            case "80":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"80","null").trim().equals("80")) {
//                    new volleyprocess_quran_fetcher(42, 0,context, this.chk.trim(),"80","80","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","80"));
//
//                }
//
//                break;
//
//
//            case "81":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"81","null").trim().equals("81")) {
//                    new volleyprocess_quran_fetcher(29, 0,context, this.chk.trim(),"81","81","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","81"));
//
//                }
//
//                break;
//
//
//
//
//            case "82":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"82","null").trim().equals("82")) {
//                    new volleyprocess_quran_fetcher(19, 0,context, this.chk.trim(),"82","82","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","82"));
//
//                }
//
//                break;
//
//
//            case "83":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"83","null").trim().equals("83")) {
//                    new volleyprocess_quran_fetcher(36, 0,context, this.chk.trim(),"83","83","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","83"));
//
//                }
//
//                break;
//
//
//
//            case "84":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"84","null").trim().equals("84")) {
//                    new volleyprocess_quran_fetcher(25, 0,context, this.chk.trim(),"84","84","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","84"));
//
//                }
//
//                break;
//
//
//            case "85":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"85","null").trim().equals("85")) {
//                    new volleyprocess_quran_fetcher(22, 0,context, this.chk.trim(),"85","85","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","85"));
//
//                }
//
//                break;
//
//
//
//            case "86":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"86","null").trim().equals("86")) {
//                    new volleyprocess_quran_fetcher(17, 0,context, this.chk.trim(),"86","86","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","86"));
//
//                }
//
//                break;
//
//
//            case "87":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"87","null").trim().equals("87")) {
//                    new volleyprocess_quran_fetcher(19, 0,context, this.chk.trim(),"87","87","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","87"));
//
//                }
//
//                break;
//
//            case "88":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"88","null").trim().equals("88")) {
//                    new volleyprocess_quran_fetcher(26, 0,context, this.chk.trim(),"88","88","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","88"));
//
//                }
//
//                break;
//
//
//
//
//
//            case "89":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"89","null").trim().equals("89")) {
//                    new volleyprocess_quran_fetcher(30, 0,context, this.chk.trim(),"89","89","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","89"));
//
//                }
//
//                break;
//
//
//
//
//            case "90":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"90","null").trim().equals("90")) {
//                    new volleyprocess_quran_fetcher(20, 0,context, this.chk.trim(),"90","90","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","90"));
//
//                }
//
//                break;
//
//
//
//            case "91":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"91","null").trim().equals("91")) {
//                    new volleyprocess_quran_fetcher(15, 0,context, this.chk.trim(),"91","91","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","91"));
//
//                }
//
//                break;
//
//
//            case "92":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"92","null").trim().equals("92")) {
//                    new volleyprocess_quran_fetcher(21, 0,context, this.chk.trim(),"92","92","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","92"));
//
//                }
//
//                break;
//
//
//
//            case "93":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"93","null").trim().equals("93")) {
//                    new volleyprocess_quran_fetcher(11, 0,context, this.chk.trim(),"93","93","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","93"));
//
//                }
//
//                break;
//
//            case "94":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"94","null").trim().equals("94")) {
//                    new volleyprocess_quran_fetcher(8, 0,context, this.chk.trim(),"94","94","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","94"));
//
//                }
//
//                break;
//
//
//
//
//
//            case "95":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"95","null").trim().equals("95")) {
//                    new volleyprocess_quran_fetcher(8, 0,context, this.chk.trim(),"95","95","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","95"));
//
//                }
//
//                break;
//
//
//
//
//
//            case "96":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"96","null").trim().equals("96")) {
//                    new volleyprocess_quran_fetcher(19, 0,context, this.chk.trim(),"96","96","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","96"));
//
//                }
//
//                break;
//
//
//
//            case "97":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"97","null").trim().equals("97")) {
//                    new volleyprocess_quran_fetcher(5, 0,context, this.chk.trim(),"97","97","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","97"));
//
//                }
//
//                break;
//
//
//
//
//            case "98":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"98","null").trim().equals("98")) {
//                    new volleyprocess_quran_fetcher(8, 0,context, this.chk.trim(),"98","98","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","98"));
//
//                }
//
//                break;
//
//
//
//
//
//
//            case "99":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"99","null").trim().equals("99")) {
//                    new volleyprocess_quran_fetcher(8, 0,context, this.chk.trim(),"99","99","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","99"));
//
//                }
//
//                break;
//
//            case "100":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"100","null").trim().equals("100")) {
//                    new volleyprocess_quran_fetcher(11, 0,context, this.chk.trim(),"100","100","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","100"));
//
//                }
//
//                break;
//
//
//
//
//            case "101":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"101","null").trim().equals("101")) {
//                    new volleyprocess_quran_fetcher(11, 0,context, this.chk.trim(),"101","101","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","101"));
//
//                }
//
//                break;
//
//
//
//            case "102":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"102","null").trim().equals("102")) {
//                    new volleyprocess_quran_fetcher(8, 0,context, this.chk.trim(),"102","102","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","102"));
//
//                }
//
//                break;
//
//
//
//            case "103":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"103","null").trim().equals("103")) {
//                    new volleyprocess_quran_fetcher(3, 0,context, this.chk.trim(),"103","103","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","103"));
//
//                }
//
//                break;
//
//
//            case "104":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"104","null").trim().equals("104")) {
//                    new volleyprocess_quran_fetcher(9, 0,context, this.chk.trim(),"104","104","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","104"));
//
//                }
//
//                break;
//
//
//
//            case "105":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"105","null").trim().equals("105")) {
//                    new volleyprocess_quran_fetcher(5, 0,context, this.chk.trim(),"105","105","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","105"));
//
//                }
//
//                break;
//
//
//
//            case "106":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"106","null").trim().equals("106")) {
//                    new volleyprocess_quran_fetcher(4, 0,context, this.chk.trim(),"106","106","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","106"));
//
//                }
//
//                break;
//
//
//
//
//            case "107":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"107","null").trim().equals("107")) {
//                    new volleyprocess_quran_fetcher(7, 0,context, this.chk.trim(),"107","107","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","107"));
//
//                }
//
//                break;
//
//
//
//
//            case "108":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"108","null").trim().equals("108")) {
//                    new volleyprocess_quran_fetcher(3, 0,context, this.chk.trim(),"108","108","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","108"));
//
//                }
//
//                break;
//
//
//            case "109":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"109","null").trim().equals("109")) {
//                    new volleyprocess_quran_fetcher(6, 0,context, this.chk.trim(),"109","109","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","109"));
//
//                }
//
//                break;
//
//            case "110":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"110","null").trim().equals("110")) {
//                    new volleyprocess_quran_fetcher(3, 0,context, this.chk.trim(),"110","110","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","110"));
//
//                }
//
//                break;
//
//
//            case "111":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"111","null").trim().equals("111")) {
//                    new volleyprocess_quran_fetcher(5, 0,context, this.chk.trim(),"111","111","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","111"));
//
//                }
//
//                break;
//
//
//            case "112":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"112","null").trim().equals("112")) {
//                    new volleyprocess_quran_fetcher(4, 0,context, this.chk.trim(),"112","112","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","112"));
//
//                }
//
//                break;
//
//
//            case "113":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"113","null").trim().equals("113")) {
//                    new volleyprocess_quran_fetcher(5, 0,context, this.chk.trim(),"113","113","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","113"));
//
//                }
//
//                break;
//
//            case "114":
//
////                Parah number wo send karna ha jismy wo surat ha
////                ayat start number or end number steps mai
//                if (! context.getSharedPreferences("DB", Context.MODE_PRIVATE).getString(this.chk.trim()+"114","null").trim().equals("114")) {
//                    new volleyprocess_quran_fetcher(6, 0,context, this.chk.trim(),"114","114","Surah");          }
//                //Surah ending aya number ...
//                else
//                {
//                    context.  startActivity(new Intent(context, Read_quran_Activity.class).putExtra("DB", this.chk.trim()).putExtra("Datafetch","114"));
//
//                }
//
//                break;
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//        }






    }


}