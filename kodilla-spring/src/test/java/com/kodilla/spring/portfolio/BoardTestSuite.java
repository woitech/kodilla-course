package com.kodilla.spring.portfolio;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class BoardTestSuite {
    @Test
    public void testTaskAdd() {
        // Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        String toDoTask = "System test";
        String inProgressTask = "System configuration";
        String doneTask = "System installation";

        // When
        boolean toDoAddResult = board.addToDoTask(toDoTask);
        boolean toInProgressResult = board.addInProgressTask(inProgressTask);
        boolean doneResult = board.addDoneTask(doneTask);

        // Then
        assertTrue(toDoAddResult);
        assertTrue(toInProgressResult);
        assertTrue(doneResult);

        assertEquals(1, board.toDoQuantity());
        assertEquals(1, board.inProgressQuantity());
        assertEquals(1, board.doneQuantity());

        assertEquals(toDoTask, board.getToDoTask(0));
        assertEquals(inProgressTask, board.getInProgressTask(0));
        assertEquals(doneTask, board.getDoneTask(0));
    }
}
