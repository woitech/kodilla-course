package com.kodilla.patterns2.decorator.taxiportal;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TaxiOrderTestSuite {
    @Test
    public void testBasicTaxiOrderGetCost() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        // Then
        assertEquals(0, calculatedCost.compareTo(new BigDecimal(5.0)));
    }

    @Test
    public void testBasicTaxiOrderGetDescription() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        // When
        String description = theOrder.getDescription();
        // Then
        assertEquals("Drive a course", description);
    }

    @Test
    public void testTaxiNetworkGetCost() {
        // Given
        TaxiOrder theOrder = new TaxiNetworkOrderDecorator(new BasicTaxiOrder());
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        // Then
        assertEquals(0, calculatedCost.compareTo(new BigDecimal(40.0)));
    }

    @Test
    public void testTaxiNetworkGetDescription() {
        // Given
        TaxiOrder theOrder = new TaxiNetworkOrderDecorator(new BasicTaxiOrder());
        // When
        String description = theOrder.getDescription();
        // Then
        assertEquals("Drive a course by Taxi Network", description);
    }

    @Test
    public void testUberNetworkGetCost() {
        // Given
        TaxiOrder theOrder = new UberNetworkOrderDecorator(new BasicTaxiOrder());
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        // Then
        assertEquals(0, calculatedCost.compareTo(new BigDecimal(25.0)));
    }

    @Test
    public void testUberNetworkGetDescription() {
        // Given
        TaxiOrder theOrder = new UberNetworkOrderDecorator(new BasicTaxiOrder());
        // When
        String description = theOrder.getDescription();
        // Then
        assertEquals("Drive a course by Uber Network", description);
    }

    @Test
    public void testMyTaxiWithChildSeatGetCost() {
        // Given
        TaxiOrder theOrder = new ChildSeatDecorator(new MyTaxiNetworkOrderDecorator(new BasicTaxiOrder()));
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        // Then
        assertEquals(0, calculatedCost.compareTo(new BigDecimal(37.0)));
    }

    @Test
    public void testMyTaxiWithChildSeatGetDescription() {
        // Given
        TaxiOrder theOrder = new ChildSeatDecorator(new MyTaxiNetworkOrderDecorator(new BasicTaxiOrder()));
        // When
        String description = theOrder.getDescription();
        // Then
        assertEquals("Drive a course by MyTaxi Network + child seat", description);
    }

    @Test
    public void testUberWithTwoChildSeatsGetCost() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new UberNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        // Then
        assertEquals(0, calculatedCost.compareTo(new BigDecimal(29.0)));
    }

    @Test
    public void testUberWithTwoChildSeatsGetDescription() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new UberNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        // When
        String description = theOrder.getDescription();
        // Then
        assertEquals("Drive a course by Uber Network + child seat + child seat", description);
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetCost() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        theOrder = new VipCarDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new ExpressDecorator(theOrder);
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        // Then
        assertEquals(0, calculatedCost.compareTo(new BigDecimal(57.0)));
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetDescription() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        theOrder = new VipCarDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new ExpressDecorator(theOrder);
        // When
        String description = theOrder.getDescription();
        // Then
        assertEquals("Drive a course by Taxi Network variant VIP + child seat express service", description);
    }
}
