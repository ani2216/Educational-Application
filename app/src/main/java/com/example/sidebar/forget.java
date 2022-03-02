package com.example.sidebar;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class forget extends AppCompatActivity {
    TextInputLayout emailforget;
    Button Submit;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        emailforget = findViewById(R.id.emailforget);
        Submit = findViewById(R.id.submitforget);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        firebaseAuth = FirebaseAuth.getInstance();

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(emailforget.getEditText().getText().toString().isEmpty()){
                    Toast.makeText(forget.this, "Empty Field", Toast.LENGTH_SHORT).show();
                }

                else
                firebaseAuth.sendPasswordResetEmail(emailforget.getEditText().getText().toString()).addOnCompleteListener(new OnCompleteListener< Void >() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task< Void > task) {
                        if (!validationemail()) {
                            return;
                        } else {
                            if (task.isSuccessful()) {
                                Toast.makeText(forget.this, "Check your email", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(forget.this, login.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(forget.this, "Try again", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
            }
        });

        }

    public boolean validationemail(){
        String naam = emailforget.getEditText().getText().toString();
        String pattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(naam.isEmpty()){
            emailforget.setError("Field not be Empty");
            return false;
        }
        else if (!naam.matches(pattern)){
            emailforget.setError("Invalid Email");
            return false;
        }
        else {
            emailforget.setError(null);
            return true;
        }
    }
}