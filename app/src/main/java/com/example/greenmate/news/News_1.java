package com.example.greenmate.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.greenmate.R;

public class News_1 extends Fragment {
    private RelativeLayout news1Layout;
    private ImageView imgNews1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.news_1, container, false);

        imgNews1 = rootView.findViewById(R.id.imgNews1);
        imgNews1.setClipToOutline(true);

        news1Layout = rootView.findViewById(R.id.news1Layout);
        news1Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"뉴스1번 선택",Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }
}