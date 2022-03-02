package com.example.sidebar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class ChapterCalling4 extends AppCompatActivity {
    WebView wv;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_calling4);

        wv = findViewById(R.id.webView5);
        String message4 = getIntent().getStringExtra("ChapterName4");
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        String id = firebaseUser.getUid();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("content").child(id);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                String s = snapshot.child("spinner1").getValue(String.class);
                if(s.equalsIgnoreCase("9th Class")) {
                    if (message4.equalsIgnoreCase("Chapter-1:The French Revolution")) {
                        getSupportActionBar().setTitle(message4);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOMTVwbWhZcVAzSmM/view?resourcekey=0-BT1ZfEq9QV7b_TPDiA8XZw");
                    } else if (message4.equalsIgnoreCase("Chapter-2:Socialism In Europe")) {
                        getSupportActionBar().setTitle(message4);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOc2pxczBDaEFMbUk/view?resourcekey=0-1huibpXb2t4Dau1DTeSmzw");
                    } else if (message4.equalsIgnoreCase("Chapter-3:Nazism & The Rise of Hitler")) {
                        getSupportActionBar().setTitle(message4);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOelFBN3NSU1BHUVU/view?resourcekey=0-cyJ3LwkcWw4drknx5-QNHw");
                    } else if (message4.equalsIgnoreCase("Chapter-4:Forest Society & Colonialism")) {
                        getSupportActionBar().setTitle(message4);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOaHJiNkFfV3ZQVTQ/view?resourcekey=0-xFtx1D2DsL_Isszwzk-lUw");
                    } else if (message4.equalsIgnoreCase("Chapter-5:Pastoralists In The Modern World")) {
                        getSupportActionBar().setTitle(message4);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnObU54MWxQSjlZUnc/view?resourcekey=0-n4HUCwF3P5d5wo7o1WxRyA");
                    } else if (message4.equalsIgnoreCase("Chapter-6:Peasants & Farmers")) {
                        getSupportActionBar().setTitle(message4);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOMXFQa3A3YjN3bXc/view?resourcekey=0-AlerAbE55jX3caDUHFlzsw");
                    } else if (message4.equalsIgnoreCase("Chapter-7:History & Sport - The Story Of Cricket")) {
                        getSupportActionBar().setTitle(message4);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOQUIybXFvOWtwdEE/view?resourcekey=0-viU03w8UFU1ayhg2ynVytw");
                    } else if (message4.equalsIgnoreCase("Chapter-8:Clothing - A Social History")) {
                        getSupportActionBar().setTitle(message4);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOeWtvUDVMRm9BblE/view?resourcekey=0-OIbQnLa1ritgoq2zwfoKfA");
                    }
                } else if(s.equalsIgnoreCase("10th Class")){
                    if (message4.equalsIgnoreCase("Chapter-1:The Making of Global World")) {
                        getSupportActionBar().setTitle(message4);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOY3RVdjRzNmYxcnc/view?resourcekey=0-T1BbMvSo0DiJz48wL0Hp-g");
                    }else if (message4.equalsIgnoreCase("Chapter-2:The Age of Industrialization")) {
                        getSupportActionBar().setTitle(message4);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOUlhESDJ1SENoZTQ/view?resourcekey=0-D1-Nuynv-jGmZrhn78c_MQ");
                    }else if (message4.equalsIgnoreCase("Chapter-3:Print Culture and The Modern World")) {
                        getSupportActionBar().setTitle(message4);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOcTlZeXcwZkxpRjA/view?resourcekey=0-EfEx8OGumt6WSUXo12ANOg");
                    }else if (message4.equalsIgnoreCase("Chapter-4:Nationalism In India")) {
                        getSupportActionBar().setTitle(message4);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOUkJyRTI1V3Z1ZG8/view?resourcekey=0-FqqnagLxTwL3q-qlFc9Cbw");
                    }else if (message4.equalsIgnoreCase("Chapter-5:Nationalism and Imperialism")) {
                        getSupportActionBar().setTitle(message4);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOV2lJZUUwMG41c0E/view?resourcekey=0-nXEAykQIllApVgHU4e_gzA");
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
            Toast.makeText(ChapterCalling4.this, "Downloading....", Toast.LENGTH_SHORT).show();
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
            AlertDialog alertDialog = new AlertDialog.Builder(ChapterCalling4.this).create();
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