package com.example.nganth.restaurantapp.restaurant;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nganth.restaurantapp.BaseActivity;
import com.example.nganth.restaurantapp.R;
import com.example.nganth.restaurantapp.databinding.AboutBinding;

/**
 * Created by HV on 6/10/2018.
 */

public class AboutFragment extends Fragment {
    private AboutBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.about, container, false);

        ViewPagerMenuActivity mainActivity = (ViewPagerMenuActivity) getActivity();
        binding.setVariableAbout(mainActivity);

        return binding.getRoot();
    }

}
