package com.example.sidebar.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.sidebar.R;
import com.example.sidebar.Registeration;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class fronthome extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public static fronthome newInstance(String param1, String param2) {
        fronthome fragment = new fronthome();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    LinearLayout linear1,linear2,linear3,linear4,linear5,linear6,linear7;
    TextView subjectName1,subjectName2,subjectName3,subText1,subText2,subText3;
    ImageView imageView;
    ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fronthome, container, false);
        linear1 = view.findViewById(R.id.linear1);
        linear2 = view.findViewById(R.id.linear2);
        linear3 = view.findViewById(R.id.linear3);
        linear4 = view.findViewById(R.id.linear4);
        linear5 = view.findViewById(R.id.linear5);
        linear6 = view.findViewById(R.id.linear6);
        linear7 = view.findViewById(R.id.linear7);
        TextView textView = view.findViewById(R.id.textforandroid);

        subjectName1 = view.findViewById(R.id.subjectName1);
        subjectName2 = view.findViewById(R.id.subjectName2);
        subjectName3 = view.findViewById(R.id.subjectName3);
        subText1 = view.findViewById(R.id.subText1);
        subText2 = view.findViewById(R.id.subText2);
        subText3 = view.findViewById(R.id.subText3);

        imageView = view.findViewById(R.id.imagechanging);


        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        String id = firebaseUser.getUid();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("content").child(id);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                String value = snapshot.child("spinner1").getValue(String.class);
                String vaue1 = snapshot.child("spinnner2").getValue(String.class);
                    progressDialog = new ProgressDialog(getContext());
                    progressDialog.show();
                    progressDialog.setContentView(R.layout.progresssubject);
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                    Runnable progressRunnable = new Runnable() {

                        @Override
                        public void run() {
                            progressDialog.cancel();
                        }
                    };

                    Handler pdCanceller = new Handler();
                    pdCanceller.postDelayed(progressRunnable, 1500);

                new CountDownTimer(900000000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                        long hour = (millisUntilFinished / 3600000) % 24;
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        textView.setText(f.format(hour) + ":" + f.format(min) + ":" + f.format(sec)+" (coming soon)");
                    }
                    // When the task is over it will print 00:00:00 there
                    public void onFinish() {
                        textView.setText("00:00:00");
                    }
                }.start();

                linear7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(), "Coming Soon", Toast.LENGTH_SHORT).show();
                    }
                });

                if(value.equalsIgnoreCase("9th Class")){
                    subjectName1.setText("Science");
                    subText1.setText("Science is past,present,future");

                    subjectName2.setText("Social Science");
                    subText2.setText("Study to become diplomatic.");
                    subjectName3.setText("English");
                    subText3.setText("Grammer Analysis with joy");

                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.englishs));

                    linear1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getContext(),maths.class);
                            startActivity(intent);
                        }
                    });

                    linear2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getContext(),science.class);
                            startActivity(intent);
                        }
                    });

                    linear3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getContext(),Socialscience.class);
                            startActivity(intent);
                        }
                    });

                    linear4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getContext(),English.class);
                            startActivity(intent);
                        }
                    });

                } else if(value.equalsIgnoreCase("10th Class")){
                    subjectName1.setText("Science");
                    subText1.setText("Science is past,present,future");

                    subjectName2.setText("Social Science");
                    subText2.setText("Study to become diplomatic.");

                    subjectName3.setText("English");
                    subText3.setText("Grammer Analysis with joy");

                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.englishs));

                    linear1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getContext(),maths.class);
                            startActivity(intent);
                        }
                    });

                    linear2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getContext(),science.class);
                            startActivity(intent);
                        }
                    });

                    linear3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getContext(),Socialscience.class);
                            startActivity(intent);
                        }
                    });

                    linear4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getContext(),english10.class);
                            startActivity(intent);
                        }
                    });
                } else if(value.equalsIgnoreCase("11th Class")){
                    linear1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getContext(),maths.class);
                            startActivity(intent);
                        }
                    });

                    linear2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getContext(),science.class);
                            startActivity(intent);
                        }
                    });

                    linear3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getContext(),Socialscience.class);
                            startActivity(intent);
                        }
                    });
                    if(vaue1.equalsIgnoreCase("Medical")){
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.bb));
                        linear4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getContext(),biology.class);
                                startActivity(intent);
                            }
                        });

                    }else if(vaue1.equalsIgnoreCase("Non-Medical")){
                        subjectName3.setText("Physical Education");
                        subText3.setText("Yoga is first step to exercise.");
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.yoga));

                        linear4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getContext(),PhysicalEducation.class);
                                startActivity(intent);
                            }
                        });
                    }

                } else if(value.equalsIgnoreCase("12th Class")) {
                    linear1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getContext(),maths.class);
                            startActivity(intent);
                        }
                    });

                    linear2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getContext(),science.class);
                            startActivity(intent);
                        }
                    });

                    linear3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getContext(),Socialscience.class);
                            startActivity(intent);
                        }
                    });
                    if(vaue1.equalsIgnoreCase("Medical")){
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.bb));
                        linear4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getContext(),biology.class);
                                startActivity(intent);
                            }
                        });

                    }else if(vaue1.equalsIgnoreCase("Non-Medical")){
                        subjectName3.setText("Physical Education");
                        subText3.setText("Yoga is first step to exercise.");
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.yoga));

                        linear4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getContext(),PhysicalEducation.class);
                                startActivity(intent);
                            }
                        });
                    }
                }else{
                    Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(), Registeration.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

        linear5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),programming.class);
                startActivity(intent);
            }
        });

        linear6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),webdev.class);
                startActivity(intent);
            }
        });

        return view;
    }

}