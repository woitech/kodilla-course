package com.kodilla.good.patterns.orders.ordering.services;

import com.kodilla.good.patterns.orders.ordering.Order;
import com.kodilla.good.patterns.orders.data.User;

public class MailService implements InformationService {
    @Override
    public boolean inform(Order order) {
        User user = order.getUser();
        String email = user.getEmail();

        // return send(email, prepareTitle(...), prepareMessage(...);
        // dummy result:
        return true;
    }
}
