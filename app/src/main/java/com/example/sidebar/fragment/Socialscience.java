package com.example.sidebar.fragment;

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

import com.example.sidebar.ChapterCalling;
import com.example.sidebar.ChapterCalling3;
import com.example.sidebar.R;
import com.example.sidebar.classsocial;
import com.example.sidebar.classsocial1;
import com.example.sidebar.classsocial2;
import com.example.sidebar.classsocial3;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class Socialscience extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    ProgressDialog progressDialog;
    ListView listView;

    String[] chapter9 = {"Geography","History","Polity","Economics"};
    String[] chapter11={
            "Chapter-1:Some Basic Concepts of Chemistry",
            "Chapter-2:Structure Of The Atom",
            "Chapter-3:Classification of Elements and Periodicity in Properties",
            "Chapter-4:Chemical Bonding and Molecular Structure",
            "Chapter-5:States of Matter",
            "Chapter-6:Thermodynamics",
            "Chapter-7:Equilibrium",
            "Chapter-8:Redox Reactions",
            "Chapter-9:Hydrogen",
            "Chapter-10:The s-Block Elements",
            "Chapter-11:The p-Block Elements",
            "Chapter-12:Organic Chemistry: Some Basic Principles and Techniques",
            "Chapter-13:Hydrocarbons",
            "Chapter-14:Environmental Chemistry",
    };

    String[] chapter12 = {
            "Chapter-1:The Solid State",
            "Chapter-2:Solutions",
            "Chapter-3:Electro chemistry",
            "Chapter-4:Chemical Kinetics",
            "Chapter-5:Surface Chemistry",
            "Chapter-6:General Principles and Processes of Isolation of Elements",
            "Chapter-7:The p Block Elements",
            "Chapter-8:The d and f Block Elements",
            "Chapter-9:Coordination Compounds",
            "Chapter-10:Haloalkanes and Haloarenes",
            "Chapter-11:Alcohols Phenols and Ethers",
            "Chapter-12:Aldehydes Ketones and Carboxylic Acids",
            "Chapter-13:Amines",
            "Chapter-14:Biomolecules",
            "Chapter-15:Polymers",
            "Chapter-16:Chemistry in Everyday Life"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socialscience);

        listView = findViewById(R.id.listView3);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        String id = firebaseUser.getUid();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("content").child(id);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                String value = snapshot.child("spinner1").getValue(String.class);
                progressDialog = new ProgressDialog(Socialscience.this);
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
                    getSupportActionBar().setTitle("Social Science");
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView< ? > parent, View view, int position, long id) {
                            String values = parent.getItemAtPosition(position).toString();

                            if(values.equalsIgnoreCase("Geography")){
                                Intent intent = new Intent(Socialscience.this, classsocial.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            } else if(values.equalsIgnoreCase("History")){
                                Intent intent = new Intent(Socialscience.this, classsocial1.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase("Polity")){
                                Intent intent = new Intent(Socialscience.this, classsocial2.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Economics")){
                                Intent intent = new Intent(Socialscience.this, classsocial3.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }
                        }
                    });

                } else if(value.equalsIgnoreCase("10th Class")){
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,chapter9);
                    listView.setAdapter(arrayAdapter);
                    getSupportActionBar().setTitle("Social Science");
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView< ? > parent, View view, int position, long id) {
                            String values = parent.getItemAtPosition(position).toString();

                            if(values.equalsIgnoreCase("Geography")){
                                Intent intent = new Intent(Socialscience.this, classsocial.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            } else if(values.equalsIgnoreCase("History")){
                                Intent intent = new Intent(Socialscience.this, classsocial1.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase("Polity")){
                                Intent intent = new Intent(Socialscience.this, classsocial2.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Economics")){
                                Intent intent = new Intent(Socialscience.this, classsocial3.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }
                        }
                    });
                } else if(value.equalsIgnoreCase("11th Class")){
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,chapter11);
                    listView.setAdapter(arrayAdapter);
                    getSupportActionBar().setTitle("Chemistry");
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView< ? > parent, View view, int position, long id) {
                            String values = parent.getItemAtPosition(position).toString();
                            if(values.equalsIgnoreCase("Chapter-1:Some Basic Concepts of Chemistry")){
                                Intent intent = new Intent(Socialscience.this, ChapterCalling3.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-2:Structure Of The Atom")){
                                Intent intent = new Intent(Socialscience.this, ChapterCalling3.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-3:Classification of Elements and Periodicity in Properties")){
                                Intent intent = new Intent(Socialscience.this, ChapterCalling3.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-4:Chemical Bonding and Molecular Structure")){
                                Intent intent = new Intent(Socialscience.this, ChapterCalling3.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-5:States of Matter")){
                                Intent intent = new Intent(Socialscience.this, ChapterCalling3.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-6:Thermodynamics")){
                                Intent intent = new Intent(Socialscience.this, ChapterCalling3.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-7:Equilibrium")){
                                Intent intent = new Intent(Socialscience.this, ChapterCalling3.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-8:Redox Reactions")){
                                Intent intent = new Intent(Socialscience.this, ChapterCalling3.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-9:Hydrogen")){
                                Intent intent = new Intent(Socialscience.this, ChapterCalling3.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-10:The s-Block Elements")){
                                Intent intent = new Intent(Socialscience.this, ChapterCalling3.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-11:The p-Block Elements")){
                                Intent intent = new Intent(Socialscience.this, ChapterCalling3.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-12:Organic Chemistry: Some Basic Principles and Techniques")){
                                Intent intent = new Intent(Socialscience.this, ChapterCalling3.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-13:Hydrocarbons")){
                                Intent intent = new Intent(Socialscience.this, ChapterCalling3.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-14:Environmental Chemistry")){
                                Intent intent = new Intent(Socialscience.this, ChapterCalling3.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }
                        }
                    });
                } else if(value.equalsIgnoreCase("12th Class")){
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,chapter12);
                    listView.setAdapter(arrayAdapter);
                    getSupportActionBar().setTitle("Chemistry");
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView< ? > parent, View view, int position, long id) {
                            String values = parent.getItemAtPosition(position).toString();
                            if(values.equalsIgnoreCase(chapter12[0])){
                                Intent intent = new Intent(Socialscience.this,ChapterCalling3.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[1])){
                                Intent intent = new Intent(Socialscience.this,ChapterCalling3.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase(chapter12[2])){
                                Intent intent = new Intent(Socialscience.this,ChapterCalling3.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase(chapter12[3])){
                                Intent intent = new Intent(Socialscience.this,ChapterCalling3.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[4])){
                                Intent intent = new Intent(Socialscience.this,ChapterCalling3.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[5])){
                                Intent intent = new Intent(Socialscience.this,ChapterCalling3.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[6])){
                                Intent intent = new Intent(Socialscience.this,ChapterCalling3.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[7])){
                                Intent intent = new Intent(Socialscience.this,ChapterCalling3.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[8])){
                                Intent intent = new Intent(Socialscience.this,ChapterCalling3.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[9])){
                                Intent intent = new Intent(Socialscience.this,ChapterCalling3.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[10])){
                                Intent intent = new Intent(Socialscience.this,ChapterCalling3.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[11])){
                                Intent intent = new Intent(Socialscience.this,ChapterCalling3.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[12])){
                                Intent intent = new Intent(Socialscience.this,ChapterCalling3.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[13])){
                                Intent intent = new Intent(Socialscience.this,ChapterCalling3.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[14])){
                                Intent intent = new Intent(Socialscience.this,ChapterCalling3.class);
                                intent.putExtra("ChapterName2",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[15])){
                                Intent intent = new Intent(Socialscience.this,ChapterCalling3.class);
                                intent.putExtra("ChapterName2",values);
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