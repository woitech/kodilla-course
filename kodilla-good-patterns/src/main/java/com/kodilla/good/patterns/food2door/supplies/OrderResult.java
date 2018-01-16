package com.kodilla.good.patterns.food2door.supplies;

import static com.kodilla.good.patterns.food2door.Validator.*;

public final class OrderResult {
    private final String outerId;
    private final Order order;

    public OrderResult(final String outerId, final Order order) {
        validateString(outerId, "valueless outer id");
        validateNotNull(order, "null Order");

        this.outerId = outerId;
        this.order = order;
    }

    public String getOuterId() {
        return outerId;
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderResult that = (OrderResult) o;
        if (!outerId.equals(that.outerId)) return false;
        return order.equals(that.order);
    }

    @Override
    public int hashCode() {
        int result = outerId.hashCode();
        result = 31 * result + order.hashCode();
        return result;
    }

    public String toFineString() {
        return "OrderResult {" + '\n' +
                "outerId='" + outerId + '\'' + '\n' +
                order.toFineString() + '\n' +
                '}';
    }

    @Override
    public String toString() {
        return "OrderResult{" +
                "outerId='" + outerId + '\'' +
                ", order=" + order +
                '}';
    }
}
