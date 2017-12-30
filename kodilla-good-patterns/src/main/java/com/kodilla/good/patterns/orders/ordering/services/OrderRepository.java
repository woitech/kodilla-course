package com.kodilla.good.patterns.orders.ordering.services;

import com.kodilla.good.patterns.orders.ordering.PlacedProductOrder;

public interface OrderRepository {
    public boolean create(PlacedProductOrder placedOrder);
}
