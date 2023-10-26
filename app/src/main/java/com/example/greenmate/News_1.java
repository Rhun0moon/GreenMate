package com.example.greenmate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class News_1 extends Fragment {
    private ImageView imgNews1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.news_1, container, false);

        imgNews1 = rootView.findViewById(R.id.imgNews1);
        imgNews1.setClipToOutline(true);

        return rootView;
    }
}