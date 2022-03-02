package com.example.sidebar.fragment;

import android.animation.LayoutTransition;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sidebar.R;

import java.util.ArrayList;
import java.util.List;


public class faq extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public faq() {

    }

    public static faq newInstance(String param1, String param2) {
        faq fragment = new faq();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    RecyclerView recyclerView;
    List<faqclass> qlist;

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
        View view = inflater.inflate(R.layout.fragment_faq, container, false);
        recyclerView = view.findViewById(R.id.recycle);

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

        qlist.add(new faqclass("Q.For whom this app beneficial?","=>For cbse students from class 9th to 12th."));
        qlist.add(new faqclass("Q.Is this app available in AppStore also?","=>No,this app is available in playStore only."));
        qlist.add(new faqclass("Q.What extra subject being provided by this app?","=>It provided extra curriculum like programming languages ,web development,etc."));
        qlist.add(new faqclass("Q.Which features make this app unique?","=>It having special features like text detection,musicfy,educational related news,etc."));
        qlist.add(new faqclass("Q.Is this app available in offline mode?","=>No,you need give permission to your net to access this app."));
    }
}