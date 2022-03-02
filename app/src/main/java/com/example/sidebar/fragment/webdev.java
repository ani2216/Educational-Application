package com.example.sidebar.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sidebar.R;
import com.example.sidebar.c;
import com.example.sidebar.cc;

public class webdev extends AppCompatActivity {
    ListView listView;
    ProgressDialog progressDialog;
    String[] chapter9 = {"Full-Course","HTML-CheatSheet","CSS-CheatSheet","JavaScript-CheatSheet"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webdev);
        listView = findViewById(R.id.listweb);

        progressDialog = new ProgressDialog(webdev.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.progresssubject);
        progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        Runnable progressRunnable = new Runnable() {

            @Override
            public void run() {
                progressDialog.cancel();
            }
        };

        Handler pdCanceller = new Handler();
        pdCanceller.postDelayed(progressRunnable, 3000);

        getSupportActionBar().setTitle("Web Development (Downloadable Files)");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,chapter9);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView< ? > parent, View view, int position, long id) {
                String s=parent.getItemAtPosition(position).toString();

                if(s.equalsIgnoreCase("Full-Course")){
                    Intent intent = new Intent(webdev.this, cc.class);
                    intent.putExtra("Key2",s);
                    startActivity(intent);

                } else  if(s.equalsIgnoreCase("HTML-CheatSheet")){
                    Intent intent = new Intent(webdev.this, cc.class);
                    intent.putExtra("Key2",s);
                    startActivity(intent);

                } else if (s.equalsIgnoreCase("CSS-CheatSheet")){
                    Intent intent = new Intent(webdev.this, cc.class);
                    intent.putExtra("Key2",s);
                    startActivity(intent);

                } else if (s.equalsIgnoreCase("JavaScript-CheatSheet")){
                    Intent intent = new Intent(webdev.this, cc.class);
                    intent.putExtra("Key2",s);
                    startActivity(intent);
                }
            }
        });


    }
}