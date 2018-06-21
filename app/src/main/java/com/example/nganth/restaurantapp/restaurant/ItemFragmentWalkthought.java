package com.example.nganth.restaurantapp.restaurant;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nganth.restaurantapp.R;
import com.example.nganth.restaurantapp.Restaurant;
import com.example.nganth.restaurantapp.databinding.FragmentItemWalkthoughtBinding;

import java.util.ArrayList;

public class ItemFragmentWalkthought extends Fragment {

    private FragmentItemWalkthoughtBinding binding;

    private PagerWalkthoughtAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentItemWalkthoughtBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_item_walkthought, container, false);
        Bundle bundle = getArguments();

        if (bundle != null) {
            Restaurant data = (Restaurant) bundle.getSerializable("Res");
            String imgResPar = data.resImage;
            if (TextUtils.isEmpty(imgResPar)) {
                binding.imgWalkthought.setImageResource(R.drawable.food_menu);
            } else {
                binding.imgWalkthought.setImageDrawable(Drawable.createFromPath(imgResPar));
            }

            String nameResPar = data.resName;
            binding.nameResWalkthought.setText(nameResPar);

            String addressResPar = data.resAddress;
            binding.addressResWalkthought.setText(addressResPar);
        }

        return binding.getRoot();
    }
}
