package com.kodilla.patterns2.observer.homework;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MentorTestSuite {
    @Test
    public void testTaskAdded() {
        // Given
        Mentor janMentorski = new Mentor("Jan Mentorski");
        Mentor anitaTutor = new Mentor("Anita Tutor");
        Student kamilWiosna = new Student("Kamil Wiosna");
        Student janLato = new Student("Jan Lato");
        Student ewaJesien = new Student("Ewa Jesien");
        Student olaZima = new Student("Ola Zima");
        kamilWiosna.addTasksListener(janMentorski);
        janLato.addTasksListener(janMentorski);
        ewaJesien.addTasksListener(anitaTutor);
        olaZima.addTasksListener(anitaTutor);

        // When
        kamilWiosna.addTask(new Task("Write infinite for loop", "for(;;);"));
        janLato.addTask(new Task("Write infinite while loop", "while(true);"));
        ewaJesien.addTask(new Task("Write unreachable if block", "if(false){doIt();}"));
        olaZima.addTask(new Task("Declare int variable","int x;"));
        kamilWiosna.addTask(new Task("Initialize boolean variable", "boolean value = true;"));
        janLato.addTask(new Task("Add two integers", "a = b + c;"));
        ewaJesien.addTask(new Task("Create list of strings", "List<String> list = new ArrayList<>();"));
        olaZima.addTask(new Task("Write a comment","/* This is a comment */"));

        // Then
        List<String> expectedJMArchive = new ArrayList<>();
        String msg = "New task has been added (index: 0)\n" +
                     "Student: Kamil Wiosna\n" +
                     "=== STATE BEFORE ===\n" +
                     "Task doesn't exist\n" +
                     "=== STATE AFTER ===\n" +
                     "Subject: Write infinite for loop\n" +
                     "Content: for(;;);";
        expectedJMArchive.add(msg);
        msg = "New task has been added (index: 0)\n" +
               "Student: Jan Lato\n" +
               "=== STATE BEFORE ===\n" +
               "Task doesn't exist\n" +
               "=== STATE AFTER ===\n" +
               "Subject: Write infinite while loop\n" +
               "Content: while(true);";
        expectedJMArchive.add(msg);
        msg = "New task has been added (index: 1)\n" +
               "Student: Kamil Wiosna\n" +
               "=== STATE BEFORE ===\n" +
               "Task doesn't exist\n" +
               "=== STATE AFTER ===\n" +
               "Subject: Initialize boolean variable\n" +
               "Content: boolean value = true;";
        expectedJMArchive.add(msg);
        msg = "New task has been added (index: 1)\n" +
               "Student: Jan Lato\n" +
               "=== STATE BEFORE ===\n" +
               "Task doesn't exist\n" +
               "=== STATE AFTER ===\n" +
               "Subject: Add two integers\n" +
               "Content: a = b + c;";
        expectedJMArchive.add(msg);
        assertEquals(expectedJMArchive, janMentorski.getMessagesArchive());

        List<String> expectedATArchive = new ArrayList<>();
        msg = "New task has been added (index: 0)\n" +
              "Student: Ewa Jesien\n" +
              "=== STATE BEFORE ===\n" +
              "Task doesn't exist\n" +
              "=== STATE AFTER ===\n" +
              "Subject: Write unreachable if block\n" +
              "Content: if(false){doIt();}";
        expectedATArchive.add(msg);
        msg = "New task has been added (index: 0)\n" +
              "Student: Ola Zima\n" +
              "=== STATE BEFORE ===\n" +
              "Task doesn't exist\n" +
              "=== STATE AFTER ===\n" +
              "Subject: Declare int variable\n" +
              "Content: int x;";
        expectedATArchive.add(msg);
        msg = "New task has been added (index: 1)\n" +
              "Student: Ewa Jesien\n" +
              "=== STATE BEFORE ===\n" +
              "Task doesn't exist\n" +
              "=== STATE AFTER ===\n" +
              "Subject: Create list of strings\n" +
              "Content: List<String> list = new ArrayList<>();";
        expectedATArchive.add(msg);
        msg = "New task has been added (index: 1)\n" +
              "Student: Ola Zima\n" +
              "=== STATE BEFORE ===\n" +
              "Task doesn't exist\n" +
              "=== STATE AFTER ===\n" +
              "Subject: Write a comment\n" +
              "Content: /* This is a comment */";
        expectedATArchive.add(msg);
        assertEquals(expectedATArchive, anitaTutor.getMessagesArchive());
    }

    @Test
    public void testTaskUpdated() {
        // Given
        Mentor janMentorski = new Mentor("Jan Mentorski");
        Student kamilWiosna = new Student("Kamil Wiosna");
        kamilWiosna.addTasksListener(janMentorski);
        kamilWiosna.addTask(new Task("Write infinite for loop", "for(;;);"));
        kamilWiosna.addTask(new Task("Initialize boolean variable", "boolean value = true;"));
        kamilWiosna.addTask(new Task("Write a comment","/* This is a comment */"));

        // When
        kamilWiosna.updateTask(1, new Task("Initialize boolean variable", "boolean value = false;"));

        // Then
        List<String> expectedJMArchive = new ArrayList<>();
        String msg = "New task has been added (index: 0)\n" +
                "Student: Kamil Wiosna\n" +
                "=== STATE BEFORE ===\n" +
                "Task doesn't exist\n" +
                "=== STATE AFTER ===\n" +
                "Subject: Write infinite for loop\n" +
                "Content: for(;;);";
        expectedJMArchive.add(msg);
        msg = "New task has been added (index: 1)\n" +
              "Student: Kamil Wiosna\n" +
              "=== STATE BEFORE ===\n" +
              "Task doesn't exist\n" +
              "=== STATE AFTER ===\n" +
              "Subject: Initialize boolean variable\n" +
              "Content: boolean value = true;";
        expectedJMArchive.add(msg);
        msg = "New task has been added (index: 2)\n" +
              "Student: Kamil Wiosna\n" +
              "=== STATE BEFORE ===\n" +
              "Task doesn't exist\n" +
              "=== STATE AFTER ===\n" +
              "Subject: Write a comment\n" +
              "Content: /* This is a comment */";
        expectedJMArchive.add(msg);
        msg = "Task has been updated (index: 1)\n" +
              "Student: Kamil Wiosna\n" +
              "=== STATE BEFORE ===\n" +
              "Subject: Initialize boolean variable\n" +
              "Content: boolean value = true;\n" +
              "=== STATE AFTER ===\n" +
              "Subject: Initialize boolean variable\n" +
              "Content: boolean value = false;";
        expectedJMArchive.add(msg);
        assertEquals(expectedJMArchive, janMentorski.getMessagesArchive());
    }

    @Test
    public void testTaskRemoved() {
        // Given
        Mentor janMentorski = new Mentor("Jan Mentorski");
        Student kamilWiosna = new Student("Kamil Wiosna");
        kamilWiosna.addTasksListener(janMentorski);
        kamilWiosna.addTask(new Task("Write infinite for loop", "for(;;);"));
        kamilWiosna.addTask(new Task("Initialize boolean variable", "boolean value = true;"));
        kamilWiosna.addTask(new Task("Write a comment","/* This is a comment */"));

        // When
        kamilWiosna.removeTask(1);

        // Then
        List<String> expectedJMArchive = new ArrayList<>();
        String msg = "New task has been added (index: 0)\n" +
                "Student: Kamil Wiosna\n" +
                "=== STATE BEFORE ===\n" +
                "Task doesn't exist\n" +
                "=== STATE AFTER ===\n" +
                "Subject: Write infinite for loop\n" +
                "Content: for(;;);";
        expectedJMArchive.add(msg);
        msg = "New task has been added (index: 1)\n" +
                "Student: Kamil Wiosna\n" +
                "=== STATE BEFORE ===\n" +
                "Task doesn't exist\n" +
                "=== STATE AFTER ===\n" +
                "Subject: Initialize boolean variable\n" +
                "Content: boolean value = true;";
        expectedJMArchive.add(msg);
        msg = "New task has been added (index: 2)\n" +
                "Student: Kamil Wiosna\n" +
                "=== STATE BEFORE ===\n" +
                "Task doesn't exist\n" +
                "=== STATE AFTER ===\n" +
                "Subject: Write a comment\n" +
                "Content: /* This is a comment */";
        expectedJMArchive.add(msg);
        msg = "Task has been removed (index: 1)\n" +
                "Student: Kamil Wiosna\n" +
                "=== STATE BEFORE ===\n" +
                "Subject: Initialize boolean variable\n" +
                "Content: boolean value = true;\n" +
                "=== STATE AFTER ===\n" +
                "Task doesn't exist";
        expectedJMArchive.add(msg);
        assertEquals(expectedJMArchive, janMentorski.getMessagesArchive());
    }

    @Test
    public void testMentorExchange() {
        // Given
        Mentor janMentorski = new Mentor("Jan Mentorski");
        Mentor anitaTutor = new Mentor("Anita Tutor");
        Student kamilWiosna = new Student("Kamil Wiosna");
        kamilWiosna.addTasksListener(janMentorski);
        kamilWiosna.addTask(new Task("Write infinite for loop", "for(;;);"));

        // When
        kamilWiosna.removeTasksListener(janMentorski);
        kamilWiosna.addTasksListener(anitaTutor);
        kamilWiosna.addTask(new Task("Initialize boolean variable", "boolean value = true;"));

        // Then
        String firstMsg = "New task has been added (index: 0)\n" +
                          "Student: Kamil Wiosna\n" +
                          "=== STATE BEFORE ===\n" +
                          "Task doesn't exist\n" +
                          "=== STATE AFTER ===\n" +
                          "Subject: Write infinite for loop\n" +
                          "Content: for(;;);";
        String secondMsg = "New task has been added (index: 1)\n" +
                           "Student: Kamil Wiosna\n" +
                           "=== STATE BEFORE ===\n" +
                           "Task doesn't exist\n" +
                           "=== STATE AFTER ===\n" +
                           "Subject: Initialize boolean variable\n" +
                           "Content: boolean value = true;";

        assertEquals(Arrays.asList(firstMsg), janMentorski.getMessagesArchive());
        assertEquals(Arrays.asList(secondMsg), anitaTutor.getMessagesArchive());
    }
}
