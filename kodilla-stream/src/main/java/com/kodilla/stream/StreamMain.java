package com.kodilla.stream;

import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args) {
        Processor processor = new Processor();

        // 1 sposob
        ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
        processor.execute(executeSaySomething);

         // 2 sposob
        processor.execute(new Executor() {
            @Override
            public void process() {
                System.out.println("This is an example text 2.");
            }
         });

        // 3 sposob
        processor.execute(() -> System.out.println("This is an example text 3."));

        ////////////////////////////////////////////////////////////////

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);
    }
}