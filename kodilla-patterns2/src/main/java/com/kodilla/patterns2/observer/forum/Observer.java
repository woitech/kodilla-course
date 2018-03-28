package com.kodilla.patterns2.observer.forum;

import com.kodilla.patterns2.observer.forum.ForumTopic;

public interface Observer {
    void update(ForumTopic forumTopic);
}
