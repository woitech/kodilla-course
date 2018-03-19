package com.kodilla.patterns2.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private ProductService productService;
    private List<Item> items = new ArrayList<>();
    private Long orderId;
    private Long userId;
    private boolean isPaid;
    private boolean isVeryfied;
    private boolean isSubmitted;

    public Order(long orderId, long userId, ProductService productService) {
        this.productService = productService;
        this.orderId = orderId;
        this.userId = userId;
    }

    public BigDecimal calculateValue() {
        BigDecimal sum = BigDecimal.ZERO;
        for (Item item : items) {
            sum = sum.add(productService.getPrice(item.getProductId()).multiply(new BigDecimal(item.getQty())));
        }

        return sum;
    }

    public List<Item> getItems() {
        return items;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public boolean isVeryfied() {
        return isVeryfied;
    }

    public void setVeryfied(boolean veryfied) {
        isVeryfied = veryfied;
    }

    public boolean isSubmitted() {
        return isSubmitted;
    }

    public void setSubmitted(boolean submitted) {
        isSubmitted = submitted;
    }
}
