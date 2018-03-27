package com.kodilla.patterns2.observer.homework;

public interface TasksEventSource<T> {
    void addTasksListener(TasksListener<T> listener);
    void removeTasksListener(TasksListener<T> listener);
    void fireTaskAdded(TasksEvent<T> event);
    void fireTaskUpdated(TasksEvent<T> event);
    void fireTaskRemoved(TasksEvent<T> event);
}
