package com.example.greenmate.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.greenmate.R;

public class News_4 extends Fragment {
    private ImageView imgNews4;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.news_4, container, false);

        imgNews4 = rootView.findViewById(R.id.imgNews4);
        imgNews4.setClipToOutline(true);

        return rootView;
    }
}