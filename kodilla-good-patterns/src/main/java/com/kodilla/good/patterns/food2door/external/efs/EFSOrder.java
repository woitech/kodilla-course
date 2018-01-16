package com.kodilla.good.patterns.food2door.external.efs;

// Let it be external library class and Food2Door developer can't change it.

import java.time.*;

public final class EFSOrder {
    private LocalDateTime date;
    private final String productName;
    private final String measure;
    private double quantity;
    private final double price;

    public EFSOrder(final LocalDateTime date, final String productName, final String measure, final double quantity,
                    final double price) {
        validate(date, productName, measure, quantity, price);

        this.date = date;
        this.productName = productName;
        this.measure = measure;
        this.quantity = quantity;
        this.price = price;
    }

    private void validate(LocalDateTime date, String productName, String measure, double quantity, double price) {
        if (date == null) {
            throw new IllegalArgumentException("Date is null");
        }
        if (productName == null || productName.isEmpty()) {
            throw new IllegalArgumentException("valueless name");
        }
        if (measure == null || measure.isEmpty()) {
            throw new IllegalArgumentException("valueless measure");
        }
        if (quantity < 0.0) {
            throw new IllegalArgumentException("quantity < 0");
        }
        if (price <= 0.0) {
            throw new IllegalArgumentException("price <= 0");
        }
    }



}
