package com.example.nganth.restaurantapp.restaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MenuActivity extends AppCompatActivity {

    private com.example.nganth.restaurantapp.databinding.MenuBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = android.databinding.DataBindingUtil.setContentView(this, com.example.nganth.restaurantapp.R.layout.menu);

        android.content.Intent intent = getIntent();
    }

    public void openAboutActivity(android.view.View view) {
        android.content.Intent intent = new android.content.Intent(getApplicationContext(), AboutActivity.class);
        startActivity(intent);
    }
}
