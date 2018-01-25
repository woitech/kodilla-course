package com.kodilla.spring.portfolio;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

// Pozwoliłem sobie dodać, bo nie byłem pewny do końca znaczenia @Scope
public class BoardConfigTestSuite {
    @Test
    public void testBoardConfigBeansScopes() {
        // Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);

        // When
        Board board1 = context.getBean(Board.class);
        Board board2 = context.getBean(Board.class);
        TaskList toDoTaskList1 = (TaskList)context.getBean("toDoList");
        TaskList toDoTaskList2 = (TaskList)context.getBean("toDoList");
        TaskList inProgressTaskList1 = (TaskList)context.getBean("inProgressList");
        TaskList inProgressTaskList2 = (TaskList)context.getBean("inProgressList");
        TaskList doneTaskList1 = (TaskList)context.getBean("doneList");
        TaskList doneTaskList2 = (TaskList)context.getBean("doneList");

        // Then
        assertSame(board1, board2);
        assertNotSame(toDoTaskList1, toDoTaskList2);
        assertNotSame(inProgressTaskList1, inProgressTaskList2);
        assertNotSame(doneTaskList1, doneTaskList2);
    }
}
