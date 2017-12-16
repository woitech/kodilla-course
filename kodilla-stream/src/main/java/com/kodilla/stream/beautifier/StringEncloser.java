package com.kodilla.stream.beautifier;

public class StringEncloser {
    private final String leftSide;
    private final String rightSide;

    public StringEncloser(String leftSide, String rightSide) {
        this.leftSide = leftSide;
        this.rightSide = rightSide;
    }

    public String enclose(String text) {
        return enclose(text, leftSide, rightSide);
    }

    public static String parentheses(String text) {
        return enclose(text, "(", ")");
    }

    public static String braces(String text) {
        return enclose(text, "{", "}");
    }

    private static String enclose(String text, String leftSide, String rightSide) {
        return leftSide + text.trim() + rightSide;
    }

}
