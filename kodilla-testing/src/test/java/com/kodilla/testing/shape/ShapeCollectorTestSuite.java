package com.kodilla.testing.shape;

import org.junit.*;

import static org.junit.Assert.*;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testAddFigure() {
        //GIVEN
        ShapeCollector sc = new ShapeCollector();
        Triangle triangle = new Triangle(5.6, 7.8, 9);

        //WEHEN
        sc.addFigure(triangle);

        //THEN
        assertEquals(1, sc.getShapeQuantity());
    }

    @Test
    public void testRemoveFigure() {
        //GIVEN
        ShapeCollector sc = new ShapeCollector();
        Triangle triangle = new Triangle(5.6, 7.8, 9);
        sc.addFigure(triangle);

        //WEHEN
        boolean result = sc.removeFigure(triangle);

        //THEN
        assertTrue(result);
        assertEquals(0, sc.getShapeQuantity());
    }

    @Test
    public void testRemoveFigureNotExisting() {
        //GIVEN
        ShapeCollector sc = new ShapeCollector();
        Triangle triangle = new Triangle(5.6, 7.8, 9);

        //WEHEN
        boolean result = sc.removeFigure(triangle);

        //THEN
        assertFalse(result);
    }

    @Test
    public void testGetFigure() {
        //GIVEN
        ShapeCollector sc = new ShapeCollector();
        Triangle triangle = new Triangle(5.6, 7.8, 9);
        sc.addFigure(triangle);

        //WEHEN
        Shape retrievedShape = sc.getFigure(0);

        //THEN
        assertEquals(triangle, retrievedShape);
    }

    @Test
    public void testGetFigureNotExisting() {
        //GIVEN
        ShapeCollector sc = new ShapeCollector();
        Triangle triangle = new Triangle(5.6, 7.8, 9);

        //WEHEN
        Shape retrievedShape = sc.getFigure(0);

        //THEN
        assertNull(retrievedShape);
    }

}
