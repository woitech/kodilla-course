package com.kodilla.good.patterns.flights.services;

import com.kodilla.good.patterns.flights.data.*;
import java.util.*;

public interface InfoService {
    public Set<Airport> getAirports();

    public List<TravelPlan> getTravelPlans(InfoRequest request);
}