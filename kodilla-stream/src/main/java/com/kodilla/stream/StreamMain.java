package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.beautifier.StringEncloser;

public class StreamMain {
    public static void main(String[] args) {
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