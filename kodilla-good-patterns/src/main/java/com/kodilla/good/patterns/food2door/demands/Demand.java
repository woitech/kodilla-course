package com.kodilla.good.patterns.food2door.demands;

public final class Demand {
    private final String productName;
    private final String measure;
    private final double quantity;

    public Demand(final String productName, final String measure, final double quantity) {
        validate(productName, measure, quantity);

        this.productName = productName;
        this.measure = measure;
        this.quantity = quantity;
    }

    private void validate(String productName, String measure, double quantity) {
        if (productName == null || productName.isEmpty()) {
            throw new IllegalArgumentException("valueless name");
        }
        if (measure == null || measure.isEmpty()) {
            throw new IllegalArgumentException("valueless measure");
        }
        if (quantity < 0.0) {
            throw new IllegalArgumentException("quantity < 0");
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Demand demand = (Demand) o;
        if (Double.compare(demand.quantity, quantity) != 0) return false;
        if (!productName.equals(demand.productName)) return false;
        return measure.equals(demand.measure);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = productName.hashCode();
        result = 31 * result + measure.hashCode();
        temp = Double.doubleToLongBits(quantity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Demand{" +
                "productName='" + productName + '\'' +
                ", measure='" + measure + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
