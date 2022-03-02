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
import com.google.firebase.database.annotations.NotNull;

public class ChapterCalling5 extends AppCompatActivity {

    WebView wv;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    ProgressDialog progressDialog;
    String[] chapter12 = {
            "Ch-01:Planning in Sports",
            "Ch-02:Adventure Sports and Leadership Training",
            "Ch-03:Sports and Nutrition",
            "Ch-04:Correct Posture",
            "Ch-05:Children and Sports",
            "Ch-06:Women and Sports",
            "Ch-07:Test and Measurement in Sports",
            "Ch-08:Physiology and Sports",
            "Ch-09:Sports and Medicine",
            "Ch-10:Biomechanics and Sports",
            "Ch-11:Psychology and Sports",
            "Ch-12:Training in Sports"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_calling5);

        wv = findViewById(R.id.webView6);
        String message6 = getIntent().getStringExtra("ChapterName6");
        String message = getIntent().getStringExtra("PE");
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
                    if (message6.equalsIgnoreCase("Chapter-1:People As Resources")) {
                        getSupportActionBar().setTitle(message6);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOa2JFWnYyT0JMY2c/view?resourcekey=0-8cPdIrpGtv-n7jbitXJtmg");
                    } else if (message6.equalsIgnoreCase("Chapter-2:Story of Palampur")) {
                        getSupportActionBar().setTitle(message6);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnONkRSVmdzMlpLNWc/view?resourcekey=0-ZXtAxIQUgVRiAkOiYXVMqA");
                    } else if (message6.equalsIgnoreCase("Chapter-3:Poverty as Challenge")) {
                        getSupportActionBar().setTitle(message6);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOcUNhRGVkd1pCSEk/view?resourcekey=0-MNb1jBCRdnb_-MnNkhMWxQ");
                    } else if (message6.equalsIgnoreCase("Chapter-4:Food Security In India")) {
                        getSupportActionBar().setTitle(message6);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOT05KbW9kWkFqVk0/view?resourcekey=0-cvL8xFNMs7tAbtVAQAo7JA");
                    }
                } else if(s.equalsIgnoreCase("10th Class")){
                    if (message6.equalsIgnoreCase("Chapter-1:Consumer Rights")) {
                        getSupportActionBar().setTitle(message6);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOM1VXbUNPX1p2TG8/view?resourcekey=0-awvBk-hxqiRwA8wix-rKvg");
                    }else  if (message6.equalsIgnoreCase("Chapter-2:Development")) {
                        getSupportActionBar().setTitle(message6);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnORTE0bVV5ZktCY1E/view?resourcekey=0-VYOyjon3W7gmEjAtHY_7Bw");
                    }else  if (message6.equalsIgnoreCase("Chapter-3:Globalization & The Indian Economy")) {
                        getSupportActionBar().setTitle(message6);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOWklMWXJ5V3d3NzA/view?resourcekey=0-Cv7W8h3S2eqVKqVpHz-G0Q");
                    }else  if (message6.equalsIgnoreCase("Chapter-4:Money & Credit")) {
                        getSupportActionBar().setTitle(message6);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOdFhhb0lKMEFJOHM/view?resourcekey=0-gF3t5OxOFut95LgyrR1-_A");
                    }else  if (message6.equalsIgnoreCase("Chapter-5:Sectors of the Indian Economy")) {
                        getSupportActionBar().setTitle(message6);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOSkd3SnllcmQ1Z2M/view?resourcekey=0-BIbapyx8RrUhgcyNKnkvnw");
                    }
                } else if(s.equalsIgnoreCase("11th Class")){
                    if(message.equalsIgnoreCase("Chapter-01:Changing Trends and Careers")){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnONlFKWTU3MlY4b2s/view?resourcekey=0-VrJBMUQOfdt3b4isijxxYg");
                    }else if(message.equalsIgnoreCase("Chapter-02:Physical Fitness and Wellness")){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOdFdVUEdUMXpmTHM/view?resourcekey=0-90dHgJ0CXT05SA4CT7Yzmg");
                    }else if(message.equalsIgnoreCase("Chapter-03:Olympic Movement")){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOU3BCWHVlakFpUVE/view?resourcekey=0-B1zsi7IiepI85qsFw7zRiQ");
                    }else if(message.equalsIgnoreCase("Chapter-04:Yoga")){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOWFl6dUo2R084QkU/view?resourcekey=0-TNj72a_XmL1kmgPFvN8h2Q");
                    }else if(message.equalsIgnoreCase("Chapter-05:Doping")){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnObUJtYmJKTDM3b1E/view?resourcekey=0-_WjFk6FvuCNVa16GY4ex0g");
                    }else if(message.equalsIgnoreCase("Chapter-06:Physical Activity Environment")){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnObkxQQUNwQUMxR3M/view?resourcekey=0-F9sGgmSXehub9UhSgpt1-w");
                    }else if(message.equalsIgnoreCase("Chapter-07:Test and Measurement in Sports")){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnObFVBaWJyQWZPcUU/view?resourcekey=0-phMPHq0twm3bc_lE4Pl26g");
                    }else if(message.equalsIgnoreCase("Chapter-08:Fundamental of Anatomy")){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOY0dqZHNmN0pOSWs/view?resourcekey=0-z-ZtPuiEaWu0wqK336eS_A");
                    }else if(message.equalsIgnoreCase("Chapter-09:Biomechanics in Sports")){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOUXExakNaYVpMZ3M/view?resourcekey=0-BYGIBXAyDgPjpTrJwCaSgA");
                    }else if(message.equalsIgnoreCase("Chapter-10:Psychology and Sports")){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOSVFMZHpGSUo4Rnc/view?resourcekey=0-XcZSPsNtN4-sWv_j8Fl0QA");
                    }else if(message.equalsIgnoreCase("Chapter-11:Training in Sports")){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnORGRQbnlrZWMtUTA/view?resourcekey=0-eHatbWROg4XA6kCD-R1ZBg");
                    }
                } else if(s.equalsIgnoreCase("12th Class")){
                    if(message.equalsIgnoreCase(chapter12[0])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOSVRPMUp6UnJJbjg/view?resourcekey=0-V5xColbj3Ku8l8VyeBkqdg");
                    }else  if(message.equalsIgnoreCase(chapter12[1])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOU3NYUzl0bzBNazA/view?resourcekey=0-TUVVBoQvH9SKFxai-GQhQg");
                    }else  if(message.equalsIgnoreCase(chapter12[2])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOXzlpNmhFbEVoa0k/view?resourcekey=0-0HAwQGdCPNGBIM2eTgH8Bw");
                    }else  if(message.equalsIgnoreCase(chapter12[3])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOUmpfZk5VY28yMU0/view?resourcekey=0-Z29UwO1FPUXWLb39oMwMGg");
                    }else  if(message.equalsIgnoreCase(chapter12[4])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOekFEVnNiM0owUmc/view?resourcekey=0-sWA-HY4u_M2muqggo1OWZw");
                    }else  if(message.equalsIgnoreCase(chapter12[5])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOWTRPcW1zOS11bUE/view?resourcekey=0-OQuNkNHhcv-4gasJKnr_7Q");
                    }else  if(message.equalsIgnoreCase(chapter12[6])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOSE03RGtRdGc5VkE/view?resourcekey=0-DmFwJ1b3SM5-9XNzmMr2mA");
                    }else  if(message.equalsIgnoreCase(chapter12[7])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOSGlPcmtyY2ppREE/view?resourcekey=0-MoH4hjyGFFChX2aneFQXEg");
                    }else  if(message.equalsIgnoreCase(chapter12[8])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnObmtScmVrMjR6SGc/view?resourcekey=0-l44LnfeEvuQxGmqP3Uf3BA");
                    }else  if(message.equalsIgnoreCase(chapter12[9])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOcUVfUU1vTmliSUk/view?resourcekey=0-TQS1fj78R-_t12L-LCGXZg");
                    }else  if(message.equalsIgnoreCase(chapter12[10])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnONnJoZEt1WDY3a0k/view?resourcekey=0-dRWhmuOwnETxexaaWz1ruQ");
                    }else  if(message.equalsIgnoreCase(chapter12[11])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnObWZVc2tZOFFVaUE/view?resourcekey=0-Y7X8HWYz0cdUUbuWF2yw5Q");
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
                Toast.makeText(ChapterCalling5.this, "Downloading....", Toast.LENGTH_SHORT).show();
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
            AlertDialog alertDialog = new AlertDialog.Builder(ChapterCalling5.this).create();
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