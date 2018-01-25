package com.kodilla.spring.portfolio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardConfigTestSuiteWithRunner {
    @Autowired
    Board board1;
    @Autowired
    Board board2;
    @Autowired
    @Qualifier("toDoList")
    TaskList toDoTaskList1;
    @Autowired
    @Qualifier("toDoList")
    TaskList toDoTaskList2;
    @Autowired
    @Qualifier("inProgressList")
    TaskList inProgressTaskList1;
    @Autowired
    @Qualifier("inProgressList")
    TaskList inProgressTaskList2;
    @Autowired
    @Qualifier("doneList")
    TaskList doneTaskList1;
    @Autowired
    @Qualifier("doneList")
    TaskList doneTaskList2;

    @Test
    public void testBoardConfigBeansScopes() {
        // Given & when
        // initialized autowired fields of the current class

        // Then
        assertSame(board1, board2);
        assertNotSame(toDoTaskList1, toDoTaskList2);
        assertNotSame(inProgressTaskList1, inProgressTaskList2);
        assertNotSame(doneTaskList1, doneTaskList2);
    }
}
