package com.kodilla.good.patterns.food2door;

import com.kodilla.good.patterns.food2door.supplies.*;
import java.time.LocalDateTime;
import java.util.*;

import static com.kodilla.good.patterns.food2door.Validator.validateNotNull;

public final class MainSystemSimpleExample {
    private final List<SupplyService> services;

    public MainSystemSimpleExample(final List<SupplyService> services) {
        validateNotNull(services, "null services list");

        this.services = services;
    }

    public void useServices() {
        for (SupplyService srv : services) {
            System.out.println("I'm uploading offers from " + srv.getProducer());
            List<Offer> offers = srv.getOffers();
            if (offers == null) {
                System.out.println("error occured");
                continue;
            }
            if (offers.isEmpty()) {
                System.out.println("There are no offers");
                continue;
            }
            System.out.println("I display them");
            for (Offer offer : offers) {
                System.out.println(offer.toFineString());
            }
            System.out.println("I order them all");
            for (Offer offer : offers) {
                OrderResult result = srv.process(new Order(LocalDateTime.now(),offer, offer.getQuantity()));
                if (result == null) {
                    System.out.println("I can't order " + offer.getProduct());
                    continue;
                }
                System.out.println("I've just made an order with result:");
                System.out.println(result.toFineString());
            }
        }
    }
}
