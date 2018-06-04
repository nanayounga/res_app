package com.example.nganth.restaurantapp.restaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AboutActivity extends AppCompatActivity {

    private com.example.nganth.restaurantapp.databinding.AboutBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = android.databinding.DataBindingUtil.setContentView(this, com.example.nganth.restaurantapp.R.layout.about);

        android.content.Intent intent = getIntent();
    }

    public void openReviewActivity(android.view.View view) {
        android.content.Intent intent = new android.content.Intent(getApplicationContext(), ReviewActivity.class);
        startActivity(intent);
    }
}
