package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class SauceDecorator extends AbstractPizzaOrderDecorator {
    public enum Sauce {
        TOMATO("Tomato sauce", "2.00"),
        GARLIC("Garlic sauce", "3.00"),
        HERBAL("Herbal sauce", "6.00");

        String name;
        BigDecimal price;

        Sauce(String name, String cost) {
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

    private Sauce sauce;

    public SauceDecorator(PizzaOrder pizzaOrder, Sauce sauce) {
        super(pizzaOrder);
        this.sauce = sauce;
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(sauce.price());
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " & Extra " + sauce;
    }
}
