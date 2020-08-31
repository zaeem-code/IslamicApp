package com.developer.islamicapp.Model;

public class Notif_data
{

String id,message,time,title,date,notification;
int count;


    public Notif_data() {
    }

    public Notif_data(String id, String message, String time, String title, String date, String notification, int count) {
        this.id = id;
        this.message = message;
        this.time = time;
        this.title = title;
        this.date = date;
        this.notification = notification;
        this.count = count;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
