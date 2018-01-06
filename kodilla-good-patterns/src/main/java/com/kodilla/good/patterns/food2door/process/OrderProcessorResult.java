package com.kodilla.good.patterns.food2door.process;

import com.kodilla.good.patterns.food2door.data.Order;

import java.util.*;

public final class OrderProcessorResult {
    private final String message;
    private final List<Order> succeedOrders;
    private final List<Order> savedOrders;

    public OrderProcessorResult(final String message, final List<Order> succeedOrders, final List<Order> savedOrders) {
        if(message == null || succeedOrders == null || savedOrders == null) {
            throw new IllegalArgumentException();
        }

        this.message = message;
        this.succeedOrders = succeedOrders;
        this.savedOrders = savedOrders;
    }

    public OrderProcessorResult(final String message) {
        this(message, Collections.emptyList(), Collections.emptyList());
    }

    public String getMessage() {
        return message;
    }

    public List<Order> getSucceedOrders() {
        return succeedOrders;
    }

    public List<Order> getSavedOrders() {
        return savedOrders;
    }

    @Override
    public String toString() {
        return "OrderProcessorResult{" +
                "message='" + message + '\'' +
                ", succeedOrders=" + succeedOrders +
                ", savedOrders=" + savedOrders +
                '}';
    }
}
