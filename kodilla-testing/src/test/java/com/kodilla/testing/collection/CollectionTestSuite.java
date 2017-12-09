package com.kodilla.testing.collection;

import org.junit.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        reportCase("Empty ArrayList as an argument");
        ArrayList<Integer> result = exterm.exterminate(new ArrayList<>());
        Assert.assertNotNull(result);
        if (result != null) {
            Assert.assertTrue(result.isEmpty());
        }
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        reportCase("ArrayList with odds and evens as an argument");
        int evensSize = 100;
        List<Integer> evens = new ArrayList<>();
        Random rand = new Random();
        while (evens.size() < evensSize+1) {
            //random evens
            evens.add(rand.nextInt()&-2);
            // repeated 0, -2 and 2
            evens.add(rand.nextInt(3)&-2);
            evens.add(-(rand.nextInt(3)&-2));
        }

        ArrayList<Integer> normal = new ArrayList<>();
        for(int n : evens) {
            normal.add(n);
            normal.add(n + 1);
        }

        ArrayList<Integer> result = exterm.exterminate(normal);
        Assert.assertArrayEquals(evens.toArray(),result.toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOddNumbersExterminatorIllegalArgument() {
        reportCase("Illegal argument");
        exterm.exterminate(null);
    }

    private static void report(String msg) {
        System.out.println(msg);
    }

    private static void reportCase(String title) {
        System.out.printf("Case: %s\n", title);
    }
}
