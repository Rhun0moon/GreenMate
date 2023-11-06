package com.example.greenmate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText loginId, loginPw;
    private Button loginBtn, joinBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginId = findViewById( R.id.loginId );
        loginPw = findViewById( R.id.loginPw );

        // 로그인 버튼
        loginBtn = findViewById( R.id.loginBtn );
        loginBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class );
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"로그인 성공",Toast.LENGTH_SHORT).show();
            }
        });

        // 회원가입 버튼
        joinBtn = findViewById( R.id.joinBtn );
        joinBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( LoginActivity.this, JoinActivity.class );
                startActivity( intent );
            }
        });
    }
}
