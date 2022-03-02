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

public class programming extends AppCompatActivity {
    ListView listView;
    ProgressDialog progressDialog;
    String[] chapter9 = {"C-Programming","C-CheatSheet","C++","C++ CheatSheet","Python","Python-CheatSheet"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programming);
        listView = findViewById(R.id.programlist);

        progressDialog = new ProgressDialog(programming.this);
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

        getSupportActionBar().setTitle("Programming (Downloadable Files)");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,chapter9);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView< ? > parent, View view, int position, long id) {
                String s=parent.getItemAtPosition(position).toString();

                if(s.equalsIgnoreCase("C-Programming")){
                    Intent intent = new Intent(programming.this, c.class);
                    intent.putExtra("Key1",s);
                    startActivity(intent);

                } else  if(s.equalsIgnoreCase("C++")){
                    Intent intent = new Intent(programming.this, c.class);
                    intent.putExtra("Key1",s);
                    startActivity(intent);

                } else if (s.equalsIgnoreCase("C-CheatSheet")){
                    Intent intent = new Intent(programming.this, c.class);
                    intent.putExtra("Key1",s);
                    startActivity(intent);

                } else if (s.equalsIgnoreCase("C++ CheatSheet")){
                    Intent intent = new Intent(programming.this, c.class);
                    intent.putExtra("Key1",s);
                    startActivity(intent);
                } else if (s.equalsIgnoreCase("Python-CheatSheet")){
                    Intent intent = new Intent(programming.this, c.class);
                    intent.putExtra("Key1",s);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(programming.this, c.class);
                    intent.putExtra("Key1",s);
                    startActivity(intent);
                }
            }
        });


    }
}