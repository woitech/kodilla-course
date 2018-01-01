package com.kodilla.good.patterns.orders.ordering;

import com.kodilla.good.patterns.orders.data.*;

public final class OrderRequest {
    private final User user;
    private final Product product;
    private final int quantity;
    private final double amount;

    public OrderRequest(final User user, final Product product,
                        final int quantity) {
        if (user == null || product == null || quantity <= 0) {
            throw new IllegalArgumentException();
        }

        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.amount = product.getPrice() * quantity;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderRequest that = (OrderRequest) o;
        if (quantity != that.quantity) return false;
        if (!user.equals(that.user)) return false;
        return product.equals(that.product);
    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + product.hashCode();
        result = 31 * result + quantity;
        return result;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "user=" + user +
                ", product=" + product +
                ", quantity=" + quantity +
                ", amount=" + amount +
                '}';
    }
}
