package com.kodilla.patterns.factory.tasks;

import static com.kodilla.patterns.factory.tasks.Validator.validateString;

public abstract class AbstractTask implements Task {
    private final String name;
    private boolean executed;

    public AbstractTask(final String name) {
        validateString(name, "valueless name");

        this.name = name;
        this.executed = false;
    }

    @Override
    public String getTaskName() {
        return name;
    }

    @Override
    public boolean isTaskExecuted() {
        return executed;
    }

    // throws TaskException in case of failure
    @Override
    public void executeTask() {
        if (executed) {
            throw new IllegalStateException("attempt to execute done task");
        }
        execute();
        executed = true;
    }

    // it should throw TaskException in case of failure
    protected abstract void execute();
}
