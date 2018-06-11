package com.example.nganth.restaurantapp;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.nganth.restaurantapp.user.ProfileActivity;
import com.example.nganth.restaurantapp.user.SignInActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

     private com.example.nganth.restaurantapp.databinding.HomeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = android.databinding.DataBindingUtil.setContentView(this, R.layout.home);

        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if( user != null && user.isEmailVerified()){
                    android.content.Intent intent = new android.content.Intent(getApplicationContext(), ProfileActivity.class);
                    startActivity(intent);
                }else{
                    android.content.Intent intent = new android.content.Intent(getApplicationContext(), com.example.nganth.restaurantapp.user.SignInActivity.class);
                    startActivity(intent);
                }
            }
        }, 1500);
    }
}
