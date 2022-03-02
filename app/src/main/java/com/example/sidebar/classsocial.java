package com.example.sidebar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;

public class classsocial extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    ProgressDialog progressDialog;
    TextView textView;
    ListView listView;

    String[] chapter9 = {"Chapter-1:India Size & Location",
            "Chapter-2:Physical Feature of India",
            "Chapter-3:Drainage",
            "Chapter-4:Climate",
            "Chapter-5:Natural Vegetation & Wildlife",
            "Chapter-6:Population"};

    String[] chapter10 = {
            "Chapter-1:Agriculture",
            "Chapter-2:Lifelines of National Economy",
            "Chapter-3:Manufacturing Industries",
            "Chapter-4:Minerals & Energy Resources",
            "Chapter-5:Resources & Development",
            "Chapter-6:Water Resources"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classsocial);

        listView = findViewById(R.id.listView4);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        String id = firebaseUser.getUid();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("content").child(id);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                String value = snapshot.child("spinner1").getValue(String.class);
                progressDialog = new ProgressDialog(classsocial.this);
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

                if(value.equalsIgnoreCase("9th Class")){
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,chapter9);
                    listView.setAdapter(arrayAdapter);
                    getSupportActionBar().setTitle("Geography");
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView< ? > parent, View view, int position, long id) {
                            String values = parent.getItemAtPosition(position).toString();
                                if (values.equalsIgnoreCase("Chapter-1:India Size & Location")) {
                                    Intent intent = new Intent(classsocial.this, ChapterCalling3.class);
                                    intent.putExtra("ChapterName3", values);
                                    startActivity(intent);
                                } else if (values.equalsIgnoreCase("Chapter-2:Physical Feature of India")) {
                                    Intent intent = new Intent(classsocial.this, ChapterCalling3.class);
                                    intent.putExtra("ChapterName3", values);
                                    startActivity(intent);
                                } else if (values.equalsIgnoreCase("Chapter-3:Drainage")) {
                                    Intent intent = new Intent(classsocial.this, ChapterCalling3.class);
                                    intent.putExtra("ChapterName3", values);
                                    startActivity(intent);
                                } else if (values.equalsIgnoreCase("Chapter-4:Climate")) {
                                    Intent intent = new Intent(classsocial.this, ChapterCalling3.class);
                                    intent.putExtra("ChapterName3", values);
                                    startActivity(intent);
                                } else if (values.equalsIgnoreCase("Chapter-5:Natural Vegetation & Wildlife")) {
                                    Intent intent = new Intent(classsocial.this, ChapterCalling3.class);
                                    intent.putExtra("ChapterName3", values);
                                    startActivity(intent);
                                } else if (values.equalsIgnoreCase("Chapter-6:Population")) {
                                    Intent intent = new Intent(classsocial.this, ChapterCalling3.class);
                                    intent.putExtra("ChapterName3", values);
                                    startActivity(intent);
                                }
                            }
                    });

                } else if(value.equalsIgnoreCase("10th Class")){
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,chapter9);
                    listView.setAdapter(arrayAdapter);
                    getSupportActionBar().setTitle("Geography");
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView< ? > parent, View view, int position, long id) {
                            String values = parent.getItemAtPosition(position).toString();
                                if (values.equalsIgnoreCase("Chapter-1:Agriculture")) {
                                    Intent intent = new Intent(classsocial.this, ChapterCalling3.class);
                                    intent.putExtra("ChapterName3", values);
                                    startActivity(intent);
                                } else if (values.equalsIgnoreCase("Chapter-2:Lifelines of National Economy")) {
                                    Intent intent = new Intent(classsocial.this, ChapterCalling3.class);
                                    intent.putExtra("ChapterName3", values);
                                    startActivity(intent);
                                } else if (values.equalsIgnoreCase("Chapter-3:Manufacturing Industries")) {
                                    Intent intent = new Intent(classsocial.this, ChapterCalling3.class);
                                    intent.putExtra("ChapterName3", values);
                                    startActivity(intent);
                                } else if (values.equalsIgnoreCase("Chapter-4:Minerals & Energy Resources")) {
                                    Intent intent = new Intent(classsocial.this, ChapterCalling3.class);
                                    intent.putExtra("ChapterName3", values);
                                    startActivity(intent);
                                } else if (values.equalsIgnoreCase("Chapter-5:Resources & Development")) {
                                    Intent intent = new Intent(classsocial.this, ChapterCalling3.class);
                                    intent.putExtra("ChapterName3", values);
                                    startActivity(intent);
                                } else if (values.equalsIgnoreCase("Chapter-6:Water Resources")) {
                                    Intent intent = new Intent(classsocial.this, ChapterCalling3.class);
                                    intent.putExtra("ChapterName3", values);
                                    startActivity(intent);
                                }
                            }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        progressDialog.dismiss();
    }
}