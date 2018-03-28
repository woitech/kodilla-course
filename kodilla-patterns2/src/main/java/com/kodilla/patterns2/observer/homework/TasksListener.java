package com.kodilla.patterns2.observer.homework;

public interface TasksListener<T> {
    void taskAdded(TasksEvent<T> event);
    void taskUpdated(TasksEvent<T> event);
    void taskRemoved(TasksEvent<T> event);
}
