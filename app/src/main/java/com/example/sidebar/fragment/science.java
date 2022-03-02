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
import com.example.sidebar.ChapterCalling2;
import com.example.sidebar.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class science extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    ProgressDialog progressDialog;
    ListView listView;

    String[] chapter9 = {
            "Chapter-1:Matter in Our Surroundings",
            "Chapter-2:Is Matter Around Us Pure",
            "Chapter-3:Atoms and Molecules",
            "Chapter-4:Structure of the Atom",
            "Chapter-5:The Fundamental Unit of Life",
            "Chapter-6:Tissues",
            "Chapter-7:Diversity in Living Organisms",
            "Chapter-8:Motion",
            "Chapter-9:Force and Laws of Motion",
            "Chapter-10:Gravitation",
            "Chapter-11:Work, Power And Energy",
            "Chapter-12:Sound",
            "Chapter-13:Why Do we Fall Ill",
            "Chapter-14:Natural Resources",
            "Chapter-15:Improvement in Food Resources"
    };

    String[] chapter10 = {
            "Chapter-1:Chemical Reactions and Equations",
            "Chapter-2:Acids, Bases and Salts",
            "Chapter-3:Metals and Non-metals",
            "Chapter-4:Carbon and its Compounds",
            "Chapter-5:Periodic Classification of Elements",
            "Chapter-6:Life Processes",
            "Chapter-7:Control and Coordination",
            "Chapter-8:How do Organisms Reproduce?",
            "Chapter-9:Heredity and Evolution",
            "Chapter-10:Light - Reflection and Refraction",
            "Chapter-11:Human Eye and Colourful World",
            "Chapter-12:Electricity",
            "Chapter-13:Magnetic Effects of Electric Current",
            "Chapter-14:Sources of Energy",
            "Chapter-15:Our Environment",
            "Chapter-16:Management of Natural Resources",
    };

    String[] chapter11={
            "Chapter-1:Physical World",
            "Chapter-2:Units and Measurements",
            "Chapter-3:Motion in a Straight Line",
            "Chapter-4:Motion in a plane",
            "Chapter-5:Laws of motion",
            "Chapter-6:Work Energy and power",
            "Chapter-7:System of particles and Rotational Motion",
            "Chapter-8:Gravitation",
            "Chapter-9:Mechanical Properties Of Solids",
            "Chapter-10:Mechanical Properties Of Fluids",
            "Chapter-11:Thermal Properties of matter",
            "Chapter-12:Thermodynamics",
            "Chapter-13:Kinetic Theory",
            "Chapter-14:Oscillations",
            "Chapter-15:Waves",
    };

    String[] chapter12={
    "Chapter-1:Electric Charges And Fields",
    "Chapter-2:Electrostatic Potential And Capacitance",
    "Chapter-3:Current Electricity",
    "Chapter-4:Moving Charges And Magnetism",
    "Chapter-5:Magnetism And Matter",
    "Chapter-6:Electromagnetic Induction",
    "Chapter-7:Alternating Current",
    "Chapter-8:Electromagnetic Waves",
    "Chapter-9:Ray Optics And Optical Instruments",
    "Chapter-10:Wave Optics",
    "Chapter-11:Dual Nature Of Radiation And Matter",
    "Chapter-12:Atoms",
    "Chapter-13:Nuclei",
    "Chapter-14:Semiconductor Electronics Materials Devices And Simple Circuits",
    "Chapter-15:Communication Systems"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science);

        listView = findViewById(R.id.listView2);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        String id = firebaseUser.getUid();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("content").child(id);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                String value = snapshot.child("spinner1").getValue(String.class);
                progressDialog = new ProgressDialog(science.this);
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
                    getSupportActionBar().setTitle("Science");
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView< ? > parent, View view, int position, long id) {
                            String values = parent.getItemAtPosition(position).toString();

                            if(values.equalsIgnoreCase("Chapter-1:Matter in Our Surroundings")){
                                Intent intent = new Intent(science.this, ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            } else if(values.equalsIgnoreCase("Chapter-2:Is Matter Around Us Pure")){
                                Intent intent = new Intent(science.this, ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase("Chapter-3:Atoms and Molecules")){
                                Intent intent = new Intent(science.this, ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-4:Structure of the Atom")){
                                Intent intent = new Intent(science.this, ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-5:The Fundamental Unit of Life")){
                                Intent intent = new Intent(science.this, ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase("Chapter-6:Tissues")){
                                Intent intent = new Intent(science.this, ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase("Chapter-7:Diversity in Living Organisms")){
                                Intent intent = new Intent(science.this, ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-8:Motion")){
                                Intent intent = new Intent(science.this, ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase("Chapter-9:Force and Laws of Motion")){
                                Intent intent = new Intent(science.this, ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase("Chapter-10:Gravitation")){
                                Intent intent = new Intent(science.this, ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase("Chapter-11:Work, Power And Energy")){
                                Intent intent = new Intent(science.this, ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase("Chapter-12:Sound")){
                                Intent intent = new Intent(science.this, ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-13:Why Do we Fall Ill")){
                                Intent intent = new Intent(science.this, ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase("Chapter-14:Natural Resources")){
                                Intent intent = new Intent(science.this, ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase("Chapter-15:Improvement in Food Resources")){
                                Intent intent = new Intent(science.this, ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }
                        }
                    });

                } else if(value.equalsIgnoreCase("10th Class")){
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,chapter9);
                    listView.setAdapter(arrayAdapter);
                    getSupportActionBar().setTitle("Science");
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView< ? > parent, View view, int position, long id) {
                            String values = parent.getItemAtPosition(position).toString();

                            if(values.equalsIgnoreCase("Chapter-1:Chemical Reactions and Equations")){
                                Intent intent = new Intent(science.this, ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            } else if(values.equalsIgnoreCase("Chapter-2:Acids, Bases and Salts")){
                                Intent intent = new Intent(science.this, ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase("Chapter-3:Metals and Non-metals")){
                                Intent intent = new Intent(science.this, ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-4:Carbon and its Compounds")){
                                Intent intent = new Intent(science.this, ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-5:Periodic Classification of Elements")){
                                Intent intent = new Intent(science.this, ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase("Chapter-6:Life Processes")){
                                Intent intent = new Intent(science.this, ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase("Chapter-7:Control and Coordination")){
                                Intent intent = new Intent(science.this, ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-8:How do Organisms Reproduce?")){
                                Intent intent = new Intent(science.this, ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase("Chapter-9:Heredity and Evolution")){
                                Intent intent = new Intent(science.this, ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase("Chapter-10:Light - Reflection and Refraction")){
                                Intent intent = new Intent(science.this, ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase("Chapter-11:Human Eye and Colourful World")){
                                Intent intent = new Intent(science.this, ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase("Chapter-12:Electricity")){
                                Intent intent = new Intent(science.this, ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-13:Magnetic Effects of Electric Current")){
                                Intent intent = new Intent(science.this, ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase("Chapter-14:Sources of Energy")){
                                Intent intent = new Intent(science.this, ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase("Chapter-15:Our Environment")){
                                Intent intent = new Intent(science.this, ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase("Chapter-16:Management of Natural Resources")){
                                Intent intent = new Intent(science.this, ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }
                        }
                    });
                } else if(value.equalsIgnoreCase("11th Class")){
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,chapter11);
                    listView.setAdapter(arrayAdapter);
                    getSupportActionBar().setTitle("Physics");
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView< ? > parent, View view, int position, long id) {
                            String values = parent.getItemAtPosition(position).toString();
                            if(values.equalsIgnoreCase("Chapter-1:Physical World")){
                                Intent intent = new Intent(science.this,ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else  if(values.equalsIgnoreCase("Chapter-2:Units and Measurements")){
                                Intent intent = new Intent(science.this,ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else  if(values.equalsIgnoreCase("Chapter-3:Motion in a Straight Line")){
                                Intent intent = new Intent(science.this,ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else  if(values.equalsIgnoreCase("Chapter-4:Motion in a plane")){
                                Intent intent = new Intent(science.this,ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else  if(values.equalsIgnoreCase("Chapter-5:Laws of motion")){
                                Intent intent = new Intent(science.this,ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else  if(values.equalsIgnoreCase("Chapter-6:Work Energy and power")){
                                Intent intent = new Intent(science.this,ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else  if(values.equalsIgnoreCase("Chapter-7:System of particles and Rotational Motion")){
                                Intent intent = new Intent(science.this,ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else  if(values.equalsIgnoreCase("Chapter-8:Gravitation")){
                                Intent intent = new Intent(science.this,ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else  if(values.equalsIgnoreCase("Chapter-10:Mechanical Properties Of Fluids")){
                                Intent intent = new Intent(science.this,ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else  if(values.equalsIgnoreCase("Chapter-11:Thermal Properties of matter")){
                                Intent intent = new Intent(science.this,ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else  if(values.equalsIgnoreCase("Chapter-12:Thermodynamics")){
                                Intent intent = new Intent(science.this,ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else  if(values.equalsIgnoreCase("Chapter-13:Kinetic Theory")){
                                Intent intent = new Intent(science.this,ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-14:Oscillations")){
                                Intent intent = new Intent(science.this,ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase("Chapter-15:Waves")){
                                Intent intent = new Intent(science.this,ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }
                        }
                    });
                } else if(value.equalsIgnoreCase("12th Class")){
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,chapter12);
                    listView.setAdapter(arrayAdapter);
                    getSupportActionBar().setTitle("Physics");
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView< ? > parent, View view, int position, long id) {
                            String values = parent.getItemAtPosition(position).toString();
                            if(values.equalsIgnoreCase(chapter12[0])){
                                Intent intent = new Intent(science.this,ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else  if(values.equalsIgnoreCase(chapter12[1])){
                                Intent intent = new Intent(science.this,ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else  if(values.equalsIgnoreCase(chapter12[2])){
                                Intent intent = new Intent(science.this,ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else  if(values.equalsIgnoreCase(chapter12[3])){
                                Intent intent = new Intent(science.this,ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else  if(values.equalsIgnoreCase(chapter12[4])){
                                Intent intent = new Intent(science.this,ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else  if(values.equalsIgnoreCase(chapter12[5])){
                                Intent intent = new Intent(science.this,ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else  if(values.equalsIgnoreCase(chapter12[6])){
                                Intent intent = new Intent(science.this,ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else  if(values.equalsIgnoreCase(chapter12[7])){
                                Intent intent = new Intent(science.this,ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else  if(values.equalsIgnoreCase(chapter12[8])){
                                Intent intent = new Intent(science.this,ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else  if(values.equalsIgnoreCase(chapter12[9])){
                                Intent intent = new Intent(science.this,ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else  if(values.equalsIgnoreCase(chapter12[10])){
                                Intent intent = new Intent(science.this,ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else  if(values.equalsIgnoreCase(chapter12[11])){
                                Intent intent = new Intent(science.this,ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else  if(values.equalsIgnoreCase(chapter12[12])){
                                Intent intent = new Intent(science.this,ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else  if(values.equalsIgnoreCase(chapter12[13])){
                                Intent intent = new Intent(science.this,ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
                                startActivity(intent);
                            }else  if(values.equalsIgnoreCase(chapter12[14])){
                                Intent intent = new Intent(science.this,ChapterCalling2.class);
                                intent.putExtra("ChapterName1",values);
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