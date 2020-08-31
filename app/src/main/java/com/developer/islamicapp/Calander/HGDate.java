package com.developer.islamicapp.Calander;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HGDate {
    private final double GREGORIAN_EPOCH;
    private final double HIGRI_EPOCH;
    private int day;
    private double julianDay;
    private int month;
    DT type;
    private int year;

    public enum DT {
        NONE,
        HIGRI,
        GREGORIAN
    }

    public HGDate() {
        this.HIGRI_EPOCH = 1948438.5d;
        this.GREGORIAN_EPOCH = 1721425.5d;
        this.type = DT.NONE;
        this.julianDay = 0.0d;
        this.day = 0;
        this.month = 0;
        this.year = 0;
        DateNow();
    }

    public HGDate(HGDate d) {
        this.HIGRI_EPOCH = 1948438.5d;
        this.GREGORIAN_EPOCH = 1721425.5d;
        this.type = d.type;
        this.julianDay = d.julianDay;
        this.day = d.day;
        this.month = d.month;
        this.year = d.year;
    }

    public Date DateNow() {
        Calendar c = Calendar.getInstance();
        String[] formattedDate = new SimpleDateFormat("dd-MM-yyyy").format(c.getTime()).split("-");
        setGregorian(Integer.parseInt(formattedDate[2].trim()), Integer.parseInt(formattedDate[1].trim()), Integer.parseInt(formattedDate[0].trim()));
        return c.getTime();
    }

    public double higri_to_jd(int year2, int month2, int day2) {
        double d = day2;
        double d2 = month2 - 1;
        Double.isNaN(d2);
        double ceil = Math.ceil(d2 * 29.5d);
        Double.isNaN(d);
        double d3 = d + ceil;
        double d4 = (year2 - 1) * 354;
        Double.isNaN(d4);
        return (((d3 + d4) + Math.floor(((year2 * 11) + 3) / 30)) + 1948438.5d) - 1.0d;
    }

    private boolean leap_gregorian(int year2) {
        return year2 % 4 == 0 && (year2 % 100 != 0 || year2 % 400 == 0);
    }

    private long mod(long a, long b) {
        double d = (double) a;
        double d2 = (double) b;
        double floor = Math.floor((double) (a / b));
        Double.isNaN(d2);
        double d3 = d2 * floor;
        Double.isNaN(d);
        return (long) (d - d3);
    }

    private double gregorian_to_jd(int year2, int month2, int day2) {
        double d = (year2 - 1) * 365;
        Double.isNaN(d);
        double floor = d + 1721424.5d + Math.floor((year2 - 1) / 4) + (-Math.floor((year2 - 1) / 100)) + Math.floor((year2 - 1) / 400);
        int i = ((month2 * 367) - 362) / 12;
        int i2 = month2 <= 2 ? 0 : leap_gregorian(year2) ? -1 : -2;
        return floor + Math.floor(i + i2 + day2);
    }

    public boolean setHigri(int year2, int month2, int day2) {
        if (year2 < 1 || month2 < 1 || day2 < 1) {
            return false;
        }
        this.julianDay = higri_to_jd(year2, month2, day2);
        toHigri();
        if (year2 == this.year && month2 == this.month && day2 == this.day) {
            return true;
        }
        this.type = DT.NONE;
        return false;
    }

    public boolean setGregorian(int year2, int month2, int day2) {
        if (year2 < 622 || month2 < 1 || day2 < 1) {
            return false;
        }
        if (year2 == 622 && month2 < 7) {
            return false;
        }
        if (year2 == 622 && month2 == 7 && day2 < 18) {
            return false;
        }
        this.julianDay = gregorian_to_jd(year2, month2, day2);
        toGregorian();
        if (year2 == this.year && month2 == this.month && day2 == this.day) {
            return true;
        }
        this.type = DT.NONE;
        return false;
    }

    public boolean toHigri() {
        double jd = Math.floor(this.julianDay) + 0.5d;
        int floor = (int) Math.floor((((jd - 1948438.5d) * 30.0d) + 10646.0d) / 10631.0d);
        this.year = floor;
        int min = (int) Math.min(12.0d, Math.ceil((jd - (higri_to_jd(floor, 1, 1) + 29.0d)) / 29.5d) + 1.0d);
        this.month = min;
        this.day = (int) ((jd - higri_to_jd(this.year, min, 1)) + 1.0d);
        this.type = DT.HIGRI;
        return true;
    }

    public boolean toGregorian() {
        double jd = Math.floor(this.julianDay - 0.5d) + 0.5d;
        double depoch = jd - 1721425.5d;
        double quadricent = Math.floor(depoch / 146097.0d);
        double dqc = (double) mod((long) depoch, 146097);
        Double.isNaN(dqc);
        double cent = Math.floor(dqc / 36524.0d);
        double dcent = (double) mod((long) dqc, 36524);
        Double.isNaN(dcent);
        double quad = Math.floor(dcent / 1461.0d);
        double d = depoch;
        double d2 = dqc;
        double dquad = (double) mod((long) dcent, 1461);
        Double.isNaN(dquad);
        double yindex = Math.floor(dquad / 365.0d);
        double d3 = dquad;
        int i = (int) ((400.0d * quadricent) + (100.0d * cent) + (quad * 4.0d) + yindex);
        this.year = i;
        if (!(cent == 4.0d || yindex == 4.0d)) {
            this.year = i + 1;
        }
        double d4 = quadricent;
        double yearday = (double) ((long) (jd - gregorian_to_jd(this.year, 1, 1)));
        double d5 = yindex;
        int i2 = jd < gregorian_to_jd(this.year, 3, 1) ? 0 : leap_gregorian(this.year) ? 1 : 2;
        double leapadj = i2;
        Double.isNaN(yearday);
        Double.isNaN(leapadj);
        double d6 = yearday;
        int floor = (int) Math.floor((((yearday + leapadj) * 12.0d) + 373.0d) / 367.0d);
        this.month = floor;
        this.day = (int) ((jd - gregorian_to_jd(this.year, floor, 1)) + 1.0d);
        this.type = DT.GREGORIAN;
        return true;
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public DT getType() {
        return this.type;
    }

    public int weekDay() {
        return (int) mod((long) Math.floor(this.julianDay + 1.5d), 7);
    }

    public void nextDay() {
        this.julianDay += 1.0d;
        if (this.type == DT.HIGRI) {
            toHigri();
        } else if (this.type == DT.GREGORIAN) {
            toGregorian();
        }
    }

    public void previousDay() {
        this.julianDay -= 1.0d;
        if (this.type == DT.HIGRI) {
            toHigri();
        } else if (this.type == DT.GREGORIAN) {
            toGregorian();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(this.day);
        String str = "/";
        sb.append(str);
        sb.append(this.month);
        sb.append(str);
        sb.append(this.year);
        return sb.toString();
    }
}
