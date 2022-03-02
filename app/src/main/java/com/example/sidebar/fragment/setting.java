package com.example.sidebar.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sidebar.R;

import java.util.ArrayList;
import java.util.List;

public class setting extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public setting() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static setting newInstance(String param1, String param2) {
        setting fragment = new setting();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    RecyclerView recyclerView;
    List<faqclass> qlist;
    Button button;

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
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        recyclerView = view.findViewById(R.id.recycle);
        button = view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.termsfeed.com/live/dab4ec8c-f1d0-4145-b31d-ff0589dc5ea5");
            }
        });

        initData();
        setRecyclerView();
        return view;
    }

    private void setRecyclerView() {

        faqAdapter faqAdapter = new faqAdapter(qlist);
        recyclerView.setAdapter(faqAdapter);
        recyclerView.setHasFixedSize(true);

    }

    private void initData() {
        qlist = new ArrayList<>();
        String t = "https://www.termsfeed.com/live/dab4ec8c-f1d0-4145-b31d-ff0589dc5ea5";


        qlist.add(new faqclass("About Us","=>This application is made by four youngsters Aniket Dwivedi, Chaitanya Mhaiskar, Mayank Hooda, Pankaj Rampal who believe to innovate new and helpful thinks which benefit all new generation people."));
        qlist.add(new faqclass("Support","=>Facing any issue during using the please mail on contentguru724@gmail.com."));
        qlist.add(new faqclass("About App","=>This application is about providing quality of content with high quality of education."));
        qlist.add(new faqclass("Branch Office","=>PDM UNIVERSITY" +
                                                            " Sector 3 , Bahadurgarh."));
    }

    private void gotoUrl(String t) {
        Uri uri = Uri.parse(t);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}