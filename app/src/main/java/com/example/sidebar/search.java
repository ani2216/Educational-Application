package com.example.sidebar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.example.sidebar.fragment.webViewControl;

public class search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        WebView webView1 = findViewById(R.id.websearch);
        String url = getIntent().getStringExtra("SearchKey");
        webView1.getSettings().setJavaScriptEnabled(true);
        webView1.loadUrl(url);
        webView1.setWebViewClient(new webViewControl());
    }
}