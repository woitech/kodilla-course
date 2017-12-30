package com.kodilla.good.patterns.orders.ordering.services;

import com.kodilla.good.patterns.orders.ordering.*;
import com.kodilla.good.patterns.orders.data.*;

import java.time.LocalDate;

public class ProductOrderService implements OrderService {
    private static int lastId = 0;

    @Override
    public PlacedProductOrder order(ProductOrder order) {
        if (order == null) {
            throw new IllegalArgumentException();
        }
        return placeOrder(order);
    }

    private PlacedProductOrder placeOrder(ProductOrder order) {
        User user = order.getUser();
        Product product = order.getProduct();
        int quantity = order.getQuantity();

        // do something with user, product, quantity ...
        // if (error) { return null; }

        return new PlacedProductOrder(user, product, quantity, ++lastId,
                                      LocalDate.now());
    }
}
