package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        // Given
        User john = new XGeneration("JohnS");
        User milena = new Millenials("milenka");
        User paula = new ZGeneration("polinka");

        // When
        String johnsPost = john.sharePost("Hello everybody, our dear customers!");
        String milenasPost = milena.sharePost("Hello everybody");
        String paulasPost = paula.sharePost(":-)");

        // Then
        assertEquals("[FACEBOOK] JohnS writes: 'Hello everybody, our dear customers!'", johnsPost);
        assertEquals("[TWITTER] milenka writes: 'Hello everybody'", milenasPost);
        assertEquals("[SNAPCHAT] polinka writes: ':-)'", paulasPost);
    }

    @Test
    public void testIndividualSharingStrategy() {
        // Given
        User john = new XGeneration("JohnS");

        // When
        john.setPublisher(new TwitterPublisher());
        String johnsPostOnTwitter = john.sharePost("Do you know the Best Smartphone In the Year 2017");
        john.setPublisher(new SnapchatPublisher());
        String johnsPostOnSnapchat = john.sharePost("* magic smartphone * your best friend *");

        // Then
        assertEquals("[TWITTER] JohnS writes: 'Do you know the Best Smartphone In the Year 2017'", johnsPostOnTwitter);
        assertEquals("[SNAPCHAT] JohnS writes: '* magic smartphone * your best friend *'", johnsPostOnSnapchat);
    }
}
