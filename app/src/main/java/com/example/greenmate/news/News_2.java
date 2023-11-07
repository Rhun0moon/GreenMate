package com.example.greenmate.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.greenmate.R;

public class News_2 extends Fragment {
    private ImageView imgNews2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.news_2, container, false);

        imgNews2 = rootView.findViewById(R.id.imgNews2);
        imgNews2.setClipToOutline(true);

        return rootView;
    }
}