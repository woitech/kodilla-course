package com.kodilla.good.patterns.orders.ordering.services;

import com.kodilla.good.patterns.orders.ordering.Order;

public class InMemoryOrderRepository implements OrderRepository {
    @Override
    public boolean create(Order order) {
        // return database.addOrder(order);
        // dummy result
        return true;
    }
}
