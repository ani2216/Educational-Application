package com.example.sidebar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.AlertDialog;
import android.app.DownloadManager;
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

import com.google.android.gms.common.api.Api;
import com.google.firebase.database.annotations.NotNull;

public class c extends AppCompatActivity {
    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        wv = findViewById(R.id.webc);
        String message = getIntent().getStringExtra("Key1");

        if(message.equalsIgnoreCase("C-Programming")){
                getSupportActionBar().setTitle(message);
                wv.loadUrl("https://www.tutorialspoint.com/cprogramming/pdf/c_quick_guide.pdf");
        }else  if(message.equalsIgnoreCase("C-CheatSheet")){
            getSupportActionBar().setTitle(message);
            wv.loadUrl("https://cheatography.com/ashlyn-black/cheat-sheets/c-reference/pdf_bw/");
        } else if(message.equalsIgnoreCase("C++ CheatSheet")){
            getSupportActionBar().setTitle(message);
            wv.loadUrl("http://www.hoomanb.com/cs/QuickRef/CppQuickRef.pdf");
        } else if(message.equalsIgnoreCase("Python-CheatSheet")){
            getSupportActionBar().setTitle(message);
            wv.loadUrl("https://programmingwithmosh.com/wp-content/uploads/2019/02/Python-Cheat-Sheet.pdf");
        } else if(message.equalsIgnoreCase("C++")){
            getSupportActionBar().setTitle(message);
            wv.loadUrl("https://www.tutorialspoint.com/cplusplus/cpp_tutorial.pdf");
        } else if(message.equalsIgnoreCase("Python")){
            getSupportActionBar().setTitle(message);
            wv.loadUrl("https://drive.google.com/file/d/19QJK9z3k7IgJDFPXY6yFTLbfw8to7AyU/view");
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
            Toast.makeText(c.this, "Downloading....", Toast.LENGTH_SHORT).show();
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
            AlertDialog alertDialog = new AlertDialog.Builder(c.this).create();
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