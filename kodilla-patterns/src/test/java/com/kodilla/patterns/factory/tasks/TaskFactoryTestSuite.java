package com.kodilla.patterns.factory.tasks;

import org.junit.Test;

import static com.kodilla.patterns.factory.tasks.TaskFactory.TaskObjectName.*;
import static org.junit.Assert.*;

public class TaskFactoryTestSuite {
    @Test
    public void testFactorySmallShopping() {
        // Given
        TaskFactory factory = new TaskFactory();

        // When
        Task smallShopping = factory.createTask(SMALL_SHOPPING);
        boolean stateBefore = smallShopping.isTaskExecuted();
        smallShopping.executeTask();
        boolean stateAfter = smallShopping.isTaskExecuted();

        // Then
        assertEquals("Very small shopping", smallShopping.getTaskName());
        assertFalse(stateBefore);
        assertTrue(stateAfter);
    }

    @Test
    public void testFactoryBigShopping() {
        // Given
        TaskFactory factory = new TaskFactory();

        // When
        Task bigShopping = factory.createTask(BIG_SHOPPING);
        boolean stateBefore = bigShopping.isTaskExecuted();
        bigShopping.executeTask();
        boolean stateAfter = bigShopping.isTaskExecuted();

        // Then
        assertEquals("Expensive shopping", bigShopping.getTaskName());
        assertFalse(stateBefore);
        assertTrue(stateAfter);
    }

    @Test
    public void testFactorySmallPainting() {
        // Given
        TaskFactory factory = new TaskFactory();

        // When
        Task smallPainting = factory.createTask(SMALL_PAINTING);
        boolean stateBefore = smallPainting.isTaskExecuted();
        smallPainting.executeTask();
        boolean stateAfter = smallPainting.isTaskExecuted();

        // Then
        assertEquals("Very small painting", smallPainting.getTaskName());
        assertFalse(stateBefore);
        assertTrue(stateAfter);
    }

    @Test
    public void testFactoryBigPainting() {
        // Given
        TaskFactory factory = new TaskFactory();

        // When
        Task bigPainting = factory.createTask(BIG_PAINTING);
        boolean stateBefore = bigPainting.isTaskExecuted();
        bigPainting.executeTask();
        boolean stateAfter = bigPainting.isTaskExecuted();

        // Then
        assertEquals("Very big painting", bigPainting.getTaskName());
        assertFalse(stateBefore);
        assertTrue(stateAfter);
    }

    @Test
    public void testFactoryShortWayDriving() {
        // Given
        TaskFactory factory = new TaskFactory();

        // When
        Task shortDriving = factory.createTask(SHORT_WAY_DRIVING);
        boolean stateBefore = shortDriving.isTaskExecuted();
        shortDriving.executeTask();
        boolean stateAfter = shortDriving.isTaskExecuted();

        // Then
        assertEquals("Very short way driving", shortDriving.getTaskName());
        assertFalse(stateBefore);
        assertTrue(stateAfter);
    }

    @Test
    public void testFactoryLongWayDriving() {
        // Given
        TaskFactory factory = new TaskFactory();

        // When
        Task longDriving = factory.createTask(LONG_WAY_DRIVING);
        boolean stateBefore = longDriving.isTaskExecuted();
        longDriving.executeTask();
        boolean stateAfter = longDriving.isTaskExecuted();

        // Then
        assertEquals("Very long way driving", longDriving.getTaskName());
        assertFalse(stateBefore);
        assertTrue(stateAfter);
    }
}
