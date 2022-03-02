package com.example.sidebar.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sidebar.MainActivity;
import com.example.sidebar.R;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import Adapter.ModelAdapter;
import Adapter.Model_Chat;
import Adapter.Model_base;

public class groupchat extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public static groupchat newInstance(String param1, String param2) {
        groupchat fragment = new groupchat();
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
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    FirebaseUser firebaseUser;
    ImageView sendImage;
    EditText userMessage;
    FirebaseAuth mAuth;
    DatabaseReference mChatData, mUserData;
    String username = "null";
    RecyclerView recyclerView;
    ArrayList<Model_Chat> arrayList;
    ModelAdapter modelAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_groupchat, container, false);
        recyclerView = view.findViewById(R.id.messagelist);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        arrayList = new ArrayList<>();
        modelAdapter = new ModelAdapter(getContext(),arrayList);
        recyclerView.setAdapter(modelAdapter);
        userMessage = view.findViewById(R.id.user_message);
        sendImage = view.findViewById(R.id.send_image);


        final FloatingActionButton fab = ((MainActivity) getActivity()).getFloatingActionButton();

        if (fab != null) {
            ((MainActivity) getActivity()).hideFloatingActionButton();
        }

        mAuth = FirebaseAuth.getInstance();

        mChatData = FirebaseDatabase.getInstance().getReference("messages");

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        String id = firebaseUser.getUid();
        firebaseDatabase = FirebaseDatabase.getInstance();
        mUserData = firebaseDatabase.getReference("content").child(id);

        mUserData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                username = dataSnapshot.child("name").getValue(String.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("HH:mm:ss");
        String strDate = mdformat.format(calendar.getTime());

        sendImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userMessage.getText().toString() != null){
                        mChatData.push().setValue(new Model_base(userMessage.getText().toString(),username,strDate));
                        userMessage.setText("");
                } else {
                    Toast.makeText(getActivity(), "Empty Field", Toast.LENGTH_SHORT).show();
                }
            }
        });
        displayChatMessage();

        return view;
    }

    private void displayChatMessage() {
              mChatData.addChildEventListener(new ChildEventListener() {
                  @Override
                  public void onChildAdded(@NonNull @NotNull DataSnapshot snapshot, @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {
                           Model_Chat model_chat = snapshot.getValue(Model_Chat.class);
                           arrayList.add(model_chat);
                       modelAdapter.notifyDataSetChanged();
                  }

                  @Override
                  public void onChildChanged(@NonNull @NotNull DataSnapshot snapshot, @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {

                  }

                  @Override
                  public void onChildRemoved(@NonNull @NotNull DataSnapshot snapshot) {

                  }

                  @Override
                  public void onChildMoved(@NonNull @NotNull DataSnapshot snapshot, @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {

                  }

                  @Override
                  public void onCancelled(@NonNull @NotNull DatabaseError error) {

                  }
              });
//            mChatData.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
//                    for (DataSnapshot dataSnapshot:snapshot.getChildren()){
//                        Model_Chat model_chat = dataSnapshot.getValue(Model_Chat.class);
//                        arrayList.add(model_chat);
//                    }
//
//                    modelAdapter.notifyDataSetChanged();
//                }
//
//                @Override
//                public void onCancelled(@NonNull @NotNull DatabaseError error) {
//
//                }
//            });
    }
}

