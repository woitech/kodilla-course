package com.kodilla.good.patterns.food2door.process;

public class DefaultOrderProcessorResultHandler implements OrderProcessorResultHandler{
    public void handle(OrderProcessorResult result) {
        // dummy implementation prints result
        System.out.println(result);
    }
}
