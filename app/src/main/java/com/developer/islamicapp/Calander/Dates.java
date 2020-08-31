package com.developer.islamicapp.Calander;

import android.content.Context;

import com.developer.islamicapp.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Dates {
    public static String islamicMonthName(Context context, int month) {
        switch (month) {
            case 0:
                return context.getString(R.string.month1);
            case 1:
                return context.getString(R.string.month2);
            case 2:
                return context.getString(R.string.month3);
            case 3:
                return context.getString(R.string.month4);
            case 4:
                return context.getString(R.string.month5);
            case 5:
                return context.getString(R.string.month6);
            case 6:
                return context.getString(R.string.month7);
            case 7:
                return context.getString(R.string.month8);
            case 8:
                return context.getString(R.string.month9);
            case 9:
                return context.getString(R.string.month10);
            case 10:
                return context.getString(R.string.month11);
            default:
                return context.getString(R.string.month12);
        }
    }

    public static String gregorianMonthName(Context context, int month) {
        switch (month) {
            case 0:
                return context.getString(R.string.month1g);
            case 1:
                return context.getString(R.string.month2g);
            case 2:
                return context.getString(R.string.month3g);
            case 3:
                return context.getString(R.string.month4g);
            case 4:
                return context.getString(R.string.month5g);
            case 5:
                return context.getString(R.string.month6g);
            case 6:
                return context.getString(R.string.month7g);
            case 7:
                return context.getString(R.string.month8g);
            case 8:
                return context.getString(R.string.month9g);
            case 9:
                return context.getString(R.string.month10g);
            case 10:
                return context.getString(R.string.month11g);
            default:
                return context.getString(R.string.month12g);
        }
    }

    public static String weekDayName(Context context, int day) {
        if (day == 0) {
            return context.getString(R.string.day1);
        }
        if (day == 1) {
            return context.getString(R.string.day2);
        }
        if (day == 2) {
            return context.getString(R.string.day3);
        }
        if (day == 3) {
            return context.getString(R.string.day4);
        }
        if (day == 4) {
            return context.getString(R.string.day5);
        }
        if (day != 5) {
            return context.getString(R.string.day7);
        }
        return context.getString(R.string.day6);
    }

    public static String getCurrentWeekDay() {
        return new SimpleDateFormat("EEEE, MMMM , dd").format(Long.valueOf(new Date().getTime())).split(",")[0];
    }
}
