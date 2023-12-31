package com.example.greenmate.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.example.greenmate.R;

public class IntroActivity extends Activity {
    int[] images = new int[] {R.drawable.page_color, R.drawable.page_food, R.drawable.page_flower};

    @Override
    protected void onCreate(Bundle savedInstanceStare) {
        super.onCreate(savedInstanceStare);
        setContentView(R.layout.activity_intro);

        ImageView mImageView = (ImageView)findViewById(R.id.imgViewIntro);
        int imageId = (int)(Math.random() * images.length);
        mImageView.setBackgroundResource(images[imageId]);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },1000); // 1초 있다 메인액티비티로
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
