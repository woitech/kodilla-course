package com.kodilla.good.patterns.food2door.external.efs;

// Let it be external library class and Food2Door developer can't change it.

import java.util.*;

// DEMO
public class EFSClient {
    private static int count = 0;

    // demo
    public static boolean connect(String url, String user, String pass) {
        return true;
    }

    // demo
    public static List<EFSOffer> fetch() {
        List<EFSOffer> offers = new ArrayList<>();
        offers.add(new EFSOffer("Apple", "kg", 50.0, 3.0));
        offers.add(new EFSOffer("Tomato", "kg", 23.0, 6.7));
        offers.add(new EFSOffer("Goat milk", "l", 5.0, 12.3));
        return offers;
    }

    // returns EFS inner identifier of accepted order
    // demo
    public static String send(EFSOrder order) {
        return "Outer order EFS/" + (++count);
    }
}
