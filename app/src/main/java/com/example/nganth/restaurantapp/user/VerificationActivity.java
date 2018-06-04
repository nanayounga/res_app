package com.example.nganth.restaurantapp.user;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class VerificationActivity extends AppCompatActivity {

    private com.example.nganth.restaurantapp.databinding.VerificationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = android.databinding.DataBindingUtil.setContentView(this, com.example.nganth.restaurantapp.R.layout.verification);

        android.content.Intent intent = getIntent();


        String transferBeginPhoneSignIn = intent.getStringExtra("valueBeginPhoneSignIn");
        String transferPhoneSignIn = intent.getStringExtra("valuePhoneSignIn");
//        String transferPasswordSignIn = intent.getStringExtra("valuePasswordSignIn");

        binding.txtPhoneVerification.setText(transferBeginPhoneSignIn + " " + transferPhoneSignIn);
    }

    public void openWalkthoughtActivity(android.view.View view) {
        android.content.Intent intent = new android.content.Intent(getApplicationContext(), com.example.nganth.restaurantapp.restaurant.WalkthoughtActivity.class);
        startActivity(intent);
    }
}
