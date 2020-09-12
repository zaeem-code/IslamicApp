package com.developer.islamicapp.Fragments;

import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.developer.islamicapp.Adapter.SliderAdapter;
import com.developer.islamicapp.Adapter.Slideronline;
import com.developer.islamicapp.Model.Constants;
import com.developer.islamicapp.Model.StoryModel;
import com.developer.islamicapp.Network.NetworkState;
import com.developer.islamicapp.R;
import com.developer.islamicapp.utils.Typcastregular;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import static android.content.Context.MODE_PRIVATE;
import static android.content.Context.POWER_SERVICE;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LiberaryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LiberaryFragment extends Fragment implements View.OnClickListener {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    long enqueID;
    DatabaseReference  databaseReferenceIMG;

    ArrayList<String> image_uri_array=new ArrayList<>();
    DownloadManager downloadManager;
    String file_name;
    File[] files;
    StoryModel f;
    String chk_name;
    String download_pos;
    Uri uri;
    String book_tite_1,book_tite_2,book_tite_3,book_tite_4,book_tite_5,book_tite_6,book_tite_7,book_tite_8,
            book_tite_9,book_tite_10,book_tite_11,book_tite_12;
TextView book1,book2,book3,book4,book5,book4b,book5b,book6,book6b,book7b,book8b,book9b;
    SharedPreferences prefs;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private com.smarteist.autoimageslider.SliderView slider,slider2;
    public LiberaryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LiberaryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LiberaryFragment newInstance(String param1, String param2) {
        LiberaryFragment fragment = new LiberaryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);


        return fragment;
    }
    View view;
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
        Typcastregular.Typcastregular(getContext(), "SERIF", "Poppins-Regular.otf");

        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_liberary, container, false);
        slider=view.findViewById(R.id.slider);
        slider2=view.findViewById(R.id.slider2);


        f = new StoryModel();

        book1=view.findViewById(R.id.book1N);
        book2=view.findViewById(R.id.book2N);
        book3=view.findViewById(R.id.book3N);
        book4=view.findViewById(R.id.book4N);
        book5=view.findViewById(R.id.book5N);
        book6=view.findViewById(R.id.book6N);



        book4b=view.findViewById(R.id.book4B);
        book5b=view.findViewById(R.id.book5B);
        book6b=view.findViewById(R.id.book6B);
        book7b=view.findViewById(R.id.book7B);
        book8b=view.findViewById(R.id.book8B);
        book9b=view.findViewById(R.id.book9B);

        view.findViewById(R.id.Hadeesbook1).setOnClickListener(this);
        view.findViewById(R.id.Hadeesbook2).setOnClickListener(this);
        view.findViewById(R.id.Hadeesbook3).setOnClickListener(this);
        view.findViewById(R.id.Hadeesbook4).setOnClickListener(this);
        view.findViewById(R.id.Hadeesbook5).setOnClickListener(this);
        view.findViewById(R.id.Hadeesbook6).setOnClickListener(this);



        view.findViewById(R.id.book7).setOnClickListener(this);
        view.findViewById(R.id.book8).setOnClickListener(this);
        view.findViewById(R.id.book9).setOnClickListener(this);
        view.findViewById(R.id.book4).setOnClickListener(this);
        view.findViewById(R.id.book5).setOnClickListener(this);
        view.findViewById(R.id.book6).setOnClickListener(this);

        settingupslider();


        prefs = getContext().getSharedPreferences("pre", MODE_PRIVATE);
        book_tite_1 = prefs.getString("Book 1", "");
        book_tite_2 = prefs.getString("Book 2", "");
        book_tite_3 = prefs.getString("Book 3", "");
        book_tite_4 = prefs.getString("Book 4", "");
        book_tite_5 = prefs.getString("Book 5", "");
        book_tite_6 = prefs.getString("Book 6", "");
        book_tite_7 = prefs.getString("Book 7", "");
        book_tite_8 = prefs.getString("Book 8", "");
        book_tite_9 = prefs.getString("Book 9", "");
        book_tite_10 = prefs.getString("Book 10", "");
        book_tite_11 = prefs.getString("Book 11", "");
        book_tite_12 = prefs.getString("Book 12", "");
        red_books_name();










        return view;

    }



    private void settingupslider(){

        slider.setSliderAdapter(new SliderAdapter(
                getContext(),getdata()));
        slider.setIndicatorAnimation(IndicatorAnimations.THIN_WORM);
        slider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
//        slider.setScrollTimeInSec(3); //set scroll delay in seconds :
//        slider.startAutoCycle();

        slider.setCurrentPagePosition(getdata().size());


//     DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference().child("Image");
//     databaseReference.addValueEventListener(new ValueEventListener() {
//         @Override
//         public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//             if (dataSnapshot.hasChildren())
//             {
////                 String uri=dataSnapshot.child("uri").getValue().toString();
//
//                 Glide.with(getContext()).load(uri).addListener(new RequestListener<Drawable>() {
//                     @Override
//                     public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
//
//                         return false;
//                     }
//
//                     @Override
//                     public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
//                         return false;
//                     }
//                 })
//                         .into(slider2);

//             }
//         }
//
//         @Override
//         public void onCancelled(@NonNull DatabaseError databaseError) {
//
//         }
//     });



    }



    private  ArrayList<Integer>  getdata() {

        ArrayList<Integer> fldrData=new ArrayList<>();
        fldrData.add(R.drawable.image_0);
        fldrData.add(R.drawable.image_1);
        fldrData.add(R.drawable.image_2);
        fldrData.add(R.drawable.image_3);
        fldrData.add(R.drawable.image_4);
        fldrData.add(R.drawable.image_5);
        fldrData.add(R.drawable.image_6);
        fldrData.add(R.drawable.image_7);
        fldrData.add(R.drawable.image_8);
        fldrData.add(R.drawable.image_9);
        fldrData.add(R.drawable.image_10);
        fldrData.add(R.drawable.image_11);
        fldrData.add(R.drawable.image_12);
        fldrData.add(R.drawable.image_13);
        fldrData.add(R.drawable.image_14);
        fldrData.add(R.drawable.image_15);
        fldrData.add(R.drawable.image_16);
        fldrData.add(R.drawable.image_17);
        fldrData.add(R.drawable.image_18);
        fldrData.add(R.drawable.image_19);
        fldrData.add(R.drawable.image_20);
        fldrData.add(R.drawable.image_21);
        fldrData.add(R.drawable.image_22);
        fldrData.add(R.drawable.image_23);
        fldrData.add(R.drawable.image_24);
        fldrData.add(R.drawable.image_25);
        fldrData.add(R.drawable.image_26);
        fldrData.add(R.drawable.image_27);
        fldrData.add(R.drawable.image_28);
        fldrData.add(R.drawable.image_29);
        fldrData.add(R.drawable.image_30);
        fldrData.add(R.drawable.image_31);
        fldrData.add(R.drawable.image_32);
        fldrData.add(R.drawable.image_33);
        fldrData.add(R.drawable.image_34);
        fldrData.add(R.drawable.image_35);
        fldrData.add(R.drawable.imgae_36);
        fldrData.add(R.drawable.image_37);
        fldrData.add(R.drawable.image_38);
        fldrData.add(R.drawable.image_39);
        fldrData.add(R.drawable.image_40);
        fldrData.add(R.drawable.image_41);
        fldrData.add(R.drawable.image_42);
        fldrData.add(R.drawable.image_43);
        fldrData.add(R.drawable.image_44);
        fldrData.add(R.drawable.image_45);
        fldrData.add(R.drawable.image_46);
        fldrData.add(R.drawable.image_47);
        fldrData.add(R.drawable.image_48);
        fldrData.add(R.drawable.image_49);
        fldrData.add(R.drawable.image_50);
        fldrData.add(R.drawable.image_51);
        fldrData.add(R.drawable.image_52);
        fldrData.add(R.drawable.image_53);
        fldrData.add(R.drawable.image_54);
        fldrData.add(R.drawable.image_55);
        fldrData.add(R.drawable.image_56);
        fldrData.add(R.drawable.image_57);
        fldrData.add(R.drawable.iamge_58);
        fldrData.add(R.drawable.image_59);
        fldrData.add(R.drawable.image_60);
        fldrData.add(R.drawable.image_61);
        fldrData.add(R.drawable.image_62);
        fldrData.add(R.drawable.image_63);
        fldrData.add(R.drawable.image_64);
        fldrData.add(R.drawable.image_65);
        fldrData.add(R.drawable.iamge_66);
        fldrData.add(R.drawable.image_67);
        fldrData.add(R.drawable.image_68);
        fldrData.add(R.drawable.image_69);
        fldrData.add(R.drawable.image_70);
        fldrData.add(R.drawable.image_71);
        fldrData.add(R.drawable.image_72);
        fldrData.add(R.drawable.image_73);
        fldrData.add(R.drawable.image_74);
        fldrData.add(R.drawable.image_75);
        fldrData.add(R.drawable.image_76);
        fldrData.add(R.drawable.image_77);
        fldrData.add(R.drawable.image_70);
        fldrData.add(R.drawable.image_79);
        fldrData.add(R.drawable.image_80);
        fldrData.add(R.drawable.image_81);
        fldrData.add(R.drawable.image_82);
        fldrData.add(R.drawable.image_83);
        fldrData.add(R.drawable.image_84);
        fldrData.add(R.drawable.image_85);
        fldrData.add(R.drawable.image_86);
        fldrData.add(R.drawable.image_87);
        fldrData.add(R.drawable.image_88);
        fldrData.add(R.drawable.image_89);
        fldrData.add(R.drawable.image_90);
        fldrData.add(R.drawable.image_91);
        fldrData.add(R.drawable.image_92);
        fldrData.add(R.drawable.image_93);
        fldrData.add(R.drawable.image_94);
        fldrData.add(R.drawable.image_95);
        fldrData.add(R.drawable.image_96);
        fldrData.add(R.drawable.image_97);
        fldrData.add(R.drawable.image_98);
        fldrData.add(R.drawable.image_99);
        Collections.reverse(fldrData);

        return  fldrData;
    }

//    private  ArrayList<Integer>  getdata2() {
//
//        ArrayList<Integer> fldrData=new ArrayList<>();
//        fldrData.add(R.drawable.quranicinfo);
//        fldrData.add(R.drawable.quranicon);
//        fldrData.add(R.drawable.logo_main);
//        fldrData.add(R.drawable.kalma_logo);
//        fldrData.add(R.drawable.kalmachannellogo);
//        return  fldrData;
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){





            case R.id.Hadeesbook1:




                 if (!book_tite_1.equals(""))
                 {


                     chk_name="Book 1";
                     fetch_book(book_tite_1);
                     get_book_database(chk_name);


                 }






                break;

            case R.id.Hadeesbook2:

                if (!book_tite_2.equals(""))
                {
                    chk_name="Book 2";
                    fetch_book(book_tite_2);
                    get_book_database(chk_name);
                }


                break;

            case R.id.Hadeesbook3:


                if (!book_tite_3.equals(""))
                {
                    chk_name="Book 3";
                    fetch_book(book_tite_3);
                    get_book_database(chk_name);

                }





                break;

            case R.id.Hadeesbook4:


                if (!book_tite_4.equals(""))
                {
                    chk_name="Book 4";
                    fetch_book(book_tite_4);
                    get_book_database(chk_name);

                }




                break;

            case R.id.Hadeesbook5:
//                startActivity(new Intent(getContext(), ReadingBookActivity.class).putExtra("book","Hadeesbook5"));

                if (!book_tite_5.equals(""))
                {
                    chk_name="Book 5";
                    fetch_book(book_tite_5);
                    get_book_database(chk_name);
                }


                break;

                case R.id.Hadeesbook6:
//                    startActivity(new Intent(getContext(), ReadingBookActivity.class).putExtra("book","Hadeesbook6"));

                    if (!book_tite_6.equals(""))
                    {
                        chk_name="Book 6";
                        fetch_book(book_tite_6);
                        get_book_database(chk_name);
                    }


                break;

            case R.id.book4:
//                startActivity(new Intent(getContext(), ReadingBookActivity.class).putExtra("book","book4"));

                if (!book_tite_7.equals(""))
                {
                    chk_name="Book 7";
                    fetch_book(book_tite_7);
                    get_book_database(chk_name);

                }

                break;
            case R.id.book5:
//                startActivity(new Intent(getContext(), ReadingBookActivity.class).putExtra("book","book5"));

                if (!book_tite_8.equals(""))
                {
                    chk_name="Book 8";
                    fetch_book(book_tite_8);
                    get_book_database(chk_name);
                }

                break;

            case R.id.book6:
//                startActivity(new Intent(getContext(), ReadingBookActivity.class).putExtra("book","book6"));

                if (!book_tite_9.equals(""))
                {
                    chk_name="Book 9";
                    fetch_book(book_tite_9);
                    get_book_database(chk_name);

                }


                break;
            case R.id.book7:
//                startActivity(new Intent(getContext(), ReadingBookActivity.class).putExtra("book","book7"));

                if (!book_tite_10.equals(""))
                {
                    chk_name="Book 10";
                    fetch_book(book_tite_10);
                    get_book_database(chk_name);

                }


                break;
            case R.id.book8:
//                startActivity(new Intent(getContext(), ReadingBookActivity.class).putExtra("book","book8"));

                if (!book_tite_11.equals(""))
                {
                    chk_name="Book 11";
                    fetch_book(book_tite_11);
                    get_book_database(chk_name);
                }

                break;
            case R.id.book9:

//                startActivity(new Intent(getContext(), ReadingBookActivity.class).putExtra("book","book9"));

              if (!book_tite_12.equals(""))
              {
                  chk_name="Book 12";
                  fetch_book(book_tite_12);
                  get_book_database(chk_name);
              }





                break;



        }
    }







    public void download_file(String url, String file_name)
    {
        DownloadManager.Request download = new DownloadManager.Request(Uri.parse(url));
        String fileName = URLUtil.guessFileName(url, null, MimeTypeMap.getFileExtensionFromUrl(url));
        download.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
        download.setTitle(fileName);
        download.setDescription("Downloading file");
        download.allowScanningByMediaScanner();
        download.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        download.setDestinationInExternalPublicDir(Environment.DIRECTORY_ALARMS, file_name);
        downloadManager = (DownloadManager)getContext().getSystemService(getContext().DOWNLOAD_SERVICE);
        enqueID =downloadManager.enqueue(download);

    }



    public  void  fetch_book(String book_name)
    {


        File file = new File(Environment.getExternalStorageDirectory(),
                Constants.FOLDER_NAME + "/" + book_name);


         if (file.exists())
         {



             f.setFilename("exist");
//             Uri uri = FileProvider.getUriForFile(getContext(), getContext().getPackageName(),file);

             if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
             {

                Uri uri= FileProvider.getUriForFile(Objects.requireNonNull(getContext()),
                         getContext().getPackageName() + ".provider", file);
                 f.setUri(uri);


             }

//             Toast.makeText(getContext(), ""+f.getFilename(), Toast.LENGTH_SHORT).show();
         }
         else
         {
             f.setFilename("not exist");
//             Toast.makeText(getContext(), ""+f.getFilename(), Toast.LENGTH_SHORT).show();
         }

        }





























    public void get_book_database(String book_child)
    {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {



            if (NetworkState.isOnline(getContext()))
            {




                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference()
                        .child("Book_data").child(book_child);
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if (dataSnapshot.hasChildren())
                        {
                            String uri = dataSnapshot.child("uri").getValue().toString();
                            String file_name = dataSnapshot.child("file_name").getValue().toString();


                             f.setKey(file_name);
//


                            if (f.getFilename().equals("exist"))
                            {

//                    Intent intent = new Intent(Intent.ACTION_VIEW);
//                    intent.setDataAndType(f.getUri(), "application/pdf");
//                    intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//                    startActivity(intent);


                                Intent pdfOpenintent = new Intent(Intent.ACTION_VIEW);
                                pdfOpenintent.setDataAndType(f.getUri(), "application/pdf");
                                pdfOpenintent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);



                                try {
                                    startActivity(pdfOpenintent);
                                }
                                catch (ActivityNotFoundException e) {

                                }

                            }
                            else
                            {
                                ///////////////////////

                                Toast.makeText(getContext(), "downloading start", Toast.LENGTH_SHORT).show();
                                download_file(uri,file_name);

                            }




                        }

                        else
                        {

                            Toast.makeText(getContext(), "no book upload", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });











            }
            else
            {

                if (f.getFilename().equals("exist"))
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(f.getUri(), "application/pdf");
                    intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(intent);

                }
                else
                {

                    Toast.makeText(getContext(), "download your book ", Toast.LENGTH_SHORT).show();
                }



            }


        }




    }


    int i;
    private  void red_books_name(){
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Book_data");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (int i=1; i<=12; i++){
                    try {

if ( dataSnapshot.child("Book "+i).hasChild("Book_name")){
    String x=     dataSnapshot.child("Book "+i).child("Book_name").getValue().toString().trim();
    if (!TextUtils.isEmpty(x)){
        setbool_name("Book "+i,x);
    }
}else {
    setbool_name("Book "+i,"N/A");

} }catch (Exception e){
                        Log.v("Hassan","Book error: "+e );
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
    }
private void setbool_name(String chk,String book_name){

    Log.v("Hassan",chk+"|Book data: "+book_name );

    switch (chk){

            case "Book 1":
                book1.setText(book_name);
                break;

            case "Book 2":
                book2.setText(book_name);
                break;

            case "Book 3":
                book3.setText(book_name);
                break;

            case "Book 4":
                book4.setText(book_name);
                break;

            case "Book 5":
                book5.setText(book_name);
                break;

            case "Book 6":
                book6.setText(book_name);
                break;

            case "Book 7":


                book4b.setText(book_name);
                break;

            case "Book 8":
                book5b.setText(book_name);
                break;

            case "Book 9":
                book6b.setText(book_name);
                break;

            case "Book 10":
                book7b.setText(book_name);
                break;

            case "Book 11":
                book8b.setText(book_name);
                break;

            case "Book 12":
                book9b.setText(book_name);
                break;


        }
}


    public void Database_images()
    {


        databaseReferenceIMG= FirebaseDatabase.getInstance().getReference()
                .child("Image");
        databaseReferenceIMG.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dsp:dataSnapshot.getChildren()){
                    if (dsp.hasChildren()) {
                        try {
                            String uri_image = dsp.child("uri").getValue().toString();
                            if (!TextUtils.isEmpty(uri_image)) {
                                image_uri_array.add(uri_image);

                                Log.v("tesst_images", uri_image+"");
                            }
                        } catch (Exception e) {
                        }


                    }

                    Log.v("tesst_images",image_uri_array.size()+"");
                    Collections.reverse(image_uri_array);


                    slider2.setSliderAdapter(new Slideronline(image_uri_array));
                    slider2.setIndicatorAnimation(IndicatorAnimations.THIN_WORM);
                    slider2.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
                    slider2.setCurrentPagePosition(image_uri_array.size());
//        slider2.setScrollTimeInSec(3); //set scroll delay in seconds :
//        slider2.startAutoCycle();













                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    }

    @Override
    public void onResume() {
        super.onResume();
        Database_images();
    }

}