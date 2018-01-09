package com.kodilla.good.patterns.flights.db;

import com.kodilla.good.patterns.flights.data.*;
import java.time.LocalDate;
import java.util.*;

public interface FlightsDatabase {
    public Set<Airport> getAirports();
    public Set<Flight> getFlights(LocalDate date);
}
