package com.kodilla.good.patterns.food2door.services;

public abstract class AbstractOrderService implements OrderService {
    private final String url;
    private final String user;
    private final String pass;

    public AbstractOrderService(final String url, final String user, final String pass) {
        validate(url, user, pass);

        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    private void validate(String url, String user, String pass) {
        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("valueless url");
        }
        if (user == null || user.isEmpty()) {
            throw new IllegalArgumentException("valueless user");
        }
        if (pass == null || pass.isEmpty()) {
            throw new IllegalArgumentException("valueless pass");
        }
    }

    protected String getUrl() {
        return url;
    }

    protected String getUser() {
        return user;
    }

    protected String getPass() {
        return pass;
    }
}
