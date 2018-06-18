package com.example.nganth.restaurantapp.restaurant;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerWalkthoughtAdapter extends FragmentStatePagerAdapter {
    public PagerWalkthoughtAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new ItemFragmentWalkthought();
        Bundle bundle = new Bundle();
        bundle.putString("value", String.valueOf(position));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
