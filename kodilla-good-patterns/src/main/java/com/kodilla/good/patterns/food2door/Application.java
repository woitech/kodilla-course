package com.kodilla.good.patterns.food2door;

import com.kodilla.good.patterns.food2door.demands.Demand;
import com.kodilla.good.patterns.food2door.process.*;

public class Application {
    public static void main(String[] args) {
        AppConfig config = new AppConfig("config.xml");

        Demand demand = config.getDemandRetriever().retrieve();
        if(demand == null) {
            System.out.println("No demands to support");
            return;
        }
        OrderProcessor processor = new OrderProcessor(config);
        OrderProcessorResult result = processor.process(demand);
        config.getOrderProcessorResultHandler().handle(result);
    }
}
