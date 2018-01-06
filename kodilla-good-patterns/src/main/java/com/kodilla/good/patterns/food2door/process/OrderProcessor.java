package com.kodilla.good.patterns.food2door.process;

import com.kodilla.good.patterns.food2door.*;
import com.kodilla.good.patterns.food2door.data.*;
import com.kodilla.good.patterns.food2door.demands.*;
import com.kodilla.good.patterns.food2door.services.*;
import java.time.LocalDate;
import java.util.*;

public class OrderProcessor {
    private final AppConfig config;

    public OrderProcessor(AppConfig config) {
        if (config == null) {
            throw new IllegalArgumentException();
        }
        this.config = config;
    }

    public OrderProcessorResult process(Demand demand) {
        if (demand == null) {
            throw new IllegalArgumentException();
        }
        Map<Company, Offer> offers = collectOffers(config.getOfferServices());
        Rules rules = config.getRules();
        List<Order> orders = distributeOrders(demand, config.getRules(), offers);
        if (orders.isEmpty()) {
            return new OrderProcessorResult("no offers for demand");
        }

        List<Order> succeedOrders = new ArrayList<>();
        Map<Company, OrderService> orderServices = config.getOrderServices();
        for(Order order : orders) {
            if(orderServices.get(order.getProducer()).order(order)) {
                succeedOrders.add(order);
            }
        }

        List<Order> savedOrders = new ArrayList<>();
        for(Order order : succeedOrders) {
            if(config.getStorageService().insert(order)) {
                savedOrders.add(order);
            }
        }

        return new OrderProcessorResult("Details were saved in services logs", succeedOrders, savedOrders);
    }

    private List<Order> distributeOrders(Demand demand, Rules rules, Map<Company, Offer> offers) {
        // Demo implementation is very simple.
        // It ignores given rules, lacks and prices !!!

        String product = demand.getProductName();
        String measure = demand.getMeasure();
        double quantity = demand.getQuantity();

        List<Order> orders = new ArrayList<>();
        for(Map.Entry<Company, Offer> entry : offers.entrySet()) {
            Company producer = entry.getKey();
            Offer offer = entry.getValue();
            String p = offer.getProductName();
            String m = offer.getMeasure();
            double q = offer.getQuantity();
            double price = offer.getPrice();
            if (p.equals(product) && m.equals(measure)) {
                double quant = Double.min(quantity, q);
                orders.add(new Order(LocalDate.now(), producer, config.getAppUser(), product, measure, quantity, price));
                if (Double.compare(quant, quantity) == 0) {
                    break;
                }
                quantity -= quant;
            }
        }
        return orders;
    }

    private Map<Company, Offer> collectOffers(Map<Company, OfferService> offerServices) {
        Map<Company, Offer> offers = new HashMap<>();
        for(Map.Entry<Company, OfferService> entry : offerServices.entrySet()) {
            for (Offer offer : entry.getValue().getOffers()) {
                offers.put(entry.getKey(), offer);
            }
        }
        return offers;
    }
}
