package com.kodilla.good.patterns.food2door.demands;

public class DefaultDemandRetriever implements DemandRetriever {
    // dummy implementation
    public Demand retrieve() {
        return new Demand("cauliflower", "item", 15.0);
    }
}
