package com.kodilla.good.patterns.orders.ordering.services;

import com.kodilla.good.patterns.orders.data.User;
import com.kodilla.good.patterns.orders.ordering.Order;

public class SMSService implements InformationService {
    @Override
    public boolean inform(Order order) {
        User user = order.getUser();
        String phone = user.getPhone();

        // return sms(phone, prepareMessage(...);
        // dummy result:
        return true;
    }
}
