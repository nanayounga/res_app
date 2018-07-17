package com.example.nganth.restaurantapp.restaurant;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.nganth.restaurantapp.BaseActivity;
//import com.example.nganth.restaurantapp.Manifest;
import com.example.nganth.restaurantapp.DataRestaurant;
import com.example.nganth.restaurantapp.Place;
import com.example.nganth.restaurantapp.R;
import com.example.nganth.restaurantapp.Restaurant;
import com.example.nganth.restaurantapp.database.FavoritesTable;
import com.example.nganth.restaurantapp.databinding.ActivityViewPagerMenuBinding;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

//https://developers.google.com/places/web-service/details
//-- get restaurant detail
//https://maps.googleapis.com/maps/api/place/details/json?placeid=ChIJ15256JXBiYgRJe9BObOLjtM&fields=photo,name,rating,formatted_phone_number,formatted_address,url,website,place_id&key=AIzaSyCEOvWIiRye57Hwi6nQoTkL7FuXX0--0xs
//-- get restaurant's photo
//https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=CmRaAAAAX-LywgyVrefPrIbLJOb7okwPLPkNCIr6WojhpWlBf72oPxQ8zZp8FEa58CdlUsw4v2rP15yHclWr1cu7qwqUC7QIFwxQivvoX6i4xdGFe3XU0sJ6ZVWxUee0xchf2FcyEhDCrBfRpbidfULwLhIsZj01GhSs_onrfczoUCE2qNI1Z6xOR5SWGw&key=AIzaSyCEOvWIiRye57Hwi6nQoTkL7FuXX0--0xs


public class ViewPagerMenuActivity extends BaseActivity {
    private ActivityViewPagerMenuBinding binding;
    private FragmentManager fragmentManager;
    private int page = 0;
    public ArrayList<Restaurant> restaurant_api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_pager_menu);
        binding.setVariableMenu(this);

        Intent intent = getIntent();
        if (intent != null) {
            page = intent.getIntExtra("pageNumber", 0);
        }

        getResFromAPI();

        //--region: gan du lieu restaurant vao field
        binding.txtResNameInMenuPage.setText(restaurant_api != null ? restaurant_api.get(0).getResName() : "name testing");
        binding.txtResAddressInMenuPage.setText(restaurant_api != null ? restaurant_api.get(0).getResAddress() : "address testing");
        //--endregion: gan du lieu restaurant vao field

        PagerMenuAdapter adapter = new PagerMenuAdapter(getSupportFragmentManager());

        binding.viewPagerMenu.setAdapter(adapter);

        binding.viewPagerMenu.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //region demo show notification
                if (position == 1) {
                    sendBroadcast(new Intent("notify"));
                } else {
                    sendBroadcast(new Intent("close"));
                }

                //endregion
                for (int i = 0; i < binding.tabLayoutMenu.getTabCount(); i++) {
                    TabLayout.Tab tab = binding.tabLayoutMenu.getTabAt(i);

                    TextView view = (TextView) tab.getCustomView();

                    if (i == position) {
                        view.setTextColor(getResources().getColor(R.color.colorOrange));
                    } else {
                        view.setTextColor(Color.BLACK);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        binding.tabLayoutMenu.setupWithViewPager(binding.viewPagerMenu);

        //binding.tabLayoutMenu.set

        for (int i = 0; i < binding.tabLayoutMenu.getTabCount(); i++) {
            TabLayout.Tab tab = binding.tabLayoutMenu.getTabAt(i);

            TextView textView = new TextView(getApplicationContext());
            textView.setTextColor(Color.BLACK);
            textView.setGravity(Gravity.CENTER);

            if (i == 0) {
                textView.setText("Menu");
                textView.setTextColor(getResources().getColor(R.color.colorOrange));
            }
            else if (i == 1) {
                textView.setText("About");
            }
            else {
                textView.setText("Review");
            }
            tab.setCustomView(textView);
        }

        binding.viewPagerMenu.setCurrentItem(page);


    }

    public void getResFromAPI() {
        //region: get restaurant from api
        // link:
        // https://maps.googleapis.com/maps/api/place/details/json?
        // placeid=ChIJ15256JXBiYgRJe9BObOLjtM&
        // fields=photo,name,rating,formatted_phone_number,formatted_address,url,website,place_id&
        // key=AIzaSyCEOvWIiRye57Hwi6nQoTkL7FuXX0--0xs

        String placeId = "ChIJ15256JXBiYgRJe9BObOLjtM";
        String params = "photo,name,rating,formatted_phone_number,formatted_address,url,website,place_id,geometry";
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://maps.googleapis.com/maps/api/place/details/json?" +
                "placeid=" + placeId + "&" +
                "fields=" + params + "&" +
                "key=AIzaSyCEOvWIiRye57Hwi6nQoTkL7FuXX0--0xs";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        String res_photo = null;
                        Double par_lat = null;
                        Double par_lng = null;

                        // khoi tao danh sach diem can phai ve
                        List<DataRestaurant> list = new ArrayList<>();

//                        Log.d("Rest API", response);
                        Gson gson = new Gson();
                        DataRestaurant data = gson.fromJson(response, DataRestaurant.class);

                        if (data != null) {
                            for (DataRestaurant.Result.Photos photo : data.result.photos) {
                                res_photo = photo.photo_reference;
                            }
//                            for (DataRestaurant.Result.Geometry geometry : data.result.geometry) {
//                                for (DataRestaurant.Result.Geometry.Location location : geometry.location) {
//                                    par_lat = location.lat;
//                                    par_lng = location.lng;
//                                }
//                            }
//                            Log.d("Rest API", Double.toString(par_lat));

//                            restaurant_api.add(new Place(data.result.place_id, null, data.result.name, data.result.formatted_address, data.result.formatted_phone_number, res_photo, par_lat, par_lng));
//                            restaurant_api.add(new Restaurant(data.result.place_id, data.result.name, data.result.formatted_address, res_photo, "nga@abc.com", data.result.rating));
//                            restaurant_api.add(new Restaurant("asdf", "asdf", "asdf", "asdf", "asdf", 2F));
//                            Log.d("Rest API", data.result.place_id);
//                            Log.d("Rest API", data.result.name);
//                            Log.d("Rest API", data.result.formatted_address);
//                            Log.d("Rest API", res_photo);
//                            Log.d("Rest API", Float.toString(data.result.rating));

                        } else {
                            Log.d("Rest API", "no data");
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Data from API: ", error.getMessage());

            }
        });

        queue.add(stringRequest);
        //endregion
    }

    public void showAbout(View view) {
        android.content.Intent intent = new android.content.Intent(getApplicationContext(), com.example.nganth.restaurantapp.restaurant.ViewPagerMenuActivity.class);
        startActivity(intent);
    }

    public void showWeb(View view) {
        android.content.Intent intent = new android.content.Intent(getApplicationContext(), com.example.nganth.restaurantapp.restaurant.WebViewActivity.class);
        TextView textView = (TextView) view;
        intent.putExtra("url", textView.getText().toString());
        startActivity(intent);
    }

    public void showMenu(View view) {
        android.content.Intent intent = new android.content.Intent(getApplicationContext(), com.example.nganth.restaurantapp.restaurant.ViewPagerMenuActivity.class);
        startActivity(intent);
    }

    public void showReview(View view) {
        android.content.Intent intent = new android.content.Intent(getApplicationContext(), com.example.nganth.restaurantapp.restaurant.ViewPagerMenuActivity.class);
        startActivity(intent);
    }

    public void openFavoriteActivity(View view) {
        android.content.Intent intent = new android.content.Intent(getApplicationContext(), com.example.nganth.restaurantapp.user.FavoriteActivity.class);
        startActivity(intent);
    }

    public void addFavorites(View view) {
        FavoritesTable favoritesTable = new FavoritesTable(this);
//        favoritesTable.insert(
//                new Restaurant(restaurant_api.get(0).resId, restaurant_api.get(0).resName, restaurant_api.get(0).resAddress, restaurant_api.get(0).resImage, restaurant_api.get(0).userEmail, restaurant_api.get(0).resRate));
        favoritesTable.insert(new Restaurant("3", "3", "adfj", "CmRaAAAAX-LywgyVrefPrIbLJOb7okwPLPkNCIr6WojhpWlBf72oPxQ8zZp8FEa58CdlUsw4v2rP15yHclWr1cu7qwqUC7QIFwxQivvoX6i4xdGFe3XU0sJ6ZVWxUee0xchf2FcyEhDCrBfRpbidfULwLhIsZj01GhSs_onrfczoUCE2qNI1Z6xOR5SWGw", "asdf@asdlkjf.com", 2F));
    }
}
