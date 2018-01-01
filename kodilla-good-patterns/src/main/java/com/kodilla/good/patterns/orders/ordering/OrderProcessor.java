package com.kodilla.good.patterns.orders.ordering;

import com.kodilla.good.patterns.orders.ordering.services.*;

public class OrderProcessor {
    private final InformationService infoService;
    private final OrderService orderService;
    private final OrderRepository orderRepo;

    public OrderProcessor(final InformationService infoService,
                          final OrderService orderService,
                          final OrderRepository orderRepo) {
        if (infoService == null || orderService == null || orderRepo == null) {
            throw new IllegalArgumentException();
        }

        this.infoService = infoService;
        this.orderService = orderService;
        this.orderRepo = orderRepo;
    }

    public OrderProcessResult process(final OrderRequest request) {
        if (request == null) {
            throw new IllegalArgumentException();
        }

        Order order = orderService.order(request);
        if (order == null) { return null; }
        return new OrderProcessResult(order, infoService.inform(order),
                                      orderRepo.create(order));
    }
}
