package com.example.sidebar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.R.color;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.jetbrains.annotations.NotNull;

public class login extends AppCompatActivity {
    Button newuser,loginbtn,forgetPass;
    FirebaseAuth firebaseAuth;
    TextInputLayout username,password;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        newuser = findViewById(R.id.newuser);
        forgetPass = findViewById(R.id.forgetPassword);
        loginbtn = findViewById(R.id.loginbtn);
        firebaseAuth = FirebaseAuth.getInstance();
        username = findViewById(R.id.usernamelogin);
        password = findViewById(R.id.passwordlogin);


        forgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this,forget.class);
                startActivity(intent);
            }
        });

        newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this,Registeration.class);
                startActivity(intent);
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String email = username.getEditText().getText().toString();
                 String pass = password.getEditText().getText().toString();
                 if(email.isEmpty() || pass.isEmpty()) {
                     Toast.makeText(login.this, "Empty Field", Toast.LENGTH_SHORT).show();
                 }
                 else {
                     firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener< AuthResult >() {
                         @Override
                         public void onComplete(@NonNull @NotNull Task< AuthResult > task) {
                             if (task.isSuccessful()) {
                                 progressDialog = new ProgressDialog(login.this);
                                 progressDialog.show();
                                 progressDialog.setContentView(R.layout.progress);
                                 progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

                                 Intent intent = new Intent(login.this, MainActivity.class);
                                 overridePendingTransition(R.transition.left, R.transition.right);
                                 startActivity(intent);
                                 finish();
                             } else {
                                 Snackbar.make(v, "Try Again Later", Snackbar.LENGTH_LONG).show();
                             }
                         }
                     });
                 }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        progressDialog.dismiss();
    }
}