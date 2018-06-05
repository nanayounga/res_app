package com.example.nganth.restaurantapp.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.nganth.restaurantapp.BaseActivity;
import com.example.nganth.restaurantapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends BaseActivity {

    private TextView mChangePasswordLink;
    private TextView mNameField;
    private TextView mEmailField;
    // [START declare_auth]
    private FirebaseAuth mAuth;
    // [END declare_auth]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        // [START initialize_auth]
        mAuth = FirebaseAuth.getInstance();
        // [END initialize_auth]

        mNameField = findViewById(R.id.name_field);
        mEmailField = findViewById(R.id.email_field);
        mChangePasswordLink = findViewById(R.id.password_change_link);

        mChangePasswordLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.content.Intent intent = new android.content.Intent(getApplicationContext(), ChangePasswordActivity.class);
                startActivity(intent);
            }
        });
    }
    // [START on_start_check_user]
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }
    public void openFavoriteActivity(android.view.View view) {
        android.content.Intent intent = new android.content.Intent(getApplicationContext(), FavoriteActivity.class);
        startActivity(intent);
    }

    public void updateUI(FirebaseUser user){
        mNameField.setText(user.getDisplayName());
        mEmailField.setText(user.getEmail());
    }
}
