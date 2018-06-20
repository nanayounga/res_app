package com.example.nganth.restaurantapp.restaurant;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.nganth.restaurantapp.BaseActivity;
import com.example.nganth.restaurantapp.R;
import com.example.nganth.restaurantapp.databinding.ActivityViewPagerWalkthoughtBinding;

public class ViewPagerWalkthoughtActivity extends BaseActivity {
    private ActivityViewPagerWalkthoughtBinding binding;
    private float percentagePadding = 0.05f;

    private int page = -1;

    private PagerWalkthoughtAdapter adapter;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_pager_walkthought);

        binding.viewPagerWalkthought.setAdapter(adapter = new PagerWalkthoughtAdapter(getSupportFragmentManager()));
        binding.viewPagerWalkthought.setClipToPadding(false);

        binding.viewPagerWalkthought.post(new Runnable() {
            @Override
            public void run() {
                float padding = percentagePadding * binding.viewPagerWalkthought.getWidth();
                binding.viewPagerWalkthought.setPadding((int) (padding * 2), 0, (int) (padding * 2), 0);
                binding.viewPagerWalkthought.setPageMargin((int) padding);
            }
        });


        final int interval = 2000; // 2 Second
        handler = new Handler();
        Runnable runnable = new Runnable(){
            public void run() {
                if (page == -1) {
                    binding.viewPagerWalkthought.setCurrentItem(++page, false);
                } else {
                    binding.viewPagerWalkthought.setCurrentItem(++page);
                }

                if (page == adapter.getCount() - 1) {
                    page = -1;
                }

                handler.postDelayed(this, interval);
            }
        };
        handler.postAtTime(runnable, System.currentTimeMillis()+interval);
        handler.postDelayed(runnable, interval);
    }

    public void showMenu(View view) {
        android.content.Intent intent = new android.content.Intent(getApplicationContext(), com.example.nganth.restaurantapp.restaurant.ViewPagerMenuActivity.class);
        startActivity(intent);
    }
}
