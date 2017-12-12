package com.kodilla.testing.shape;

public class Square implements Shape {
    private static final String NAME = "square";

    private final double a;
    
    public Square(double a) {
        if (a <= 0) {
            throw new IllegalArgumentException("bad side's length");
        }
        this.a = a;
    }

    public double getA() {
        return a;
    }

    @Override
    public String getShapeName() {
        return NAME;
    }

    @Override
    public double getField() {
        return a * a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(square.a, a) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(a);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        return "Square(a=" + a + ')';
    }
}
