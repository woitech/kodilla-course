package com.kodilla.good.patterns.food2door.services;

import com.kodilla.good.patterns.food2door.data.Offer;
import java.util.*;


public class GFSOfferService extends AbstractOfferService {
    private static final List<Offer> DEMO_OFFERS = createDemoOffers();

    public GFSOfferService(String url, String user, String pass) {
        super(url, user, pass);
    }

    @Override
    public List<Offer> getOffers() {
        return DEMO_OFFERS;
    }

    private static List<Offer> createDemoOffers() {
        List<Offer> offers = new ArrayList<>();
        offers.add(new Offer("tomato", "kg", 90.0, 5.2));
        offers.add(new Offer("milk", "l", 37.0, 5.0));
        offers.add(new Offer("cauliflower", "item", 7.0, 7.2));
        return offers;
    }
}