package com.kodilla.good.patterns.food2door.services;

import com.kodilla.good.patterns.food2door.data.Order;

public class GFSOrderService extends AbstractOrderService {
    public GFSOrderService(String url, String user, String pass) {
        super(url, user, pass);
    }

    @Override
    public boolean order(Order order) {
        // dummy
        return true;
    }
}
