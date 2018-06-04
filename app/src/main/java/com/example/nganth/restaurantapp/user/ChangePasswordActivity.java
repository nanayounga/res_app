package com.example.nganth.restaurantapp.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nganth.restaurantapp.R;

public class ChangePasswordActivity extends AppCompatActivity {

    private com.example.nganth.restaurantapp.databinding.ChangePasswordBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = android.databinding.DataBindingUtil.setContentView(this, R.layout.change_password);

        android.content.Intent intent = getIntent();
    }

    public void openSettingActivity(android.view.View view) {
        android.content.Intent intent = new android.content.Intent(getApplicationContext(), SettingActivity.class);
        startActivity(intent);
    }
}
