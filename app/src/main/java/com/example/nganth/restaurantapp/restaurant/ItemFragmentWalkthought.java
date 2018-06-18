package com.example.nganth.restaurantapp.restaurant;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nganth.restaurantapp.R;
import com.example.nganth.restaurantapp.databinding.FragmentItemWalkthoughtBinding;

public class ItemFragmentWalkthought extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentItemWalkthoughtBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_item_walkthought, container, false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String value = bundle.getString("value");
            binding.textView.setText(value);
        }
        return binding.getRoot();
    }
}
