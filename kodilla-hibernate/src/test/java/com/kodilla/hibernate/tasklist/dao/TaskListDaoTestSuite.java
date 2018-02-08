package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    private static final String NAME1 = "ToDo";
    private static final String DESCRIPTION1 = "Tasks that are not started yet";
    private static final String NAME2 = "In progress";
    private static final String DESCRIPTION2 = "Tasks that are started but that are not finished yet";
    private static final String NAME3 = "Done";
    private static final String DESCRIPTION3 = "Tasks that are finished";
    private static final String DESCRIPTION_COMMON = "The task has no description yet";

    @Test
    public void testFindByListName() {
        // Given
        TaskList taskList1 = new TaskList(NAME1, DESCRIPTION1);
        TaskList taskList2 = new TaskList(NAME2, DESCRIPTION2);
        TaskList taskList3 = new TaskList(NAME3, DESCRIPTION3);
        taskListDao.save(taskList1);
        taskListDao.save(taskList2);
        taskListDao.save(taskList3);

        // When
        List<TaskList> readTasksLists = taskListDao.findByListName(NAME2);

        // Then
        assertEquals(1, readTasksLists.size());
        TaskList readTaskList = readTasksLists.get(0);
        assertEquals(taskList2, readTaskList);

        // CleanUp
        taskListDao.delete(taskList1);
        taskListDao.delete(taskList2);
        taskListDao.delete(taskList3);
    }



    @Test
    public void testTaskListDaoSaveWithTasks() {
        //Given
        Task task = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 3);
        TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        task.setTaskFinancialDetails(tfd);
        task2.setTaskFinancialDetails(tfd2);
        TaskList taskList = new TaskList(NAME1, DESCRIPTION1);

        taskList.getTasks().add(task);
        taskList.getTasks().add(task2);
        task.setTaskList(taskList);
        task2.setTaskList(taskList);

        //When
        taskListDao.save(taskList);
        int id = taskList.getId();

        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
        taskListDao.delete(id);
    }
}
