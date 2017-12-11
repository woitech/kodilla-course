package com.kodilla.testing.collection;

import org.junit.*;
import java.util.*;

import static org.junit.Assert.*;

public class CollectionTestSuite {
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
    }

    @After
    public void after() {
        report("Test unit END");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        // GIVEN
        OddNumbersExterminator exterm = new OddNumbersExterminator();
        ArrayList<Integer> emptyList = new ArrayList<>();

        //WHEN
        ArrayList<Integer> result = exterm.exterminate(emptyList);

        //THEN
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        //GIVEN
        OddNumbersExterminator exterm = new OddNumbersExterminator();
        ArrayList<Integer> averageList =
                new ArrayList<>(Arrays.asList(-1, 100, 3, 2, -5, -2, 7,
                        0, -9, 4, 11, -4, -13, 100));

        //WHEN
        ArrayList<Integer> result = exterm.exterminate(averageList);

        //THEN
        assertNotNull(result);
        ArrayList<Integer> expected =
                new ArrayList<>(Arrays.asList(100, 2, -2, 0, 4, -4, 100));
        assertEquals(expected, result);
    }

    @Test
    public void testOddNumbersExterminatorIllegalArgument() {
        //GIVEN
        OddNumbersExterminator exterm = new OddNumbersExterminator();
        ArrayList<Integer> invalidList = null;

        try {
            //WHEN
            exterm.exterminate(invalidList);
            //THEN
            fail();
        } catch (IllegalArgumentException exc) {
            //OK
        }
    }

    private static void report(String msg) {
        System.out.println(msg);
    }
}
