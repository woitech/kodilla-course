package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> theUserList = new ArrayList<>();

    public Forum() {
        theUserList.add(
                new ForumUser("Wojtek", 'M', LocalDate.parse("1965-09-11"), 123));
        theUserList.add(
                new ForumUser("Bartek", 'M', LocalDate.parse("2001-02-20"), 0));
        theUserList.add(
                new ForumUser("Arek", 'M', LocalDate.parse("1997-12-16"), 1));
        theUserList.add(
                new ForumUser("Magda", 'F', LocalDate.parse("1994-10-14"), 0));
        theUserList.add(
                new ForumUser("Kamil", 'M', LocalDate.parse("1991-03-14"), 43));
        theUserList.add(
                new ForumUser("Dominik", 'M', LocalDate.parse("1982-04-15"), 0));
        theUserList.add(
                new ForumUser("Damian", 'M', LocalDate.parse("2000-07-18"), 32));
        theUserList.add(
                new ForumUser("Patrycja", 'F', LocalDate.parse("2003-03-07"), 130));
        theUserList.add(
                new ForumUser("Ania", 'F', LocalDate.parse("1989-05-22"), 7));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(theUserList);
    }
}