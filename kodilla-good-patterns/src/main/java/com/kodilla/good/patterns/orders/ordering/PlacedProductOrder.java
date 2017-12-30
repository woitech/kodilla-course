package com.kodilla.good.patterns.orders.ordering;

import com.kodilla.good.patterns.orders.data.*;
import java.time.LocalDate;

public class PlacedProductOrder extends ProductOrder {
    private final int id;
    private final LocalDate date;

    public PlacedProductOrder(final User user, final Product product,
                              final int quantity, final int id,
                              final LocalDate date) {
        super(user, product, quantity);

        if (id <= 0 || date == null) {
            throw new IllegalArgumentException();
        }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PlacedProductOrder that = (PlacedProductOrder) o;
        if (id != that.id) return false;
        return date.equals(that.date);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id;
        result = 31 * result + date.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PlacedProductOrder{" +
                "id=" + id +
                ", date=" + date +
                ", user=" + getUser() +
                ", product=" + getProduct() +
                ", quantity=" + getQuantity() +
                ", amount=" + getAmount() +
                "}";
    }
}
