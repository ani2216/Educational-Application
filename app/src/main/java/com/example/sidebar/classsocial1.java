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

import org.jetbrains.annotations.NotNull;

public class classsocial1 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    ProgressDialog progressDialog;
    TextView textView;
    ListView listView;

    String[] chapter9 = {"Chapter-1:The French Revolution",
            "Chapter-2:Socialism In Europe",
            "Chapter-3:Nazism & The Rise of Hitler",
            "Chapter-4:Forest Society & Colonialism",
            "Chapter-5:Pastoralists In The Modern World",
            "Chapter-6:Peasants & Farmers",
            "Chapter-7:History & Sport - The Story Of Cricket",
            "Chapter-8:Clothing - A Social History"};

    String[] chapter10 = {
            "Chapter-1:The Making of Global World",
            "Chapter-2:The Age of Industrialization",
            "Chapter-3:Print Culture and The Modern World",
            "Chapter-4:Nationalism In India",
            "Chapter-5:Nationalism and Imperialism"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classsocial1);

        listView = findViewById(R.id.listView5);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        String id = firebaseUser.getUid();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("content").child(id);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                String value = snapshot.child("spinner1").getValue(String.class);
                progressDialog = new ProgressDialog(classsocial1.this);
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
                    getSupportActionBar().setTitle("History");
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView< ? > parent, View view, int position, long id) {
                            String values = parent.getItemAtPosition(position).toString();
                            if (values.equalsIgnoreCase("Chapter-1:The French Revolution")) {
                                Intent intent = new Intent(classsocial1.this, ChapterCalling4.class);
                                intent.putExtra("ChapterName4", values);
                                startActivity(intent);
                            } else if (values.equalsIgnoreCase("Chapter-2:Socialism In Europe")) {
                                Intent intent = new Intent(classsocial1.this, ChapterCalling4.class);
                                intent.putExtra("ChapterName4", values);
                                startActivity(intent);
                            } else if (values.equalsIgnoreCase("Chapter-3:Nazism & The Rise of Hitler")) {
                                Intent intent = new Intent(classsocial1.this, ChapterCalling4.class);
                                intent.putExtra("ChapterName4", values);
                                startActivity(intent);
                            } else if (values.equalsIgnoreCase("Chapter-4:Forest Society & Colonialism")) {
                                Intent intent = new Intent(classsocial1.this, ChapterCalling4.class);
                                intent.putExtra("ChapterName4", values);
                                startActivity(intent);
                            } else if (values.equalsIgnoreCase("Chapter-5:Pastoralists In The Modern World")) {
                                Intent intent = new Intent(classsocial1.this, ChapterCalling4.class);
                                intent.putExtra("ChapterName4", values);
                                startActivity(intent);
                            } else if (values.equalsIgnoreCase("Chapter-6:Peasants & Farmers")) {
                                Intent intent = new Intent(classsocial1.this, ChapterCalling4.class);
                                intent.putExtra("ChapterName4", values);
                                startActivity(intent);
                            }else if (values.equalsIgnoreCase("Chapter-7:History & Sport - The Story Of Cricket")) {
                                Intent intent = new Intent(classsocial1.this, ChapterCalling4.class);
                                intent.putExtra("ChapterName4", values);
                                startActivity(intent);
                            }else if (values.equalsIgnoreCase("Chapter-8:Clothing - A Social History")) {
                                Intent intent = new Intent(classsocial1.this, ChapterCalling4.class);
                                intent.putExtra("ChapterName4", values);
                                startActivity(intent);
                            }
                        }
                    });

                } else if(value.equalsIgnoreCase("10th Class")){
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,chapter9);
                    listView.setAdapter(arrayAdapter);
                    getSupportActionBar().setTitle("History");
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView< ? > parent, View view, int position, long id) {
                            String values = parent.getItemAtPosition(position).toString();
                            if (values.equalsIgnoreCase("Chapter-1:The Making of Global World")) {
                                Intent intent = new Intent(classsocial1.this, ChapterCalling4.class);
                                intent.putExtra("ChapterName1", values);
                                startActivity(intent);
                            } else if (values.equalsIgnoreCase("Chapter-2:The Age of Industrialization")) {
                                Intent intent = new Intent(classsocial1.this, ChapterCalling4.class);
                                intent.putExtra("ChapterName1", values);
                                startActivity(intent);
                            } else if (values.equalsIgnoreCase("Chapter-3:Print Culture and The Modern World")) {
                                Intent intent = new Intent(classsocial1.this, ChapterCalling4.class);
                                intent.putExtra("ChapterName1", values);
                                startActivity(intent);
                            } else if (values.equalsIgnoreCase("Chapter-4:Nationalism In India")) {
                                Intent intent = new Intent(classsocial1.this, ChapterCalling4.class);
                                intent.putExtra("ChapterName1", values);
                                startActivity(intent);
                            } else if (values.equalsIgnoreCase("Chapter-5:Nationalism and Imperialism")) {
                                Intent intent = new Intent(classsocial1.this, ChapterCalling4.class);
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