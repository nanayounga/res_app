package com.example.nganth.restaurantapp.user;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.nganth.restaurantapp.R;
import com.example.nganth.restaurantapp.Restaurant;
import com.example.nganth.restaurantapp.databinding.ItemFavoriteBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FavoriteAdapter extends RecyclerView.Adapter {
    private static final String IMAGE_PATH = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&key=AIzaSyCEOvWIiRye57Hwi6nQoTkL7FuXX0--0xs&photoreference=";

    public interface Callback {
        void onItemSelected(int position, String value);
    }

    private ArrayList<Restaurant> restaurants;
    private Callback callback;

    public void onItemClick(Callback callback) {
        this.callback = callback;
    }

    public FavoriteAdapter(ArrayList<Restaurant> restaurants) {
        this.restaurants = restaurants;
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
                    if (callback != null) {
                        Restaurant data = restaurants.get(position);
                        callback.onItemSelected(position, data.resName);
                    }
                }
            });
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup recycleView, int viewType) {
        // Lay layout trong thu muc res
        LayoutInflater layoutInflater = LayoutInflater.from(recycleView.getContext());
        // Binding den layout ma minh muon lay
        ItemFavoriteBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_favorite, recycleView, false);
        // Lay layout ra
        View layout = binding.getRoot();
        // Cung cap cho ViewHolder
        MyViewHolder viewHolder = new MyViewHolder(layout);
        return viewHolder;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemFavoriteBinding binding = DataBindingUtil.findBinding(holder.itemView);

        Restaurant data = restaurants.get(position);

        binding.lblResName.setText(data.resName);
        binding.lblResAddress.setText(data.resAddress);

        if (TextUtils.isEmpty(data.resImage)) {
            binding.imgRestaurant.setImageResource(R.drawable.img_res);
        } else {
            Context context = holder.itemView.getContext();
//            Picasso.with(context).load(IMAGE_PATH + data.getResImage()).placeholder(R.mipmap.ic_launcher).into(binding.imgRestaurant);
            Picasso.with(context).load(IMAGE_PATH + data.getResImage()).placeholder(R.mipmap.ic_launcher).into(binding.imgRestaurant);
        }
    }

    public int getItemCount() {
        return restaurants.size();
    }
}
