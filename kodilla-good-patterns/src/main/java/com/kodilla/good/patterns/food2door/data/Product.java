package com.kodilla.good.patterns.food2door.data;

import static com.kodilla.good.patterns.food2door.Validator.*;

public final class Product {
    private final Company producer;
    private final String name;
    private final String measure;

    public Product(final Company producer, final String name, final String measure) {
        validateNotNull(producer, "null Producer");
        validateString(name, "valueless name");
        validateString(measure, "valueless measure");

        this.producer = producer;
        this.name = name;
        this.measure = measure;
    }

    public Company getProducer() {
        return producer;
    }

    public String getName() {
        return name;
    }

    public String getMeasure() {
        return measure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        if (!producer.equals(product.producer)) return false;
        if (!name.equals(product.name)) return false;
        return measure.equals(product.measure);
    }

    @Override
    public int hashCode() {
        int result = producer.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + measure.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "producer=" + producer +
                ", name='" + name + '\'' +
                ", measure='" + measure + '\'' +
                '}';
    }
}
