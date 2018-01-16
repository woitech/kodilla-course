package com.kodilla.good.patterns.food2door.external.gfs;

// Let it be external library class and F2D developer can't change it.

// DEMO
public class GFSClient {
    private static int count = 0;

    // demo
    public static boolean connect(String url, String user, String pass) {
        return true;
    }

    // demo
    public static String[][] getOffers() {
        String[][] offers = {
                {"Potato", "kg", "120.0", "2.4"},
                {"Cabbage", "item", "12", "8.3"},
                {"Sauerkraut", "kg", "15.0", "4.5"}
        };
        return offers;
    }

    // returns GFS inner identifier of accepted order
    // demo
    public static String sendOrder(String[] order) {
        return "OO/GFS/" + (++count);
    }
}