package com.example.sidebar.ui.slideshow;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;

import com.example.sidebar.R;

public class networkcheck extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(!Common.connection(context)){
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            View view = LayoutInflater.from(context).inflate(R.layout.activity_noconnection,null);
            builder.setView(view);


            AppCompatButton retry = view.findViewById(R.id.button3);

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            alertDialog.setCancelable(false);

            alertDialog.getWindow().setGravity(Gravity.CENTER);

            retry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                    onReceive(context,intent);
                }
            });
        }
    }
}
