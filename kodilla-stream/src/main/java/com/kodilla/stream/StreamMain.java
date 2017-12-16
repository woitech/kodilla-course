package com.kodilla.stream;


import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.beautifier.StringEncloser;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        BookDirectory theBookDirectory = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));

        System.out.println(theResultStringOfBooks);

        // Zadanie: Upiększacz tekstów
        PoemBeautifier pb = new PoemBeautifier();
        String text =
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";

        println(pb.beautify(text, (string) -> "//" + string));
        println(pb.beautify(text, (string) -> string.toUpperCase()));
        println(pb.beautify(text, (string) -> string.replace(' ', '_')));
        println(pb.beautify(text, StringEncloser::parentheses));
        println(pb.beautify(text, StringEncloser::braces));
        println(pb.beautify(text, new StringEncloser("<*> ", " <*>")::enclose));
        // troche bez sensu, ale chcialem sprawdzic uzycie konstruktora
        println(pb.beautify(";-) "+ text, String::new));

        // Submodule 7.1
        System.out.println("Submodule 7.1");
        System.out.println("Wstęp do programowania funkcyjnego, ...");
        Processor processor = new Processor();

        // 1 sposob
        ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
        processor.execute(executeSaySomething);

        // 2 sposob
        processor.execute(new Executor() {
            @Override
            public void process() {
                System.out.println("This is an example text 2.");
            }
        });

        // 3 sposob
        processor.execute(() -> System.out.println("This is an example text 3."));

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        // Submodule 7.2 ////////////////////////////////////////////////////
        System.out.println("\nSubmodule 7.2\nCzym jest stream?");

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }

    private static void println(String string) {
        System.out.println(string);
    }
}
