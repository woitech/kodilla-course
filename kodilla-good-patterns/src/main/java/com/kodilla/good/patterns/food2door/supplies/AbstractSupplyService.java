package com.kodilla.good.patterns.food2door.supplies;

import com.kodilla.good.patterns.food2door.data.Company;

import static com.kodilla.good.patterns.food2door.Validator.*;

public abstract class AbstractSupplyService implements SupplyService {
    private final Company producer;
    private final String url;
    private final String user;
    private final String pass;

    protected AbstractSupplyService(final Company producer, final String url, final String user, final String pass) {
        validateNotNull(producer, "null Producer");
        validateString(url, "valueless URL");
        validateString(user, "valueless user name");
        validateString(pass, "valueless password");

        this.producer = producer;
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    public Company getProducer() {
        return producer;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
}
