package com.kodilla.good.patterns.food2door.services;

import com.kodilla.good.patterns.food2door.data.Order;

public class MySqlStorageService implements StorageService {
    public MySqlStorageService(final String url, final String user, final String pass) {
        // dummy
    }

    @Override
    public boolean insert(Order order) {
        // dummy
        return true;
    }
}
