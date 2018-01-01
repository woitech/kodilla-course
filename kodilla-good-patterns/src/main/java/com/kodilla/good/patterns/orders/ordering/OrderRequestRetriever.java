package com.kodilla.good.patterns.orders.ordering;

import com.kodilla.good.patterns.orders.data.*;

public class OrderRequestRetriever {
    private OrderRequest request;

    public OrderRequestRetriever() {
        User user = new User(123, "janek", "Jan", "Kowalski",
                "ul. Komputerowa 7,12-345 Programowo",
                "janek@example.pl", "123456789");
        Product product = new Product(456, "Buty damskie \"Nispodzianka\"",
                630.0);
        request = new OrderRequest(user, product, 3);
    }

    public OrderRequest retrieve() { return request; }
}
