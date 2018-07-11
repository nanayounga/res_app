package com.example.nganth.restaurantapp.user;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.nganth.restaurantapp.BaseActivity;
import com.example.nganth.restaurantapp.MySqliteOpenHelper;
import com.example.nganth.restaurantapp.Restaurant;
import com.example.nganth.restaurantapp.restaurant.ViewPagerMenuActivity;

import java.util.ArrayList;


public class FavoriteActivity extends BaseActivity {
    private SQLiteDatabase database;
    private com.example.nganth.restaurantapp.databinding.FavoriteBinding binding;

    ArrayList<Restaurant> restaurants = new ArrayList<>();
    private FavoriteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = android.databinding.DataBindingUtil.setContentView(this, com.example.nganth.restaurantapp.R.layout.favorite);

        MySqliteOpenHelper openHelper = new
                MySqliteOpenHelper(getApplicationContext());

        database = openHelper.getWritableDatabase();
//        insert();
        find(null);

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

    public void find(View view) {
        Cursor cursor = database.query("favorites",null, null, null, null, null, "id DESC");
        if (cursor != null) {
            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex("id"); // == 0;
                String resId = cursor.getString(1);
                String resName = cursor.getString(2);
                String resAdd = cursor.getString(3);
                String resImage = cursor.getString(4);
                Float resRate = cursor.getFloat(5);
                String userEmail = cursor.getString(6);

                restaurants.add(new Restaurant(resId, resName, resAdd, resImage, userEmail, resRate));
            }
        }
    }

    private void insert() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("res_id", "1");// thêm giá trị cho cột hoten
        contentValues.put("res_name", "Restaurant 3");// thêm giá trị cho cột hoten
        contentValues.put("res_add", "DN");// thêm giá trị cho cột diachi
        contentValues.put("res_img", "CmRaAAAAX-LywgyVrefPrIbLJOb7okwPLPkNCIr6WojhpWlBf72oPxQ8zZp8FEa58CdlUsw4v2rP15yHclWr1cu7qwqUC7QIFwxQivvoX6i4xdGFe3XU0sJ6ZVWxUee0xchf2FcyEhDCrBfRpbidfULwLhIsZj01GhSs_onrfczoUCE2qNI1Z6xOR5SWGw&key=AIzaSyCEOvWIiRye57Hwi6nQoTkL7FuXX0--0xs");
        contentValues.put("res_rate", 5);
        contentValues.put("user_email", "nganth@evolableasia.vn");
        long id = database.insert(
                "favorites", // tên bảng
                null,
                contentValues // dữ liệu của 1 dòng
        );

//        Toast.makeText(getApplicationContext(), String.valueOf(id), Toast.LENGTH_LONG).show();
    }

    public void delete() {
        int count = database.delete("favorites",
                "id = 4",
                null
        );
//        Toast.makeText(getApplicationContext(), String.valueOf(count), Toast.LENGTH_LONG).show();
    }
}
