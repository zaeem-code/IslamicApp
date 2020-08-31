package com.developer.islamicapp.Model;

import java.io.Serializable;

public class Quran_words_search implements Serializable {
   public String  arabic,surah,ayat,name;

    public Quran_words_search(String arabic, String surah, String ayat, String name) {
        this.arabic = arabic;
        this.surah = surah;
        this.ayat = ayat;
        this.name=name;
    }
}
