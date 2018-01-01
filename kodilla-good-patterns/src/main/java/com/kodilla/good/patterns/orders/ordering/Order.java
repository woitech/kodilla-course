package com.kodilla.good.patterns.orders.ordering;

import com.kodilla.good.patterns.orders.data.*;
import java.time.LocalDate;

public final class Order implements OrderData {
    private final OrderData data;
    private final int id;
    private final LocalDate date;

    public Order(final OrderData data, final int id,
                 final LocalDate date) {
        if (data == null || id <= 0 || date == null) {
            throw new IllegalArgumentException();
        }

        this.data = data;
        this.id = id;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public User getUser() {
        return data.getUser();
    }

    @Override
    public Product getProduct() {
        return data.getProduct();
    }

    @Override
    public int getQuantity() {
        return data.getQuantity();
    }

    @Override
    public double getAmount() {
        return data.getAmount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        if (id != order.id) return false;
        if (!data.equals(order.data)) return false;
        return date.equals(order.date);
    }

    @Override
    public int hashCode() {
        int result = data.hashCode();
        result = 31 * result + id;
        result = 31 * result + date.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
               "id=" + id +
               ", date=" + date +
               ", data=" + data +
               '}';
    }
}
