package com.example.nganth.restaurantapp.restaurant;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nganth.restaurantapp.R;
import com.example.nganth.restaurantapp.databinding.MenuBinding;
import com.example.nganth.restaurantapp.user.Restaurant;

import java.util.ArrayList;

/**
 * Created by HV on 6/10/2018.
 */

public class MenuFragment extends Fragment{

    private MenuBinding binding;
    ArrayList<Restaurant> restaurants = new ArrayList<>();
    private MenuAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.menu, container, false);

        RestaurantActivity mainActivity = (RestaurantActivity) getActivity();
        binding.setVariableMenu(mainActivity);

        restaurants.add(new Restaurant("Nha hang 1",null, null));
        restaurants.add(new Restaurant("Nha hang 2",null, null));
        restaurants.add(new Restaurant("Nha hang 3",null, null));
        restaurants.add(new Restaurant("Nha hang 4",null, null));
        restaurants.add(new Restaurant("Nha hang 5",null, null));
        restaurants.add(new Restaurant("Nha hang 6",null, null));
        restaurants.add(new Restaurant("Nha hang 7",null, null));

        // khoi tao Adapter
        MenuAdapter adapter = new MenuAdapter(restaurants);

        // cung cap Adapter cho RecyclerView
        binding.lstResGrid.setAdapter(adapter);

        // thiet lap dang hien thi cho RecyclerView
        // hiển thị dạng lưới
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mainActivity.getApplicationContext(),
                2);
        binding.lstResGrid.setLayoutManager(gridLayoutManager);

        return binding.getRoot();
    }

//    public void openAboutActivity(android.view.View view) {
//        android.content.Intent intent = new android.content.Intent(getActivity().getApplicationContext(), AboutActivity.class);
//        startActivity(intent);
//    }
}
