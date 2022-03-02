package com.example.sidebar.ui.slideshow;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.sidebar.splashScreen;

public class Common {
    public static boolean connection(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wificon = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobcon = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if((wificon != null && wificon.isConnected()) || (mobcon != null && mobcon.isConnected())){
            NetworkInfo[] info = connectivityManager.getAllNetworkInfo();
            if(info!=null){
                for(int i=0;i<info.length;i++){
                    if(info[i].getState() == NetworkInfo.State.CONNECTED)
                        return true;
                }
            }
        }
        return false;
    }
}
