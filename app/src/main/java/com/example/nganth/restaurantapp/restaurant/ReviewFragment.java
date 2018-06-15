package com.example.nganth.restaurantapp.restaurant;



import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nganth.restaurantapp.R;
import com.example.nganth.restaurantapp.databinding.ReviewBinding;

public class ReviewFragment extends Fragment {
    private ReviewBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.review, container, false);

        ViewPagerMenuActivity mainActivity = (ViewPagerMenuActivity) getActivity();
        binding.setVariableReview(mainActivity);

        return binding.getRoot();
    }
}
