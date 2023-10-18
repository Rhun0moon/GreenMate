package com.example.greenmate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;

public class MainpageActivity extends AppCompatActivity {
    private Button gohome_button, goqna_button, gomy_button;
    private Button ecodetail_btn, ecosearch_btn, ecoplace_btn;
    private ViewPager2 mPager_banner, mPager_news;
    private FragmentStateAdapter pagerAdapterBanner, pagerAdapterNews;
    private int num_page = 4;
    private CircleIndicator3 mIndicator;

    private List<Integer> news_imageList = new ArrayList<>();
    private List<String> news_textList = new ArrayList<>();
    private TextView news_contentText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        /*
        gohome_button = findViewById(R.id.gohome);
        gohome_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainpageActivity.class );
                startActivity(intent);
            }
        });

        goqna_button = findViewById(R.id.goqna);
        goqna_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), QuizActivity.class );
                startActivity(intent);
            }
        });

        gomy_button = findViewById(R.id.gomy);
        gomy_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyPageActivity.class );
                startActivity(intent);
            }
        });

        ecodetail_btn = findViewById(R.id.ecodetail_btn);
        ecodetail_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EcosearchActivity.class );
                startActivity(intent);
            }
        });

        ecosearch_btn = findViewById(R.id.ecosearch_btn);
        ecosearch_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EcosearchActivity.class );
                startActivity(intent);
            }
        });

        ecoplace_btn = findViewById(R.id.ecodetail_btn);
        ecoplace_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EcosearchActivity.class );
                startActivity(intent);
            }
        });
        */


        // banner slide
        //ViewPager2
        mPager_banner = findViewById(R.id.sliderViewPagerBanner);
        //Adapter
        pagerAdapterBanner = new SliderAdapter(this, num_page);
        mPager_banner.setAdapter(pagerAdapterBanner);
        //Indicator
        mIndicator = findViewById(R.id.indicatorBanner);
        mIndicator.setViewPager(mPager_banner);
        mIndicator.createIndicators(num_page,0);
        //ViewPager Setting
        mPager_banner.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        mPager_banner.setCurrentItem(1000); //시작 지점
        mPager_banner.setOffscreenPageLimit(4); //최대 이미지 수
        mPager_banner.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (positionOffsetPixels == 0) {
                    mPager_banner.setCurrentItem(position);
                }
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mIndicator.animatePageSelected(position%num_page);
            }
        });

        // news slide
        mPager_news = findViewById(R.id.sliderViewPagerNews);
        news_contentText = findViewById(R.id.newsContent);

        news_imageList.add(R.drawable.news1);
        news_imageList.add(R.drawable.news2);
        news_imageList.add(R.drawable.news3);
        news_imageList.add(R.drawable.news4);

        news_textList.add("경기도, 어린이집 집단급식소 1598곳 식중독 예방 점검");
        news_textList.add("수도권 새벽부터 최대 40㎜ 비…오후 전국으로 확대 [내일날씨]");
        news_textList.add("\"환경자료 공개하고 소각장 등 현대화… 더 쾌적한 인천으로\" [로컬 포커스 공공기관장을 만나다]");
        news_textList.add("[날씨] 쌀쌀함 더하는 가을비…비 그친 뒤 기온 더 떨어져");

        mainInitViewPager2();
    }

    private void mainInitViewPager2() {
        news_contentText.setText("경기도, 어린이집 집단급식소 1598곳 식중독 예방 점검");
        mPager_news.setClipToPadding(false);
        mPager_news.setClipChildren(false);
        mPager_news.setOffscreenPageLimit(1);
        //mPager_news.setAdapter(new ViewPager2Adapter(this, news_imageList));
        pagerAdapterNews = new SliderAdapter(this, num_page);
        mPager_banner.setAdapter(pagerAdapterNews);

        mPager_news.setPageTransformer(new MarginPageTransformer(100));
        mPager_news.setPadding(200, 0, 200, 0);
        mainViewChangeEvent();
    }

    private void mainViewChangeEvent() {
        mPager_news.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                news_contentText.setText(news_textList.get(position));
            }
        });
    }
}

