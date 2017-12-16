package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private static int counter = 0;

    private final int id;
    private final String name;
    private final char gender;
    private final LocalDate birthDate;
    private final int postCount;

    public ForumUser(final String name, final char gender,
                     final LocalDate birthDate, final int postCount) {
        if (name == null || name.isEmpty() || (gender != 'M' && gender != 'F')
            || birthDate == null || postCount < 0)
            throw new IllegalArgumentException("bad argument(s)");

        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.postCount = postCount;

        this.id = ++counter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostCount() {
        return postCount;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", postCount=" + postCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForumUser forumUser = (ForumUser) o;
        if (id != forumUser.id) return false;
        if (gender != forumUser.gender) return false;
        if (postCount != forumUser.postCount) return false;
        if (!name.equals(forumUser.name)) return false;
        return birthDate.equals(forumUser.birthDate);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + (int) gender;
        result = 31 * result + birthDate.hashCode();
        result = 31 * result + postCount;
        return result;
    }
}
