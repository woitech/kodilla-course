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

    public OrderProcessResultDto process(final ProductOrder order) {
        if (order == null) {
            throw new IllegalArgumentException();
        }

        PlacedProductOrder ppo = orderService.order(order);
        if (ppo == null) {
            return new OrderProcessResultDto(order, null, false, false);
        }
        return new OrderProcessResultDto(order, ppo, infoService.inform(ppo),
                                         orderRepo.create(ppo));

    }
}
