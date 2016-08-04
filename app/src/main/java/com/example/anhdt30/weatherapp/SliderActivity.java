package com.example.anhdt30.weatherapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.example.anhdt30.weatherapp.Adapter.InfinitePagerAdapter;

import java.util.Timer;
import java.util.TimerTask;

public class SliderActivity extends FragmentActivity {

    int i = 999;
    Timer timer;

    int currentItem;
    ViewPager viewPager;

    private int[] mImageArray = { R.drawable.slider1, R.drawable.slider2, R.drawable.slider3,
            R.drawable.slider4, R.drawable.slider5 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        PagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return mImageArray.length;
            }

            @Override
            public Fragment getItem(int position) {
                Fragment fragment = new ImageFragment();
                Bundle args = new Bundle();
                args.putInt("colour", mImageArray[position]);
                fragment.setArguments(args);
                return fragment;
            }
        };

        PagerAdapter wrappedAdapter = new InfinitePagerAdapter(adapter);

        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(wrappedAdapter);
        viewPager.setCurrentItem(i);
        currentItem = i;

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                currentItem = position;
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        pageSwitcher(3);
    }

    public void pageSwitcher(int seconds) {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    public void run() {
                        currentItem = viewPager.getCurrentItem();
                        currentItem++;
                        viewPager.setCurrentItem(currentItem);
                    }
                });
            }
        }, 0, seconds * 1000);
    }
}
