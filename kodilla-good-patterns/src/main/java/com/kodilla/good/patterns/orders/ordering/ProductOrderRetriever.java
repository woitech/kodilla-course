package com.kodilla.good.patterns.orders.ordering;

import com.kodilla.good.patterns.orders.data.*;

public class ProductOrderRetriever {
    private ProductOrder order;

    public ProductOrderRetriever() {
    }

    public ProductOrder retrieve() {
        if (order == null) {
            User user = new User(123, "janek", "Jan", "Kowalski",
                                 "ul. Komputerowa 7,12-345 Programowo",
                                 "janek@example.pl", "123456789");
            Product product = new Product(456, "Buty damskie \"Nispodzianka\"",
                                          630.0);
            order = new ProductOrder(user, product, 3);
        }
        return order;
    }
}
