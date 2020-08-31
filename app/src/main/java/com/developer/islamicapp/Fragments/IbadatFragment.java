package com.developer.islamicapp.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developer.islamicapp.Activities.NamazActivit_details;
import com.developer.islamicapp.Activities.NamazActivity;
import com.developer.islamicapp.Activities.TasbHIActivity;
import com.developer.islamicapp.R;
import com.developer.islamicapp.Activities.ZikarActivity;
import com.developer.islamicapp.utils.Typcastregular;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IbadatFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IbadatFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public IbadatFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IbadatFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static IbadatFragment newInstance(String param1, String param2) {
        IbadatFragment fragment = new IbadatFragment();
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
        // Inflate the layout for this fragment
        Typcastregular.Typcastregular(getContext(), "SERIF", "Poppins-Regular.otf");

        view= inflater.inflate(R.layout.fragment_ibadat, container, false);
        view.findViewById(R.id.Tasbeh).setOnClickListener(this);
        view.findViewById(R.id.Zikar).setOnClickListener(this);
        view.findViewById(R.id.Namaz).setOnClickListener(this);
        view.findViewById(R.id.Roza).setOnClickListener(this);
        view.findViewById(R.id.Hajj).setOnClickListener(this);
        view.findViewById(R.id.Zakat).setOnClickListener(this);
        view.findViewById(R.id.Umrah).setOnClickListener(this);

        view.findViewById(R.id.zero).setOnClickListener(this);
        view.findViewById(R.id.zerot).setOnClickListener(this);

        view.findViewById(R.id.one).setOnClickListener(this);
        view.findViewById(R.id.onet).setOnClickListener(this);

        view.findViewById(R.id.two).setOnClickListener(this);
        view.findViewById(R.id.twot).setOnClickListener(this);

        view.findViewById(R.id.three).setOnClickListener(this);
        view.findViewById(R.id.threet).setOnClickListener(this);

        view.findViewById(R.id.four).setOnClickListener(this);
        view.findViewById(R.id.fourt).setOnClickListener(this);

        view.findViewById(R.id.five).setOnClickListener(this);
        view.findViewById(R.id.fivet).setOnClickListener(this);

        view.findViewById(R.id.six).setOnClickListener(this);
        view.findViewById(R.id.sixt).setOnClickListener(this);



        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Tasbeh:
            case R.id.zero:
            case R.id.zerot:

                startActivity(new Intent(getContext(), TasbHIActivity.class));

                break;


            case R.id.Zikar:
            case R.id.one:
            case R.id.onet:

                startActivity(new Intent(getContext(), ZikarActivity.class));
                break;


            case R.id.Namaz:
            case R.id.two:
            case R.id.twot:

                startActivity(new Intent(getContext(), NamazActivity.class));

                break;


            case R.id.Hajj:
            case R.id.three:
            case R.id.threet:

                startActivity(new Intent(getContext(), NamazActivit_details.class)
                        .putExtra("chk","Hajj"));

                break;

            case R.id.Roza:
            case R.id.four:
            case R.id.fourt:


                startActivity(new Intent(getContext(), NamazActivit_details.class)
                        .putExtra("chk","Roza"));
                break;


            case R.id.Zakat:
            case R.id.five:
            case R.id.fivet:

                startActivity(new Intent(getContext(), NamazActivit_details.class)
                        .putExtra("chk","Zakat"));
                break;


            case R.id.Umrah:
            case R.id.six:
            case R.id.sixt:


                startActivity(new Intent(getContext(), NamazActivit_details.class)
                        .putExtra("chk","Umrah"));
                break;



        }
    }
}