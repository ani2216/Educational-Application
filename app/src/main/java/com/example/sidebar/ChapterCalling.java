package com.example.sidebar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.sidebar.fragment.webViewControl;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class ChapterCalling extends AppCompatActivity {
    WebView wv;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    String[] chapter12={
            "Chapter-1:Relations and Functions",
            "Chapter-2:Inverse Trigonometric Functions",
            "Chapter-3:Matrices",
            "Chapter-4:Determinants",
            "Chapter-5:Continuity and Differentiability",
            "Chapter-6:Application of Derivatives",
            "Chapter-7:Integrals",
            "Chapter-8:Application of Integrals",
            "Chapter-9:Differential Equations",
            "Chapter-10:Vector Algebra",
            "Chapter-11:Three Dimensional Geometry",
            "Chapter-12:Linear Programming",
            "Chapter-13:Probability"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_calling);
        wv = findViewById(R.id.webView1);

        String message = getIntent().getStringExtra("ChapterName");

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        String id = firebaseUser.getUid();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("content").child(id);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                String s = snapshot.child("spinner1").getValue(String.class);

                if(s.equalsIgnoreCase("9th Class")){
                    if(message.equalsIgnoreCase("Chapter-1:Number Systems")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOZWdzUGtvLVY5cWc/view?resourcekey=0-MT0eRUb69YYMulKllZ72iw");
                    } else if(message.equalsIgnoreCase("Chapter-2:Polynomials")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOWEtYMWp5ZTJqWnc/view?resourcekey=0-KMOkzWQcIE4Uu2qiydmsqg");
                    }else if(message.equalsIgnoreCase("Chapter-3:Coordinate Geometry")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOeW50WkhGVnNhcms/view?resourcekey=0-cTM35I-9pUgLmjlRCU2M0w");
                    }
                    else if(message.equalsIgnoreCase("Chapter-4:Linear Equations in Two Variables")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOUmtmMWZxNHBWTlE/view?resourcekey=0-0dsYDDAd0Ehf2XRvYAy0lQ");
                    }
                    else if(message.equalsIgnoreCase("Chapter-5:Introduction to Euclid’s Geometry")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOWTNmQmlLbldLSFE/view?resourcekey=0-HAIvqkxiL1ekrTIL3nKzBQ");
                    }else if(message.equalsIgnoreCase("Chapter-6:Lines and Angles")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOd3ZaWFBTcUtRYVU/view?resourcekey=0-lIwStuRqSe9gSqYprj-FDQ");
                    }else if(message.equalsIgnoreCase("Chapter-7:Triangles")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOLU9RTHdCNmc1Zjg/view?resourcekey=0-DULHNd1A7GJErAb7TSNfjQ");
                    }
                    else if(message.equalsIgnoreCase("Chapter-8:Quadrilaterals")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOMWNBeEpYcjVKSjQ/view?resourcekey=0-oCuKFX4KqmnVssNeJOpiyQ");
                    }else if(message.equalsIgnoreCase("Chapter-9:Areas of Parallelograms and Triangles")) {
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOUWotbFpaNmlpRTA/view?resourcekey=0-9KZXKDhkRmr5Ifuz1fBLAw");
                    }else if(message.equalsIgnoreCase("Chapter-10:Circles")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOTk0xeWwtR2tWdkU/view?resourcekey=0-6DFcJczOy-Vhzx7X2iHR5A");
                    }else if(message.equalsIgnoreCase("Chapter-12:Heron’s Formula")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOSHlNMDJSQkFjUmM/view?resourcekey=0-UDhiEU2tphFw6llr3Ab5RQ");
                    }else if(message.equalsIgnoreCase("Chapter-11:Constructions")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOWUZjR2I0T1llMzA/view?resourcekey=0-DoQkRB350MIuZutuhdqXuw");
                    }else if(message.equalsIgnoreCase("Chapter-13:Surface Areas and Volumes")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOdmRqdVF1VjVqMXc/view?resourcekey=0-QJOPyK1tgX6eWtrijJeGhA");
                    }else if(message.equalsIgnoreCase("Chapter-14:Statistics")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOMUNYd0xYX3ZMSzA/view?resourcekey=0-ARZ0cCb85wBEhoVpWIP3cw");
                    }else if(message.equalsIgnoreCase("Chapter-15:Probability")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOU0FpRGlJMGd0Wm8/view?resourcekey=0-_wIfYbd8kb37GsCzM5r5sw");
                    }
                } else if(s.equalsIgnoreCase("10th Class")){
                    if(message.equalsIgnoreCase("Chapter-1:Real Numbers")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOdDhJaVJreXZienM/view?resourcekey=0-i3ZycX0MZAR5HOtUEXagDA");
                    } else if(message.equalsIgnoreCase("Chapter-2:Polynomials")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOS2RzeHJBUWhXMWM/view?resourcekey=0-BZco77_xi0KhjV14dzb65A");
                    }else if(message.equalsIgnoreCase("Chapter-3:Pair of Linear Equations in Two Variables")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOOWFMYzJMVzg1VEk/view?resourcekey=0-lTTwmf2q4FT3tb8lBfPeNw");
                    }
                    else if(message.equalsIgnoreCase("Chapter-4:Quadratic Equations")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOUlFaeFFGaHVPVlE/view?resourcekey=0-B-xx6J6u86qf9edv2yvK1Q");
                    }
                    else if(message.equalsIgnoreCase("Chapter-5:Arithmetic Progressions")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOaTc4UVVSLTNoTmM/view?resourcekey=0-gr8AwYdXsr6xiO2qNC99ow");
                    }else if(message.equalsIgnoreCase("Chapter-6:Triangles")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnON09fYUhRa2pjczg/view?resourcekey=0-yApcvv5n8A0FwEx0aET70g");
                    }else if(message.equalsIgnoreCase("Chapter-7:Coordinate Geometry")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOWENScU5pZFZGNUE/view?resourcekey=0-Y3IjrTOTGVw0NUbSNYVR3Q");
                    }
                    else if(message.equalsIgnoreCase("Chapter-8:Introduction to Trigonometry")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOR3NnWlB3RXFrUjQ/view?resourcekey=0-WSNi4ZVlweEQ-TpTql5GxQ");
                    }else if(message.equalsIgnoreCase("Chapter-9:Some Applications of Trigonometry")) {
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnON094WUo4V0szajg/view?resourcekey=0-CxKK1fXSDWz_pam49w7nAQ");
                    }else if(message.equalsIgnoreCase("Chapter-10:Circles")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOMWplSTNJV2NHc28/view?resourcekey=0-w-Tacb-iH8G2TypCCrmfiA");
                    }else if(message.equalsIgnoreCase("Chapter-11:Constructions")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnORmFjd05weGMtLWs/view?resourcekey=0-IiscT813pWvdPiqduwBhAQ");
                    }else if(message.equalsIgnoreCase("Chapter-12:Areas Related to Circles")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnONklUaTJPalctS0U/view?resourcekey=0-MmT4NyOCFk6VxcrfulGFkQ");
                    }else if(message.equalsIgnoreCase("Chapter-13:Surface Areas and Volumes")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOWHZrb1JzY3RwOTA/view?resourcekey=0-49iXxWazuKTfdCASL7F6kA");
                    }else if(message.equalsIgnoreCase("Chapter-14:Statistics")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOQ1c4ZkthTURyMXc/view?resourcekey=0-IGLSZNSDYG1h65HYvdrYyA");
                    }else if(message.equalsIgnoreCase("Chapter-15:Probability")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOWk5sTkNUT3ZIeTA/view?resourcekey=0-HP_dIyvC7aiF5uMxaK2SHA");
                    }
                } else if(s.equalsIgnoreCase("11th Class")){
                    if(message.equalsIgnoreCase("Chapter-1:Sets")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOLXVaYk9kcWxtY1U/view?resourcekey=0-4kuChxkwMwp7rLaqSMempw");
                    }else  if(message.equalsIgnoreCase("Chapter-2:Relations and Functions")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOOW5jZFBUSXA0bk0/view?resourcekey=0-qvJKDN7oTB3NEWruGtCB0g");
                    }else  if(message.equalsIgnoreCase("Chapter-3:Trigonometric Functions")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOeXB6NmZFdnhLSXM/view?resourcekey=0-NGCYoWY8jZSAuaBQml3K6A");
                    }else  if(message.equalsIgnoreCase("Chapter-4:Principle of Mathematical Induction")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOSjBmSHhBZGxqUjQ/view?resourcekey=0-4cMMlSZUZAe7K_Xek_BMWw");
                    }else  if(message.equalsIgnoreCase("Chapter-5:Complex Numbers and Quadratic Equations")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOb1dRNjdhSWpCUTg/view?resourcekey=0-B0eiOm-FK5SlrIXEK8K8AA");
                    }else  if(message.equalsIgnoreCase("Chapter-6:Linear Inequalities")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOLXN4cmphbmJwVU0/view?resourcekey=0-UKltpVJIgaurAb3a9E2qNw");
                    }else  if(message.equalsIgnoreCase("Chapter-7:Permutation and Combinations")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnORzZnZHdHRVI0R00/view?resourcekey=0-u8Xli1W7u21La2CiNe36CA");
                    }else  if(message.equalsIgnoreCase("Chapter-8:Binomial Theorem")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOUHc2bUlnbC1KZmM/view?resourcekey=0-xDOZ3EBYm4CLYwVjT1oqFQ");
                    }else  if(message.equalsIgnoreCase("Chapter-9:Sequences and Series")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOVTdaVDFlZjV1YW8/view?resourcekey=0-xqEPLbIYzMj60RZrSwo82Q");
                    }else  if(message.equalsIgnoreCase("Chapter-10:Straight Lines")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOZ2dxNXNlZWZvQ2c/view?resourcekey=0-eu_AcViKijfVT75Nd3yeMw");
                    }else  if(message.equalsIgnoreCase("Chapter-11:Conic Sections")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOTHVZX2Jhc0Y1Qkk/view?resourcekey=0-ueCL21RDVcdnlnVn6LP45w");
                    }else  if(message.equalsIgnoreCase("Chapter-12:Introduction to three Dimensional Geometry")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOY1NzYkFFSUlzZm8/view?resourcekey=0-ffExUlCEAimmMX40Dz_lBg");
                    }
                    else  if(message.equalsIgnoreCase("Chapter-13:Limits and Derivatives")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOMWwwVFg4b2p5eTg/view?resourcekey=0-8n6RxbCK6Lk1wYf9E8yqyw");
                    }else  if(message.equalsIgnoreCase("Chapter-14:Mathematical Reasoning")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOZGtMVE1zREttclE/view?resourcekey=0-G7AEq8zNzBixKkWp3IUcwg");
                    }else  if(message.equalsIgnoreCase("Chapter-15:Statistics")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOUUhLVTBWWTF4emc/view?resourcekey=0-GupuCx_3hBwJz_znZESyvg");
                    }else  if(message.equalsIgnoreCase("Chapter-16:Probability")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOUmhNRlhjTExtOWM/view?resourcekey=0-3eR0z1iVc1JdjUxcDiWgRA");
                    }

                } else if(s.equalsIgnoreCase("12th Class")){
                    if(message.equalsIgnoreCase(chapter12[0])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOcjZkYnlrbnJGdmM/view?resourcekey=0-ejoUgOFYt-zyZp-d9-RQNQ");
                    }else if(message.equalsIgnoreCase(chapter12[1])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOVURvakdpV2JKUlk/view?resourcekey=0-YXf4Oq1J_m5pmcuwhEEIfw");
                    }else if(message.equalsIgnoreCase(chapter12[2])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOc2QtT1BmZTB1V1E/view?resourcekey=0-ZEDfvvHzq5xNQRbZYkjXJA");
                    }else if(message.equalsIgnoreCase(chapter12[3])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOc2QtT1BmZTB1V1E/view?resourcekey=0-ZEDfvvHzq5xNQRbZYkjXJA");
                    }else if(message.equalsIgnoreCase(chapter12[4])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnObzZGRVJ3SXdHNEk/view?resourcekey=0-zZ-s7Ejh-PrhUPpHWxK5xA");
                    }else if(message.equalsIgnoreCase(chapter12[5])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOVkV6WC1HdVFnZlk/view?resourcekey=0-q3U0qFFh-eR_2G1ZnfC3wg");
                    }else if(message.equalsIgnoreCase(chapter12[6])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOTjFPcjRNYy11ekk/view?resourcekey=0-aG2p__M_EaKC4nm-E1APMQ");
                    }else if(message.equalsIgnoreCase(chapter12[7])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnObW5ndTBtcDBUcnc/view?resourcekey=0-_Q17PzTAZTsex0nL5MYpwg");
                    }else if(message.equalsIgnoreCase(chapter12[8])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOMXlZdWhEWnRDM3c/view?resourcekey=0-iJN_lQ_PpYb6gePxvJluuw");
                    }else if(message.equalsIgnoreCase(chapter12[9])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOckcwd1J0RnZEMjg/view?resourcekey=0-jGILyt9LV-DBmX88HepYSA");
                    }else if(message.equalsIgnoreCase(chapter12[10])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnObTFXeF8xbmthSDQ/view?resourcekey=0-eiSJrxFCHx6cdSmAvtxdZA");
                    }else if(message.equalsIgnoreCase(chapter12[11])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOb0RyeEFMRXpCWnM/view?resourcekey=0-0wiLa3gxuK1WcExSdxiffw");
                    }else if(message.equalsIgnoreCase(chapter12[12])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOd09UcENFTVkwVzg/view?resourcekey=0-JuqGNV354UvaoOhBhaXMMw");
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
        wv.setWebViewClient(new Client());
        WebSettings ws = wv.getSettings();
        ws.setJavaScriptEnabled(true);
        wv.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        wv.clearCache(true);
        wv.clearHistory();

        wv.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String s1, String s2, String s3, long l) {
                DownloadManager.Request req = new DownloadManager.Request(Uri.parse(url));
                req.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                dm.enqueue(req);
                Toast.makeText(ChapterCalling.this, "Downloading....", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private class Client extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }

        public void onReceivedError(WebView webView, int errorCode, String description, String failingUrl) {
            try {
                webView.stopLoading();
            } catch (Exception e) {
            }

            if (webView.canGoBack()) {
                webView.goBack();
            }

            webView.loadUrl("about:blank");
            AlertDialog alertDialog = new AlertDialog.Builder(ChapterCalling.this).create();
            alertDialog.setTitle("Error");
            alertDialog.setMessage("Check your internet connection and Try again.");
            alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Try Again", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                    startActivity(getIntent());
                }
            });

            alertDialog.show();
            super.onReceivedError(webView, errorCode, description, failingUrl);
        }
    }
}