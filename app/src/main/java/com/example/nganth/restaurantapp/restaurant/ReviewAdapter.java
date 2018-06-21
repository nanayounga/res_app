package com.example.nganth.restaurantapp.restaurant;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.nganth.restaurantapp.R;
import com.example.nganth.restaurantapp.databinding.ItemReviewBinding;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter {
    private List<String> list;

    public ReviewAdapter(List<String> list) {
        this.list = list;
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
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup recyclerView, int viewType) {
        // Lấy layout trong thư mục res
        // đối tượng hỗ trợ truy xuất tài nguyên layout trong thư mục res/layout
        LayoutInflater layoutInflater = LayoutInflater.from(recyclerView.getContext());
        // binding đến layout mà mình muốn lấy
        ItemReviewBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_review, recyclerView, false);
        // lấy layout ra
        View layout = binding.getRoot();

        // cung cấp cho ViewHolder
        MyViewHolder viewHolder = new MyViewHolder(layout);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemReviewBinding binding = DataBindingUtil.findBinding(holder.itemView);

        String data = list.get(position);

        binding.txtAddress.setText(data);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}