package com.example.nganth.restaurantapp.restaurant;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nganth.restaurantapp.R;
import com.example.nganth.restaurantapp.databinding.FragmentItemWalkthoughtBinding;
import com.example.nganth.restaurantapp.user.Restaurant;

import java.util.ArrayList;

public class ItemFragmentWalkthought extends Fragment {

    private FragmentItemWalkthoughtBinding binding;
    ArrayList<Restaurant> restaurants = new ArrayList<>();

    private PagerWalkthoughtAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentItemWalkthoughtBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_item_walkthought, container, false);
//        Bundle bundle = getArguments();

        restaurants = (ArrayList<Restaurant>)getArguments().getSerializable("listRes");

        if (restaurants != null) {
//            String nameResPar = bundle.getString("nameResGet");
//            binding.nameResWalkthought.setText(nameResPar);

            Restaurant data = restaurants.get(0);
            String imgResPar = data.resImage;
            binding.imgWalkthought.setImageDrawable(Drawable.createFromPath(imgResPar));

            String nameResPar = data.resName;
            binding.nameResWalkthought.setText(nameResPar);

            String addressResPar = data.resAddress;
            binding.addressResWalkthought.setText(addressResPar);
        }

        return binding.getRoot();
    }
}
