package com.kodilla.good.patterns.orders.ordering;

import com.kodilla.good.patterns.orders.data.*;
import java.time.LocalDate;

public final class Order {
    private final OrderRequest request;
    private final int id;
    private final LocalDate date;

    public Order(final OrderRequest request, final int id,
                 final LocalDate date) {
        if (request == null || id <= 0 || date == null) {
            throw new IllegalArgumentException();
        }

        this.request = request;
        this.id = id;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public User getUser() {
        return request.getUser();
    }

    public Product getProduct() {
        return request.getProduct();
    }

    public int getQuantity() {
        return request.getQuantity();
    }

    public double getAmount() {
        return request.getAmount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        if (id != order.id) return false;
        if (!request.equals(order.request)) return false;
        return date.equals(order.date);
    }

    @Override
    public int hashCode() {
        int result = request.hashCode();
        result = 31 * result + id;
        result = 31 * result + date.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
               "id=" + id +
               ", date=" + date +
                ", user=" + request.getUser() +
                ", product=" + request.getProduct() +
                ", quantity=" + request.getQuantity() +
                ", amount=" + request.getAmount() +
               '}';
    }
}
