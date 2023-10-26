package com.example.greenmate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class News_3 extends Fragment {
    private ImageView imgNews3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.news_3, container, false);

        imgNews3 = rootView.findViewById(R.id.imgNews3);
        imgNews3.setClipToOutline(true);

        return rootView;
    }
}