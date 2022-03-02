package com.example.sidebar.fragment;

import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.sidebar.R;
import com.google.android.material.snackbar.Snackbar;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class application extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public static application newInstance(String param1, String param2) {
        application fragment = new application();
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
    EditText editText1,editText2,editText3,editText4,editText5,editText6,editText7,editText8;
    Button button;
    Spinner spinner;
    ArrayAdapter< CharSequence > arrayAdapter;
    int pageHeight = 1120;
    int pagewidth = 792;
    private static final int PERMISSION_REQUEST_CODE = 200;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_application, container, false);
        editText1 = view.findViewById(R.id.name);
        editText2 = view.findViewById(R.id.schoolname);
        editText3 = view.findViewById(R.id.address);
        editText4 = view.findViewById(R.id.city);
        editText5 = view.findViewById(R.id.pincode);
        editText6 = view.findViewById(R.id.classStandard);
        editText7 = view.findViewById(R.id.from);
        editText8 = view.findViewById(R.id.to);
        spinner = view.findViewById(R.id.spinnerapp);
        button    = view.findViewById(R.id.submitpdf);
        arrayAdapter = ArrayAdapter.createFromResource(getContext(), R.array.list2, R.layout.spinnerlayout);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        if (checkPermission()) {
            Toast.makeText(view.getContext(), "Permission Granted", Toast.LENGTH_SHORT).show();
        } else {
            requestPermission();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText1.getText().toString().isEmpty() || editText2.getText().toString().isEmpty() ||
                        editText3.getText().toString().isEmpty() || editText4.getText().toString().isEmpty()
                        || editText5.getText().toString().isEmpty() || editText6.getText().toString().isEmpty()
                        || editText7.getText().toString().isEmpty() || editText8.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Empty Field", Toast.LENGTH_SHORT).show();
                } else {
                    createPdf();
                    editText1.setText("");
                    editText2.setText("");
                    editText3.setText("");
                    editText4.setText("");
                    editText5.setText("");
                    editText6.setText(""); editText8.setText("");
                    editText7.setText("");

                }
            }
        });

        return view;
    }
    private void createPdf(){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = new Date();
            String s = simpleDateFormat.format(date);
            String s1;
            SpannableString content = new SpannableString("Yours sincerely,");
            content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
            s1 = content.toString();
            PdfDocument pdfDocument = new PdfDocument();
            Paint paint = new Paint();
            Paint title = new Paint();
            Paint title1 = new Paint();
            PdfDocument.PageInfo mypageInfo = new PdfDocument.PageInfo.Builder(pagewidth, pageHeight, 1).create();
            PdfDocument.Page mypage = pdfDocument.startPage(mypageInfo);
            Canvas canvas = mypage.getCanvas();
            title.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
            title.setTextSize(30);
            title.setColor(ContextCompat.getColor(getContext(), R.color.black));
            title1.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
            title1.setTextSize(15);
            title1.setColor(ContextCompat.getColor(getContext(), R.color.purple_700));
            canvas.drawText("To,", 20, 140, title);
            canvas.drawText("The Principal,", 20, 180, title);
            canvas.drawText(editText2.getText().toString().toUpperCase(),20,220,title);
            canvas.drawText(editText3.getText().toString().toUpperCase(),20,260,title);
            canvas.drawText(editText4.getText().toString().toUpperCase()+"-"+editText5.getText().toString(),20,300,title);
            canvas.drawText("Date:"+s,20,360,title);
                    String sp = spinner.getSelectedItem().toString();

                    if(sp.equalsIgnoreCase("Sick Leave Application")){
                        canvas.drawText("Subject:"+sp,20,420,title);
                        canvas.drawText("Respected Ma'am",20,480,title);
                        canvas.drawText("With due regard, I want to notify you that my child ",20,540,title);
                        canvas.drawText(editText1.getText().toString().toUpperCase()+" is a student of class "+editText6.getText().toString()+", of your ",20,580,title);
                        canvas.drawText("school.As, doctor advise him bedrest for two days.",20,620,title);
                        canvas.drawText("So, we are not in a state to send him to school.",20,660,title);
                        canvas.drawText("Hence,please grant my child leave from "+editText7.getText().toString(),20,700,title);
                        canvas.drawText("to "+editText8.getText().toString()+".I ensure you that my child will attend the",20,740,title);
                        canvas.drawText("school daily going forward.",20,780,title);
                        canvas.drawText(s1,20,850,title);
                        canvas.drawText(editText1.getText().toString().toUpperCase(),20,880,title);
                    } else if (sp.equalsIgnoreCase("One Day Leave Application")){
                        canvas.drawText("Subject: "+sp,20,420,title);
                        canvas.drawText("Respected Ma'am",20,480,title);
                        canvas.drawText("I am a student of "+editText6.getText().toString()+", at your school.This is to inform",
                                20,540,title);
                        canvas.drawText("you that, I have to visit my relative house due to ",20
                        ,580,title);
                        canvas.drawText("some essential work along with my parents. Hence, ",20,620,title);
                        canvas.drawText("I will not be able to come to school tomorrow. Kindly give ",20,660,title);
                        canvas.drawText("me the leave for one day. I shall be really grateful to you.",20,700,title);
                        canvas.drawText("Yours obediently,",20,770,title);
                        canvas.drawText(editText1.getText().toString().toUpperCase(),20,800,title);

                    }else if (sp.equalsIgnoreCase("Leave Application For Going Out Of Station")) {
                        canvas.drawText("Subject:" + sp, 20, 420, title);
                        canvas.drawText("Respected Ma'am", 20, 480, title);
                        canvas.drawText("I am a student of " + editText6.getText().toString() + ", at your school.I have my cousin’s",
                                20, 540, title);
                        canvas.drawText("sister’s marriage in Kerala and all of my family members", 20, 580, title);
                        canvas.drawText("are going to attend it.Hence,I am also leaving with them", 20, 620, title);
                        canvas.drawText("and will not be able to attend school from" + editText7.getText().toString() , 20, 660, title);
                        canvas.drawText("to " + editText8.getText().toString() + ".After coming back I will try to",
                                20, 700, title);
                        canvas.drawText("finish the syllabus covered in my absence with the help", 20, 740, title);
                        canvas.drawText("of my fellow classmates.", 20, 780, title);
                        canvas.drawText(" I shall be really grateful to you if you improve my leaves.", 20, 820, title);
                        canvas.drawText("Yours obediently,", 20, 890, title);
                        canvas.drawText(editText1.getText().toString().toUpperCase(), 20, 920, title);
                    }
                    canvas.drawText("BY:Content Guru",600,1095,title1);

            pdfDocument.finishPage(mypage);

            File file = new File(Environment.getExternalStorageDirectory(),"Application.pdf");
            try {
                pdfDocument.writeTo(new FileOutputStream(file));
                Snackbar.make(getView(),"Please Check in Your Storage.",Snackbar.LENGTH_LONG).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
            pdfDocument.close();
        }
    }


    private boolean checkPermission() {
        int permission1 = ContextCompat.checkSelfPermission(getContext(), WRITE_EXTERNAL_STORAGE);
        int permission2 = ContextCompat.checkSelfPermission(getContext(), READ_EXTERNAL_STORAGE);
        return permission1 == PackageManager.PERMISSION_GRANTED && permission2 == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(getActivity(), new String[]{WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0) {

                // after requesting permissions we are showing
                // users a toast message of permission granted.
                boolean writeStorage = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                boolean readStorage = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                if (writeStorage && readStorage) {
                    Toast.makeText(getContext(), "Permission Granted..", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Permission Denined.", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}