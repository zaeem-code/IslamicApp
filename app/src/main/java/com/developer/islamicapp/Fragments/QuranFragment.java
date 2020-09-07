package com.developer.islamicapp.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.developer.islamicapp.Activities.Beautiful_recitation_Activity;
import com.developer.islamicapp.Activities.QuranActivity;
import com.developer.islamicapp.Activities.QuraninfoActivity;
import com.developer.islamicapp.Activities.SearchActivity;
import com.developer.islamicapp.R;
import com.developer.islamicapp.utils.Typcastregular;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuranFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuranFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ImageView quran,quraninfo,search,recitation,translation;
    private TextView quran_text,quraninfo_text
            ,search_text,recitation_text,
            translation_text;
    private View view;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public QuranFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuranFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuranFragment newInstance(String param1, String param2) {
        QuranFragment fragment = new QuranFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

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

        view =inflater.inflate(R.layout.fragment_quran, container, false);
quran=view.findViewById(R.id.quran); quran.setOnClickListener(this);
quraninfo=view.findViewById(R.id.quraninfo); quraninfo.setOnClickListener(this);
search=view.findViewById(R.id.search); search.setOnClickListener(this);
recitation=view.findViewById(R.id.recitation); recitation.setOnClickListener(this);
translation=view.findViewById(R.id.transalate); translation.setOnClickListener(this);
quran_text=view.findViewById(R.id.quran_text); quran_text.setOnClickListener(this);
quraninfo_text=view.findViewById(R.id.quraninfo_text); quraninfo_text.setOnClickListener(this);
search_text=view.findViewById(R.id.search_text); search_text.setOnClickListener(this);
recitation_text=view.findViewById(R.id.recitation_text); recitation_text.setOnClickListener(this);
translation_text=view.findViewById(R.id.transalate_text); translation_text.setOnClickListener(this);

        return view;


    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.quran:
            case R.id.quran_text:
               startActivity(new Intent(getContext(), QuranActivity.class));
               break;

            case R.id.quraninfo:
            case R.id.quraninfo_text:
                startActivity(new Intent(getContext(), QuraninfoActivity.class));

            break;


            case R.id.search:
            case R.id.search_text:
                startActivity(new Intent(getContext(), SearchActivity.class));
            break;


            case R.id.transalate:
            case R.id.transalate_text:
//                Toast.makeText(getContext(), ""+v.getId(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(), Beautiful_recitation_Activity.class).putExtra("process","urdu"));

                break;

            case R.id.recitation:
            case R.id.recitation_text:

//                Toast.makeText(getContext(), ""+v.getId(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(), Beautiful_recitation_Activity.class).putExtra("process","rec"));

                break;

        }
    }
}