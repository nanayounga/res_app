package com.example.nganth.restaurantapp;

public class Place {

        Integer placeId;
        String icon, name, formatted_address, formatted_phone_number, reference;

        public Place() { }

        public Integer getPlaceId() {
            return placeId;
        }

        public String getName() {
            return name;
        }

        public String getIcon() {
            return icon;
        }

        public String getFormatted_address() {
            return formatted_address;
        }

        public String getFormatted_phone_number() {
            return formatted_phone_number;
        }

        public String getReference() {
            return reference;
        }
}
