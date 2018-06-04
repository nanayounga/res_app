package com.example.nganth.restaurantapp.search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SearchActivity extends AppCompatActivity {

    private com.example.nganth.restaurantapp.databinding.SearchBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = android.databinding.DataBindingUtil.setContentView(this, com.example.nganth.restaurantapp.R.layout.search);

        android.content.Intent intent = getIntent();
    }

    public void openResultActivity(android.view.View view) {
        android.content.Intent intent = new android.content.Intent(getApplicationContext(), ResultActivity.class);
        startActivity(intent);
    }
}
