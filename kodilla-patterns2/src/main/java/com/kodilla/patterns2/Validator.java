package com.kodilla.patterns2;

public final class Validator {
    public static void notNull(Object o, String message){
        if (o == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notBlank(String s, String message){
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void min(int value, int minValue, String message){
        if (value < minValue) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void max(int value, int maxValue, String message){
        if (value > maxValue) {
            throw new IllegalArgumentException(message);
        }
    }


    private Validator(){
    }
}
