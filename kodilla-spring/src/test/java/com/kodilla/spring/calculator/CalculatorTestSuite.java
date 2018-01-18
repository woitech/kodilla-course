package com.kodilla.spring.calculator;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

public class CalculatorTestSuite {
    @Test
    public void testCalculations() {
        // Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        double d1 = 123.456;
        double d2 = 789.012;
        double expectedSumResult = 912.468;
        double expectedSubResult = -665.556;
        double expectedMulResult = 97_408.265_472;
        double expectedDivResult = 0.156_469_103_131_511_3;
        int delta = 16;

        // When
        double sumResult = calculator.add(d1, d2);
        double subResult = calculator.sub(d1, d2);
        double mulResult = calculator.mul(d1, d2);
        double divResult = calculator.div(d1, d2);

        // Then
        assertEquals(expectedSumResult, sumResult, delta);
        assertEquals(expectedSubResult, subResult, delta);
        assertEquals(expectedMulResult, mulResult, delta);
        assertEquals(expectedDivResult, divResult, delta);
    }
}
