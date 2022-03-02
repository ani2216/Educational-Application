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

import com.example.sidebar.ChapterCalling5;
import com.example.sidebar.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class PhysicalEducation extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    ListView listView;
    ProgressDialog progressDialog;

    String[] chapter11 = {
            "Chapter-01:Changing Trends and Careers",
            "Chapter-02:Physical Fitness and Wellness",
            "Chapter-03:Olympic Movement",
            "Chapter-04:Yoga",
            "Chapter-05:Doping",
            "Chapter-06:Physical Activity Environment",
            "Chapter-07:Test and Measurement in Sports",
            "Chapter-08:Fundamental of Anatomy",
            "Chapter-09:Biomechanics in Sports",
            "Chapter-10:Psychology and Sports",
            "Chapter-11:Training in Sports",
    };

    String[] chapter12 = {
            "Ch-01:Planning in Sports",
            "Ch-02:Adventure Sports and Leadership Training",
            "Ch-03:Sports and Nutrition",
            "Ch-04:Correct Posture",
            "Ch-05:Children and Sports",
            "Ch-06:Women and Sports",
            "Ch-07:Test and Measurement in Sports",
            "Ch-08:Physiology and Sports",
            "Ch-09:Sports and Medicine",
            "Ch-10:Biomechanics and Sports",
            "Ch-11:Psychology and Sports",
            "Ch-12:Training in Sports"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physical_education);

        listView = findViewById(R.id.listView11);

        progressDialog = new ProgressDialog(PhysicalEducation.this);
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

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        String id = firebaseUser.getUid();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("content").child(id);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                String value = snapshot.child("spinner1").getValue(String.class);
                if(value.equalsIgnoreCase("11th Class")){
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,chapter11);
                    listView.setAdapter(arrayAdapter);
                    getSupportActionBar().setTitle("Physical Education");
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView< ? > parent, View view, int position, long id) {
                            String values = parent.getItemAtPosition(position).toString();
                            if(values.equalsIgnoreCase("Chapter-01:Changing Trends and Careers")){
                                Intent intent = new Intent(PhysicalEducation.this, ChapterCalling5.class);
                                intent.putExtra("PE",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-02:Physical Fitness and Wellness")){
                                Intent intent = new Intent(PhysicalEducation.this, ChapterCalling5.class);
                                intent.putExtra("PE",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-03:Olympic Movement")){
                                Intent intent = new Intent(PhysicalEducation.this, ChapterCalling5.class);
                                intent.putExtra("PE",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-04:Yoga")){
                                Intent intent = new Intent(PhysicalEducation.this, ChapterCalling5.class);
                                intent.putExtra("PE",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-05:Doping")){
                                Intent intent = new Intent(PhysicalEducation.this, ChapterCalling5.class);
                                intent.putExtra("PE",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-06:Physical Activity Environment")){
                                Intent intent = new Intent(PhysicalEducation.this, ChapterCalling5.class);
                                intent.putExtra("PE",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-07:Test and Measurement in Sports")){
                                Intent intent = new Intent(PhysicalEducation.this, ChapterCalling5.class);
                                intent.putExtra("PE",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-08:Fundamental of Anatomy")){
                                Intent intent = new Intent(PhysicalEducation.this, ChapterCalling5.class);
                                intent.putExtra("PE",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-09:Biomechanics in Sports")){
                                Intent intent = new Intent(PhysicalEducation.this, ChapterCalling5.class);
                                intent.putExtra("PE",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-10:Psychology and Sports")){
                                Intent intent = new Intent(PhysicalEducation.this, ChapterCalling5.class);
                                intent.putExtra("PE",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-11:Training in Sports")){
                                Intent intent = new Intent(PhysicalEducation.this, ChapterCalling5.class);
                                intent.putExtra("PE",values);
                                startActivity(intent);
                            }
                        }
                    });
                } else if(value.equalsIgnoreCase("12th Class")){
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,chapter12);
                    listView.setAdapter(arrayAdapter);
                    getSupportActionBar().setTitle("Physical Education");
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView< ? > parent, View view, int position, long id) {
                            String values = parent.getItemAtPosition(position).toString();
                            if(values.equalsIgnoreCase(chapter12[0])){
                                Intent intent = new Intent(PhysicalEducation.this,ChapterCalling5.class);
                                intent.putExtra("PE",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[1])){
                                Intent intent = new Intent(PhysicalEducation.this,ChapterCalling5.class);
                                intent.putExtra("PE",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[2])){
                                Intent intent = new Intent(PhysicalEducation.this,ChapterCalling5.class);
                                intent.putExtra("PE",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[3])){
                                Intent intent = new Intent(PhysicalEducation.this,ChapterCalling5.class);
                                intent.putExtra("PE",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[4])){
                                Intent intent = new Intent(PhysicalEducation.this,ChapterCalling5.class);
                                intent.putExtra("PE",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[5])){
                                Intent intent = new Intent(PhysicalEducation.this,ChapterCalling5.class);
                                intent.putExtra("PE",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[6])){
                                Intent intent = new Intent(PhysicalEducation.this,ChapterCalling5.class);
                                intent.putExtra("PE",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[7])){
                                Intent intent = new Intent(PhysicalEducation.this,ChapterCalling5.class);
                                intent.putExtra("PE",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[8])){
                                Intent intent = new Intent(PhysicalEducation.this,ChapterCalling5.class);
                                intent.putExtra("PE",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[9])){
                                Intent intent = new Intent(PhysicalEducation.this,ChapterCalling5.class);
                                intent.putExtra("PE",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[10])){
                                Intent intent = new Intent(PhysicalEducation.this,ChapterCalling5.class);
                                intent.putExtra("PE",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[11])){
                                Intent intent = new Intent(PhysicalEducation.this,ChapterCalling5.class);
                                intent.putExtra("PE",values);
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
}