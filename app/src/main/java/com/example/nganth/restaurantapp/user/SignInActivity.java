package com.example.nganth.restaurantapp.user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SignInActivity extends AppCompatActivity {

    private com.example.nganth.restaurantapp.databinding.SignInBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = android.databinding.DataBindingUtil.setContentView(this, com.example.nganth.restaurantapp.R.layout.sign_in);

        android.content.Intent intent = getIntent();
    }

    public void openSignUpActivity(android.view.View view) {
        android.content.Intent intent = new android.content.Intent(getApplicationContext(), SignUpActivity.class);
        startActivityForResult(intent, 1);// co ket qua tra ve
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                String beginPhone = data.getStringExtra("beginPhone");
                String Phone = data.getStringExtra("Phone");
                String Password = data.getStringExtra("Password");

                binding.txtBeginPhoneSignIn.setText(beginPhone);
                binding.txtPhoneSignIn.setText(Phone);
                binding.txtPasswordSignIn.setText(Password);
            }
        }
    }

    public void openVerificationActivity(View view) {
        android.content.Intent intent = new android.content.Intent(getApplicationContext(), VerificationActivity.class);

        String valueBeginPhoneSignIn = binding.txtBeginPhoneSignIn.getText().toString();
        intent.putExtra("valueBeginPhoneSignIn", valueBeginPhoneSignIn);

        String valuePhoneSignIn = binding.txtPhoneSignIn.getText().toString();
        intent.putExtra("valuePhoneSignIn", valuePhoneSignIn);

        String valuePasswordSignIn = binding.txtPasswordSignIn.getText().toString();
        intent.putExtra("valuePasswordSignIn", valuePasswordSignIn);

        startActivity(intent);
    }
}
