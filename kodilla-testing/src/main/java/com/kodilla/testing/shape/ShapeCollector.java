package com.kodilla.testing.shape;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    private List<Shape> list = new ArrayList<>();

    public ShapeCollector() {
    }

    public void addFigure(Shape shape) {
        if (shape == null) {
            throw new IllegalArgumentException("null Shape");
        }
        list.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        // ShapeCollector is not intended for collecting null values
        if (shape == null) {
            throw new IllegalArgumentException("null Shape");
        }
        return list.remove(shape);
    }

    public Shape getFigure(int n) {
        // negative index has no sense in this case
        if (n < 0) {
            throw new IllegalArgumentException("negative index");
        }
        if (n >= list.size()) {
            return null;
        }
        return list.get(n);
    }

    // supplementary method
    public int getShapeQuantity(){
        return list.size();
    }

    // prints shapes' toString() results ended with '\n' char
    // into given PrintStream
    public void showFigures(PrintStream out) {
        for (Shape shape : list) {
            out.printf(shape.toString() + '\n');
        }
    }
}
