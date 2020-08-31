package com.developer.islamicapp.Model;

public class Fire_model {

    String url,download_status,pos,key;
    Integer img;

    public Fire_model(String url, String download_status, String pos, String key) {
        this.url = url;
        this.download_status = download_status;
        this.pos = pos;
        this.key = key;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDownload_status() {
        return download_status;
    }

    public void setDownload_status(String download_status) {
        this.download_status = download_status;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}

