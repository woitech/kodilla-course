package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ItalianPizzaOrder implements PizzaOrder {
    @Override
    public BigDecimal getCost() {
        return new BigDecimal(17.0);
    }

    @Override
    public String getDescription() {
        return "Pizza: Italian bottom & Olive and Herbs sauce & Mozzarella";
    }
}
