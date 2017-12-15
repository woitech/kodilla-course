package com.kodilla.testing.forum.statistics;

import java.util.List;

public interface Statistics {
    // list of users names
    List<String> usersNames();
    // total quantity of forum posts
    int postsCount();
    // total quantity of forum comments
    int commentsCount();
}