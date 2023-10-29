package com.example.greenmate;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class QuizFragment extends Fragment {
    private Button yes_btn, no_btn;

    public QuizFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup)inflater.inflate(R.layout.fragment_quiz, container, false);

        yes_btn = view.findViewById(R.id.yesBtn);
        yes_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 새로운 액티비티로 이동
                Intent intent = new Intent(getActivity(), HomeFragment.class);
                startActivity(intent);
            }
        });

        no_btn = view.findViewById(R.id.noBtn);
        no_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 새로운 액티비티로 이동
                Intent intent = new Intent(getActivity(), HomeFragment.class);
                startActivity(intent);
            }
        });

        return view;
    }
}