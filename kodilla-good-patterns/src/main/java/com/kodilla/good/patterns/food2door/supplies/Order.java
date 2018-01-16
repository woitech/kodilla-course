package com.kodilla.good.patterns.food2door.supplies;

import com.kodilla.good.patterns.food2door.data.Product;
import java.time.LocalDateTime;

import static com.kodilla.good.patterns.food2door.Validator.*;

public final class Order {
    private final LocalDateTime date;
    private final Product product;
    private final double quantity;
    private final double price;
    // derived
    private final double amount;


    public Order(final LocalDateTime date, final Product product, final double quantity, final double price) {
        validateNotNull(date, "null LocalDateTime");
        validateNotNull(product, "null Product");
        validateTrue(Double.compare(quantity, 0) == 1, "quantity <= 0");
        validateTrue(Double.compare(price, 0) == 1, "price <= 0");

        this.date = date;
        this.product = product;
        this.quantity = quantity;
        this.price = price;

        this.amount = Math.round(price * quantity * 100) / 100;
    }

    public Order (final LocalDateTime date, final Offer offer, final double quantity) {
        this(date, offer.getProduct(), offer.getQuantity(), offer.getPrice());
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Product getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        if (Double.compare(order.quantity, quantity) != 0) return false;
        if (Double.compare(order.price, price) != 0) return false;
        if (!date.equals(order.date)) return false;
        return product.equals(order.product);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = date.hashCode();
        result = 31 * result + product.hashCode();
        temp = Double.doubleToLongBits(quantity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public String toFineString() {
        StringBuilder buff = new StringBuilder();
        buff.append("Order {").append('\n')
            .append('\t').append("date=").append(date).append('\n');
        Product p = getProduct();
        buff.append('\t').append("product {").append('\n')
            .append("\t\t").append("producer=").append(p.getProducer()).append('\n')
            .append("\t\t").append("name=").append(p.getName()).append('\n')
            .append("\t\t").append("measure=").append(p.getMeasure()).append('\n')
            .append("\t}").append('\n')
            .append('\t').append("quantity=").append(getQuantity()).append('\n')
            .append('\t').append("price=").append(getPrice()).append('\n')
            .append('\t').append("amount=").append(getAmount()).append('\n')
            .append('}');
        return buff.toString();
    }

    @Override
    public String toString() {
        return "Order{" +
                "date=" + date +
                ", product=" + product +
                ", quantity=" + quantity +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
