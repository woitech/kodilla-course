package com.kodilla.testing.shape;

import org.junit.*;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

        //WHEN
        sc.addFigure(triangle);

        //THEN
        assertEquals(1, sc.getShapeQuantity());
    }

    @Test
    public void testAddFigureBadArgument() {
        //GIVEN
        ShapeCollector sc = new ShapeCollector();
        Shape nullShape = null;
        try {
            //WHEN
            sc.addFigure(nullShape);
            //THEN
            fail();
        } catch (IllegalArgumentException exc) {
            //OK
        }
    }

    @Test
    public void testRemoveFigure() {
        //GIVEN
        ShapeCollector sc = new ShapeCollector();
        Triangle triangle = new Triangle(5.6, 7.8, 9);
        sc.addFigure(triangle);

        //WHEN
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

        //WHEN
        boolean result = sc.removeFigure(triangle);

        //THEN
        assertFalse(result);
    }

    @Test
    public void testRemoveFigureBadArgument() {
        //GIVEN
        ShapeCollector sc = new ShapeCollector();
        Shape nullShape = null;
        try {
            //WHEN
            sc.removeFigure(nullShape);
            //THEN
            fail();
        } catch (IllegalArgumentException exc) {
            //OK
        }
    }

    @Test
    public void testGetFigure() {
        //GIVEN
        ShapeCollector sc = new ShapeCollector();
        Triangle triangle = new Triangle(5.6, 7.8, 9);
        sc.addFigure(triangle);

        //WHEN
        Shape retrievedShape = sc.getFigure(0);

        //THEN
        assertEquals(triangle, retrievedShape);
    }

    @Test
    public void testGetFigureNotExisting() {
        //GIVEN
        ShapeCollector sc = new ShapeCollector();

        //WHEN
        Shape retrievedShape = sc.getFigure(0);

        //THEN
        assertNull(retrievedShape);
    }

    @Test
    public void testGetFigureBadArgument() {
        //GIVEN
        ShapeCollector sc = new ShapeCollector();
        int badIndex = -1;
        try {
            //WHEN
            sc.getFigure(badIndex);
            //THEN
            fail();
        } catch (IllegalArgumentException exc) {
            //OK
        }
    }

    @Test
    public void testShowFiguresShapeToStringResultIsASCII() {
        //GIVEN
        ShapeCollector sc = new ShapeCollector();
        // Possible examples of ASCII shape.toString() results
        String asciiShapeOneToString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ(a=1.2)";
        String asciiNameShapeTwoToString = "abcdefghijklm(a=1.2, b=3.4)";
        String asciiNameShapeThreeToString = "nopqrstuvwxyz(a=1.2, b=3.4, c=5.6)";
        Shape shapeOne = mock(Shape.class);
        Shape shapeTwo = mock(Shape.class);
        Shape shapeThree = mock(Shape.class);
        String expectedString
                = String.format("%s\n%s\n%s\n", asciiShapeOneToString, asciiNameShapeTwoToString, asciiNameShapeThreeToString);
        when(shapeOne.toString()).thenReturn(asciiShapeOneToString);
        when(shapeTwo.toString()).thenReturn(asciiNameShapeTwoToString);
        when(shapeThree.toString()).thenReturn(asciiNameShapeThreeToString);
        sc.addFigure(shapeOne);
        sc.addFigure(shapeTwo);
        sc.addFigure(shapeThree);
        ByteArrayOutputStream printBuffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(printBuffer);

        //WHEN
        sc.showFigures(out);
        String printedString = printBuffer.toString();

        //THEN
        assertEquals(expectedString, printedString);
    }
}
