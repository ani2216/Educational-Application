package com.example.sidebar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class englishCalling extends AppCompatActivity {
    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_calling);
        wv = findViewById(R.id.webenglish);
        String message = getIntent().getStringExtra("KeyEnglish");

        if(message.equalsIgnoreCase("Chapter-1:Two Gentlemen of Verona")){
            getSupportActionBar().setTitle(message);
            wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOT0dEaEhOSHBhelk/view?resourcekey=0-dEOJjtugn9X8aeXPOYWylA");
        }else if(message.equalsIgnoreCase("Chapter-2:Mrs. Packletide's Tiger")){
            getSupportActionBar().setTitle(message);
            wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOM2NIMi0zd1U0aUU/view?resourcekey=0-NHICiYSzHXoPm8QxujQHqw");
        }else if(message.equalsIgnoreCase("Chapter-3:The Letter")){
            getSupportActionBar().setTitle(message);
            wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOV1ladGRCMDNwZVE/view?resourcekey=0-6pnPiej5Wz55i-rvmPmGXQ");
        }else if(message.equalsIgnoreCase("Chapter-4:A Shady Plot")){
            getSupportActionBar().setTitle(message);
            wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOd3JVYWItd29ycDQ/view?resourcekey=0-sVtRGEYpo4ThUFo0KronHA");
        }else if(message.equalsIgnoreCase("Chapter-5:Patol Babu, Film Star")){
            getSupportActionBar().setTitle(message);
            wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOejJJV1VNZWJrblk/view?resourcekey=0-wnM2Ic0EbZIyvxVuAgkFAg");
        }else if(message.equalsIgnoreCase("Chapter-6:Virtually True")){
            getSupportActionBar().setTitle(message);
            wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOTnpBVmRYcENUUDg/view?resourcekey=0-CJxiAS7ArMgNfXQlt8-vuw");
        }else if(message.equalsIgnoreCase("Chapter-7:The Frog and the Nightingale")){
            getSupportActionBar().setTitle(message);
            wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOdWptU2FZcDNjb0E/view?resourcekey=0-986iDUbPNYVxB6iOy4-WcA");
        }else if(message.equalsIgnoreCase("Chapter-8:Mirror")){
            getSupportActionBar().setTitle(message);
            wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOdnB2NEhqMXI3ZEE/view?resourcekey=0-hvyAp6xHwuQaGxFy2N6tUw");
        }else if(message.equalsIgnoreCase("Chapter-9:Not Marble nor the Gilded Monuments")){
            getSupportActionBar().setTitle(message);
            wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOY21ZS2xsRC1QSDQ/view?resourcekey=0-b-6oP5KhwmFylCig4q_dOw");
        }else if(message.equalsIgnoreCase("Chapter-10:Ozymandias")){
            getSupportActionBar().setTitle(message);
            wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOT2R3b2RQQ2JWUlU/view?resourcekey=0-pqQJrOpU5hIyva9qe-cvgQ");
        }else if(message.equalsIgnoreCase("Chapter-11:The Rime of the Ancient Mariner")){
            getSupportActionBar().setTitle(message);
            wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOYVFiR0ZvbmE1STA/view?resourcekey=0-FAnY5jLBF_cQnV2C9MxynA");
        }else if(message.equalsIgnoreCase("Chapter-12:Snake")){
            getSupportActionBar().setTitle(message);
            wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOODY4M3lPMVRZdFk/view?resourcekey=0-aGIZ6PPWqBNZW9C-Vuj7XA");
        }else if(message.equalsIgnoreCase("Chapter-13:The Dear Departed")){
            getSupportActionBar().setTitle(message);
            wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOSGFHRTVfWl9EYVE/view?resourcekey=0-4reSrTphgvZTRT32DcB7XA");
        }else if(message.equalsIgnoreCase("Chapter-14:Julius Caesar")){
            getSupportActionBar().setTitle(message);
            wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOTmxtY0o3ZUt3N3M/view?resourcekey=0-7KoAASJ4IJTnv7Uc2954PQ");
        }else if(message.equalsIgnoreCase("Extra1-Grammar Notes")){
            getSupportActionBar().setTitle(message);
            wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOc2lrMHRrMEJleVE/view?resourcekey=0-Ua2DJqIsGSLRRiyJX_Jnfw");
        }else if(message.equalsIgnoreCase("Extra2-Reading Notes")){
            getSupportActionBar().setTitle(message);
            wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnOMVp1S294alBsOXc/view?resourcekey=0-ciFeScNmQgdGDkONzH7I1w");
        }else if(message.equalsIgnoreCase("Extra3-Writing Notes")){
            getSupportActionBar().setTitle(message);
            wv.loadUrl("https://drive.google.com/file/d/0B-l8gXYPjfnONW0wcXdFWWVmMkk/view?resourcekey=0-5CJPiUBy4uFW5OWZvuwcTw");
        }

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
                Toast.makeText(englishCalling.this, "Downloading....", Toast.LENGTH_SHORT).show();
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
            AlertDialog alertDialog = new AlertDialog.Builder(englishCalling.this).create();
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