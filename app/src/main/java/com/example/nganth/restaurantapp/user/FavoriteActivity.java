package com.example.nganth.restaurantapp.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class FavoriteActivity extends AppCompatActivity {

    private com.example.nganth.restaurantapp.databinding.FavoriteBinding binding;

    ArrayList<Restaurant> restaurants = new ArrayList<>();
    private FavoriteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = android.databinding.DataBindingUtil.setContentView(this, com.example.nganth.restaurantapp.R.layout.favorite);

//        android.content.Intent intent = getIntent();

        // data is string
//        List<String> list = new ArrayList<>();
//        list.add("Wabi Sabi restaurant");
//        list.add("Marianne restaurant");
//        list.add("TheFive Fields restaurant");
//        list.add("TortelliniCup London restaurant");

        // data is object

        restaurants.add(new Restaurant("Nha hang 1","Dia chi 1", null));
        restaurants.add(new Restaurant("Nha hang 2","Dia chi 2", null));
        restaurants.add(new Restaurant("Nha hang 3","Dia chi 3", null));
        restaurants.add(new Restaurant("Nha hang 4","Dia chi 4", null));
        restaurants.add(new Restaurant("Nha hang 5","Dia chi 5", null));
        restaurants.add(new Restaurant("Nha hang 6","Dia chi 6", null));
        restaurants.add(new Restaurant("Nha hang 7","Dia chi 7", null));

        // Khoi tao Adapter
        adapter = new FavoriteAdapter(restaurants);

        adapter.onItemClick(new FavoriteAdapter.Callback() {
            @Override
            public void onItemSelected(int position, String value) {
                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_LONG).show();
            }
        });

        // Cung cap Adapter cho RecyclerView
        binding.lstRestaurant.setAdapter(adapter);

        // Thiet lap dang hien thi cho RecyclerView - dang danh sach
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                getApplicationContext(),
                LinearLayoutManager.VERTICAL,
                false
        );

        binding.lstRestaurant.setLayoutManager(linearLayoutManager);
    }

    public void openProfileActivity(android.view.View view) {
        android.content.Intent intent = new android.content.Intent(getApplicationContext(), ProfileActivity.class);
        startActivity(intent);
    }
}
