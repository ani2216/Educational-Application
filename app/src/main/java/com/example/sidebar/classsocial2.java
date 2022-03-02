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

public class classsocial2 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    ProgressDialog progressDialog;
    TextView textView;
    ListView listView;

    String[] chapter9 = {"Chapter-1:Democracy in the Contemporary World",
            "Chapter-2:What is Democracy & Why Democracy?",
            "Chapter-3:Constitutional Design",
            "Chapter-4:Electoral Design",
            "Chapter-5:Working of Institutions",
            "Chapter-6:Democratic Rights"};

    String[] chapter10 = {
            "Chapter-1:Power Sharing",
            "Chapter-2:Federalism",
            "Chapter-3:Democracy and Diversity",
            "Chapter-4:Gender, Religion and Caste",
            "Chapter-5:Popular Struggles and Movements",
            "Chapter-6:Political Parties",
            "Chapter-7:Outcomes of Democracy",
            "Chapter-8:Challenges to Democracy"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classsocial2);

        listView = findViewById(R.id.listView6);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        String id = firebaseUser.getUid();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("content").child(id);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                String value = snapshot.child("spinner1").getValue(String.class);
                progressDialog = new ProgressDialog(classsocial2.this);
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
                    getSupportActionBar().setTitle("Polity");
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView< ? > parent, View view, int position, long id) {
                            String values = parent.getItemAtPosition(position).toString();
                            if (values.equalsIgnoreCase("Chapter-1:Democracy in the Contemporary World")) {
                                Intent intent = new Intent(classsocial2.this, ChapterCalling6.class);
                                intent.putExtra("ChapterName5", values);
                                startActivity(intent);
                            } else if (values.equalsIgnoreCase("Chapter-2:What is Democracy & Why Democracy?")) {
                                Intent intent = new Intent(classsocial2.this, ChapterCalling6.class);
                                intent.putExtra("ChapterName5", values);
                                startActivity(intent);
                            } else if (values.equalsIgnoreCase("Chapter-3:Constitutional Design")) {
                                Intent intent = new Intent(classsocial2.this, ChapterCalling6.class);
                                intent.putExtra("ChapterName5", values);
                                startActivity(intent);
                            } else if (values.equalsIgnoreCase("Chapter-4:Electoral Design")) {
                                Intent intent = new Intent(classsocial2.this, ChapterCalling6.class);
                                intent.putExtra("ChapterName5", values);
                                startActivity(intent);
                            } else if (values.equalsIgnoreCase("Chapter-5:Working of Institutions")) {
                                Intent intent = new Intent(classsocial2.this, ChapterCalling6.class);
                                intent.putExtra("ChapterName5", values);
                                startActivity(intent);
                            } else if (values.equalsIgnoreCase("Chapter-6:Democratic Rights")) {
                                Intent intent = new Intent(classsocial2.this, ChapterCalling6.class);
                                intent.putExtra("ChapterName5", values);
                                startActivity(intent);
                            }
                        }
                    });

                } else if(value.equalsIgnoreCase("10th Class")){
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,chapter9);
                    listView.setAdapter(arrayAdapter);
                    getSupportActionBar().setTitle("Polity");
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView< ? > parent, View view, int position, long id) {
                            String values = parent.getItemAtPosition(position).toString();
                            if (values.equalsIgnoreCase("Chapter-1:Power Sharing")) {
                                Intent intent = new Intent(classsocial2.this, ChapterCalling6.class);
                                intent.putExtra("ChapterName1", values);
                                startActivity(intent);
                            } else if (values.equalsIgnoreCase("Chapter-2:Federalism")) {
                                Intent intent = new Intent(classsocial2.this, ChapterCalling6.class);
                                intent.putExtra("ChapterName1", values);
                                startActivity(intent);
                            } else if (values.equalsIgnoreCase("Chapter-3:Democracy and Diversity")) {
                                Intent intent = new Intent(classsocial2.this, ChapterCalling6.class);
                                intent.putExtra("ChapterName1", values);
                                startActivity(intent);
                            } else if (values.equalsIgnoreCase("Chapter-4:Gender, Religion and Caste")) {
                                Intent intent = new Intent(classsocial2.this, ChapterCalling6.class);
                                intent.putExtra("ChapterName1", values);
                                startActivity(intent);
                            } else if (values.equalsIgnoreCase("Chapter-5:Popular Struggles and Movements")) {
                                Intent intent = new Intent(classsocial2.this, ChapterCalling6.class);
                                intent.putExtra("ChapterName1", values);
                                startActivity(intent);
                            } else if (values.equalsIgnoreCase("Chapter-6:Political Parties")) {
                                Intent intent = new Intent(classsocial2.this, ChapterCalling6.class);
                                intent.putExtra("ChapterName1", values);
                                startActivity(intent);
                            }else if (values.equalsIgnoreCase("Chapter-7:Outcomes of Democracy")) {
                                Intent intent = new Intent(classsocial2.this, ChapterCalling6.class);
                                intent.putExtra("ChapterName1", values);
                                startActivity(intent);
                            }else if (values.equalsIgnoreCase("Chapter-8:Challenges to Democracy")) {
                                Intent intent = new Intent(classsocial2.this, ChapterCalling6.class);
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