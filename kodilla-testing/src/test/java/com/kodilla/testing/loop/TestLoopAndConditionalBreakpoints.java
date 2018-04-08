package com.kodilla.testing.loop;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLoopAndConditionalBreakpoints {
    @Test
    public void testLoop() {
        // Given
        long sum = 0L;
        // When
        for (int n = 0; n < 1000; n++) {
            sum += n;
            System.out.printf("[%d] Sum equals: %d\n", n, sum);
        }
        // Then
        assertEquals(499500, sum);
    }

    @Test
    public void testSteps() {
        top();
    }

    private void top() {
        m1();
        m2();
        m3();
    }

    private void m1() {
        m11();
        m12();
        m13();
    }

    private void m2() {
        m21();
        m22();
        m23();
    }

    private void m3() {
        m31();
        m32();
        m33();
    }

    private void m11() {
        System.out.println("m11 line1");
        System.out.println("m11 line2");
        System.out.println("m11 line3");
    }

    private void m12() {
        System.out.println("m12 line1");
        System.out.println("m12 line2");
        System.out.println("m12 line3");
    }

    private void m13() {
        System.out.println("m13 line1");
        System.out.println("m13 line2");
        System.out.println("m13 line3");
    }

    private void m21() {
        System.out.println("m21 line1");
        System.out.println("m21 line2");
        System.out.println("m21 line3");
    }

    private void m22() {
        System.out.println("m22 line1");
        System.out.println("m22 line2");
        System.out.println("m22 line3");
    }

    private void m23() {
        System.out.println("m23 line1");
        System.out.println("m23 line2");
        System.out.println("m23 line3");
    }

    private void m31() {
        System.out.println("m31 line1");
        System.out.println("m31 line2");
        System.out.println("m31 line3");
    }

    private void m32() {
        System.out.println("m32 line1");
        System.out.println("m32 line2");
        System.out.println("m32 line3");
    }

    private void m33() {
        System.out.println("m33 line1");
        System.out.println("m33 line2");
        System.out.println("m33 line3");
    }
}
