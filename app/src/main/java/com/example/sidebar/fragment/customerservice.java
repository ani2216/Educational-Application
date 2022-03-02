package com.example.sidebar.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.sidebar.R;
import com.google.android.material.snackbar.Snackbar;

public class customerservice extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    EditText subject, descrip;
    Button btn;

    private String mParam1;
    private String mParam2;


    public customerservice() {
    }

    public static customerservice newInstance(String param1, String param2) {
        customerservice fragment = new customerservice();
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
        View view = inflater.inflate(R.layout.fragment_customerservice, container, false);
        subject = view.findViewById(R.id.subject);
        descrip = view.findViewById(R.id.descrip);
        btn = view.findViewById(R.id.subbutton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL,new String[] {"contentguru724@gmail.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,subject.getText().toString());
                emailIntent.putExtra(Intent.EXTRA_TEXT,descrip.getText().toString());
                try {
                    if(!subject.getText().toString().isEmpty() && !descrip.getText().toString().isEmpty()) {
                        startActivity(emailIntent);
                        subject.setText("");
                        descrip.setText("");
                    } else {
                        Toast.makeText(getContext(), "Empty Field", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e){
                    Snackbar snackbar=Snackbar.make(view,"Can't access Email from this device.",Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }
        });

        return view;
    }

}