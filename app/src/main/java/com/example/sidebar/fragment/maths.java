package com.example.sidebar.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sidebar.ChapterCalling;
import com.example.sidebar.R;
import com.example.sidebar.login;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class maths extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    ProgressDialog progressDialog;
    TextView textView;
    ListView listView;

    String[] chapter9 = {"Chapter-1:Number Systems",
            "Chapter-2:Polynomials",
            "Chapter-3:Coordinate Geometry",
            "Chapter-4:Linear Equations in Two Variables",
            "Chapter-5:Introduction to Euclid’s Geometry",
            "Chapter-6:Lines and Angles",
            "Chapter-7:Triangles",
            "Chapter-8:Quadrilaterals",
            "Chapter-9:Areas of Parallelograms and Triangles",
            "Chapter-10:Circles",
            "Chapter-11:Constructions",
            "Chapter-12:Heron’s Formula",
            "Chapter-13:Surface Areas and Volumes",
            "Chapter-14:Statistics",
            "Chapter-15:Probability"};

    String[] chapter10 = {
            "Chapter-1:Real Numbers",
            "Chapter-2:Polynomials",
            "Chapter-3:Pair of Linear Equations in Two Variables",
            "Chapter-4:Quadratic Equations",
            "Chapter-5:Arithmetic Progressions",
            "Chapter-6:Triangles",
            "Chapter-7:Coordinate Geometry",
            "Chapter-8:Introduction to Trigonometry",
            "Chapter-9:Some Applications of Trigonometry",
            "Chapter-10:Circles",
            "Chapter-11:Constructions",
            "Chapter-12:Areas Related to Circles",
            "Chapter-13:Surface Areas and Volumes",
            "Chapter-14:Statistics",
            "Chapter-15:Probability"
    };

    String[] chapter11 = {
    "Chapter-1:Sets",
    "Chapter-2:Relations and Functions",
    "Chapter-3:Trigonometric Functions",
    "Chapter-4:Principle of Mathematical Induction",
    "Chapter-5:Complex Numbers and Quadratic Equations",
    "Chapter-6:Linear Inequalities",
    "Chapter-7:Permutation and Combinations",
    "Chapter-8:Binomial Theorem",
    "Chapter-9:Sequences and Series",
    "Chapter-10:Straight Lines",
    "Chapter-11:Conic Sections",
    "Chapter-12:Introduction to three Dimensional Geometry",
    "Chapter-13:Limits and Derivatives",
    "Chapter-14:Mathematical Reasoning",
    "Chapter-15:Statistics",
    "Chapter-16:Probability"
    };

    String[] chapter12={
    "Chapter-1:Relations and Functions",
    "Chapter-2:Inverse Trigonometric Functions",
    "Chapter-3:Matrices",
    "Chapter-4:Determinants",
    "Chapter-5:Continuity and Differentiability",
    "Chapter-6:Application of Derivatives",
    "Chapter-7:Integrals",
    "Chapter-8:Application of Integrals",
    "Chapter-9:Differential Equations",
    "Chapter-10:Vector Algebra",
    "Chapter-11:Three Dimensional Geometry",
    "Chapter-12:Linear Programming",
    "Chapter-13:Probability"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths);
        listView = findViewById(R.id.listView);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        String id = firebaseUser.getUid();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("content").child(id);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                String value = snapshot.child("spinner1").getValue(String.class);
                progressDialog = new ProgressDialog(maths.this);
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
                    getSupportActionBar().setTitle("Maths");
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView< ? > parent, View view, int position, long id) {
                           String values = parent.getItemAtPosition(position).toString();

                           if(values.equalsIgnoreCase("Chapter-1:Number Systems")){
                               Intent intent = new Intent(maths.this, ChapterCalling.class);
                               intent.putExtra("ChapterName",values);
                               startActivity(intent);
                           } else if(values.equalsIgnoreCase("Chapter-2:Polynomials")){
                                Intent intent = new Intent(maths.this, ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }
                           else if(values.equalsIgnoreCase("Chapter-3:Coordinate Geometry")){
                               Intent intent = new Intent(maths.this, ChapterCalling.class);
                               intent.putExtra("ChapterName",values);
                               startActivity(intent);
                           }else if(values.equalsIgnoreCase("Chapter-4:Linear Equations in Two Variabless")){
                               Intent intent = new Intent(maths.this, ChapterCalling.class);
                               intent.putExtra("ChapterName",values);
                               startActivity(intent);
                           }else if(values.equalsIgnoreCase("Chapter-5:Introduction to Euclid’s Geometry")){
                               Intent intent = new Intent(maths.this, ChapterCalling.class);
                               intent.putExtra("ChapterName",values);
                               startActivity(intent);
                           }
                           else if(values.equalsIgnoreCase("Chapter-6:Lines and Angles")){
                               Intent intent = new Intent(maths.this, ChapterCalling.class);
                               intent.putExtra("ChapterName",values);
                               startActivity(intent);
                           }
                           else if(values.equalsIgnoreCase("Chapter-7:Triangles")){
                               Intent intent = new Intent(maths.this, ChapterCalling.class);
                               intent.putExtra("ChapterName",values);
                               startActivity(intent);
                           }else if(values.equalsIgnoreCase("Chapter-8:Quadrilaterals")){
                               Intent intent = new Intent(maths.this, ChapterCalling.class);
                               intent.putExtra("ChapterName",values);
                               startActivity(intent);
                           }
                           else if(values.equalsIgnoreCase("Chapter-9:Areas of Parallelograms and Triangles")){
                               Intent intent = new Intent(maths.this, ChapterCalling.class);
                               intent.putExtra("ChapterName",values);
                               startActivity(intent);
                           }
                           else if(values.equalsIgnoreCase("Chapter-10:Circles")){
                               Intent intent = new Intent(maths.this, ChapterCalling.class);
                               intent.putExtra("ChapterName",values);
                               startActivity(intent);
                           }
                           else if(values.equalsIgnoreCase("Chapter-11:Constructions")){
                               Intent intent = new Intent(maths.this, ChapterCalling.class);
                               intent.putExtra("ChapterName",values);
                               startActivity(intent);
                           }
                           else if(values.equalsIgnoreCase("Chapter-12:Heron’s Formula")){
                               Intent intent = new Intent(maths.this, ChapterCalling.class);
                               intent.putExtra("ChapterName",values);
                               startActivity(intent);
                           }else if(values.equalsIgnoreCase("Chapter-13:Surface Areas and Volumes")){
                               Intent intent = new Intent(maths.this, ChapterCalling.class);
                               intent.putExtra("ChapterName",values);
                               startActivity(intent);
                           }
                           else if(values.equalsIgnoreCase("Chapter-14:Statistics")){
                               Intent intent = new Intent(maths.this, ChapterCalling.class);
                               intent.putExtra("ChapterName",values);
                               startActivity(intent);
                           }
                           else if(values.equalsIgnoreCase("Chapter-15:Probability")){
                               Intent intent = new Intent(maths.this, ChapterCalling.class);
                               intent.putExtra("ChapterName",values);
                               startActivity(intent);
                           }
                        }
                    });

                } else if(value.equalsIgnoreCase("10th Class")){
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,chapter10);
                    listView.setAdapter(arrayAdapter);
                    getSupportActionBar().setTitle("Maths");
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView< ? > parent, View view, int position, long id) {
                            String values = parent.getItemAtPosition(position).toString();

                            if(values.equalsIgnoreCase("Chapter-1:Real Numbers")){
                                Intent intent = new Intent(maths.this, ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            } else if(values.equalsIgnoreCase("Chapter-2:Polynomials")){
                                Intent intent = new Intent(maths.this, ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase("Chapter-3:Pair of Linear Equations in Two Variables")){
                                Intent intent = new Intent(maths.this, ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-4:Quadratic Equations")){
                                Intent intent = new Intent(maths.this, ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-5:Arithmetic Progressions")){
                                Intent intent = new Intent(maths.this, ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase("Chapter-6:Triangles")){
                                Intent intent = new Intent(maths.this, ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase("Chapter-7:Coordinate Geometry")){
                                Intent intent = new Intent(maths.this, ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-8:Introduction to Trigonometry")){
                                Intent intent = new Intent(maths.this, ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase("Chapter-9:Some Applications of Trigonometry")){
                                Intent intent = new Intent(maths.this, ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase("Chapter-10:Circles")){
                                Intent intent = new Intent(maths.this, ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase("Chapter-11:Constructions")){
                                Intent intent = new Intent(maths.this, ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase("Chapter-12:Areas Related to Circles")){
                                Intent intent = new Intent(maths.this, ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-13:Surface Areas and Volumes")){
                                Intent intent = new Intent(maths.this, ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase("Chapter-14:Statistics")){
                                Intent intent = new Intent(maths.this, ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase("Chapter-15:Probability")){
                                Intent intent = new Intent(maths.this, ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }
                        }
                    });
                } else if(value.equalsIgnoreCase("11th Class")){
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,chapter11);
                    listView.setAdapter(arrayAdapter);
                    getSupportActionBar().setTitle("Maths");
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView< ? > parent, View view, int position, long id) {
                            String values = parent.getItemAtPosition(position).toString();

                            if(values.equalsIgnoreCase("Chapter-1:Sets")){
                                Intent intent = new Intent(maths.this,ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-2:Relations and Functions")){
                                Intent intent = new Intent(maths.this,ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-3:Trigonometric Functions")){
                                Intent intent = new Intent(maths.this,ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-4:Principle of Mathematical Induction")){
                                Intent intent = new Intent(maths.this,ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase("Chapter-5:Complex Numbers and Quadratic Equations")){
                                Intent intent = new Intent(maths.this,ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-6:Linear Inequalities")){
                                Intent intent = new Intent(maths.this,ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-7:Permutation and Combinations")){
                                Intent intent = new Intent(maths.this,ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-8:Binomial Theorem")){
                                Intent intent = new Intent(maths.this,ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-9:Sequences and Series")){
                                Intent intent = new Intent(maths.this,ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-10:Straight Lines")){
                                Intent intent = new Intent(maths.this,ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-11:Conic Sections")){
                                Intent intent = new Intent(maths.this,ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-12:Introduction to three Dimensional Geometry")){
                                Intent intent = new Intent(maths.this,ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-13:Limits and Derivatives")){
                                Intent intent = new Intent(maths.this,ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-14:Mathematical Reasoning")){
                                Intent intent = new Intent(maths.this,ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-15:Statistics")){
                                Intent intent = new Intent(maths.this,ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase("Chapter-16:Probability")){
                                Intent intent = new Intent(maths.this,ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }

                        }
                    });

                } else {
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,chapter12);
                    listView.setAdapter(arrayAdapter);
                    getSupportActionBar().setTitle("Maths");
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView< ? > parent, View view, int position, long id) {
                            String values = parent.getItemAtPosition(position).toString();
                            if(values.equalsIgnoreCase(chapter12[0])){
                                Intent intent = new Intent(maths.this,ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[1])){
                                Intent intent = new Intent(maths.this,ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase(chapter12[2])){
                                Intent intent = new Intent(maths.this,ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[3])){
                                Intent intent = new Intent(maths.this,ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[4])){
                                Intent intent = new Intent(maths.this,ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[5])){
                                Intent intent = new Intent(maths.this,ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[6])){
                                Intent intent = new Intent(maths.this,ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[7])){
                                Intent intent = new Intent(maths.this,ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[8])){
                                Intent intent = new Intent(maths.this,ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[9])){
                                Intent intent = new Intent(maths.this,ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[10])){
                                Intent intent = new Intent(maths.this,ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }else if(values.equalsIgnoreCase(chapter12[11])){
                                Intent intent = new Intent(maths.this,ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
                                startActivity(intent);
                            }
                            else if(values.equalsIgnoreCase(chapter12[12])){
                                Intent intent = new Intent(maths.this,ChapterCalling.class);
                                intent.putExtra("ChapterName",values);
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