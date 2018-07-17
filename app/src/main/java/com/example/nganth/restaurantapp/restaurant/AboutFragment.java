package com.example.nganth.restaurantapp.restaurant;

import android.Manifest;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nganth.restaurantapp.R;
import com.example.nganth.restaurantapp.VideoService;
import com.example.nganth.restaurantapp.databinding.AboutBinding;

//https://www.technobyte.org/play-video-file-android-studio-using-videoview-tutorial/

public class AboutFragment extends Fragment {
    private AboutBinding binding;
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("broadcast")) {
                int star = intent.getIntExtra("star", 0);

                Dialog dialog = new Dialog(getContext());
                dialog.setTitle("dialog");
                TextView textView = new TextView(getContext());
                textView.setText(String.valueOf(star) + "Nga is testing");
                dialog.setContentView(textView);
                dialog.show();
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.about, container, false);

        ViewPagerMenuActivity mainActivity = (ViewPagerMenuActivity) getActivity();
        binding.setVariableAbout(mainActivity);

        //-- begin service video in about page
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (getActivity().checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 111);
            } else {
                startService();
            }
        } else {
            startService();
        }
        //-- end service video in about page

        getContext().registerReceiver(broadcastReceiver, new IntentFilter("broadcast"));

        return binding.getRoot();
    }

    private void startService() {
        getActivity().startService(new Intent(getActivity(), VideoService.class));
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 111) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startService();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getContext().unregisterReceiver(broadcastReceiver);
    }
}
