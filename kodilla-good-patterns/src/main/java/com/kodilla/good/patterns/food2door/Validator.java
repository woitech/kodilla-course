package com.kodilla.good.patterns.food2door;

public final class Validator {
    private Validator(){
    }

    public static void validateString(String arg, String message){
        if (arg == null || arg.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static <T> void validateNotNull(T arg, String message){
        if (arg == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateTrue(boolean expr, String message){
        if (!expr) {
            throw new IllegalArgumentException(message);
        }
    }
}
