package com.example.nganth.restaurantapp.restaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ReviewActivity extends AppCompatActivity {

    private com.example.nganth.restaurantapp.databinding.ReviewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = android.databinding.DataBindingUtil.setContentView(this, com.example.nganth.restaurantapp.R.layout.review);

        android.content.Intent intent = getIntent();
    }

    public void openFavoriteActivity(android.view.View view) {
        android.content.Intent intent = new android.content.Intent(getApplicationContext(), com.example.nganth.restaurantapp.user.FavoriteActivity.class);
        startActivity(intent);
    }
}
