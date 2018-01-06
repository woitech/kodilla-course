package com.kodilla.good.patterns.food2door.services;

import com.kodilla.good.patterns.food2door.data.Offer;
import java.util.*;

public class EFSOfferService extends AbstractOfferService {
    private static final List<Offer> DEMO_OFFERS = createDemoOffers();

    public EFSOfferService(String url, String user, String pass) {
        super(url, user, pass);
    }

    @Override
    public List<Offer> getOffers() {
        return DEMO_OFFERS;
    }

    private static List<Offer> createDemoOffers() {
        List<Offer> offers = new ArrayList<>();
        offers.add(new Offer("apple", "kg", 120.0, 3.5));
        offers.add(new Offer("tomato", "kg", 140.0, 6.2));
        offers.add(new Offer("milk", "l", 40.0, 5.2));
        offers.add(new Offer("cauliflower", "item", 12.0, 8.4));
        return offers;
    }
}
