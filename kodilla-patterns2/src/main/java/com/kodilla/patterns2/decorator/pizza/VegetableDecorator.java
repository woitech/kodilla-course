package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class VegetableDecorator extends AbstractPizzaOrderDecorator {
    public enum Vegetable {
        OLIVE("Olive", "4.00"),
        ONION("Onion", "2.00"),
        PEPPERS("Peppers", "5.00"),
        MUSHROOM("Mushroom", "3.00");

        String name;
        BigDecimal price;

        Vegetable(String name, String cost) {
            this.name = name;
            this.price = new BigDecimal(cost);
        }

        @Override
        public String toString() {
            return name;
        }

        public BigDecimal price() {
            return price;
        }
    }

    private Vegetable vegetable;

    public VegetableDecorator(PizzaOrder pizzaOrder, Vegetable vegetable) {
        super(pizzaOrder);
        this.vegetable = vegetable;
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(vegetable.price());
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " & " + vegetable;
    }
}
