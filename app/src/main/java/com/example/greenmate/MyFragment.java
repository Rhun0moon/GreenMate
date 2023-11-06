package com.example.greenmate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class MyFragment extends Fragment{
    private LinearLayout editprofileLayout, warningsLayout, reviewLayout, withdrawalLayout, logoutLayout;

    public MyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup)inflater.inflate(R.layout.fragment_my, container, false);

        editprofileLayout = view.findViewById(R.id.editprofileLayout);
        editprofileLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), JoinActivity.class);
                startActivity(intent);
            }
        });


        warningsLayout = view.findViewById(R.id.warningsLayout);
        warningsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), JoinActivity.class);
                startActivity(intent);
            }
        });


        reviewLayout = view.findViewById(R.id.reviewLayout);
        reviewLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });


        withdrawalLayout = view.findViewById(R.id.withdrawalLayout);
        withdrawalLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), JoinActivity.class);
                startActivity(intent);
            }
        });


        logoutLayout = view.findViewById(R.id.logoutLayout);
        logoutLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //로그아웃
            }
        });

        return view;
    }
}