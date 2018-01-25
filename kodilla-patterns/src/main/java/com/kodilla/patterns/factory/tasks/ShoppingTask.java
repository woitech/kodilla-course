package com.kodilla.patterns.factory.tasks;

import static com.kodilla.patterns.factory.tasks.Validator.*;

public class ShoppingTask extends AbstractTask implements Task {
    private final String whatToBuy;
    private final double quantity;
    private final String measure;

    public ShoppingTask(String taskName, final String whatToBuy, final double quantity, final String measure) {
        super(taskName);

        validateString(whatToBuy, "valueless whatToBuy");
        validateTrue(quantity > 0, "quantity <= 0");
        validateString(measure, "valueless measure");

        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
        this.measure = measure;
    }

    @Override
    protected void execute() {
        // demo
        System.out.printf("%s:\nbuying %f %s of %s\n", getTaskName(), quantity, measure, whatToBuy);
    }
}
