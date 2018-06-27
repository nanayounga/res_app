package com.example.nganth.restaurantapp;

import java.io.Serializable;

public class Restaurant implements Serializable {
        public String resName,resImage, resAddress;

        public Restaurant(){};
        public Restaurant(String resName, String resImage, String resAddress) {
            this.resName = resName;
            this.resImage = resImage;
            this.resAddress = resAddress;
        }

        public String getResName() {
            return resName;
        }

        public String getResImage() {
            return resImage;
        }

        public String getResAddress() {
            return resAddress;
        }
}
