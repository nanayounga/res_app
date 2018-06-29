package com.example.nganth.restaurantapp.restaurant;



import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nganth.restaurantapp.Comments;
import com.example.nganth.restaurantapp.R;
import com.example.nganth.restaurantapp.databinding.ReviewBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ReviewFragment extends Fragment {
    private ReviewBinding binding;
    ArrayList<Comments> comments = new ArrayList<>();
    ReviewAdapter adapter;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference resRef = database.getReference("res_comments");
    DatabaseReference myRef = resRef.child("restaurant_1");

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.review, container, false);

        ViewPagerMenuActivity mainActivity = (ViewPagerMenuActivity) getActivity();
        binding.setVariableReview(mainActivity);

        //-- begin get data from firebase
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                comments.clear();
                for (DataSnapshot i: dataSnapshot.getChildren()) {
                    Comments value = i.getValue(Comments.class);
//                    Log.d("restaurantapp", "Value is: " + value.comment);
                    comments.add(value);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("restaurantapp", "Failed to read value.", error.toException());
            }
        });
        //-- end get data from firebase


        // khoi tao Adapter
        adapter = new ReviewAdapter(comments);

        // cung cap Adapter cho RecyclerView
        binding.lstComment.setAdapter(adapter);

        // thiet lap dang hien thi cho RecyclerView
        // Hiển thị dạng danh sách
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mainActivity.getApplicationContext(),
                LinearLayoutManager.VERTICAL, // hiển thị theo chiều dọc
                /*LinearLayoutManager.HORIZONTAL,*/ // hiển thị theo chiều ngang
                false
        );
        binding.lstComment.setLayoutManager(linearLayoutManager);

        binding.btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            // Save data in to database
            String id = UUID.randomUUID().toString();
            DatabaseReference commentRef = myRef.child(id);

            commentRef.child("comment").setValue(binding.txtInputComment.getText().toString());
            commentRef.child("date").setValue(date_time_now("yyyy-MM-dd"));
            commentRef.child("mail").setValue("abc@gmail.com");
            commentRef.child("time").setValue(date_time_now("HH:mm"));

            binding.txtInputComment.setText("");
            }
        });

        return binding.getRoot();
    }

    public static String date_time_now(String date_time) {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(date_time);
        String strDate = sdf.format(c.getTime());

        return strDate;
    }
}

