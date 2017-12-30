package com.kodilla.good.patterns.orders.ordering.services;

import com.kodilla.good.patterns.orders.ordering.PlacedProductOrder;

public class ProductOrderRepository implements OrderRepository {
    @Override
    public boolean create(PlacedProductOrder placedOrder) {
        // return database.addOrder(placedOrder);
        // dummy result
        return true;
    }
}
