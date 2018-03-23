package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class AmericanPizzaOrder implements PizzaOrder {
    @Override
    public BigDecimal getCost() {
        return new BigDecimal(15.0);
    }

    @Override
    public String getDescription() {
        return "Pizza: American bottom & Tomato sauce & Cheese";
    }
}
