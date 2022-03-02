package com.example.sidebar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

public class Registeration extends AppCompatActivity {
        Spinner spinner,spinner1;
        ArrayAdapter<CharSequence> arrayAdapter,streamAdapter;
        TextInputLayout schoolname;
        TextView textView;
        LinearLayout linearspin;
        Button alreadyacc,register;
        TextInputEditText names,email1,phone1,password1;
        TextInputLayout name,email,phone,password;
        FirebaseAuth firebaseAuth;
        FirebaseUser firebaseUser;
        FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        spinner = findViewById(R.id.spinner);
        spinner1 = findViewById(R.id.spinner1);
        schoolname = findViewById(R.id.schoolname);
        textView = findViewById(R.id.streamtext);
        alreadyacc = findViewById(R.id.alreadyacc);
        register = findViewById(R.id.register);
        names = findViewById(R.id.names);
        email1 = findViewById(R.id.email1);
        phone1 = findViewById(R.id.phone1);
        password1 = findViewById(R.id.password1);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        linearspin = findViewById(R.id.linearspin);

        AlertDialog.Builder builder = new AlertDialog.Builder(Registeration.this);
        builder.setTitle("Password:")
                .setMessage("Atleast one capital letter, one special character , one digit.").setPositiveButton(
                "ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }
        );
        AlertDialog alertDialog = builder.create();
        alertDialog.show();


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        arrayAdapter = ArrayAdapter.createFromResource(Registeration.this, R.array.list, R.layout.spinnerlayout);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        streamAdapter = ArrayAdapter.createFromResource(Registeration.this, R.array.list1, R.layout.spinnerlayout);
        streamAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(streamAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView< ? > parent, View v, int position, long id) {
                    String s =spinner.getSelectedItem().toString();
                    String s1 = spinner1.getSelectedItem().toString();

                    if(s.equalsIgnoreCase("11th Class") || s.equalsIgnoreCase("12th Class")){
                        linearspin.setVisibility(View.VISIBLE);
                    } else {
                        linearspin.setVisibility(View.INVISIBLE);
                    }
            }

            @Override
            public void onNothingSelected(AdapterView< ? > parent) {

            }
        });

        alreadyacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registeration.this,login.class);
                startActivity(intent);
                finish();
            }
        });


            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String s = spinner.getSelectedItem().toString();
                    String s1 = spinner1.getSelectedItem().toString();

                    String user = names.getText().toString();
                    user = user.toUpperCase();
                    String firstName = "";

                    if(user.split("\\w+").length>1){
                        firstName = user.substring(0, user.lastIndexOf(' '));
                    }
                    else{
                        firstName = user;
                    }

                    if (!validationname() | !validationemail() | !validationphone() | !validationpass()) {
                        return;
                    }
                    else if (s1.equalsIgnoreCase("Select Stream") && (s.equalsIgnoreCase("11th Class") || s.equalsIgnoreCase("12th Class"))) {
                            Snackbar.make(v, "Please Select Stream", Snackbar.LENGTH_LONG).setBackgroundTint(913831).show();
                    }
                    else if(s.equalsIgnoreCase("Select Class")){
                        Snackbar.make(v,"Please Select Class",Snackbar.LENGTH_LONG).setBackgroundTint(913831).show();
                    }
                    else {
                        firebaseDatabase = FirebaseDatabase.getInstance();
                        String finalFirstName = firstName;
                        firebaseAuth.createUserWithEmailAndPassword(email1.getText().toString(),
                                password1.getText().toString()).addOnCompleteListener(new OnCompleteListener< AuthResult >() {
                            @Override
                            public void onComplete(@NonNull @NotNull Task< AuthResult > task) {
                                if(task.isSuccessful()){
                                        registerion registerion = new registerion(names.getText().toString()
                                                , email1.getText().toString(), phone1.getText().toString(), password1.getText().toString(), schoolname.getEditText().getText().toString(), spinner.getSelectedItem().toString(), spinner1.getSelectedItem().toString());
                                        String id = task.getResult().getUser().getUid();
                                        firebaseDatabase.getReference().child("content").child(id).setValue(registerion);
//                                        senEmail();
                                        Intent intent = new Intent(Registeration.this, splashScreen2.class);
                                        intent.putExtra("Keyname", finalFirstName);
                                        overridePendingTransition(R.transition.left, R.transition.right);
                                        startActivity(intent);
                                        finish();
                                } else {
                                    Snackbar.make(v,"Please Try Again Later",Snackbar.LENGTH_LONG).show();
                                }
                            }
                        });
                    }


                }
            });
        }



    public boolean validationname(){
        String naam = names.getText().toString();

        if(naam.isEmpty()){
            name.setError("Field not be Empty");
            return false;
        } else {
            name.setError(null);
            return true;
        }
    }

    public boolean validationemail(){
        String naam = email1.getText().toString();
        String pattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(naam.isEmpty()){
            email1.setError("Field not be Empty");
            return false;
        }
        else if (!naam.matches(pattern)){
            email1.setError("Invalid Email");
            return false;
        }
        else {
            email1.setError(null);
            return true;
        }
    }

    public boolean validationphone(){
        String naam = phone1.getText().toString();

        if(naam.isEmpty()){
            phone.setError("Field not be Empty");
            return false;
        }
        else  if(naam.length()>11 || naam.length()<10){
            phone.setError("Invalid Number");
            return false;
        }
        else {
            phone.setError(null);
            return true;
        }
    }

    public boolean validationpass(){
        String naam = password1.getText().toString();
        String pass ="(?=.*[0-9])"+"(?=.*[A-Z])"+"(?=.*[a-zA-Z])"+"(?=.*[@#$^&*])"+".{6,}";


        if(naam.isEmpty()){
            password.setError("Field not be Empty");
            return false;
        }
        else if(!naam.matches(pass)){
            password.setError("Password is Too weak");
            return false;
        }
        else {
            password.setError(null);
            return true;
        }
    }

    public boolean validateSchool(){
        String s = schoolname.getEditText().getText().toString();

        if(s.isEmpty()){
            schoolname.setError("Empty Field");
            return false;
        } else {
            return true;
        }
    }

//    public void senEmail() {
//        String mEmail = email1.getText().toString();
//        String mSubject = "noreply-contentguru724@gmail.com";
//        String mMessage = "Thank you for registering in content guru application.Hope you will get benefited of our app.Stay tuned with us to get latest notification first.";
//        JavaMailApi javaMailAPI = new JavaMailApi(this, mEmail, mSubject, mMessage);
//
//        javaMailAPI.execute();
//    }

}