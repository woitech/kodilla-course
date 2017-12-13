package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

// Przetestuj poprawność obliczeń wartości średnich dla różnych przypadków:
//     gdy liczba postów = 0
//     gdy liczba postów = 1000
//     gdy liczba komentarzy = 0
//     gdy liczba komentarzy < liczba postów
//     gdy liczba komentarzy > liczba postów
//     gdy liczba użytkowników = 0
//     gdy liczba użytkowników = 100

public class StatisticsProcessorTestSuite {
    @Test
    public void testCalculateAdvStatisticsWithoutUsers() {
        //GIVEN - the forum is absolutely empty
        StatisticsProcessor sp = new StatisticsProcessor();
        Statistics statistics = mock(Statistics.class);
        List<String> listWithoutUsers = Collections.emptyList();
        int postsCount = 0;
        int commentsCount = 0;
        when(statistics.usersNames()).thenReturn(listWithoutUsers);
        when(statistics.postsCount()).thenReturn(postsCount);
        when(statistics.commentsCount()).thenReturn(commentsCount);

        //WHEN
        sp.calculateAdvStatistics(statistics);

        //THEN
        assertEquals(0.0, sp.getPostsPerUser(), 0.0);
        assertEquals(0.0, sp.getCommentsPerUser(), 0.0);
        assertEquals(0.0, sp.getCommentsPerPost(), 0.0);
    }

    @Test
    public void testCalculateAdvStatisticsWithoutPosts() {
        //GIVEN - there are some users, but no posts
        StatisticsProcessor sp = new StatisticsProcessor();
        Statistics statistics = mock(Statistics.class);
        List<String> usersNames = Arrays.asList("First", "Second", "Third");
        int postsCount = 0;
        int commentsCount = 0;
        when(statistics.usersNames()).thenReturn(usersNames);
        when(statistics.postsCount()).thenReturn(postsCount);
        when(statistics.commentsCount()).thenReturn(commentsCount);

        //WHEN
        sp.calculateAdvStatistics(statistics);

        //THEN
        assertEquals(0.0, sp.getPostsPerUser(), 0.0);
        assertEquals(0.0, sp.getCommentsPerUser(), 0.0);
        assertEquals(0.0, sp.getCommentsPerPost(), 0.0);
    }

    @Test
    public void testCalculateAdvStatisticsWithoutComments() {
        //GIVEN - there are some users and their posts but no comments
        StatisticsProcessor sp = new StatisticsProcessor();
        Statistics statistics = mock(Statistics.class);
        List<String> usersNames = Arrays.asList("First", "Second", "Third");
        int postsCount = 10;
        int commentsCount = 0;

        when(statistics.usersNames()).thenReturn(usersNames);
        when(statistics.postsCount()).thenReturn(postsCount);
        when(statistics.commentsCount()).thenReturn(commentsCount);

        //WHEN
        sp.calculateAdvStatistics(statistics);

        //THEN
        assertEquals(0.0, sp.getCommentsPerUser(), 0.0);
        assertEquals(0.0, sp.getCommentsPerPost(), 0.0);
    }

    @Test
    public void testCalculateAdvStatisticsMorePostsThanComments() {
        //GIVEN
        StatisticsProcessor sp = new StatisticsProcessor();
        Statistics statistics = mock(Statistics.class);
        String[] strArray = new String[100];
        Arrays.fill(strArray, "userName");
        List<String> users100Names = Arrays.asList(strArray);
        int postsCount = 1000;
        int commentsCount = 891;

        when(statistics.usersNames()).thenReturn(users100Names);
        when(statistics.postsCount()).thenReturn(postsCount);
        when(statistics.commentsCount()).thenReturn(commentsCount);

        //WHEN
        sp.calculateAdvStatistics(statistics);

        //THEN
        assertEquals(10.0, sp.getPostsPerUser(), 0.0);
        assertEquals(8.91, sp.getCommentsPerUser(), 0.00001);
        assertEquals(0.891, sp.getCommentsPerPost(), 0.00001);
    }

    @Test
    public void testCalculateAdvStatisticsMoreCommentsThanPosts() {
        //GIVEN
        StatisticsProcessor sp = new StatisticsProcessor();
        Statistics statistics = mock(Statistics.class);
        String[] strArray = new String[100];
        Arrays.fill(strArray, "userName");
        List<String> users100Names = Arrays.asList(strArray);
        int postsCount = 1000;
        int commentsCount = 3456;

        when(statistics.usersNames()).thenReturn(users100Names);
        when(statistics.postsCount()).thenReturn(postsCount);
        when(statistics.commentsCount()).thenReturn(commentsCount);

        //WHEN
        sp.calculateAdvStatistics(statistics);

        //THEN
        assertEquals(10.0, sp.getPostsPerUser(), 0.0);
        assertEquals(34.56, sp.getCommentsPerUser(), 0.0001);
        assertEquals(3.456, sp.getCommentsPerPost(), 0.0001);
    }

}
