package com.example.sidebar;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.auth.FirebaseAuth;

public class splashScreen extends AppCompatActivity {
    ImageView imageView, imageView2;
    TextView textView;
    LottieAnimationView logo;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.lightblack));
        }
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        textView = findViewById(R.id.textView);
        logo = findViewById(R.id.logo);
        firebaseAuth = FirebaseAuth.getInstance();
        if (connection(splashScreen.this)) {
            if (firebaseAuth.getCurrentUser() != null) {
                Thread thread = new Thread() {

                    @Override
                    public void run() {
                        try {
                            sleep(4000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            Intent intent = new Intent(splashScreen.this, MainActivity.class);
                            startActivity(intent);
                            overridePendingTransition(R.transition.right, R.transition.left);
                            finish();
                        }
                    }
                };
                thread.start();
            } else {
                Thread thread = new Thread() {

                    @Override
                    public void run() {
                        try {
                            sleep(4000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            Intent intent = new Intent(splashScreen.this, login.class);
                            startActivity(intent);
                            overridePendingTransition(R.transition.right, R.transition.left);
                            finish();
                        }
                    }
                };
                thread.start();
            }

        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(splashScreen.this);
            builder.setMessage("Please Check Your Connection.").setCancelable(false).
                    setPositiveButton("Connect", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                        }
                    }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startActivity(new Intent(splashScreen.this,noconnection.class));
                    finish();
                }
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }

    public boolean connection (splashScreen ss){
            ConnectivityManager connectivityManager = (ConnectivityManager) ss.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo wificon = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            NetworkInfo mobcon = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if ((wificon != null && wificon.isConnected()) || (mobcon != null && mobcon.isConnected())) {
                return true;
            } else {
                return false;
            }
        }
}