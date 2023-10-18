package com.example.greenmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button login_button, join_button, home_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);

        // 로그인 버튼
        login_button = findViewById( R.id.login_btn );
        login_button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this, LoginActivity.class );
                startActivity( intent );
            }
        });

        // 회원가입 버튼
        join_button = findViewById( R.id.join_btn );
        join_button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this, RegisterActivity.class );
                startActivity( intent );
            }
        });

        // 홈 버튼
        home_button = findViewById( R.id.home_btn );
        home_button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this, MainpageActivity.class );
                startActivity( intent );
            }
        });
    }
}