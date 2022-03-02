package com.example.sidebar.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sidebar.R;
import com.example.sidebar.editprofile;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import static android.app.Activity.RESULT_OK;

public class changeprofile extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public static changeprofile newInstance(String param1, String param2) {
        changeprofile fragment = new changeprofile();
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
    TextView textView;
    TextView editText,editText1,editText2,editText3,editText4;
    Button btn;
    int PICK_IMAGE =1;
    Uri ImageUrl;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_changeprofile, container, false);
        textView = view.findViewById(R.id.textView3);
        editText = view.findViewById(R.id.editTextTextPersonName);
        editText1 = view.findViewById(R.id.editTextTextPersonName2);
        editText2 = view.findViewById(R.id.editTextTextPersonName3);
        editText3 = view.findViewById(R.id.editTextTextPersonName4);
        editText4 = view.findViewById(R.id.editTextTextPersonName5);
        btn = view.findViewById(R.id.button4);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), editprofile.class);
                startActivity(intent);
            }
        });


        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        String id = firebaseUser.getUid();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("content").child(id);

        getData();

        return view;
    }

    private void getData() {
    databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                String value = snapshot.child("name").getValue(String.class);
                String value1 = snapshot.child("email").getValue(String.class);
                String value2 = snapshot.child("phone").getValue(String.class);
                String value3 = snapshot.child("spinner1").getValue(String.class);
                String value4 = snapshot.child("spinner2").getValue(String.class);
                value = value.toUpperCase();
                String firstName = "";

                if(value.split("\\w+").length>1){
                    firstName = value.substring(0, value.lastIndexOf(' '));
                }
                else{
                    firstName = value;
                }
                textView.setText("Hi "+firstName);
                editText.setText(value);
                editText1.setText(value1);
                editText2.setText(value2);
                editText3.setText(value3);
        }

        @Override
        public void onCancelled(@NonNull @NotNull DatabaseError error) {
            Toast.makeText(getContext(), "Connection Error!", Toast.LENGTH_SHORT).show();

        }
    });
    }
}