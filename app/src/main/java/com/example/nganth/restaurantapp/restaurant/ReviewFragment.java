package com.example.nganth.restaurantapp.restaurant;



import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nganth.restaurantapp.R;
import com.example.nganth.restaurantapp.databinding.ReviewBinding;

import java.util.ArrayList;
import java.util.List;

public class ReviewFragment extends Fragment {
    private ReviewBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.review, container, false);

        ViewPagerMenuActivity mainActivity = (ViewPagerMenuActivity) getActivity();
        binding.setVariableReview(mainActivity);

        List<String> list = new ArrayList<>();
        list.add("Nguyen A");
        list.add("Nguyen B");
        list.add("Nguyen C");
        list.add("Nguyen D");

        // khoi tao Adapter
        ReviewAdapter adapter = new ReviewAdapter(list);

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

        return binding.getRoot();
    }
}

