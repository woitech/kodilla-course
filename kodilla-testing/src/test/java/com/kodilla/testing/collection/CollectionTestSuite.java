package com.kodilla.testing.collection;

import org.junit.*;
import java.util.*;

import static org.junit.Assert.*;

public class CollectionTestSuite {
    private OddNumbersExterminator exterm;

    @BeforeClass
    public static void beforeClass() {
        report("CollectionTestSuite BEGIN");
    }

    @AfterClass
    public static void afterClass() {
        report("CollectionTestSuite END");
    }

    @Before
    public void before() {
        report("Test unit BEGIN");
        exterm = new OddNumbersExterminator();
    }

    @After
    public void after() {
        report("Test unit END");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        ArrayList<Integer> result = exterm.exterminate(new ArrayList<>());
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        ArrayList<Integer> expected =
            new ArrayList<>(Arrays.asList(100, 2, -2, 0, 4, -4, 100));
        ArrayList<Integer> inputData =
            new ArrayList<>(Arrays.asList(-1, 100, 3, 2, -5, -2, 7,
                                           0, -9, 4, 11, -4, -13, 100));
        ArrayList<Integer> result = exterm.exterminate(inputData);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    private static void report(String msg) {
        System.out.println(msg);
    }
}
