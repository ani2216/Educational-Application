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

import com.example.sidebar.ChapterCalling6;
import com.example.sidebar.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class biology extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    ListView listView;
    ProgressDialog progressDialog;

    String[] chapter11 = {
            "Chapter-1:The Living World",
            "Chapter-2:Biological Classification",
            "Chapter-3:Plant Kingdom",
            "Chapter-4:Animal Kingdom",
            "Chapter-5:Morphology of Flowering Plants",
            "Chapter-6:Anatomy of Flowering Plants",
            "Chapter-7:Structural Organisation in Animals",
            "Chapter-8:Cell The Unit of Life",
            "Chapter-9:Biomolecules",
            "Chapter-10:Cell Cycle and Cell Division",
            "Chapter-11:Transport in Plants",
            "Chapter-12:Mineral Nutrition",
            "Chapter-13:Photosynthesis in Higher Plants",
            "Chapter-14:Respiration in Plants",
            "Chapter-15:Plant Growth and Development",
            "Chapter-16:Digestion and Absorption",
            "Chapter-17:Breathing and Exchange of Gases",
            "Chapter-18:Body Fluids and Circulation",
            "Chapter-19:Excretory Products and their Elimination",
            "Chapter-20:Locomotion and Movement",
            "Chapter-21:Neural Control and Coordination",
            "Chapter-22:Chemical Coordination and Integration",
    };

    String[] chapter12={
    "Chapter-1:Reproduction in Organisms",
    "Chapter-2:Sexual Reproduction in Flowering Plants",
    "Chapter-3:Human Reproduction",
    "Chapter-4:Reproductive Health",
    "Chapter-5:Principles of Inheritance and Variation",
    "Chapter-6:Molecular Basis of Inheritance",
    "Chapter-7:Evolution",
    "Chapter-8:Human Health and Disease",
    "Chapter-9:Strategies for Enhancement in Food Production",
    "Chapter-10:Microbes in Human Welfare",
    "Chapter-11:Biotechnology: Principles And Processes",
    "Chapter-12:Biotechnology and its Applications",
    "Chapter-13:Organisms and Populations",
    "Chapter-14:Ecosystem",
    "Chapter-15:Biodiversity and Conservation",
    "Chapter-16:Environmental Issues"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biology);

        listView = findViewById(R.id.listView10);

        progressDialog = new ProgressDialog(biology.this);
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
                    getSupportActionBar().setTitle("Biology");
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView< ? > parent, View view, int position, long id) {
                            String s = parent.getItemAtPosition(position).toString();
                            if(s.equalsIgnoreCase("Chapter-1:The Living World")){
                                Intent intent = new Intent(biology.this, ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase("Chapter-2:Biological Classification")){
                                Intent intent = new Intent(biology.this, ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase("Chapter-3:Plant Kingdom")){
                                Intent intent = new Intent(biology.this, ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase("Chapter-4:Animal Kingdom")){
                                Intent intent = new Intent(biology.this, ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase("Chapter-5:Morphology of Flowering Plants")){
                                Intent intent = new Intent(biology.this, ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase("Chapter-6:Anatomy of Flowering Plants")){
                                Intent intent = new Intent(biology.this, ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase("Chapter-7:Structural Organisation in Animals")){
                                Intent intent = new Intent(biology.this, ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase("Chapter-8:Cell The Unit of Life")){
                                Intent intent = new Intent(biology.this, ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase("Chapter-9:Biomolecules")){
                                Intent intent = new Intent(biology.this, ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase("Chapter-10:Cell Cycle and Cell Division")){
                                Intent intent = new Intent(biology.this, ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase("Chapter-11:Transport in Plants")){
                                Intent intent = new Intent(biology.this, ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase("Chapter-12:Mineral Nutrition")){
                                Intent intent = new Intent(biology.this, ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase("Chapter-13:Photosynthesis in Higher Plants")){
                                Intent intent = new Intent(biology.this, ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase("Chapter-14:Respiration in Plants")){
                                Intent intent = new Intent(biology.this, ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase("Chapter-15:Plant Growth and Development")){
                                Intent intent = new Intent(biology.this, ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase("Chapter-16:Digestion and Absorption")){
                                Intent intent = new Intent(biology.this, ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase("Chapter-17:Breathing and Exchange of Gases")){
                                Intent intent = new Intent(biology.this, ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase("Chapter-18:Body Fluids and Circulation")){
                                Intent intent = new Intent(biology.this, ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase("Chapter-19:Excretory Products and their Elimination")){
                                Intent intent = new Intent(biology.this, ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase("Chapter-20:Locomotion and Movement")){
                                Intent intent = new Intent(biology.this, ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase("Chapter-21:Neural Control and Coordination")){
                                Intent intent = new Intent(biology.this, ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase("Chapter-22:Chemical Coordination and Integration")){
                                Intent intent = new Intent(biology.this, ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }
                        }
                    });
                } else  if(value.equalsIgnoreCase("12th Class")){
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,chapter12);
                    listView.setAdapter(arrayAdapter);
                    getSupportActionBar().setTitle("Biology");
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView< ? > parent, View view, int position, long id) {
                            String s = parent.getItemAtPosition(position).toString();

                            if(s.equalsIgnoreCase(chapter12[0])){
                                Intent intent = new Intent(biology.this,ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase(chapter12[1])){
                                Intent intent = new Intent(biology.this,ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase(chapter12[2])){
                                Intent intent = new Intent(biology.this,ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase(chapter12[3])){
                                Intent intent = new Intent(biology.this,ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase(chapter12[4])){
                                Intent intent = new Intent(biology.this,ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase(chapter12[5])){
                                Intent intent = new Intent(biology.this,ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase(chapter12[6])){
                                Intent intent = new Intent(biology.this,ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase(chapter12[7])){
                                Intent intent = new Intent(biology.this,ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase(chapter12[8])){
                                Intent intent = new Intent(biology.this,ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase(chapter12[9])){
                                Intent intent = new Intent(biology.this,ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase(chapter12[10])){
                                Intent intent = new Intent(biology.this,ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase(chapter12[11])){
                                Intent intent = new Intent(biology.this,ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase(chapter12[12])){
                                Intent intent = new Intent(biology.this,ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase(chapter12[13])){
                                Intent intent = new Intent(biology.this,ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase(chapter12[14])){
                                Intent intent = new Intent(biology.this,ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
                                startActivity(intent);
                            }else if(s.equalsIgnoreCase(chapter12[15])){
                                Intent intent = new Intent(biology.this,ChapterCalling6.class);
                                intent.putExtra("ChapterBiology",s);
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