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
import com.example.sidebar.classsocial;
import com.example.sidebar.englishCalling;

public class english10 extends AppCompatActivity {
    ProgressDialog progressDialog;
    ListView listView;
    String[] chapter10 = {
            "Chapter-1:Two Gentlemen of Verona",
            "Chapter-2:Mrs. Packletide's Tiger",
            "Chapter-3:The Letter",
            "Chapter-4:A Shady Plot",
            "Chapter-5:Patol Babu, Film Star",
            "Chapter-6:Virtually True",
            "Chapter-7:The Frog and the Nightingale",
            "Chapter-8:Mirror",
            "Chapter-9:Not Marble nor the Gilded Monuments",
            "Chapter-10:Ozymandias",
            "Chapter-11:The Rime of the Ancient Mariner",
            "Chapter-12:Snake",
            "Chapter-13:The Dear Departed",
            "Chapter-14:Julius Caesar",
            "Extra1-Grammar Notes",
            "Extra2-Reading Notes",
            "Extra3-Writing Notes"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english10);
        listView = findViewById(R.id.listView8);

        progressDialog = new ProgressDialog(english10.this);
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

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,chapter10);
        listView.setAdapter(arrayAdapter);
        getSupportActionBar().setTitle("English");
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView< ? > parent, View view, int position, long id) {
                String value = parent.getItemAtPosition(position).toString();

                if(value.equalsIgnoreCase("Chapter-1:Two Gentlemen of Verona")){
                    Intent intent = new Intent(english10.this,englishCalling.class);
                    intent.putExtra("KeyEnglish",value);
                    startActivity(intent);
                }else  if(value.equalsIgnoreCase("Chapter-2:Mrs. Packletide's Tiger")){
                    Intent intent = new Intent(english10.this,englishCalling.class);
                    intent.putExtra("KeyEnglish",value);
                    startActivity(intent);
                }else  if(value.equalsIgnoreCase("Chapter-3:The Letter")){
                    Intent intent = new Intent(english10.this,englishCalling.class);
                    intent.putExtra("KeyEnglish",value);
                    startActivity(intent);
                }else  if(value.equalsIgnoreCase("Chapter-4:A Shady Plot")){
                    Intent intent = new Intent(english10.this,englishCalling.class);
                    intent.putExtra("KeyEnglish",value);
                    startActivity(intent);
                }else  if(value.equalsIgnoreCase("Chapter-5:Patol Babu, Film Star")){
                    Intent intent = new Intent(english10.this,englishCalling.class);
                    intent.putExtra("KeyEnglish",value);
                    startActivity(intent);
                }else  if(value.equalsIgnoreCase("Chapter-6:Virtually True")){
                    Intent intent = new Intent(english10.this,englishCalling.class);
                    intent.putExtra("KeyEnglish",value);
                    startActivity(intent);
                }else  if(value.equalsIgnoreCase("Chapter-7:The Frog and the Nightingale")){
                    Intent intent = new Intent(english10.this,englishCalling.class);
                    intent.putExtra("KeyEnglish",value);
                    startActivity(intent);
                }else  if(value.equalsIgnoreCase("Chapter-8:Mirror")){
                    Intent intent = new Intent(english10.this,englishCalling.class);
                    intent.putExtra("KeyEnglish",value);
                    startActivity(intent);
                }else  if(value.equalsIgnoreCase("Chapter-9:Not Marble nor the Gilded Monuments")){
                    Intent intent = new Intent(english10.this,englishCalling.class);
                    intent.putExtra("KeyEnglish",value);
                    startActivity(intent);
                }else  if(value.equalsIgnoreCase("Chapter-10:Ozymandias")){
                    Intent intent = new Intent(english10.this,englishCalling.class);
                    intent.putExtra("KeyEnglish",value);
                    startActivity(intent);
                }else  if(value.equalsIgnoreCase("Chapter-11:The Rime of the Ancient Mariner")){
                    Intent intent = new Intent(english10.this,englishCalling.class);
                    intent.putExtra("KeyEnglish",value);
                    startActivity(intent);
                }else  if(value.equalsIgnoreCase("Chapter-12:Snake")){
                    Intent intent = new Intent(english10.this,englishCalling.class);
                    intent.putExtra("KeyEnglish",value);
                    startActivity(intent);
                }else  if(value.equalsIgnoreCase("Chapter-13:The Dear Departed")){
                    Intent intent = new Intent(english10.this,englishCalling.class);
                    intent.putExtra("KeyEnglish",value);
                    startActivity(intent);
                }else  if(value.equalsIgnoreCase("Chapter-14:Julius Caesar")){
                    Intent intent = new Intent(english10.this,englishCalling.class);
                    intent.putExtra("KeyEnglish",value);
                    startActivity(intent);
                }else  if(value.equalsIgnoreCase("Extra1-Grammar Notes")){
                    Intent intent = new Intent(english10.this,englishCalling.class);
                    intent.putExtra("KeyEnglish",value);
                    startActivity(intent);
                }else  if(value.equalsIgnoreCase("Extra2-Reading Notes")){
                    Intent intent = new Intent(english10.this, englishCalling.class);
                    intent.putExtra("KeyEnglish",value);
                    startActivity(intent);
                }else  if(value.equalsIgnoreCase("Extra3-Writing Notes")){
                    Intent intent = new Intent(english10.this,englishCalling.class);
                    intent.putExtra("KeyEnglish",value);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        progressDialog.dismiss();
    }
}