package com.kodilla.good.patterns.orders.ordering;

import com.kodilla.good.patterns.orders.data.*;

public interface OrderData {
    public User getUser();
    public Product getProduct();
    public int getQuantity();
    public double getAmount();
}
