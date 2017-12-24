package com.kodilla.exception.test;

public class RouteNotFoundException extends Exception {
    public RouteNotFoundException() { super(); }

    public RouteNotFoundException(String message) { super(message); }
}