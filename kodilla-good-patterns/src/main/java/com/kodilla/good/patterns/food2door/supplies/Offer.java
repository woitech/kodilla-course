package com.kodilla.good.patterns.food2door.supplies;

import com.kodilla.good.patterns.food2door.data.Product;

import static com.kodilla.good.patterns.food2door.Validator.*;

public final class Offer {
    private final Product product;
    private final double quantity;
    private final double price;

    public Offer(final Product product, final double quantity, final double price) {
        validateNotNull(product, "null Product");
        validateTrue(Double.compare(quantity, 0) == 1, "quantity <= 0");
        validateTrue(Double.compare(price, 0) == 1, "price <= 0");

        this.product = product;
        this.quantity = quantity;
        this.price = price;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        if (Double.compare(offer.quantity, quantity) != 0) return false;
        if (Double.compare(offer.price, price) != 0) return false;
        return product.equals(offer.product);
    }

    public String toFineString() {
        StringBuilder buff = new StringBuilder();
        buff.append("Offer {").append('\n');
        Product p = getProduct();
        buff.append('\t').append("product {").append('\n')
            .append("\t\t").append("producer=").append(p.getProducer()).append('\n')
            .append("\t\t").append("name=").append(p.getName()).append('\n')
            .append("\t\t").append("measure=").append(p.getMeasure()).append('\n')
            .append("\t}").append('\n')
            .append('\t').append("quantity=").append(getQuantity()).append('\n')
            .append('\t').append("price=").append(getPrice()).append('\n')
            .append('}');
        return buff.toString();
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = product.hashCode();
        temp = Double.doubleToLongBits(quantity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "product=" + product +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
