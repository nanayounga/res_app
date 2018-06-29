package com.example.nganth.restaurantapp.restaurant;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.nganth.restaurantapp.BaseActivity;
import com.example.nganth.restaurantapp.R;
import com.example.nganth.restaurantapp.databinding.ActivityViewPagerMenuBinding;

public class ViewPagerMenuActivity extends BaseActivity {
    private ActivityViewPagerMenuBinding binding;
    private FragmentManager fragmentManager;
    private int page = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_pager_menu);

        Intent intent = getIntent();
        if (intent != null) {
            page = intent.getIntExtra("pageNumber", 0);
        }

        PagerMenuAdapter adapter = new PagerMenuAdapter(getSupportFragmentManager());

        binding.viewPagerMenu.setAdapter(adapter);

        binding.viewPagerMenu.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < binding.tabLayoutMenu.getTabCount(); i++) {
                    TabLayout.Tab tab = binding.tabLayoutMenu.getTabAt(i);

                    TextView view = (TextView) tab.getCustomView();

                    if (i == position) {
                        view.setTextColor(getResources().getColor(R.color.colorOrange));
                    } else {
                        view.setTextColor(Color.BLACK);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        binding.tabLayoutMenu.setupWithViewPager(binding.viewPagerMenu);

        //binding.tabLayoutMenu.set

        for (int i = 0; i < binding.tabLayoutMenu.getTabCount(); i++) {
            TabLayout.Tab tab = binding.tabLayoutMenu.getTabAt(i);

            TextView textView = new TextView(getApplicationContext());
            textView.setTextColor(Color.BLACK);
            textView.setGravity(Gravity.CENTER);

            if (i == 0) {
                textView.setText("Menu");
                textView.setTextColor(getResources().getColor(R.color.colorOrange));
            }
            else if (i == 1) {
                textView.setText("About");
            }
            else {
                textView.setText("Review");
            }
            tab.setCustomView(textView);
        }


        binding.viewPagerMenu.setCurrentItem(page);
    }

    public void showAbout(View view) {
        android.content.Intent intent = new android.content.Intent(getApplicationContext(), com.example.nganth.restaurantapp.restaurant.ViewPagerMenuActivity.class);
        startActivity(intent);
    }

    public void showMenu(View view) {
        android.content.Intent intent = new android.content.Intent(getApplicationContext(), com.example.nganth.restaurantapp.restaurant.ViewPagerMenuActivity.class);
        startActivity(intent);
    }

    public void showReview(View view) {
        android.content.Intent intent = new android.content.Intent(getApplicationContext(), com.example.nganth.restaurantapp.restaurant.ViewPagerMenuActivity.class);
        startActivity(intent);
    }

    public void openFavoriteActivity(View view) {
        android.content.Intent intent = new android.content.Intent(getApplicationContext(), com.example.nganth.restaurantapp.user.FavoriteActivity.class);
        startActivity(intent);
    }
}
