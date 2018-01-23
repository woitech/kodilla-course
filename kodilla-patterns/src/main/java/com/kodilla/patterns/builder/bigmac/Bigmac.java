package com.kodilla.patterns.builder.bigmac;

import java.util.*;

import static com.kodilla.patterns.builder.bigmac.Validator.*;

public final class Bigmac {
    private final String roll;
    private final String sauce;
    private final int burgers;
    private final Set<String> ingredients;

    private Bigmac(String roll, String sauce, int burgers, Set<String> ingredients) {
        this.roll = roll;
        this.sauce = sauce;
        this.burgers = burgers;
        this.ingredients = new HashSet<>(ingredients);
    }

    public static class BigmacBuilder {
        private final Limits limits;

        private String roll;
        private String sauce;
        private int burgers = -1;
        private Set<String> ingredients = new HashSet<>();

        public BigmacBuilder(Limits limits) {
            validateNotNull(limits, "null Limits");
            this.limits = limits;
        }

        public BigmacBuilder roll(String roll) {
            validateStateNull(this.roll, "roll is already set");
            limits.validateRoll(roll);
            this.roll = roll;

            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            validateStateNull(this.sauce, "sauce is already set");
            limits.validateSauce(sauce);
            this.sauce = sauce;

            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            validateStateTrue(this.burgers == -1, "burgers number is already set");
            limits.validateBurgers(burgers);

            this.burgers = burgers;

            return this;
        }

        public BigmacBuilder ingredient(String ingredient) {
            limits.validateIngredient(ingredient);
            this.ingredients.add(ingredient);

            return this;
        }

        public Bigmac build() {
            validateStateNotNull(roll, "missing roll");
            validateStateNotNull(sauce, "missing sauce");
            // ingredients set can be empty
            validateStateTrue(burgers > -1, "missing burgers number");

            return new Bigmac(roll, sauce, burgers, ingredients);
        }
    }

    public String getRoll() {
        return roll;
    }

    public String getSauce() {
        return sauce;
    }

    public int getBurgers() {
        return burgers;
    }

    public Set<String> getIngredients() {
        return new HashSet<>(ingredients);
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "roll='" + roll + '\'' +
                ", sauce='" + sauce + '\'' +
                ", burgers=" + burgers +
                ", ingredients=" + ingredients +
                '}';
    }
}
