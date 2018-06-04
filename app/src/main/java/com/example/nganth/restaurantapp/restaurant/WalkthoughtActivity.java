package com.example.nganth.restaurantapp.restaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WalkthoughtActivity extends AppCompatActivity {

    private com.example.nganth.restaurantapp.databinding.WalkthoughtBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = android.databinding.DataBindingUtil.setContentView(this, com.example.nganth.restaurantapp.R.layout.walkthought);

        android.content.Intent intent = getIntent();
    }

    public void openSearchActivity(android.view.View view) {
        android.content.Intent intent = new android.content.Intent(getApplicationContext(), com.example.nganth.restaurantapp.search.SearchActivity.class);
        startActivity(intent);
    }
}
