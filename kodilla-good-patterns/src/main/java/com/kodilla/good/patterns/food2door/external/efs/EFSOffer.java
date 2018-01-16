package com.kodilla.good.patterns.food2door.external.efs;

// Let it be external library class and Food2Door developer can't change it.

public final class EFSOffer {
    private final String productName;
    private final String measure;
    private double quantity;
    private final double price;

    public EFSOffer(final String productName, final String measure, final double quantity, final double price) {
        validate(productName, measure, quantity, price);

        this.productName = productName;
        this.measure = measure;
        this.quantity = quantity;
        this.price = price;
    }

    private void validate(String productName, String measure, double quantity, double price) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
       EFSOffer that = (EFSOffer) o;
        if (Double.compare(that.quantity, quantity) != 0) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (!productName.equals(that.productName)) return false;
        return measure.equals(that.measure);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = productName.hashCode();
        result = 31 * result + measure.hashCode();
        temp = Double.doubleToLongBits(quantity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "EFSOffer{" +
                "productName='" +  productName + '\'' +
                ", measure='" + measure + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
