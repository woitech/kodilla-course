package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static com.kodilla.patterns2.decorator.pizza.VegetableDecorator.Vegetable.*;
import static com.kodilla.patterns2.decorator.pizza.CheeseDecorator.Cheese.*;
import static com.kodilla.patterns2.decorator.pizza.MeatDecorator.Meat.*;
import static com.kodilla.patterns2.decorator.pizza.SauceDecorator.Sauce.*;

import static org.junit.Assert.assertEquals;

public class PizzaOrderTestSuite {
    @Test
    public void testItalianPizzaOrderGetCost() {
        // Given
        PizzaOrder theOrder = new ItalianPizzaOrder();
        // When
        BigDecimal cost = theOrder.getCost();
        //Then
        assertEquals(0, cost.compareTo(new BigDecimal(17)));
    }

    @Test
    public void testItalianPizzaOrderGetDescription() {
        // Given
        PizzaOrder theOrder = new ItalianPizzaOrder();
        // When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Pizza: Italian bottom & Olive and Herbs sauce & Mozzarella", description);
    }

    @Test
    public void testAmericanPizzaOrderGetCost() {
        // Given
        PizzaOrder theOrder = new AmericanPizzaOrder();
        // When
        BigDecimal cost = theOrder.getCost();
        //Then
        assertEquals(0, cost.compareTo(new BigDecimal(15)));
    }

    @Test
    public void testAmericanPizzaOrderGetDescription() {
        // Given
        PizzaOrder theOrder = new AmericanPizzaOrder();
        // When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Pizza: American bottom & Tomato sauce & Cheese", description);
    }

    @Test
    public void testItalianPizzaWithVegsMeatExtraCheeseAndSauceGetCost() {
        // Given
        PizzaOrder theOrder = new ItalianPizzaOrder();
        theOrder = new VegetableDecorator(theOrder, PEPPERS);
        theOrder = new VegetableDecorator(theOrder, OLIVE);
        theOrder = new MeatDecorator(theOrder, PRAWN);
        theOrder = new CheeseDecorator(theOrder, PARMIGIANO_REGGIANO);
        theOrder = new SauceDecorator(theOrder, GARLIC);
        // When
        BigDecimal cost = theOrder.getCost();
        //Then
        assertEquals(0, cost.compareTo(new BigDecimal(49)));
    }

    @Test
    public void testItalianPizzaWithVegsMeatExtraCheeseAndSauceGetDescription() {
        // Given
        PizzaOrder theOrder = new ItalianPizzaOrder();
        theOrder = new VegetableDecorator(theOrder, PEPPERS);
        theOrder = new VegetableDecorator(theOrder, OLIVE);
        theOrder = new MeatDecorator(theOrder, PRAWN);
        theOrder = new CheeseDecorator(theOrder, PARMIGIANO_REGGIANO);
        theOrder = new SauceDecorator(theOrder, GARLIC);
        // When
        String description = theOrder.getDescription();
        //Then
        String expectedDesc = "Pizza: Italian bottom & Olive and Herbs sauce & Mozzarella & Peppers & Olive & Prawn" +
                              " & Extra cheese Parmigiano-Reggiano & Extra Garlic sauce";
        assertEquals(expectedDesc, description);
    }

    @Test
    public void testAmericanPizzaWithVegsMeatExtraCheeseAndSauceGetCost() {
        // Given
        PizzaOrder theOrder = new AmericanPizzaOrder();
        theOrder = new VegetableDecorator(theOrder, MUSHROOM);
        theOrder = new MeatDecorator(theOrder, CHICKEN);
        theOrder = new CheeseDecorator(theOrder, GOUDA);
        theOrder = new CheeseDecorator(theOrder, GOUDA);
        theOrder = new SauceDecorator(theOrder, TOMATO);
        // When
        BigDecimal cost = theOrder.getCost();
        //Then
        assertEquals(0, cost.compareTo(new BigDecimal(40)));
    }

    @Test
    public void testAmericanPizzaWithVegsMeatExtraCheeseAndSauceGetDescription() {
        // Given
        PizzaOrder theOrder = new AmericanPizzaOrder();
        theOrder = new VegetableDecorator(theOrder, MUSHROOM);
        theOrder = new MeatDecorator(theOrder, CHICKEN);
        theOrder = new CheeseDecorator(theOrder, GOUDA);
        theOrder = new CheeseDecorator(theOrder, GOUDA);
        theOrder = new SauceDecorator(theOrder, TOMATO);
        // When
        String description = theOrder.getDescription();
        //Then
        String expectedDesc = "Pizza: American bottom & Tomato sauce & Cheese & Mushroom & Chicken" +
                              " & Extra cheese Gouda & Extra cheese Gouda & Extra Tomato sauce";
        assertEquals(expectedDesc, description);
    }
}
