package com.example.nganth.restaurantapp.restaurant;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.nganth.restaurantapp.Restaurant;

import java.util.ArrayList;

public class PagerWalkthoughtAdapter extends FragmentStatePagerAdapter {

    ArrayList<Restaurant> restaurants = new ArrayList<>();

    public PagerWalkthoughtAdapter(FragmentManager fm) {
        super(fm);

        restaurants.add(new Restaurant("Nha hang 1",". New York, NY, USA", null));
        restaurants.add(new Restaurant("Nha hang 2",". New York, NY, USA", null));
        restaurants.add(new Restaurant("Nha hang 3",null, null));
        restaurants.add(new Restaurant("Nha hang 4",null, null));
        restaurants.add(new Restaurant("Nha hang 5",null, null));
        restaurants.add(new Restaurant("Nha hang 6",null, null));
        restaurants.add(new Restaurant("Nha hang 7",null, null));
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new ItemFragmentWalkthought();

        Bundle bundle = new Bundle();
        bundle.putSerializable("Res", restaurants.get(position));
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public int getCount() {
        return restaurants.size();
    }
}
