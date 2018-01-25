package com.kodilla.spring.portfolio;

import java.util.*;

public final class TaskList {
    private final  List<String> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public boolean addTask(String task) {
        if (task == null || task.isEmpty()) {
            throw new IllegalArgumentException("valueless task");
        }
        return tasks.add(task);
    }

    // throws IndexOutOfBoundsException if index < 0 || index >= size()
    public String getTask(int index) {
        return tasks.get(index);
    }

    public int size() {
        return tasks.size();
    }
}
