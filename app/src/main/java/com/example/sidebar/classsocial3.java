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

public class classsocial3 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    ProgressDialog progressDialog;
    ListView listView;

    String[] chapter9= {
            "Chapter-1:People As Resources",
            "Chapter-2:Story of Palampur",
            "Chapter-3:Poverty as Challenge",
            "Chapter-4:Food Security In India"
    };

    String[] chapter10 = {
            "Chapter-1:Consumer Rights",
            "Chapter-2:Development",
            "Chapter-3:Globalization & The Indian Economy",
            "Chapter-4:Money & Credit",
            "Chapter-5:Sectors of the Indian Economy"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classsocial3);

        listView = findViewById(R.id.listView7);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        String id = firebaseUser.getUid();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("content").child(id);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                String value = snapshot.child("spinner1").getValue(String.class);
                progressDialog = new ProgressDialog(classsocial3.this);
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
                    getSupportActionBar().setTitle("Economics");
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView< ? > parent, View view, int position, long id) {
                            String values = parent.getItemAtPosition(position).toString();
                            if (values.equalsIgnoreCase("Chapter-1:People As Resources")) {
                                Intent intent = new Intent(classsocial3.this, ChapterCalling5.class);
                                intent.putExtra("ChapterName6", values);
                                startActivity(intent);
                            } else if (values.equalsIgnoreCase("Chapter-2:Story of Palampur")) {
                                Intent intent = new Intent(classsocial3.this, ChapterCalling5.class);
                                intent.putExtra("ChapterName6", values);
                                startActivity(intent);
                            } else if (values.equalsIgnoreCase("Chapter-3:Poverty as Challenge")) {
                                Intent intent = new Intent(classsocial3.this, ChapterCalling5.class);
                                intent.putExtra("ChapterName6", values);
                                startActivity(intent);
                            } else if (values.equalsIgnoreCase("Chapter-4:Food Security In India")) {
                                Intent intent = new Intent(classsocial3.this, ChapterCalling5.class);
                                intent.putExtra("ChapterName6", values);
                                startActivity(intent);
                            }
                        }
                    });

                } else if(value.equalsIgnoreCase("10th Class")){
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,chapter9);
                    listView.setAdapter(arrayAdapter);
                   getSupportActionBar().setTitle("Economics");
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView< ? > parent, View view, int position, long id) {
                            String values = parent.getItemAtPosition(position).toString();
                            if (values.equalsIgnoreCase("Chapter-1:Consumer Rights")) {
                                Intent intent = new Intent(classsocial3.this, ChapterCalling5.class);
                                intent.putExtra("ChapterName1", values);
                                startActivity(intent);
                            } else if (values.equalsIgnoreCase("Chapter-2:Development")) {
                                Intent intent = new Intent(classsocial3.this, ChapterCalling5.class);
                                intent.putExtra("ChapterName1", values);
                                startActivity(intent);
                            } else if (values.equalsIgnoreCase("Chapter-3:Globalization & The Indian Economy")) {
                                Intent intent = new Intent(classsocial3.this, ChapterCalling5.class);
                                intent.putExtra("ChapterName1", values);
                                startActivity(intent);
                            } else if (values.equalsIgnoreCase("Chapter-4:Money & Credit")) {
                                Intent intent = new Intent(classsocial3.this, ChapterCalling5.class);
                                intent.putExtra("ChapterName1", values);
                                startActivity(intent);
                            } else if (values.equalsIgnoreCase("Chapter-5:Sectors of the Indian Economy")) {
                                Intent intent = new Intent(classsocial3.this, ChapterCalling5.class);
                                intent.putExtra("ChapterName1", values);
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