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

public class ChapterCalling3 extends AppCompatActivity {
    WebView wv;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    ProgressDialog progressDialog;
    String[] chapter12 = {
            "Chapter-1:The Solid State",
            "Chapter-2:Solutions",
            "Chapter-3:Electro chemistry",
            "Chapter-4:Chemical Kinetics",
            "Chapter-5:Surface Chemistry",
            "Chapter-6:General Principles and Processes of Isolation of Elements",
            "Chapter-7:The p Block Elements",
            "Chapter-8:The d and f Block Elements",
            "Chapter-9:Coordination Compounds",
            "Chapter-10:Haloalkanes and Haloarenes",
            "Chapter-11:Alcohols Phenols and Ethers",
            "Chapter-12:Aldehydes Ketones and Carboxylic Acids",
            "Chapter-13:Amines",
            "Chapter-14:Biomolecules",
            "Chapter-15:Polymers",
            "Chapter-16:Chemistry in Everyday Life"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_calling3);
        wv = findViewById(R.id.webView4);
        String message3 = getIntent().getStringExtra("ChapterName3");
        String message = getIntent().getStringExtra("ChapterName2");

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
                    if (message3.equalsIgnoreCase("Chapter-1:India Size & Location")) {
                        getSupportActionBar().setTitle(message3);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnONEtURFI3TU82UE0/view?resourcekey=0-QUwOEkZ5ldTOw0C1eNsSZA");
                    } else if (message3.equalsIgnoreCase("Chapter-2:Physical Feature of India")) {
                        getSupportActionBar().setTitle(message3);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOYV9kYm9XYi1qNk0/view?resourcekey=0-3ZyJk_EYTi-IYAL-biXX-w");
                    } else if (message3.equalsIgnoreCase("Chapter-3:Drainage")) {
                        getSupportActionBar().setTitle(message3);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOTkhIV0VBYi1fUU0/view?resourcekey=0-r0R7zhfCPeab_skYTrFaaw");
                    } else if (message3.equalsIgnoreCase("Chapter-4:Climate")) {
                        getSupportActionBar().setTitle(message3);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOM1JBemJuclFScDg/view?resourcekey=0-EcWnCE8LS_mFpdnWATpESg");
                    } else if (message3.equalsIgnoreCase("Chapter-5:Natural Vegetation & Wildlife")) {
                        getSupportActionBar().setTitle(message3);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOVWRUUXBLNnU1OUU/view?resourcekey=0-onFOAwaTWqMctrdfSQqNfQ");
                    } else if (message3.equalsIgnoreCase("Chapter-6:Population")) {
                        getSupportActionBar().setTitle(message3);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOemVaOGZ6a0Q2Y3c/view?resourcekey=0-dXCS75DoCBSEgZ4GH0zhug");
                    }
                } else if(s.equalsIgnoreCase("10th Class")){
                    if (message3.equalsIgnoreCase("Chapter-1:Agriculture")) {
                        getSupportActionBar().setTitle(message3);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnORXBHV0pXSjB4Zms/view?resourcekey=0-I8yL3XGnHH4VLL3-5oVkCQ");
                    }else   if (message3.equalsIgnoreCase("Chapter-2:Lifelines of National Economy")) {
                        getSupportActionBar().setTitle(message3);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOc1NMUXNXSVRzZWM/view?resourcekey=0-GABWAF-Ezp-HLtyBSRWGUg");
                    }else   if (message3.equalsIgnoreCase("Chapter-3:Manufacturing Industries")) {
                        getSupportActionBar().setTitle(message3);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOQi1IYVVsUkhkcU0/view?resourcekey=0-ft0La29Nb1UxQX5gN-Iasw");
                    }else   if (message3.equalsIgnoreCase("Chapter-4:Minerals & Energy Resources")) {
                        getSupportActionBar().setTitle(message3);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnONGtPZjBVaWdTSG8/view?resourcekey=0-QUBEt4Umh2cHIaH5UBaw8A");
                    }else   if (message3.equalsIgnoreCase("Chapter-5:Resources & Development")) {
                        getSupportActionBar().setTitle(message3);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOa0NYOVVNQV90LVE/view?resourcekey=0-Vn2CHciVVRi3hq7sYgJrBg");
                    }
                    else   if (message3.equalsIgnoreCase("Chapter-6:Water Resources")) {
                        getSupportActionBar().setTitle(message3);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOdjBDdC1EQTlSNWc/view?resourcekey=0-V9VwgxodXKAlanbgYxtTtQ");
                    }
                } else if(s.equalsIgnoreCase("11th Class")){
                    if (message.equalsIgnoreCase("Chapter-1:Some Basic Concepts of Chemistry")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOVTl6aXZrbTBKRUE/view?resourcekey=0-hqkjMAbOfGD8H24njcWnlw");
                    }else if (message.equalsIgnoreCase("Chapter-2:Structure Of The Atom")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnORlZwS20tbmNQaFk/view?resourcekey=0-8BZ-_Dmtf9MUGc8u0Uf_RQ");
                    }
                    else if (message.equalsIgnoreCase("Chapter-3:Classification of Elements and Periodicity in Properties")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOdjVWMFRBV3NoanM/view?resourcekey=0-PITeVXlLwVxI1s1ghQqwHQ");
                    }
                    else if (message.equalsIgnoreCase("Chapter-4:Chemical Bonding and Molecular Structure")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnORUJ3ZVVKUVN1VzQ/view?resourcekey=0-fz5z1IPKi5Pt5R1ykMINzg");
                    }else if (message.equalsIgnoreCase("Chapter-5:States of Matter")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnORUZCWHpqX25GQzA/view?resourcekey=0-eUd48zGpWav5KIPDX8JSFg");
                    }else if (message.equalsIgnoreCase("Chapter-6:Thermodynamics")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOWkhFYUVUWlFRRnc/view?resourcekey=0-a1dmpYiZ2bzTmXAJLjVJzA");
                    }else if (message.equalsIgnoreCase("Chapter-7:Equilibrium")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOTHkzSXY3X0xWTHM/view?resourcekey=0-sqNZ2PdL7WucG37sBrGAnA");
                    }else if (message.equalsIgnoreCase("Chapter-8:Redox Reactions")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOYjQ5cnV6V1ZONTA/view?resourcekey=0-_F1GmAYYFRpDGGz7upwViA");
                    }else if (message.equalsIgnoreCase("Chapter-9:Hydrogen")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOQU1RZnE2YXR3Nms/view?resourcekey=0-2BlDcGhE1r-EJ4meLpX00w");
                    }else if (message.equalsIgnoreCase("Chapter-10:The s-Block Elements")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnORm0yVUJDV0d0dUE/view?resourcekey=0-55tIsurv6PjQeSA3YrZ54Q");
                    }else if (message.equalsIgnoreCase("Chapter-11:The p-Block Elements")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOVkY4Y2dOcndNRk0/view?resourcekey=0-u9BKC-A2ZWPQTHIH4Y6MrA");
                    }else if (message.equalsIgnoreCase("Chapter-12:Organic Chemistry: Some Basic Principles and Techniques")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOcFBtbEktNnRXMTQ/view?resourcekey=0-JH4GNrgFLxDI1jEum86ueQ");
                    }else if (message.equalsIgnoreCase("Chapter-13:Hydrocarbons")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOMWtIUjJYSTVOZ0U/view?resourcekey=0-mQuvkOjl4fmNlX6TQmLM9w");
                    }else if (message.equalsIgnoreCase("Chapter-14:Environmental Chemistry")) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOamhLaXdaTkdSZlU/view?resourcekey=0-mDaNqSRByaTh1Deqjnhpvg");
                    }
                } else if(s.equalsIgnoreCase("12th Class")){
                    if(message.equalsIgnoreCase(chapter12[0])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOYVFKVFBKNUpGeDg/view?resourcekey=0-TfY5J074AM6oEKTIJZJ6vw");
                    }else if(message.equalsIgnoreCase(chapter12[1])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnORGxTSHhaa1NsS2M/view?resourcekey=0-JeYb1rK8g7-j7uySLRGAmg");
                    }else if(message.equalsIgnoreCase(chapter12[2])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOUl9UaVA1WWxSNVE/view?resourcekey=0-shUynl-j_9_jaWBUFTplVg");
                    }else if(message.equalsIgnoreCase(chapter12[3])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOQlR3TzVBRm1RdTg/view?resourcekey=0-3RBVdoqyGPkWjGfuCRn_yA");
                    }else if(message.equalsIgnoreCase(chapter12[4])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOYU5BNXhQcXp4V1U/view?resourcekey=0-b25sNDrV3EY4a_UoGMZYwg");
                    }else if(message.equalsIgnoreCase(chapter12[5])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOVzBxU0RROFZqN1k/view?resourcekey=0-6egB9Fjd1cRxjfoUpSeH_g");
                    }else if(message.equalsIgnoreCase(chapter12[6])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOYjlRLU5pTDJXNUk/view?resourcekey=0-_Yu_NX80XMB7IrLgiEseRQ");
                    }else if(message.equalsIgnoreCase(chapter12[7])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOQ0hfLU5oQ1F3Nms/view?resourcekey=0-CbBQ-e9PXpVrgPAi4zEVkg");
                    }else if(message.equalsIgnoreCase(chapter12[8])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOdlUxUkVfN1JibW8/view?resourcekey=0-g-NbDA5kIRYvJ-hyJlA_sA");
                    }else if(message.equalsIgnoreCase(chapter12[9])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnORURRNDN3S1hTczg/view?resourcekey=0-Xr-C7a_22mqymYP31A_UZA");
                    }else if(message.equalsIgnoreCase(chapter12[10])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOUWZHeXNIX1RCWVU/view?resourcekey=0-21ghZ-ybLULZdVpAVSSD1Q");
                    }else if(message.equalsIgnoreCase(chapter12[11])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOV0ZVMjNPZlZZU2s/view?resourcekey=0-hZI8QMZPG1DdX54IU7fYIA");
                    }else if(message.equalsIgnoreCase(chapter12[12])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOVkZmMnRUVFdEVms/view?resourcekey=0-Wqj-tg_Ng4he0ry9UgVF2A");
                    }else if(message.equalsIgnoreCase(chapter12[13])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOMFVWbkV3QnBmMmM/view?resourcekey=0-UqFKgng1MXj5pVsZDDvVfw");
                    }else if(message.equalsIgnoreCase(chapter12[14])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnON19VWF9YS1ZzRjA/view?resourcekey=0-r537I7roOmT6MMbMZM5_iA");
                    }else if(message.equalsIgnoreCase(chapter12[15])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOdE1Qa1hLV1lhdjA/view?resourcekey=0-YXRcuOkf0LD_5XbPlNS4EA");
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
                Toast.makeText(ChapterCalling3.this, "Downloading....", Toast.LENGTH_SHORT).show();
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
            AlertDialog alertDialog = new AlertDialog.Builder(ChapterCalling3.this).create();
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