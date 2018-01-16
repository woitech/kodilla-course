package com.kodilla.good.patterns.food2door.supplies;

import com.kodilla.good.patterns.food2door.data.Company;
import java.util.List;

// Behaviors:
// The SupplyService's user does order using process() according to offers obtained with getOffers()
// Each SupplyService returns producer - the offers' owner and orders' receiver
public interface SupplyService {
    public Company getProducer();

    public List<Offer> getOffers();

    public OrderResult process(Order order);
}
