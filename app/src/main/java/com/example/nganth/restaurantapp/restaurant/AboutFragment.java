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
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nganth.restaurantapp.R;
import com.example.nganth.restaurantapp.VideoService;
import com.example.nganth.restaurantapp.databinding.AboutBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

//https://www.technobyte.org/play-video-file-android-studio-using-videoview-tutorial/
public class AboutFragment extends Fragment implements OnMapReadyCallback {
//public class AboutFragment extends Fragment {
    private AboutBinding binding;
    private GoogleMap mMap;

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

        //-- region: maps
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //-- endregion: maps

        getContext().registerReceiver(broadcastReceiver, new IntentFilter("broadcast"));

        return binding.getRoot();
    }

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney, Australia, and move the camera.
        LatLng res = new LatLng(34.1749039, -86.61975079999999);
        mMap.addMarker(new MarkerOptions().position(res).title("Marker in Restaurant"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(res, 15));
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
