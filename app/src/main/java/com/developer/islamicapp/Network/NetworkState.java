package com.developer.islamicapp.Network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class NetworkState {

    @RequiresApi(api = Build.VERSION_CODES.M)
    public static boolean isOnline(Context cont)
    {
        ConnectivityManager cm = (ConnectivityManager) cont.getSystemService(Context.CONNECTIVITY_SERVICE);
        @SuppressWarnings("deprecation") NetworkInfo netInfo = cm.getActiveNetworkInfo();


        return netInfo != null && netInfo.isConnectedOrConnecting();

    }







}


