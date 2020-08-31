package com.developer.islamicapp.callbacks;

import com.developer.islamicapp.Model.Quran_words_search;

import java.util.ArrayList;

public interface Search_Result {
    void data(ArrayList<Quran_words_search> data, String count);
}
