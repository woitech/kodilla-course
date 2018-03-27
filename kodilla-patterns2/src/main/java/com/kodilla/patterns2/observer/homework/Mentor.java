package com.kodilla.patterns2.observer.homework;

import com.kodilla.patterns2.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Mentor implements TasksListener<Student> {
    private final String name;
    private final List<String> messagesArchive;

    public Mentor(String name) {
        Validator.notBlank(name, "blank name");
        messagesArchive = new ArrayList<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getMessagesArchive() {
        return Collections.unmodifiableList(messagesArchive);
    }

    @Override
    public void taskAdded(TasksEvent<Student> event) {
        Validator.notNull(event, "null event");
        String msg = prepareMessage("New task has been added", event);
        System.out.println(msg);
        messagesArchive.add(msg);
    }

    @Override
    public void taskUpdated(TasksEvent<Student> event) {
        Validator.notNull(event, "null event");
        String msg = prepareMessage("Task has been updated", event);
        System.out.println(msg);
        messagesArchive.add(msg);
    }

    @Override
    public void taskRemoved(TasksEvent<Student> event) {
        Validator.notNull(event, "null event");
        String msg = prepareMessage("Task has been removed", event);
        System.out.println(msg);
        messagesArchive.add(msg);
    }

    private String prepareMessage(String eventDescription, TasksEvent<Student> event) {
        StringBuilder buff = new StringBuilder();
        buff.append(eventDescription).append(" (index: ").append(event.getTaskIndex()).append(')').append('\n')
            .append("Student: ").append(event.getSource().getName()).append('\n');

        buff.append("=== STATE BEFORE ===").append('\n');
        Task taskBefore = event.getTaskBefore();
        buff.append(taskBefore == null ? "Task doesn't exist" : taskBefore.toFineString()).append('\n');

        buff.append("=== STATE AFTER ===").append('\n');
        Task taskAfter = event.getTaskAfter();
        buff.append(taskAfter == null ? "Task doesn't exist" : taskAfter.toFineString());

        return buff.toString();
    }
}
