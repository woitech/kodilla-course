package com.kodilla.good.patterns.orders.ordering;

public final class OrderProcessResult {
    private final Order order;
    private final boolean isUserInformed;
    private final boolean isOrderStored;

    public OrderProcessResult(final Order order, final boolean isUserInformed,
                              final boolean isOrderStored) {
        if (order == null) {
            throw new IllegalArgumentException("Order is null");
        }

        this.order = order;
        this.isUserInformed = isUserInformed;
        this.isOrderStored = isOrderStored;
    }

    public Order getOrder() {
        return order;
    }

    public boolean isUserInformed() {
        return isUserInformed;
    }

    public boolean isOrderStored() {
        return isOrderStored;
    }

    @Override
    public String toString() {
        return "OrderProcessResult{" +
                ", order=" + order +
                ", isUserInformed=" + isUserInformed +
                ", isOrderStored=" + isOrderStored +
                '}';
    }
}
