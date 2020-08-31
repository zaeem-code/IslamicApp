package com.developer.islamicapp.utils;

import android.content.Context;
import android.content.Intent;

public class share {
    public share(Context context) {
        int applicationNameId = context.getApplicationInfo().labelRes;
        final String appPackageName = context.getPackageName();
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, context.getString(applicationNameId));
        String text = "Install this cool application: ";
        String link = "https://play.google.com/store/apps/details?id="+appPackageName;
        i.putExtra(Intent.EXTRA_TEXT, text + " " + link);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
       context. startActivity(Intent.createChooser(i, "Share link:"));
    }
}
