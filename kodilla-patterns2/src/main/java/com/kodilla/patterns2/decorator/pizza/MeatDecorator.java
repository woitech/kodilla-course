package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class MeatDecorator extends AbstractPizzaOrderDecorator {
    public enum Meat {
        CHICKEN("Chicken", "8.00"),
        BEEF("Beef", "14.00"),
        PRAWN("Prawn", "10.00");

        String name;
        BigDecimal price;

        Meat(String name, String cost) {
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

    private Meat meat;

    public MeatDecorator(PizzaOrder pizzaOrder, Meat meat) {
        super(pizzaOrder);
        this.meat = meat;
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(meat.price());
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " & " + meat;
    }
}
