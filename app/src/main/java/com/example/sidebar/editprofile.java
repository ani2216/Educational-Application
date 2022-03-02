package com.example.sidebar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;

public class editprofile extends AppCompatActivity {
    TextView textView;
    EditText editText,editText1,editText2,editText3;
    Button btn;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);
        textView = findViewById(R.id.textView3);
        editText = findViewById(R.id.editTextTextPersonName);
        editText1 = findViewById(R.id.editTextTextPersonName2);
        editText2 = findViewById(R.id.editTextTextPersonName3);
        editText3 = findViewById(R.id.editTextTextPersonName4);
        btn = findViewById(R.id.buttonchangeprofile);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        String id = firebaseUser.getUid();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("content").child(id);

        getData();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.child("name").setValue(editText.getText().toString());
                databaseReference.child("email").setValue(editText1.getText().toString());
                databaseReference.child("phone").setValue(editText2.getText().toString());
                databaseReference.child("spinner1").setValue(editText3.getText().toString());
                Snackbar.make(v,"Profile Updated",Snackbar.LENGTH_LONG).show();
                Intent intent = new Intent(editprofile.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void getData() {
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                String value = snapshot.child("name").getValue(String.class);
                String value1 = snapshot.child("email").getValue(String.class);
                String value2 = snapshot.child("phone").getValue(String.class);
                String value3 = snapshot.child("spinner1").getValue(String.class);
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
                Toast.makeText(editprofile.this, "Connection Error!", Toast.LENGTH_SHORT).show();

            }
        });
    }
}