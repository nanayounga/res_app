package com.example.nganth.restaurantapp.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ProfileActivity extends AppCompatActivity {

    private com.example.nganth.restaurantapp.databinding.ProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = android.databinding.DataBindingUtil.setContentView(this, com.example.nganth.restaurantapp.R.layout.profile);

        android.content.Intent intent = getIntent();
    }

    public void openSettingActivity(android.view.View view) {
        android.content.Intent intent = new android.content.Intent(getApplicationContext(), SettingActivity.class);
        startActivity(intent);
    }

    public void openFavoriteActivity(android.view.View view) {
        android.content.Intent intent = new android.content.Intent(getApplicationContext(), FavoriteActivity.class);
        startActivity(intent);
    }
}
