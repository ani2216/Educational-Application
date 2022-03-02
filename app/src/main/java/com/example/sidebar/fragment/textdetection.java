package com.example.sidebar.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.sidebar.R;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

import java.io.IOException;

import static android.app.Activity.RESULT_OK;


public class textdetection extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public textdetection() {
        // Required empty public constructor
    }

    public static textdetection newInstance(String param1, String param2) {
        textdetection fragment = new textdetection();
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

    ImageView imageView;
    TextView detectedText;
    Button btn_detect,button1,button2;
    int PICK_IMAGE = 1;
    private int resultCode;
    private int requestCode;
    private Intent data;
    Uri ImageUrl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_textdetection, container, false);
        imageView = view.findViewById(R.id.img);
        detectedText = view.findViewById(R.id.detectedText);
        btn_detect = view.findViewById(R.id.button_detect);
        button1 = view.findViewById(R.id.button1);
        button2 = view.findViewById(R.id.button2);
        
        if(ContextCompat.checkSelfPermission(view.getContext(), Manifest.permission.CAMERA)!=
                PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(),new String[]{
                    Manifest.permission.CAMERA
            },100);
        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,100);
                Uri uri = intent.getData();
                Bitmap bitmap = null;
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
                } catch (IOException e) {
                    Toast.makeText(getContext(), "Not Supported", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select Image"),PICK_IMAGE);

            }
        });


        btn_detect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(imageView.getDrawable()!=null) {
                    detect(v);
                } else{
                    Toast.makeText(v.getContext(), "Please Select Image", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }


    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == 100){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
        }

        if(requestCode == PICK_IMAGE && resultCode == RESULT_OK){
            ImageUrl = data.getData();
            try{
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(),ImageUrl);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private void detect(View view) {

        TextRecognizer recognizer = new TextRecognizer.Builder(view.getContext()).build();
        Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
        Frame frame = new Frame.Builder().setBitmap(bitmap).build();

        SparseArray< TextBlock > sparseArray =  recognizer.detect(frame);

        StringBuilder stringBuilder = new StringBuilder();

        for(int i=0;i < sparseArray.size(); i++){
            TextBlock tx = sparseArray.get(i);
            String str = tx.getValue();

            stringBuilder.append(str);
        }

        detectedText.setText(stringBuilder);
    }
    }
