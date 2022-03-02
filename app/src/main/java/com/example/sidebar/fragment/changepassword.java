package com.example.sidebar.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.sidebar.MainActivity;
import com.example.sidebar.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class changepassword extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public static changepassword newInstance(String param1, String param2) {
        changepassword fragment = new changepassword();
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
        TextInputLayout pass,pass1;
        Button change;
        DatabaseReference databaseReference;
        FirebaseAuth firebaseAuth;
        FirebaseUser firebaseUser;
        FirebaseDatabase firebaseDatabase;
        ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_changepassword, container, false);
        pass = view.findViewById(R.id.pass);
        pass1 = view.findViewById(R.id.pass1);
        change = view.findViewById(R.id.change);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        String id = firebaseUser.getUid();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("content").child(id);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = pass.getEditText().getText().toString();
                String s1 = pass1.getEditText().getText().toString();

                if(s.isEmpty() || s1.isEmpty()){
                    Snackbar.make(v,"Empty Field",Snackbar.LENGTH_LONG).show();
                } else if (!validationpass()){
                    return;
                }
                else if(s.equalsIgnoreCase(s1)){
                    Toast.makeText(view.getContext(), "New password Can't be Same that of old password.", Toast.LENGTH_SHORT).show();
                }

                else {
                    databaseReference.child("password").setValue(s1);
                    progressDialog = new ProgressDialog(view.getContext());
                    progressDialog.show();
                    progressDialog.setContentView(R.layout.progresspass);
                    progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                    Snackbar.make(view,"Password Updated",Snackbar.LENGTH_LONG).show();
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);

                }

            }
        });

        return view;
    }

    public boolean validationpass(){
        String naam = pass1.getEditText().getText().toString();
        String pass ="(?=.*[0-9])"+"(?=.*[A-Z])"+"(?=.*[a-zA-Z])"+"(?=.*[@#$^&*])"+".{6,}";


        if(naam.isEmpty()){
            pass1.setError("Field not be Empty");
            return false;
        }
        else if(!naam.matches(pass)){
            pass1.setError("Password is Too weak");
            return false;
        }
        else {
            pass1.setError(null);
            return true;
        }
    }

}