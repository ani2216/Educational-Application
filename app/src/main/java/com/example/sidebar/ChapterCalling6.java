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

public class ChapterCalling6 extends AppCompatActivity {

    WebView wv;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    ProgressDialog progressDialog;

    String[] chapter11 = {
            "Chapter-1:The Living World",
            "Chapter-2:Biological Classification",
            "Chapter-3:Plant Kingdom",
            "Chapter-4:Animal Kingdom",
            "Chapter-5:Morphology of Flowering Plants",
            "Chapter-6:Anatomy of Flowering Plants",
            "Chapter-7:Structural Organisation in Animals",
            "Chapter-8:Cell The Unit of Life",
            "Chapter-9:Biomolecules",
            "Chapter-10:Cell Cycle and Cell Division",
            "Chapter-11:Transport in Plants",
            "Chapter-12:Mineral Nutrition",
            "Chapter-13:Photosynthesis in Higher Plants",
            "Chapter-14:Respiration in Plants",
            "Chapter-15:Plant Growth and Development",
            "Chapter-16:Digestion and Absorption",
            "Chapter-17:Breathing and Exchange of Gases",
            "Chapter-18:Body Fluids and Circulation",
            "Chapter-19:Excretory Products and their Elimination",
            "Chapter-20:Locomotion and Movement",
            "Chapter-21:Neural Control and Coordination",
            "Chapter-22:Chemical Coordination and Integration",
    };

    String[] chapter12={
            "Chapter-1:Reproduction in Organisms",
            "Chapter-2:Sexual Reproduction in Flowering Plants",
            "Chapter-3:Human Reproduction",
            "Chapter-4:Reproductive Health",
            "Chapter-5:Principles of Inheritance and Variation",
            "Chapter-6:Molecular Basis of Inheritance",
            "Chapter-7:Evolution",
            "Chapter-8:Human Health and Disease",
            "Chapter-9:Strategies for Enhancement in Food Production",
            "Chapter-10:Microbes in Human Welfare",
            "Chapter-11:Biotechnology: Principles And Processes",
            "Chapter-12:Biotechnology and its Applications",
            "Chapter-13:Organisms and Populations",
            "Chapter-14:Ecosystem",
            "Chapter-15:Biodiversity and Conservation",
            "Chapter-16:Environmental Issues"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_calling4);

        wv = findViewById(R.id.webView5);
        String message5 = getIntent().getStringExtra("ChapterName5");
        String message = getIntent().getStringExtra("ChapterBiology");
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
                    if (message5.equalsIgnoreCase("Chapter-1:Democracy in the Contemporary World")) {
                        getSupportActionBar().setTitle(message5);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOWHFvajBtTGZGa0U/view?resourcekey=0-eLGizCTsahiGYu8IN32F2Q");
                    } else if (message5.equalsIgnoreCase("Chapter-2:What is Democracy & Why Democracy?")) {
                        getSupportActionBar().setTitle(message5);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOWmlkcGR4WWFObUU/view?resourcekey=0-TEGthzVvy-hp9j81VYxVhg");
                    } else if (message5.equalsIgnoreCase("Chapter-3:Constitutional Design")) {
                        getSupportActionBar().setTitle(message5);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOMGRMRkxEUkd4eWM/view?resourcekey=0-at1lFR5JsGIMZ2FUlQBp9Q");
                    } else if (message5.equalsIgnoreCase("Chapter-4:Electoral Design")) {
                        getSupportActionBar().setTitle(message5);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnONlNuYnBzMkhYeWc/view?resourcekey=0-lvzGlNfVcv2IzcMB8hYJpg");
                    } else if (message5.equalsIgnoreCase("Chapter-5:Working of Institutions")) {
                        getSupportActionBar().setTitle(message5);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOUTQ0NEZ6SzZMNnc/view?resourcekey=0-myWiGzZ30Z-Tfz4A6Nu9mQ");
                    } else if (message5.equalsIgnoreCase("Chapter-6:Democratic Rights")) {
                        getSupportActionBar().setTitle(message5);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOWVFKZEtIVnRfZHc/view?resourcekey=0-Fagr-z2ZKa9TkXpGZk_S5w");
                    }
                } else  if(s.equalsIgnoreCase("10th Class")){
                    if (message5.equalsIgnoreCase("Chapter-1:Power Sharing")) {
                        getSupportActionBar().setTitle(message5);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOWjQxSVd1S243aVE/view?resourcekey=0-MMUBCkJ4OckPgxqqTTSPKA");
                    }else  if (message5.equalsIgnoreCase("Chapter-2:Federalism")) {
                        getSupportActionBar().setTitle(message5);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOWTdXdm1JWnJ1d1U/view?resourcekey=0-zAXEDi3fsxGhUZz38BCUlg");
                    }
                    else  if (message5.equalsIgnoreCase("Chapter-3:Democracy and Diversity")) {
                        getSupportActionBar().setTitle(message5);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOS0VsR2JxNjNBWDA/view?resourcekey=0-M9Rp5mVR7IA-Bvr4ooOeHA");
                    }
                    else  if (message5.equalsIgnoreCase("Chapter-4:Gender, Religion and Caste")) {
                        getSupportActionBar().setTitle(message5);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOajBLcTdmcVFVVDQ/view?resourcekey=0-jVG2ITn-lRmqFu9Gxi6GIw");
                    }else  if (message5.equalsIgnoreCase("Chapter-5:Popular Struggles and Movements")) {
                        getSupportActionBar().setTitle(message5);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOemcyLU80MGRBZkU/view?resourcekey=0-241_DfbT02DiC6pAvEqEgg");
                    }
                    else  if (message5.equalsIgnoreCase("Chapter-6:Political Parties")) {
                        getSupportActionBar().setTitle(message5);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOdzhwSmhQWm04WHc/view?resourcekey=0-O6D1eCfut_yo6z-VmLWcWQ");
                    }
                    else  if (message5.equalsIgnoreCase("Chapter-7:Outcomes of Democracy")) {
                        getSupportActionBar().setTitle(message5);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOV2V4UFlCUHBHdGc/view?resourcekey=0-bQzs2F6_q5dem7Ivry_Dfw");
                    }else  if (message5.equalsIgnoreCase("Chapter-8:Challenges to Democracy")) {
                        getSupportActionBar().setTitle(message5);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOMnR1RkxfbFRYbDg/view?resourcekey=0-Nhe5vrIXd2I_jJnEk6G1ag");
                    }
                } else if(s.equalsIgnoreCase("11th Class")){
                    if (message.equalsIgnoreCase(chapter11[0])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOV1ZhNmJWTFIzSGs/view?resourcekey=0-srIeTt3qMg3FqAeqCRE3eg");
                    }else if (message.equalsIgnoreCase(chapter11[1])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOc1JkRjlVUnozTmM/view?resourcekey=0-J8rXD-zojNrEt6VO5421iw");
                    }
                    else if (message.equalsIgnoreCase(chapter11[2])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOaUpDMkpVdC1DMVk/view?resourcekey=0-cNu_qC7mYBtHqRE-RfOCqA");
                    }else if (message.equalsIgnoreCase(chapter11[3])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOZ1R6WjVGaDN4S1U/view?resourcekey=0-Oy8aUM1yxRnaFmv_VYsPsQ");
                    }else if (message.equalsIgnoreCase(chapter11[4])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOcGRwTlpUMkF3UHc/view?resourcekey=0-EhfXkaB0uVWFc3-kM_lrIA");
                    }else if (message.equalsIgnoreCase(chapter11[5])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOd2IxcFV6SzAyNzg/view?resourcekey=0-JuYWRz3fhkVPS6sii8YVHg");
                    }else if (message.equalsIgnoreCase(chapter11[6])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOaXJnVnNva091VjQ/view?resourcekey=0-JMfr5LpM4kJsw_5SebNBXw");
                    }else if (message.equalsIgnoreCase(chapter11[7])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnORnZ2ZnBQSy1oUms/view?resourcekey=0-W8aNAxFtG9M9ke-oaXoykg");
                    }else if (message.equalsIgnoreCase(chapter11[8])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOSkt1OGFFY0l6SWc/view?resourcekey=0-ydeePnjC0BomxyxJn5mSpg");
                    }else if (message.equalsIgnoreCase(chapter11[9])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnORnItWk9PMnA3dWM/view?resourcekey=0-P0CzyYVIp3NohnPpw9CWJw");
                    }else if (message.equalsIgnoreCase(chapter11[10])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOS1hKNXdXT2hsWU0/view?resourcekey=0-V89mCjKfrHFfzVSr_134ew");
                    }else if (message.equalsIgnoreCase(chapter11[11])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOTnZWMWtLYzVzNmc/view?resourcekey=0-H1-rCILp9nD9iyDcsaJKug");
                    }else if (message.equalsIgnoreCase(chapter11[12])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOTFpKSGVzY1plRkU/view?resourcekey=0-tZZo2xZN1VRgS7OvOkKX6g");
                    }else if (message.equalsIgnoreCase(chapter11[13])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnObzFLYkswYnY5VXM/view?resourcekey=0-bIJQQpP8nuv-6fRpDhbCpQ");
                    }else if (message.equalsIgnoreCase(chapter11[14])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOZHRhVWtwVXJQMFk/view?resourcekey=0-GZ6MRs9BUVEwKdavaeoTuw");
                    }else if (message.equalsIgnoreCase(chapter11[15])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOQWEzV1ZPQUZmUzg/view?resourcekey=0-g0pModrDhNAB6B9rvfdwnQ");
                    }else if (message.equalsIgnoreCase(chapter11[16])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOcFI0b3RVZ2Jxekk/view?resourcekey=0-tiHdS-yYEgJKoHtbOQKuYA");
                    }else if (message.equalsIgnoreCase(chapter11[17])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOVnN5eXN3cHpGOWc/view?resourcekey=0-p55kmsxOiTM657G7z5i9Mg");
                    }else if (message.equalsIgnoreCase(chapter11[18])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOYnVlU3l2c3ZyZWM/view?resourcekey=0-NmPWD_PVAktnRaMLjELkag");
                    }else if (message.equalsIgnoreCase(chapter11[19])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOREtNZG5WYnlfQjg/view?resourcekey=0-hAAz1ApDeYBp5p2y-iIZAg");
                    }else if (message.equalsIgnoreCase(chapter11[20])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOVE1WTVFUQ3JXWkE/view?resourcekey=0-9VvuzqKeKJhglfgQY4BNMA");
                    }else if (message.equalsIgnoreCase(chapter11[21])) {
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOMVN6amduSmJfVFU/view?resourcekey=0-XLK4nPHeeCrPg070BUkMpg");
                    }
            } else if(s.equalsIgnoreCase("12th Class")){
                    if(message.equalsIgnoreCase(chapter12[0])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOOUE0Y1RMTXJyVm8/view?resourcekey=0-_AN8e_Ts02fI9DCfjnMKmg");
                    }else if(message.equalsIgnoreCase(chapter12[1])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOSVZLQXowUXBZSUU/view?resourcekey=0-fFBMHdExu4zihttZteetrw");
                    }else if(message.equalsIgnoreCase(chapter12[2])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOWHgwNGpqN1ZjdFU/view?resourcekey=0-dc6pum3i-5LR8nqx0nVVug");
                    }else if(message.equalsIgnoreCase(chapter12[3])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOZzlmZnlmN3hoWmM/view?resourcekey=0-sKiyhmnbH-4najtW5JZ37w");
                    }else if(message.equalsIgnoreCase(chapter12[4])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOZlNwdm9oUGdEeXM/view?resourcekey=0-WJYW79hv9hsb_6BgPvRFOA");
                    }else if(message.equalsIgnoreCase(chapter12[5])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOa3ByTUNNVmlRam8/view?resourcekey=0-D5sAlgu8nEvutptQ-zeASA");
                    }else if(message.equalsIgnoreCase(chapter12[6])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOLXJuNkhuSHcwbWc/view?resourcekey=0-pkmCMseqbNLtp7J0Wnk8Gg");
                    }else if(message.equalsIgnoreCase(chapter12[7])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOb2dVZDZqWmRjeWs/view?resourcekey=0-cBdRxFVNqxhMa61wWJI7cQ");
                    }else if(message.equalsIgnoreCase(chapter12[8])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOVXdFTlh1YjVpd28/view?resourcekey=0-rFIBLSsyBgP2JZ3QMxOZsQ");
                    }else if(message.equalsIgnoreCase(chapter12[9])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOMnVGR3lTX0FxVWM/view?resourcekey=0-jtmjJVpiAfe1BPjipGcEgg");
                    }else if(message.equalsIgnoreCase(chapter12[10])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOa21TakpmN2I1d00/view?resourcekey=0-oNo034YMcpmPKwn_lbuolQ");
                    }else if(message.equalsIgnoreCase(chapter12[11])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOcVZFaGhmSHB0Wlk/view?resourcekey=0-DMzTfKyNd6m47AkhC5nvxA");
                    }else if(message.equalsIgnoreCase(chapter12[12])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOYVZVdGdjRDdoLWs/view?resourcekey=0-wUHjTspzMuBGgOfG3VUI4Q");
                    }else if(message.equalsIgnoreCase(chapter12[13])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOSW5aUGM5akhGcmc/view?resourcekey=0-duur1v46ChbUKWEy-Mfw4w");
                    }else if(message.equalsIgnoreCase(chapter12[14])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOQzJJUy1Ob0RkNTA/view?resourcekey=0-bq66IQoQweIp_S68FddBzw");
                    }else if(message.equalsIgnoreCase(chapter12[15])){
                        getSupportActionBar().setTitle(message);
                        wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOR1NDeXRQbVZpRU0/view?resourcekey=0-kJlcNIQ3n9K6rNqUdLtxTA");
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
                Toast.makeText(ChapterCalling6.this, "Downloading....", Toast.LENGTH_SHORT).show();
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
            AlertDialog alertDialog = new AlertDialog.Builder(ChapterCalling6.this).create();
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