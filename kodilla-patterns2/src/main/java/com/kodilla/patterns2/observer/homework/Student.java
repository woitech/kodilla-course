package com.kodilla.patterns2.observer.homework;

import com.kodilla.patterns2.Validator;

import java.util.*;

public final class Student implements TasksEventSource<Student> {
    private final List<TasksListener<Student>> listeners;
    private final List<Task> tasks;

    private final String name;

    public Student(String name) {
        Validator.notBlank(name, "blank name");
        listeners = new ArrayList<>();
        tasks = new ArrayList<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addTask(Task task) {
        Validator.notNull(task, "null task");
        int index = tasks.size();
        tasks.add(index, task);
        fireTaskAdded(new TasksEvent<>(this, null, task, index));
    }

    public void updateTask(int index, Task task) {
        Validator.notNull(task, "null task");
        Validator.min(index, 0, "index < 0");
        Task taskBefore;
        if (index >= tasks.size() || (taskBefore = tasks.set(index, task)) == null) {
            throw new NoSuchElementException("index: " + index);
        }
        fireTaskUpdated(new TasksEvent<>(this, taskBefore, task, index));
    }

    public void removeTask(int index) {
        Validator.min(index, 0, "index < 0");
        Task taskBefore;
        if (index >= tasks.size() || (taskBefore = tasks.set(index, null)) == null) {
            throw new NoSuchElementException("index: " + index);
        }
        fireTaskRemoved(new TasksEvent<>(this, taskBefore, null, index));
    }

    public List<Task> getTasks() {
        return Collections.unmodifiableList(tasks);
    }

    public Optional<Task> getTask(int index) {
        Validator.min(index, 0, "index < 0");
        Task result = null;
        if (index < tasks.size()) {
            result = tasks.get(index);
        }
        return Optional.ofNullable(result);
    }

    public int tasksSize() {
        return tasks.size();
    }

    @Override
    public void addTasksListener(TasksListener<Student> listener) {
        Validator.notNull(listener, "null listener");
        listeners.add(listener);
    }

    @Override
    public void removeTasksListener(TasksListener<Student> listener) {
        Validator.notNull(listener, "null listener");
        listeners.remove(listener);
    }

    @Override
    public void fireTaskAdded(TasksEvent<Student> event) {
        Validator.notNull(event, "null event");
        for (TasksListener<Student> l : listeners) {
            l.taskAdded(event);
        }
    }

    @Override
    public void fireTaskUpdated(TasksEvent<Student> event) {
        Validator.notNull(event, "null event");
        for (TasksListener<Student> l : listeners) {
            l.taskUpdated(event);
        }
    }

    @Override
    public void fireTaskRemoved(TasksEvent<Student> event) {
        Validator.notNull(event, "null event");
        for (TasksListener<Student> l : listeners) {
            l.taskRemoved(event);
        }
    }
}
