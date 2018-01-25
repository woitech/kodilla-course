package com.kodilla.patterns.strategy.social.publishers;

import com.kodilla.patterns.strategy.social.SocialPublisher;

import static com.kodilla.patterns.Validator.validateString;

public class SnapchatPublisher implements SocialPublisher {
    @Override
    public String share(String userName, String content) {
        validateString(userName, "valueless userName");
        validateString(content, "valueless content");

        return String.format("[SNAPCHAT] %s writes: '%s'", userName, content);
    }
}
