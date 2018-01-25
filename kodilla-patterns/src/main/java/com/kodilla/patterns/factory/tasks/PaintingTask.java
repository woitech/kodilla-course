package com.kodilla.patterns.factory.tasks;

import static com.kodilla.patterns.factory.tasks.Validator.*;

public class PaintingTask extends AbstractTask implements Task {
    private final String color;
    private final String whatToPaint;

    public PaintingTask(String taskName, final String color, final String whatToPaint) {
        super(taskName);

        validateString(color, "valueless color");
        validateString(whatToPaint, "valueless whatToPaint");

        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    @Override
    protected void execute() {
        // demo
        System.out.printf("%s:\npainting %s in %s color\n", getTaskName(), whatToPaint, color);
    }
}
