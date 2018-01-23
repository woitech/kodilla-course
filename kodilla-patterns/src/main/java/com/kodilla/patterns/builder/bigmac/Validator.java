package com.kodilla.patterns.builder.bigmac;

import java.util.Collection;

public final class Validator {
    private Validator(){
    }

    public static void validateString(String arg, String message){
        if (message == null) {
            message = "";
        }
        if (arg == null || arg.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static <E> void validateCollection(Collection<E> arg, String message){
        if (message == null) {
            message = "";
        }
        if (arg == null || arg.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static <T> void validateNotNull(T arg, String message){
        if (message == null) {
            message = "";
        }
        if (arg == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateTrue(boolean expr, String message){
        if (message == null) {
            message = "";
        }
        if (!expr) {
            throw new IllegalArgumentException(message);
        }
    }

    public static <T> void validateStateNull(T var, String message){
        if (message == null) {
            message = "";
        }
        if (var != null) {
            throw new IllegalStateException(message);
        }
    }

    public static <T> void validateStateNotNull(T var, String message){
        if (message == null) {
            message = "";
        }
        if (var == null) {
            throw new IllegalStateException(message);
        }
    }

    public static void validateStateTrue(boolean expr, String message){
        if (message == null) {
            message = "";
        }
        if (!expr) {
            throw new IllegalStateException(message);
        }
    }
}
