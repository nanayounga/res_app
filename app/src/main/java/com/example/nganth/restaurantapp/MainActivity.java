package com.example.nganth.restaurantapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

     private com.example.nganth.restaurantapp.databinding.HomeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = android.databinding.DataBindingUtil.setContentView(this, R.layout.home);
    }

    public void openSignInActivity(android.view.View view) {
        android.content.Intent intent = new android.content.Intent(getApplicationContext(), com.example.nganth.restaurantapp.user.SignInActivity.class);
        startActivity(intent);
    }
}
