package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.FacebookPublisher;

public class XGeneration extends User {
    public XGeneration(String name) {
        super(name, new FacebookPublisher());
    }
}
