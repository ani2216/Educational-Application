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
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.sidebar.fragment.science;
import com.google.android.gms.common.api.Api;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class ChapterCalling2 extends AppCompatActivity {
    WebView wv;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    ProgressDialog progressDialog;
    String[] chapter12={
            "Chapter-1:Electric Charges And Fields",
            "Chapter-2:Electrostatic Potential And Capacitance",
            "Chapter-3:Current Electricity",
            "Chapter-4:Moving Charges And Magnetism",
            "Chapter-5:Magnetism And Matter",
            "Chapter-6:Electromagnetic Induction",
            "Chapter-7:Alternating Current",
            "Chapter-8:Electromagnetic Waves",
            "Chapter-9:Ray Optics And Optical Instruments",
            "Chapter-10:Wave Optics",
            "Chapter-11:Dual Nature Of Radiation And Matter",
            "Chapter-12:Atoms",
            "Chapter-13:Nuclei",
            "Chapter-14:Semiconductor Electronics Materials Devices And Simple Circuits",
            "Chapter-15:Communication Systems"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_calling2);
        wv = findViewById(R.id.webView2);
        String message1 = getIntent().getStringExtra("ChapterName1");

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
                    if (message1.equalsIgnoreCase("Chapter-1:Matter in Our Surroundings")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnObG9FMmlRZ2F4REk/view?resourcekey=0-JbYQFKNyaljwnGjqHhLEVA");
                    } else if (message1.equalsIgnoreCase("Chapter-2:Is Matter Around Us Pure")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOWGMyRl85U2dyNmM/view?resourcekey=0-69BikWzKJhflaWtOKgUfug");
                    } else if (message1.equalsIgnoreCase("Chapter-3:Atoms and Molecules")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOYjYzWTdrXzhZeVk/view?resourcekey=0-okWVVFTDX-KikpinCQUCtg");
                    } else if (message1.equalsIgnoreCase("Chapter-4:Structure of the Atom")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOT05mOFJqNl9aVnc/view?resourcekey=0-Rx8uISQer6r1mmPjYtnztQ");
                    } else if (message1.equalsIgnoreCase("Chapter-5:The Fundamental Unit of Life")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOaTNHMXhfMExqQjQ/view?resourcekey=0-gbj23Z-sjfTLKQKL80woPg");
                    } else if (message1.equalsIgnoreCase("Chapter-6:Tissues")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOc1IyaFBuYmFNMW8/view?resourcekey=0-9o3uIMHf_hCYG_VBEZrRdw");
                    } else if (message1.equalsIgnoreCase("Chapter-7:Diversity in Living Organisms")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOY2gyR1NOMVIxRWs/view?resourcekey=0-aa90GDEXDkQfMiAkU73twg");
                    } else if (message1.equalsIgnoreCase("Chapter-8:Motion")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOcGE4UnlqbG5UQjg/view?resourcekey=0-ATYYgb5CHQx4cY-2Aw6Cug");
                    } else if (message1.equalsIgnoreCase("Chapter-9:Force and Laws of Motion")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOZW0zNWRDNFk1VkE/view?resourcekey=0-Jd3itYe7BUa8mtwLJpG6Mg");
                    } else if (message1.equalsIgnoreCase("Chapter-10:Gravitation")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnON1Z5MFgwMS1maGc/view?resourcekey=0-dDOVaw_0tenN4kBKEvCiQA");
                    } else if (message1.equalsIgnoreCase("Chapter-11:Work, Power And Energy")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOQXVGUXVxTDZyM2s/view?resourcekey=0-ZwRncjcc3C-EgrHN6drB1Q");
                    } else if (message1.equalsIgnoreCase("Chapter-12:Sound")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOZEFpQzNqWHVJUFE/view?resourcekey=0-xgQyJqh9zvDPEJcXTckTeQ");
                    } else if (message1.equalsIgnoreCase("Chapter-13:Why Do we Fall Ill")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOQ2doUy0tTTBoOFU/view?resourcekey=0-8d1akwqxcon0xV_07a9YvQ");
                    } else if (message1.equalsIgnoreCase("Chapter-14:Natural Resources")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOZktDNU9pSVBxT0E/view?resourcekey=0-GFmkos3bfrzY8J_GRDIInw");
                    } else if (message1.equalsIgnoreCase("Chapter-15:Improvement in Food Resources")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOYzlvZTJobnJZajQ/view?resourcekey=0-bT3cktCwadD2THeQjBqKUQ");
                    }
                } else if(s.equalsIgnoreCase("10th Class")){
                    if (message1.equalsIgnoreCase("Chapter-1:Chemical Reactions and Equations")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOc3VLSS1RdDZtZ00/view?resourcekey=0-hL4C_JQy9uhi5lDWPrbKOg");
                    } else if (message1.equalsIgnoreCase("Chapter-2:Acids, Bases and Salts")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOeTZ6d3o5cXRkRGM/view?resourcekey=0-HhYqioxpPhBlPvApkJMEMA");
                    } else if (message1.equalsIgnoreCase("Chapter-3:Metals and Non-metals")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOaFVJRGpDSDItX00/view?resourcekey=0-cMW8LizOA40d6HT0nAiWDQ");
                    }else if (message1.equalsIgnoreCase("Chapter-4:Carbon and its Compounds")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOYk5Nd1lmdVh5MG8/view?resourcekey=0-KY5O0050HGVYZlPAEvyDBQ");
                    }else if (message1.equalsIgnoreCase("Chapter-5:Periodic Classification of Elements")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnObjJ3SHExajVJbUU/view?resourcekey=0-65biE3jhK2WWd5XxfFJZtw");
                    }else if (message1.equalsIgnoreCase("Chapter-6:Life Processes")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOa1J5Q2RMODNJd2s/view?resourcekey=0-C2inyX8y0vZpqWnMnrgsZA");
                    }else if (message1.equalsIgnoreCase("Chapter-7:Control and Coordination")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOUTFIVnVlc1ktMGM/view?resourcekey=0-puGd84Whi9bIeEjIJ9vcyw");
                    }else if (message1.equalsIgnoreCase("Chapter-8:How do Organisms Reproduce?")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOQXBxMmZVeGRJS28/view?resourcekey=0-8OiCLwJDkuT7s0QUABFiCA");
                    }else if (message1.equalsIgnoreCase("Chapter-9:Heredity and Evolution")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOekd4VkJUdzREckE/view?resourcekey=0-Ab4dx6LvNkjmzI5YEPoE6w");
                    }else if (message1.equalsIgnoreCase("Chapter-10:Light - Reflection and Refraction")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOWktpMktlRm5RRjg/view?resourcekey=0-i9zVBp8UvclxMg8YmUOTRA");
                    }else if (message1.equalsIgnoreCase("Chapter-11:Human Eye and Colourful World")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOOWNCNXZmdlYybnc/view?resourcekey=0-73YUzYqd9G26c8rcdNML1g");
                    }else if (message1.equalsIgnoreCase("Chapter-12:Electricity")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOYjVadmdGYW52UVE/view?resourcekey=0-RCEs3SP2EFiH_tE2M44W5A");
                    }else if (message1.equalsIgnoreCase("Chapter-13:Magnetic Effects of Electric Current")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOWW52R2VrMUdZMkE/view?resourcekey=0-x8q9T21kxaI7BFL-oGt-bw");
                    }
                    else if (message1.equalsIgnoreCase("Chapter-14:Sources of Energy")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOTUhCbXFHR2U2b3M/view?resourcekey=0-Koooc0U6OGd2oKVDnYdnIw");
                    }else if (message1.equalsIgnoreCase("Chapter-15:Our Environment")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOTTNKa2tDVkVrTXM/view?resourcekey=0-ZlFGahcrrOVvNMu19Sm1gg");
                    }else if (message1.equalsIgnoreCase("Chapter-16:Management of Natural Resources")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOZ2F4UHEtOXRsSU0/view?resourcekey=0-tDe_q5nkv85FU49_b5IPUw");
                    }
                } else if(s.equalsIgnoreCase("11th Class")){
                    if (message1.equalsIgnoreCase("Chapter-1:Physical World")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOaW11LXVrYXRfWkE/view?resourcekey=0-grdms7w_onD2jPZjRyBRbQ");
                    }else  if (message1.equalsIgnoreCase("Chapter-2:Units and Measurements")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOZXlQX1ZNM0VxNkU/view?resourcekey=0-cUKpd3_vOHIOGTvxSoSRiQ");
                    }
                    else  if (message1.equalsIgnoreCase("Chapter-3:Motion in a Straight Line")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOblQ5dmRaX0k4LUU/view?resourcekey=0-m7_mfa5JHTb6FOe2Metl5w");
                    }else  if (message1.equalsIgnoreCase("Chapter-4:Motion in a plane")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOTmVzX2lCdzlKdU0/view?resourcekey=0-x3RaEv5GNnwUl4TrzefYSA");
                    }else  if (message1.equalsIgnoreCase("Chapter-5:Laws of motion")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOLW54bzBWNVJuZW8/view?resourcekey=0-RbFeWCFkH8QiXAL8W6HQkw");
                    }else  if (message1.equalsIgnoreCase("Chapter-6:Work Energy and power")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOM2hqSWRfcVVyRHc/view?resourcekey=0-mOjHnDcstJGcxCKHizxP3Q");
                    }else  if (message1.equalsIgnoreCase("Chapter-7:System of particles and Rotational Motion")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnONWVjN3M2WVNWMlk/view?resourcekey=0-ApHyTqG2lYe2jQX0PxRXwg");
                    }else  if (message1.equalsIgnoreCase("Chapter-8:Gravitation")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnONGxVeEFVWVcxY28/view?resourcekey=0-_GSi0mbBCnQ3YQy8xd7I6g");
                    }else  if (message1.equalsIgnoreCase("Chapter-9:Mechanical Properties Of Solids")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnONU52ZjM5WHhNWVk/view?resourcekey=0-jz7Sm7WMOVa-vIopEwqouQ");
                    }else  if (message1.equalsIgnoreCase("Chapter-10:Mechanical Properties Of Fluids")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOSVg0NjFKalotelU/view?resourcekey=0-gIwlM5iYYbUYFw-nx9fYRA");
                    }else  if (message1.equalsIgnoreCase("Chapter-11:Thermal Properties of matter")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOOGhTLXVLTUt4Z28/view?resourcekey=0-ezpXoaQBct5kmvPws1YRyA");
                    }else  if (message1.equalsIgnoreCase("Chapter-12:Thermodynamics")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnONklRTGdMVFF5R2M/view?resourcekey=0-rIQBrJHMGw-aHbxYfIZrbA");
                    }else  if (message1.equalsIgnoreCase("Chapter-13:Kinetic Theory")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOcTJtRXNZclBHU1U/view?resourcekey=0-0xodvCafc-BcVmB4xQODBg");
                    }else  if (message1.equalsIgnoreCase("Chapter-14:Oscillations")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOcTMyMlEzV29LWUk/view?resourcekey=0-fcryDeHnyobvUUJU_WnH_g");
                    }else  if (message1.equalsIgnoreCase("Chapter-15:Waves")) {
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOM19jZUtSWUVjVWs/view?resourcekey=0-fLWYqqr9hwlPD-fDJKmtKg");
                    }
                } else if(s.equalsIgnoreCase("12th Class")){
                    if(message1.equalsIgnoreCase(chapter12[0])){
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOUVFQb2NpaHdVRW8/view?resourcekey=0-Q1nZjd4NeyIrqckRCqA_dQ");
                    }else  if(message1.equalsIgnoreCase(chapter12[1])){
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOdThWMkFKSGRlR3M/view?resourcekey=0-xWVcABYrASLsc8L3UIOpsA");
                    }else  if(message1.equalsIgnoreCase(chapter12[2])){
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnORDJZUXhhckhmR1E/view?resourcekey=0-HMedebty9qRS2dZOvTOOqQ");
                    }else  if(message1.equalsIgnoreCase(chapter12[3])){
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOTk5SLUFNZEZabm8/view?resourcekey=0-ER95wfDqu0F9XXk3IFjISw");
                    }else  if(message1.equalsIgnoreCase(chapter12[4])){
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOa2JSOHUzTVdoTGs/view?resourcekey=0-KG7HbOmY6C3TkGvdDPKt2g");
                    }else  if(message1.equalsIgnoreCase(chapter12[5])){
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOd3BEdDg3UDdJMVU/view?resourcekey=0-En4v1ylj__18oHz-uhMOGg");
                    }else  if(message1.equalsIgnoreCase(chapter12[6])){
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOY29qUTRuQmxvUU0/view?resourcekey=0-4il-tZeqQj9ytRN-j0Dtbg");
                    }else  if(message1.equalsIgnoreCase(chapter12[7])){
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOQVhTR0IwT0Uxd2c/view?resourcekey=0-V2UglUvZCh4CmNcNc0GF7w");
                    }else  if(message1.equalsIgnoreCase(chapter12[8])){
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOc2ZZakgtX2NBNVU/view?resourcekey=0-XhxccmizzZsstWJaEOAZpg");
                    }else  if(message1.equalsIgnoreCase(chapter12[9])){
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOOXhfamFBRWFodlU/view?resourcekey=0-ryOuv9r0zjL7RkjKNWbIBA");
                    }else  if(message1.equalsIgnoreCase(chapter12[10])){
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOVXNyemtreDNrUzA/view?resourcekey=0-X8gQ--VSiszfPoQc0yD45g");
                    }else  if(message1.equalsIgnoreCase(chapter12[11])){
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOVHg5eTh2M1BNU3c/view?resourcekey=0-AGwC5UyWfO_ozd4vFQavbg");
                    }else  if(message1.equalsIgnoreCase(chapter12[12])){
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOY3drMU9PQ3Q2VkU/view?resourcekey=0-tI2daBkfYObGnPKt81xi7w");
                    }else  if(message1.equalsIgnoreCase(chapter12[13])){
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOb3dlWjIyem1ydms/view?resourcekey=0-CRrtKDzFcaGWH7VcPX6IJA");
                    }else  if(message1.equalsIgnoreCase(chapter12[14])){
                        getSupportActionBar().setTitle(message1);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOeDVqSVFPRURLNHc/view?resourcekey=0-4-4B7y6U72iHGDfck8SuFQ");
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
                Toast.makeText(ChapterCalling2.this, "Downloading....", Toast.LENGTH_SHORT).show();
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
            AlertDialog alertDialog = new AlertDialog.Builder(ChapterCalling2.this).create();
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