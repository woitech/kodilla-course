package com.kodilla.testing.shape;

public class Circle implements Shape {
    private static final String NAME = "circle";

    private final double radius;
    
    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("bad radius");
        }
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String getShapeName() {
        return NAME;
    }

    @Override
    public double getField() {
        return Math.PI * radius * radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(radius);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        return "Circle(radius=" + radius + ')';
    }
}
