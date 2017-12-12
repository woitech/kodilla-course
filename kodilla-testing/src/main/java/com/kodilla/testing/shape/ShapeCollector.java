package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    private List<Shape> list = new ArrayList<>();

    public ShapeCollector() {
    }

    public void addFigure(Shape shape) {
        // do nothing
    }

    public boolean removeFigure(Shape shape) {
        // return true temporarily
        return true;
    }

    public Shape getFigure(int n) {
        // returning null means that the operation was unsuccessful
        return null;
    }

    // supplementary method
    public int getShapeQuantity(){
        // return 100 temporarily
        return 100;
    }

    public void showFigures() {
        for (Shape shape : list) {
            System.out.println(shape);
        }
    }
}
