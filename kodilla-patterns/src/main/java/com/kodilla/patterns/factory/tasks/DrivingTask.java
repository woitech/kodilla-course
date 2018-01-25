package com.kodilla.patterns.factory.tasks;

import static com.kodilla.patterns.factory.tasks.Validator.validateString;

public class DrivingTask extends AbstractTask implements Task {
    private final String where;
    private final String using;

    public DrivingTask(String taskName, final String where, final String using) {
        super(taskName);

        validateString(where, "valueless where");
        validateString(using, "valueless using");

        this.where = where;
        this.using = using;
    }

    @Override
    protected void execute()  {
        // demo
        System.out.printf("%s:\ndriving to %s using %s\n", getTaskName(), where, using);
    }
}
