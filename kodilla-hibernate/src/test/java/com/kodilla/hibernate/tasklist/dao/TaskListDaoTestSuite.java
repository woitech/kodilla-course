package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.task.dao.TaskDao;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;

    @Autowired
    private TaskDao taskDao;

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

    @Test
    public void testNamedQueries() {
        //Given
        Task task1 = new Task("Test: Study Hibernate", 3);
        Task task2 = new Task("Test: Practice Named Queries", 6);
        Task task3 = new Task("Test: Study native queries", 7);
        Task task4 = new Task("Test: Makse some tests", 13);
        TaskFinancialDetails tfd1 = new TaskFinancialDetails(new BigDecimal(5), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        TaskFinancialDetails tfd3 = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd4 = new TaskFinancialDetails(new BigDecimal(15), false);
        task1.setTaskFinancialDetails(tfd1);
        task2.setTaskFinancialDetails(tfd2);
        task3.setTaskFinancialDetails(tfd3);
        task4.setTaskFinancialDetails(tfd4);
        TaskList taskList = new TaskList(NAME1, DESCRIPTION1);
        taskList.getTasks().add(task1);
        taskList.getTasks().add(task2);
        taskList.getTasks().add(task3);
        taskList.getTasks().add(task4);
        task1.setTaskList(taskList);
        task2.setTaskList(taskList);
        task3.setTaskList(taskList);
        task4.setTaskList(taskList);

        taskListDao.save(taskList);
        int id = taskList.getId();

        //When
        List<Task> longTasks = taskDao.retrieveLongTasks();
        List<Task> shortTasks = taskDao.retrieveShortTasks();
        List<Task> enoughTimeTasks = taskDao.retrieveTasksWithEnoughTime();
        List<Task> durationLungerThanTasks = taskDao.retrieveTasksWithDurationLongerThan(6);

        //Then
        try {
            Assert.assertEquals(1, longTasks.size());
            Assert.assertEquals(3, shortTasks.size());
            Assert.assertEquals(3, enoughTimeTasks.size());
            Assert.assertEquals(2, durationLungerThanTasks.size());
        } finally {
            //CleanUp
            taskListDao.delete(id);
        }
    }
}
