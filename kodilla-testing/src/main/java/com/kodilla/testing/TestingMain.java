package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args){
        System.out.print("Testing of SimpleUser(String): ");
        SimpleUser simpleUser = new SimpleUser("theForumUser");
        String result = simpleUser.getUsername();
        if (result.equals("theForumUser")){
            passed();
        } else {
            failed();
        }

        // Calculator tests
        Calculator calc = new Calculator();

        System.out.print("Testing of calculator.add(int,int): ");
        final int e1 = Integer.MAX_VALUE-1;
        final int e2 = 1;
        final int sum = Integer.MAX_VALUE;
        if (calc.add(e1, e2) == sum) {
            passed();
        } else {
            failed();
        }

        System.out.print("Testing of calculator.substract(int,int): ");
        final int minuend = Integer.MIN_VALUE+1;
        final int subtrahend = 1;
        final int diff = Integer.MIN_VALUE;
        if (calc.subtract(minuend, subtrahend) == diff) {
            passed();
        } else {
            failed();
        }
    }

    private static void passed() {
        System.out.println("Test Ok");
    }

    private static void failed() { System.out.println("Error!"); }

}
