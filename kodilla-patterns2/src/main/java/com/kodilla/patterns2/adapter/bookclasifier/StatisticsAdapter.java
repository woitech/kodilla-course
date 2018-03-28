package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;

import java.util.*;
import java.util.stream.Collectors;

public class StatisticsAdapter extends StatisticsAdaptee implements Classifier {
    @Override
    public int publicationYearMedian(Set<Book> booksOfTypeA) {
       if (booksOfTypeA == null || booksOfTypeA.isEmpty()) {
           throw new IllegalArgumentException("The set is null or empty");
       }
       return medianPublicationYear(booksOfTypeA.stream()
                  .collect(Collectors.toMap(StatisticsAdapter::toSignature, StatisticsAdapter::bookAtoB)));
    }

    private static com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book bookAtoB(Book bookOfTypeA) {
        return new com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book(
                bookOfTypeA.getAuthor(), bookOfTypeA.getTitle(), bookOfTypeA.getPublicationYear());
    }

    private static BookSignature toSignature(Book bookOfTypeA) {
        return new BookSignature(bookOfTypeA.getSignature());
    }
}
