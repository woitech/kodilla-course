package com.kodilla.good.patterns.food2door.demands;

public interface DemandRetriever {
    // Retrieves and removes the head of demand queue, or returns null if this queue is empty.
    public Demand retrieve();
}
