package com.example.greenmate.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.greenmate.fragment.HomeFragment;
import com.example.greenmate.fragment.MyFragment;
import com.example.greenmate.fragment.QuizFragment;
import com.example.greenmate.R;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {
    HomeFragment homeFragment;
    QuizFragment quizFragment;
    MyFragment myFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment = new HomeFragment();
        quizFragment = new QuizFragment();
        myFragment = new MyFragment();


        // 화면 전환 프래그먼트 선언 및 초기 화면 설정
        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();

        NavigationBarView navigationBarView = findViewById(R.id.bottomBar);
        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                    return true;
                } else if (itemId == R.id.quiz) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, quizFragment).commit();
                    return true;
                } else if (itemId == R.id.my) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment).commit();
                    return true;
                }
                return false;
            }
        });
    }
}