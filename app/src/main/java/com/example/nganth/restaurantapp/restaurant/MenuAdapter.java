package com.example.nganth.restaurantapp.restaurant;

import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.nganth.restaurantapp.R;
import com.example.nganth.restaurantapp.databinding.ItemMenuBinding;
import com.example.nganth.restaurantapp.user.Restaurant;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter {
    private ArrayList<Restaurant> restaurants;

    public MenuAdapter(ArrayList<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup recyclerView, int viewType) {
        // Lấy layout trong thư mục res
        // đối tượng hỗ trợ truy xuất tài nguyên layout trong thư mục res/layout
        LayoutInflater layoutInflater = LayoutInflater.from(recyclerView.getContext());
        // binding đến layout mà mình muốn lấy
        ItemMenuBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_menu, recyclerView, false);
        // lấy layout ra
        View layout = binding.getRoot();

        // cung cấp cho ViewHolder
        MyViewHolder viewHolder = new MyViewHolder(layout);
        return viewHolder;
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // vị trí vừa click
                    int position = getAdapterPosition();
                    Toast.makeText(view.getContext(), String.valueOf(position), Toast.LENGTH_LONG).show();
                }
            });

        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemMenuBinding binding = DataBindingUtil.findBinding(holder.itemView);

        Restaurant data = restaurants.get(position);

        binding.lblResNameMenu.setText(data.resName);

        if (TextUtils.isEmpty(data.resImage)) {
            binding.imgFood.setImageResource(R.drawable.food_menu);
        }
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }
}
