package com.kodilla.patterns.builder.bigmac;

import java.util.*;

import static com.kodilla.patterns.builder.bigmac.Validator.*;

public final class Limits {
    private final Set<String> rolls;
    private final Set<String> sauces;
    private final Set<String> ingredients;
    private final int minBurgers;
    private final int maxBurgers;

    private Limits(Set<String> rolls, Set<String> sauces, Set<String> ingredients, int minBurgers, int maxBurgers) {
        this.rolls = new HashSet<>(rolls);
        this.sauces = new HashSet<>(sauces);
        this.ingredients = new HashSet<>(ingredients);
        this.minBurgers = minBurgers;
        this.maxBurgers = maxBurgers;
    }

    public static class LimitsBuilder {
        private Set<String> rolls;
        private Set<String> sauces;
        private Set<String> ingredients;
        private int minBurgers;
        private int maxBurgers;

        public LimitsBuilder rolls(Collection<String> rolls) {
            validateStateNull(this.rolls, "rolls set already exists");
            validateCollection(rolls, "null or empty rolls");

            this.rolls = new HashSet<>(rolls);

            return this;
        }

        public LimitsBuilder sauces(Collection<String> sauces) {
            validateStateNull(this.sauces, "sauces set already exists");
            validateCollection(rolls, "null or empty sauces");

            this.sauces = new HashSet<>(sauces);

            return this;
        }

        public LimitsBuilder ingredients(Collection<String> ingredients) {
            validateStateNull(this.ingredients, "ingredients set already exists");
            validateCollection(ingredients, "null or empty ingredients");

            this.ingredients = new HashSet<>(ingredients);

            return this;
        }

        public LimitsBuilder burgers(int min, int max) {
            validateTrue(min >= 0 && max >= min, "min < 0 or max < min");

            this.minBurgers = min;
            this.maxBurgers = max;

            return this;
        }

        public Limits build() {
            validateStateNotNull(rolls, "null rolls set");
            validateStateNotNull(sauces, "null sauces set");
            validateStateTrue(maxBurgers > 0, "maxBurgers is not set");
            validateStateNotNull(ingredients, "null ingredients set");

            return new Limits(rolls, sauces, ingredients, minBurgers, maxBurgers);
        }
    }

    public void validateRoll(String roll) {
        validateString(roll, "valueless roll");
        validateStateTrue(rolls.contains(roll), "There's no such roll: " + roll);
    }

    public void validateSauce(String sauce) {
        validateString(sauce, "valueless sauce");
        validateStateTrue(sauces.contains(sauce), "There's no such sauce: " + sauce);
    }

    public void validateIngredient(String ingredient) {
        validateString(ingredient, "valueless ingredient");
        validateStateTrue(ingredients.contains(ingredient), "There's no such ingredient: " + ingredient);
    }

    public void validateBurgers(int burgers) {
        validateStateTrue(burgers >= minBurgers && burgers <= maxBurgers,
                String.format("burgers number is out of range from %d to %d", minBurgers, maxBurgers));
    }

    public Set<String> getRolls() {
        return new HashSet<>(rolls);
    }

    public Set<String> getSauces() {
        return new HashSet<>(sauces);
    }

    public Set<String> getIngredients() {
        return new HashSet<>(ingredients);
    }

    public int getMinBurgers() {
        return minBurgers;
    }

    public int getMaxBurgers() {
        return maxBurgers;
    }

    @Override
    public String toString() {
        return "Limits{" +
                "rolls=" + rolls +
                ", sauces=" + sauces +
                ", ingredients=" + ingredients +
                ", minBurgers=" + minBurgers +
                ", maxBurgers=" + maxBurgers +
                '}';
    }
}
