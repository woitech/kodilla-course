package com.kodilla.patterns.strategy.social;

import static com.kodilla.patterns.Validator.*;

public class User {
    private final String name;
    private SocialPublisher publisher;

    public User(final String name, SocialPublisher publisher) {
        validateString(name, "valueless name");
        validateNotNull(publisher, "null publisher");

        this.name = name;
        this.publisher = publisher;
    }

    public String getName() {
        return name;
    }

    public void setPublisher(SocialPublisher publisher) {
        validateNotNull(publisher, "null publisher");
        this.publisher = publisher;
    }

    public String sharePost(String content) {
        return publisher.share(name, content);
    }
}
