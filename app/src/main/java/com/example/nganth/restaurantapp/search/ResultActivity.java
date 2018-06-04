package com.example.nganth.restaurantapp.search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ResultActivity extends AppCompatActivity {

    private com.example.nganth.restaurantapp.databinding.ResultBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = android.databinding.DataBindingUtil.setContentView(this, com.example.nganth.restaurantapp.R.layout.result);

        android.content.Intent intent = getIntent();
    }

    public void openMenuActivity(android.view.View view) {
        android.content.Intent intent = new android.content.Intent(getApplicationContext(), com.example.nganth.restaurantapp.restaurant.MenuActivity.class);
        startActivity(intent);
    }
}
