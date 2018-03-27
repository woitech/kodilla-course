package com.kodilla.patterns2.observer.homework;

import com.kodilla.patterns2.Validator;

public final class TasksEvent<T> {
    private final T source;
    private final Task taskBefore;
    private final Task taskAfter;
    private final int taskIndex;

    public TasksEvent(final T source, final Task taskBefore, final Task taskAfter, final int taskIndex) {
        Validator.notNull(source,"null source");
        Validator.min(taskIndex, 0, "index < 0");

        this.source = source;
        this.taskBefore = taskBefore;
        this.taskAfter = taskAfter;
        this.taskIndex = taskIndex;
    }

    public T getSource() {
        return source;
    }

    public Task getTaskBefore() {
        return taskBefore;
    }

    public Task getTaskAfter() {
        return taskAfter;
    }

    public int getTaskIndex() {
        return taskIndex;
    }
}
