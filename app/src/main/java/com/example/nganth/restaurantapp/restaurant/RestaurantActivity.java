package com.example.nganth.restaurantapp.restaurant;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.nganth.restaurantapp.BaseActivity;
import com.example.nganth.restaurantapp.R;
import com.example.nganth.restaurantapp.databinding.MenuBinding;
import com.example.nganth.restaurantapp.databinding.RestaurantBinding;
import com.example.nganth.restaurantapp.user.Restaurant;

public class RestaurantActivity extends BaseActivity {

    private RestaurantBinding binding;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getSupportFragmentManager();
        binding = DataBindingUtil.setContentView(this, R.layout.restaurant);

        Intent intent = getIntent();
        if (intent != null) {
            String flag = intent.getStringExtra("flag");
            if (flag == null) {
                showWalkthought(null);
            } else {
                switch (flag) {
                    case "ResMenu":
                        showMenu(null);
                        break;
                    case "Walkthout":
                        showWalkthought(null);
                        break;
                }
            }
        }
    }

    public void showWalkthought(View view) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        WalkthoughtFragment fragment = new WalkthoughtFragment();
        transaction.replace(R.id.fragmentRestaurant, fragment);
        transaction.commit();
    }

    public void showMenu(View view) {
        // khởi tạo đối tượng hỗ trợ add Fragment vào FragmentManager
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        // thêm fragment Login đã tạo vào
        MenuFragment fragment = new MenuFragment();

        transaction.replace(R.id.fragmentRestaurant, fragment);

        // yêu cầu thực thi
        transaction.commit();
    }

    public void showAbout(View view) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        AboutFragment fragment = new AboutFragment();
        transaction.replace(R.id.fragmentRestaurant, fragment);
        transaction.commit();
    }

    public void showReview(View view) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        ReviewFragment fragment = new ReviewFragment();
        transaction.replace(R.id.fragmentRestaurant, fragment);
        transaction.commit();
    }

    public void showSearch(View view) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        SearchFragment fragment = new SearchFragment();
        transaction.replace(R.id.fragmentRestaurant, fragment);
        transaction.commit();
    }

    public void showResult(View view) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        ResultFragment fragment = new ResultFragment();
        transaction.replace(R.id.fragmentRestaurant, fragment);
        transaction.commit();
    }

    public void openFavoriteActivity(View view) {
        android.content.Intent intent = new android.content.Intent(getApplicationContext(), com.example.nganth.restaurantapp.user.FavoriteActivity.class);
        startActivity(intent);
    }

//    public void openSearchActivity(View view) {
//        android.content.Intent intent = new android.content.Intent(getApplicationContext(), com.example.nganth.restaurantapp.search.SearchActivity.class);
//        startActivity(intent);
//    }
}
