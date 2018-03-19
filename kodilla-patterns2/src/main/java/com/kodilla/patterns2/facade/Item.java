package com.kodilla.patterns2.facade;

public class Item {
    private Long productId;
    private double qty;

    public Item(long productId, double qty) {
        this.productId = productId;
        this.qty = qty;
    }

    public Long getProductId() {
        return productId;
    }

    public double getQty() {
        return qty;
    }
}
