package com.kodilla.stream;

import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.person.People;
import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.beautifier.StringEncloser;
import java.util.List;
import java.util.Map;

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
    }

    private static void println(String string) {
        System.out.println(string);
    }
}
