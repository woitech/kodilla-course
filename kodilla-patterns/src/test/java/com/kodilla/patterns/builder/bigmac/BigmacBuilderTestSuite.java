package com.kodilla.patterns.builder.bigmac;

import org.junit.*;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class BigmacBuilderTestSuite {
    private static Limits limits;

    @BeforeClass
    public static void buildLimits() {
        limits = new Limits.LimitsBuilder()
                .rolls(Arrays.asList("basic", "sesame"))
                .sauces(Arrays.asList("standard", "thousand islands", "barbecue"))
                .burgers(1,3)
                .ingredients(Arrays.asList("lettuce", "onion", "bacon", "cucumber",
                        "chilli", "mushrooms", "prawns", "cheese"))
                .build();
    }

    @Test
    public void testBuildWithIngredients() {
        // Given
        System.out.println(limits);

        // When
        Bigmac bigmac = new Bigmac.BigmacBuilder(limits)
                .roll("sesame")
                .sauce("thousand islands")
                .burgers(2)
                .ingredient("onion")
                .ingredient("bacon")
                .ingredient("cheese")
                .build();
        System.out.println(bigmac);

        // Then
        assertEquals("sesame", bigmac.getRoll());
        assertEquals("thousand islands", bigmac.getSauce());
        assertEquals(2, bigmac.getBurgers());
        assertEquals(new HashSet<>(Arrays.asList("onion", "bacon", "cheese")), bigmac.getIngredients());
    }

    @Test
    public void testBuildWithoutIngredients() {
        // Given
        // When
        Bigmac bigmac = new Bigmac.BigmacBuilder(limits)
                .roll("sesame")
                .sauce("thousand islands")
                .burgers(1)
                .build();

        // Then
        assertEquals("sesame", bigmac.getRoll());
        assertEquals("thousand islands", bigmac.getSauce());
        assertEquals(1, bigmac.getBurgers());
        assertEquals(Collections.emptySet(), bigmac.getIngredients());
    }

    @Test
    public void testRollBeyondLimits() {
        // Given
        Bigmac.BigmacBuilder builder = new Bigmac.BigmacBuilder(limits);
        try {
        // When
            builder.roll("sunflower");
        // Then
            fail("missing IllegalStateException");
        } catch(IllegalStateException e) {
            assertEquals("There's no such roll: sunflower", e.getMessage());
        }
    }

    @Test
    public void testSauceBeyondLimits() {
        // Given
        Bigmac.BigmacBuilder builder = new Bigmac.BigmacBuilder(limits);
        try {
        // When
            builder.sauce("mayonnaise");
        // Then
            fail("missing IllegalStateException");
        } catch(IllegalStateException e) {
            assertEquals("There's no such sauce: mayonnaise", e.getMessage());
        }
    }

    @Test
    public void testIngredientBeyondLimits() {
        // Given
        Bigmac.BigmacBuilder builder = new Bigmac.BigmacBuilder(limits);
        try {
        // When
            builder.ingredient("tomato");
        // Then
            fail("missing IllegalStateException");
        } catch(IllegalStateException e) {
            assertEquals("There's no such ingredient: tomato", e.getMessage());
        }
    }

    @Test
    public void testBurgersBeyondLimits() {
        // Given
        Bigmac.BigmacBuilder builder = new Bigmac.BigmacBuilder(limits);
        try {
        // When
            builder.burgers(0);
        // Then
            fail("missing IllegalStateException");
        } catch(IllegalStateException e) {
            assertEquals("burgers number is out of range from 1 to 3", e.getMessage());
        }
    }

    @Test
    public void testRollRepeatedCall() {
        // Given
        Bigmac.BigmacBuilder builder = new Bigmac.BigmacBuilder(limits);
        builder.roll("basic");
        try {
            // When
            builder.roll("sesame");
            // Then
            fail("missing IllegalStateException");
        } catch(IllegalStateException e) {
            assertEquals("roll is already set", e.getMessage());
        }
    }

    @Test
    public void testSauceRepeatedCall() {
        // Given
        Bigmac.BigmacBuilder builder = new Bigmac.BigmacBuilder(limits);
        builder.sauce("standard");
        try {
            // When
            builder.sauce("barbeque");
            // Then
            fail("missing IllegalStateException");
        } catch(IllegalStateException e) {
            assertEquals("sauce is already set", e.getMessage());
        }
    }

    @Test
    public void testBurgersRepeatedCall() {
        // Given
        Bigmac.BigmacBuilder builder = new Bigmac.BigmacBuilder(limits);
        builder.burgers(3);
        try {
            // When
            builder.burgers(1);
            // Then
            fail("missing IllegalStateException");
        } catch(IllegalStateException e) {
            assertEquals("burgers number is already set", e.getMessage());
        }
    }

    @Test
    public void testBuildMissingRoll() {
        // Given
        Bigmac.BigmacBuilder builder = new Bigmac.BigmacBuilder(limits);
        builder.sauce("thousand islands").burgers(1);
        try {
            // When
            builder.build();
            // Then
            fail("missing IllegalStateException");
        } catch(IllegalStateException e) {
            assertEquals("missing roll", e.getMessage());
        }
    }

    @Test
    public void testBuildMissingSauce() {
        // Given
        Bigmac.BigmacBuilder builder = new Bigmac.BigmacBuilder(limits);
        builder.roll("sesame").burgers(1);
        try {
            // When
            builder.build();
            // Then
            fail("missing IllegalStateException");
        } catch(IllegalStateException e) {
            assertEquals("missing sauce", e.getMessage());
        }
    }

    @Test
    public void testBuildMissingBurgers() {
        // Given
        Bigmac.BigmacBuilder builder = new Bigmac.BigmacBuilder(limits);
        builder.roll("sesame").sauce("thousand islands");
        try {
            // When
            builder.build();
            // Then
            fail("missing IllegalStateException");
        } catch(IllegalStateException e) {
            assertEquals("missing burgers number", e.getMessage());
        }
    }

    @Test
    public void testRollAfterBuild() {
        // Given
        Bigmac.BigmacBuilder builder = new Bigmac.BigmacBuilder(limits);
        builder.roll("sesame").sauce("thousand islands").burgers(1).build();
        try {
            // When
            builder.roll("basic");
            // Then
            fail("missing IllegalStateException");
        } catch(IllegalStateException e) {
            assertEquals("bigmac has already got built", e.getMessage());
        }
    }

    @Test
    public void testSauceAfterBuild() {
        // Given
        Bigmac.BigmacBuilder builder = new Bigmac.BigmacBuilder(limits);
        builder.roll("sesame").sauce("thousand islands").burgers(1).build();
        try {
            // When
            builder.sauce("barbeque");
            // Then
            fail("missing IllegalStateException");
        } catch(IllegalStateException e) {
            assertEquals("bigmac has already got built", e.getMessage());
        }
    }

    @Test
    public void testIngredientAfterBuild() {
        // Given
        Bigmac.BigmacBuilder builder = new Bigmac.BigmacBuilder(limits);
        builder.roll("sesame").sauce("thousand islands").burgers(1).build();
        try {
            // When
            builder.ingredient("onion");
            // Then
            fail("missing IllegalStateException");
        } catch(IllegalStateException e) {
            assertEquals("bigmac has already got built", e.getMessage());
        }
    }

    @Test
    public void testBuildAfterBuild() {
        // Given
        Bigmac.BigmacBuilder builder = new Bigmac.BigmacBuilder(limits);
        builder.roll("sesame").sauce("thousand islands").burgers(1).build();
        try {
            // When
            builder.build();
            // Then
            fail("missing IllegalStateException");
        } catch(IllegalStateException e) {
            assertEquals("bigmac has already got built", e.getMessage());
        }
    }

}
