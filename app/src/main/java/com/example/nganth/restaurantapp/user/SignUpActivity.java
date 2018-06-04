package com.example.nganth.restaurantapp.user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SignUpActivity extends AppCompatActivity {

    private com.example.nganth.restaurantapp.databinding.SignUpBinding binding;
//    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = android.databinding.DataBindingUtil.setContentView(this, com.example.nganth.restaurantapp.R.layout.sign_up);

        final Intent intent = getIntent();

        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //lay gia tri nhap
                String valueBeginPhone = binding.txtBeginPhone.getText().toString();
                intent.putExtra("beginPhone", valueBeginPhone);

                String valuePhone = binding.txtPhone.getText().toString();
                intent.putExtra("Phone", valuePhone);

                String valuePassword = binding.txtPassword.getText().toString();
                intent.putExtra("Password", valuePassword);

                String valueConfirmPassword = binding.txtConfirmPassword.getText().toString();
                intent.putExtra("ConfirmPassword", valueConfirmPassword);

                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    public void openVerificationActivity(android.view.View view) {
        android.content.Intent intent = new android.content.Intent(getApplicationContext(), VerificationActivity.class);
        startActivity(intent);
    }

    public void openSignInActivity(android.view.View view) {
        android.content.Intent intent = new android.content.Intent(getApplicationContext(), SignInActivity.class);
        startActivity(intent);
    }
}
