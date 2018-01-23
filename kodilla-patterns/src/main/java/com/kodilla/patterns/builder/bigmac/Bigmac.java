package com.kodilla.patterns.builder.bigmac;

import java.util.*;

import static com.kodilla.patterns.builder.bigmac.Validator.*;

public final class Bigmac {
    private String roll;
    private String sauce;
    private int burgers = -1;
    private Set<String> ingredients = new HashSet<>();

    private Bigmac() {
    }

    public static class BigmacBuilder {
        private final Limits limits;
        private final Bigmac target;

        private boolean built;

        public BigmacBuilder(Limits limits) {
            validateNotNull(limits, "null Limits");
            this.limits = limits;
            target = new Bigmac();
        }

        private void checkBuilt() {
            if(built) {
                throw new IllegalStateException("bigmac has already got built");
            }
        }

        private void setBuilt() {
            built = true;
        }

        public BigmacBuilder roll(String roll) {
            checkBuilt();
            validateStateNull(target.roll, "roll is already set");
            limits.validateRoll(roll);
            target.roll = roll;

            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            checkBuilt();
            validateStateNull(target.sauce, "sauce is already set");
            limits.validateSauce(sauce);
            target.sauce = sauce;

            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            checkBuilt();
            validateStateTrue(target.burgers == -1, "burgers number is already set");
            limits.validateBurgers(burgers);

            target.burgers = burgers;

            return this;
        }

        public BigmacBuilder ingredient(String ingredient) {
            checkBuilt();
            limits.validateIngredient(ingredient);
            target.ingredients.add(ingredient);

            return this;
        }

        public Bigmac build() {
            checkBuilt();
            validateStateNotNull(target.roll, "missing roll");
            validateStateNotNull(target.sauce, "missing sauce");
            // ingredients set can be empty
            validateStateTrue(target.burgers > -1, "missing burgers number");

            setBuilt();

            return target;
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
