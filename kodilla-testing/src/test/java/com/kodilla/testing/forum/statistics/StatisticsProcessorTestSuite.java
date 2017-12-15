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

// possible cases inside method calculateAdvStatistics(Statistcs statistics):
// Correct ones are marked with 'OK'.
//                                                               testNumber
// 1. statistics == null                                             #6
// 2. statistics.usersNames() == null                                #7
// 3. statistics.postsCount() < 0                                    #8
// 4. statistics.commentsCount() < 0                                 #9
// 5. Let 1 means value>0 and 0 value==0
//        users  posts comments descriptiom
//   5.1.   1      1       1    OK                                   #4 #5
//   5.2.   1      1       0    OK                                   #3
//   5.3.   1      0       0    OK                                   #2
//   5.4.   0      0       0    OK                                   #1
//   5.5.   0      1       1    orphaned posts with comments         #10
//   5.6.   0      1       0    orphaned posts without comments      #11
//   5.7.   1      0       1    orphaned comments, users exist       #12
//   5.8.   0      0       1    orphaned comments, no users          #13

public class StatisticsProcessorTestSuite {
    @Test //#1
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
        assertEquals(0, sp.getUserQuantity());
        assertEquals(0, sp.getPostQuantity());
        assertEquals(0, sp.getCommentQuantity());
        assertEquals(0.0, sp.getPostsPerUser(), 0.0);
        assertEquals(0.0, sp.getCommentsPerUser(), 0.0);
        assertEquals(0.0, sp.getCommentsPerPost(), 0.0);
    }

    @Test //#2
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
        assertEquals(3, sp.getUserQuantity());
        assertEquals(0, sp.getPostQuantity());
        assertEquals(0, sp.getCommentQuantity());
        assertEquals(0.0, sp.getPostsPerUser(), 0.0);
        assertEquals(0.0, sp.getCommentsPerUser(), 0.0);
        assertEquals(0.0, sp.getCommentsPerPost(), 0.0);
    }

    @Test //#3
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
        assertEquals(3, sp.getUserQuantity());
        assertEquals(10, sp.getPostQuantity());
        assertEquals(0, sp.getCommentQuantity());
        assertEquals(3.3333, sp.getPostsPerUser(), 0.0001);
        assertEquals(0.0, sp.getCommentsPerUser(), 0.0);
        assertEquals(0.0, sp.getCommentsPerPost(), 0.0);
    }

    @Test //#4
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
        assertEquals(100, sp.getUserQuantity());
        assertEquals(1000, sp.getPostQuantity());
        assertEquals(891, sp.getCommentQuantity());
        assertEquals(10.0, sp.getPostsPerUser(), 0.0);
        assertEquals(8.91, sp.getCommentsPerUser(), 0.00001);
        assertEquals(0.891, sp.getCommentsPerPost(), 0.00001);
    }

    @Test //#5
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
        assertEquals(100, sp.getUserQuantity());
        assertEquals(1000, sp.getPostQuantity());
        assertEquals(3456, sp.getCommentQuantity());
        assertEquals(10.0, sp.getPostsPerUser(), 0.0);
        assertEquals(34.56, sp.getCommentsPerUser(), 0.0001);
        assertEquals(3.456, sp.getCommentsPerPost(), 0.0001);
    }

    @Test //#6
    public void testCalculateAdvStatisticsNullStatistics() {
        //GIVEN
        StatisticsProcessor sp = new StatisticsProcessor();
        Statistics nullStatistics = null;
        String excMessage = "null Statistics";

        try {
            //WHEN
            sp.calculateAdvStatistics(nullStatistics);
            //THEN
            fail();
        } catch (IllegalArgumentException exc) {
            assertEquals(excMessage, exc.getMessage());
            //OK
        }
    }

    @Test //#7
    public void testCalculateAdvStatisticsNullUserNames() {
        //GIVEN
        StatisticsProcessor sp = new StatisticsProcessor();
        Statistics statistics = mock(Statistics.class);
        List<String> nullUsersList = null;
        int postsCount = 10;
        int commentsCount = 10;
        when(statistics.usersNames()).thenReturn(nullUsersList);
        when(statistics.postsCount()).thenReturn(postsCount);
        when(statistics.commentsCount()).thenReturn(commentsCount);
        String excMessage = "null users list";

        try {
            //WHEN
            sp.calculateAdvStatistics(statistics);
            //THEN
            fail();
        } catch (IllegalArgumentException exc) {
            assertEquals(excMessage, exc.getMessage());
            //OK
        }
    }

    @Test //#8
    public void testCalculateAdvStatisticsNegativePostCount() {
        //GIVEN
        StatisticsProcessor sp = new StatisticsProcessor();
        Statistics statistics = mock(Statistics.class);
        List<String> usersNames = Arrays.asList("First", "Second", "Third");
        int postsCount = -1;
        int commentsCount = 10;
        when(statistics.usersNames()).thenReturn(usersNames);
        when(statistics.postsCount()).thenReturn(postsCount);
        when(statistics.commentsCount()).thenReturn(commentsCount);
        String excMessage = "negative posts count";

        try {
            //WHEN
            sp.calculateAdvStatistics(statistics);
            //THEN
            fail();
        } catch (IllegalArgumentException exc) {
            assertEquals(excMessage, exc.getMessage());
            //OK
        }
    }

    @Test //#9
    public void testCalculateAdvStatisticsNegativeCommentsCount() {
        //GIVEN
        StatisticsProcessor sp = new StatisticsProcessor();
        Statistics statistics = mock(Statistics.class);
        List<String> usersNames = Arrays.asList("First", "Second", "Third");
        int postsCount = 10;
        int commentsCount = -1;
        when(statistics.usersNames()).thenReturn(usersNames);
        when(statistics.postsCount()).thenReturn(postsCount);
        when(statistics.commentsCount()).thenReturn(commentsCount);
        String excMessage = "negative comments count";

        try {
            //WHEN
            sp.calculateAdvStatistics(statistics);
            //THEN
            fail();
        } catch (IllegalArgumentException exc) {
            assertEquals(excMessage, exc.getMessage());
            //OK
        }
    }

    @Test //#10
    public void testCalculateAdvStatisticsOrphanedPostsWithComments() {
        //GIVEN
        StatisticsProcessor sp = new StatisticsProcessor();
        Statistics statistics = mock(Statistics.class);
        List<String> listWithoutUsers = Collections.emptyList();
        int postsCount = 1;
        int commentsCount = 1;
        when(statistics.usersNames()).thenReturn(listWithoutUsers);
        when(statistics.postsCount()).thenReturn(postsCount);
        when(statistics.commentsCount()).thenReturn(commentsCount);
        String excMessage = "orphaned posts";

        try {
            //WHEN
            sp.calculateAdvStatistics(statistics);
            //THEN
            fail();
        } catch (IllegalArgumentException exc) {
            assertEquals(excMessage, exc.getMessage());
            //OK
        }
    }

    @Test //#11
    public void testCalculateAdvStatisticsOrphanedPostsWithoutComments() {
        //GIVEN
        StatisticsProcessor sp = new StatisticsProcessor();
        Statistics statistics = mock(Statistics.class);
        List<String> listWithoutUsers = Collections.emptyList();
        int postsCount = 1;
        int commentsCount = 0;
        when(statistics.usersNames()).thenReturn(listWithoutUsers);
        when(statistics.postsCount()).thenReturn(postsCount);
        when(statistics.commentsCount()).thenReturn(commentsCount);
        String excMessage = "orphaned posts";

        try {
            //WHEN
            sp.calculateAdvStatistics(statistics);
            //THEN
            fail();
        } catch (IllegalArgumentException exc) {
            assertEquals(excMessage, exc.getMessage());
            //OK
        }
    }

    @Test //#12
    public void testCalculateAdvStatisticsOrphanedCommentsUsersExist() {
        //GIVEN
        StatisticsProcessor sp = new StatisticsProcessor();
        Statistics statistics = mock(Statistics.class);
        List<String> usersNames = Arrays.asList("First", "Second", "Third");
        int postsCount = 0;
        int commentsCount = 1;
        when(statistics.usersNames()).thenReturn(usersNames);
        when(statistics.postsCount()).thenReturn(postsCount);
        when(statistics.commentsCount()).thenReturn(commentsCount);
        String excMessage = "orphaned comments";

        try {
            //WHEN
            sp.calculateAdvStatistics(statistics);
            //THEN
            fail();
        } catch (IllegalArgumentException exc) {
            assertEquals(excMessage, exc.getMessage());
            //OK
        }
    }

    @Test //#13
    public void testCalculateAdvStatisticsOrphanedCommentsNoUsers() {
        //GIVEN
        StatisticsProcessor sp = new StatisticsProcessor();
        Statistics statistics = mock(Statistics.class);
        List<String> listWithoutUsers = Collections.emptyList();
        int postsCount = 0;
        int commentsCount = 1;
        when(statistics.usersNames()).thenReturn(listWithoutUsers);
        when(statistics.postsCount()).thenReturn(postsCount);
        when(statistics.commentsCount()).thenReturn(commentsCount);
        String excMessage = "orphaned comments";

        try {
            //WHEN
            sp.calculateAdvStatistics(statistics);
            //THEN
            fail();
        } catch (IllegalArgumentException exc) {
            assertEquals(excMessage, exc.getMessage());
            //OK
        }
    }
}
