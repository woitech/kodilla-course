package com.kodilla.testing.forum.statistics;

import java.util.List;

public class StatisticsProcessor {
    // Ilość użytkowników
    private int usersQuantity;
    // Ilość postów
    private int postsQuantity;
    // Ilość komentarzy
    private int commentsQuantity;
    // Średnia ilość postów na użytkownika
    private double postsPerUser;
    // Średnia ilość komentarzy na użytkownika
    private double commentsPerUser;
    // Średnia ilość komentarzy na post
    private double commentsPerPost;

    public StatisticsProcessor() {
    }

    public int getUserQuantity() {
        return usersQuantity;
    }

    public int getPostQuantity() {
        return postsQuantity;
    }

    public int getCommentQuantity() {
        return commentsQuantity;
    }

    public double getPostsPerUser() {
        return postsPerUser;
    }

    public double getCommentsPerUser() {
        return commentsPerUser;
    }

    public double getCommentsPerPost() {
        return commentsPerPost;
    }

    // Calculated values are intended to round to 2 decimal places
    public void calculateAdvStatistics(Statistics statistics) {
        if (statistics == null) {
            throw new IllegalArgumentException("null Statistics");
        }
        List<String> userNames = statistics.usersNames();
        if (userNames == null) {
            throw new IllegalArgumentException("null users list");
        }
        usersQuantity = userNames.size();
        if ((postsQuantity = statistics.postsCount()) < 0) {
            throw new IllegalArgumentException("negative posts count");
        }
        if ((commentsQuantity = statistics.commentsCount()) < 0) {
            throw new IllegalArgumentException("negative comments count");
        }

        if (postsQuantity == 0) {
            if (commentsQuantity > 0) {
                throw new IllegalArgumentException("orphaned comments");
            }
            postsPerUser = commentsPerUser = commentsPerPost = 0.0;
            return;
        }
        if (usersQuantity == 0) {
            throw new IllegalArgumentException("orphaned posts");
        }

        double usersQuantityD = (double)usersQuantity;
        double postsQuantityD = (double)postsQuantity;
        double commentsQuantityD = (double)commentsQuantity;
        postsPerUser = postsQuantityD / usersQuantityD;
        commentsPerUser = commentsQuantityD / usersQuantityD;
        commentsPerPost = commentsQuantityD / postsQuantityD;
    }

    // Calculated values are rounded to 2 decimal places
    public void ShowStatistics() {
        throw new UnsupportedOperationException("not implemented yet");
    }
}