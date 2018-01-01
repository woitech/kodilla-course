package com.kodilla.good.patterns.orders.ordering.services;

import com.kodilla.good.patterns.orders.ordering.Order;

public interface OrderRepository {
    public boolean create(Order order);
}
