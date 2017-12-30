package com.kodilla.good.patterns.orders;

import com.kodilla.good.patterns.orders.ordering.*;
import com.kodilla.good.patterns.orders.ordering.services.*;

public class Application {
    public static void main(String[] args) {
        ProductOrderRetriever por = new ProductOrderRetriever();
        ProductOrder order = por.retrieve();

        OrderProcessor processor = new OrderProcessor(new SMSService(),
                new ProductOrderService(), new ProductOrderRepository());
        log(processor.process(order));
    }

    private static void log(Object o) {
        System.out.println(o.toString());
    }
}
