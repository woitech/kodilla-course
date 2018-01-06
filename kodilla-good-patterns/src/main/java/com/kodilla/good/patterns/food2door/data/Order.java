package com.kodilla.good.patterns.food2door.data;

import java.time.LocalDate;

public final class Order {
    private LocalDate date;
    private final Company producer;
    private final Company recipient;
    private final String productName;
    private final String measure;
    private double quantity;
    private final double price;
    // derived
    private final double amount;

    public Order(final LocalDate  date, final Company producer, final Company recipient, final String productName,
                 final String measure, final double quantity, final double price) {
        validate(date, producer, recipient, productName, measure, quantity, price);

        this.date = date;
        this.producer = producer;
        this.recipient = recipient;
        this.productName = productName;
        this.measure = measure;
        this.quantity = quantity;
        this.price = price;
        this.amount = Math.round(price * quantity * 100) / 100;
    }

    private void validate(LocalDate  date, Company producer, Company recipient,
                          String productName, String measure, double quantity,
                          double price) {
        if (date == null) {
            throw new IllegalArgumentException("Date is null");
        }
        if (producer == null) {
            throw new IllegalArgumentException("Producer is null");
        }
        if (recipient == null) {
            throw new IllegalArgumentException("Recipient is null");
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

    public LocalDate getDate() { return date; }

    public Company getProducer() { return producer; }

    public Company getRecipient() { return recipient; }

    public String getProductName() {
        return productName;
    }

    public String getMeasure() {
        return measure;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getAmount() { return amount; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        if (Double.compare(order.quantity, quantity) != 0) return false;
        if (Double.compare(order.price, price) != 0) return false;
        if (Double.compare(order.amount, amount) != 0) return false;
        if (!date.equals(order.date)) return false;
        if (!producer.equals(order.producer)) return false;
        if (!recipient.equals(order.recipient)) return false;
        if (!productName.equals(order.productName)) return false;
        return measure.equals(order.measure);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = date.hashCode();
        result = 31 * result + producer.hashCode();
        result = 31 * result + recipient.hashCode();
        result = 31 * result + productName.hashCode();
        result = 31 * result + measure.hashCode();
        temp = Double.doubleToLongBits(quantity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "date=" + date +
                "producer=" + producer +
                ", recipient=" + recipient +
                ", productName='" + productName + '\'' +
                ", measure='" + measure + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
