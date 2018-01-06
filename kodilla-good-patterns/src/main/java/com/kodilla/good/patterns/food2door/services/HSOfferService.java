package com.kodilla.good.patterns.food2door.services;

import com.kodilla.good.patterns.food2door.data.Offer;
import java.util.*;


public class HSOfferService extends AbstractOfferService {
    private static final List<Offer> DEMO_OFFERS = createDemoOffers();


    public HSOfferService(String url, String user, String pass) {
        super(url, user, pass);
    }

    @Override
    public List<Offer> getOffers() {
        return DEMO_OFFERS;
    }

    private static List<Offer> createDemoOffers() {
        List<Offer> offers = new ArrayList<>();
        offers.add(new Offer("apple", "kg", 120.0, 3.5));
        offers.add(new Offer("butter", "kg", 20.25, 16.2));
        return offers;
    }
}