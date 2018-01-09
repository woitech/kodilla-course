package com.kodilla.good.patterns.flights.services;

import com.kodilla.good.patterns.flights.data.*;
import java.util.*;

// Possible examples: HTTPCustomerService, InfomatCustomerService, etc.
public interface CustomerService {
    public void updateAirports(Set<Airport> airports);
    public InfoRequest nextInfoRequest();
    public boolean hasNextInfoRequest();
    public void replyToInfoRequest(InfoRequest request, List<TravelPlan> tplist);
    public void sendError(InfoRequest request);
}
