package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            System.out.println(
                    secondChallenge.probablyIWillThrowException(1.6, 1.6));
            System.out.println(
                    secondChallenge.probablyIWillThrowException(3.0, 1.6));
        } catch (Exception e) {
            System.out.println("Error occured: " + e);
        } finally {
            System.out.println("Whatever happened, thanks!");
        }
    }
}
