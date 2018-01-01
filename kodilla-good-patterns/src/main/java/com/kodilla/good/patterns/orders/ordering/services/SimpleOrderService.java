package com.kodilla.good.patterns.orders.ordering.services;

import com.kodilla.good.patterns.orders.ordering.*;

import java.time.LocalDate;

public class SimpleOrderService implements OrderService {
    private static int lastId = 0;

    @Override
    public Order order(OrderRequest request) {
        if (request == null) {
            throw new IllegalArgumentException();
        }
        return placeOrder(request);
    }

    private Order placeOrder(OrderRequest request) {
        // do something with request ...
        // if (error) { return null; }
        return new Order(request, ++lastId, LocalDate.now());
    }
}
