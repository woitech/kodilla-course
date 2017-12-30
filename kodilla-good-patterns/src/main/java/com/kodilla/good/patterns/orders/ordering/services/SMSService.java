package com.kodilla.good.patterns.orders.ordering.services;

import com.kodilla.good.patterns.orders.data.User;
import com.kodilla.good.patterns.orders.ordering.PlacedProductOrder;

public class SMSService implements InformationService {
    @Override
    public boolean inform(PlacedProductOrder placedOrder) {
        User user = placedOrder.getUser();
        String phone = user.getPhone();

        // return sms(phone, prepareMessage(...);
        // dummy result:
        return true;
    }
}
