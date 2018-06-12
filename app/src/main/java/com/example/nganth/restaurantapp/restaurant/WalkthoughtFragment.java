package com.example.nganth.restaurantapp.restaurant;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nganth.restaurantapp.R;
import com.example.nganth.restaurantapp.databinding.WalkthoughtBinding;

public class WalkthoughtFragment extends Fragment {
    private WalkthoughtBinding binding;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.walkthought, container, false);

        RestaurantActivity mainActivity = (RestaurantActivity) getActivity();
        binding.setVariableWalkthought(mainActivity);

        return binding.getRoot();
    }
}
