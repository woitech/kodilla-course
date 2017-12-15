package com.kodilla.testing.shape;

import java.util.*;

public class Triangle implements Shape {
    private static final String NAME = "triangle";

    // sides should be sorted (a <= b <= c), its very important
    // for calculation of equality
    private final double a;
    private final double b;
    private final double c;
    
    public Triangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Some sides are 0 or negative");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
             throw new IllegalArgumentException(
                "Given values are not triangle sides");
        }
        double[] sides = {a, b, c};
        Arrays.sort(sides);
        this.a = sides[0];
        this.b = sides[1];
        this.c = sides[2];
    }

    @Override
    public String getShapeName() {
        return NAME;
    }

    @Override
    public double getField() {
        // Heron's formula
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        if (Double.compare(triangle.a, a) != 0) return false;
        if (Double.compare(triangle.b, b) != 0) return false;
        return Double.compare(triangle.c, c) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(a);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(b);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(c);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Triangle(" + "a=" + a + ", b=" + b + ", c=" + c + ')';
    }
}
