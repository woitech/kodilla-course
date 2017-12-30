package com.kodilla.good.patterns.orders.ordering;

public final class OrderProcessResultDto {
    private final ProductOrder order;
    private final PlacedProductOrder placedOrder;
    private final boolean isUserInformed;
    private final boolean isOrderStored;

    // order can't be null, placed order can.
    public OrderProcessResultDto(final ProductOrder order,
                                 final PlacedProductOrder placedOrder,
                                 final boolean isUserInformed,
                                 final boolean isOrderStored) {
        if (order == null) {
            throw new IllegalArgumentException("ProductOrder is null");
        }

        this.order = order;
        this.placedOrder = placedOrder;
        this.isUserInformed = isUserInformed;
        this.isOrderStored = isOrderStored;
    }

    public ProductOrder getOrder() {
        return order;
    }

    public PlacedProductOrder getPlacedOrder() {
        return placedOrder;
    }

    public boolean isUserInformed() {
        return isUserInformed;
    }

    public boolean isOrderStored() {
        return isOrderStored;
    }

    @Override
    public String toString() {
        return "OrderProcessResultDto{" +
                "order=" + order +
                ", placedOrder=" + placedOrder +
                ", isUserInformed=" + isUserInformed +
                ", isOrderStored=" + isOrderStored +
                '}';
    }
}
