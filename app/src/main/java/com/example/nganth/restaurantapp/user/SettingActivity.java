package com.example.nganth.restaurantapp.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SettingActivity extends AppCompatActivity {

    private com.example.nganth.restaurantapp.databinding.SettingBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = android.databinding.DataBindingUtil.setContentView(this, com.example.nganth.restaurantapp.R.layout.setting);

        android.content.Intent intent = getIntent();
    }

    public void openProfileActivity(android.view.View view) {
        android.content.Intent intent = new android.content.Intent(getApplicationContext(), ProfileActivity.class);
        startActivity(intent);
    }

    public void openChangePasswordActivity(android.view.View view) {
        android.content.Intent intent = new android.content.Intent(getApplicationContext(), ChangePasswordActivity.class);
        startActivity(intent);
    }
}
