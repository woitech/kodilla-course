package com.kodilla.good.patterns.orders.ordering.services;

import com.kodilla.good.patterns.orders.ordering.PlacedProductOrder;
import com.kodilla.good.patterns.orders.data.User;

public class MailService implements InformationService {
    @Override
    public boolean inform(PlacedProductOrder placedOrder) {
        User user = placedOrder.getUser();
        String email = user.getEmail();

        // return send(email, prepareTitle(...), prepareMessage(...);
        // dummy result:
        return true;
    }
}
