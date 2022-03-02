package com.example.sidebar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class splashScreen2 extends AppCompatActivity {
    TextView textView,textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen2);

       textView = findViewById( R.id.textView);
       textView2 = findViewById(R.id.textView2);

       String name = getIntent().getStringExtra("Keyname");
       textView.setText("Hello "+name);

       Thread thread = new Thread(){
           @Override
           public void run() {
               try {
                   sleep(2000);
                   textView2.setText("Creating Study Environment....");
                   sleep(6000);
               }catch (Exception e){
                   e.printStackTrace();
               } finally {
                   Intent intent = new Intent(splashScreen2.this,MainActivity.class);
                   startActivity(intent);
                   overridePendingTransition(R.transition.left,R.transition.right);
                   finish();
               }
           }
       }; thread.start();
    }
}