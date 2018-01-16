package com.kodilla.good.patterns.flights.db;

import com.kodilla.good.patterns.flights.data.*;
import java.time.*;
import java.util.*;

import static com.kodilla.good.patterns.flights.data.Airport.*;

public class DefaultFlightsDatabase implements FlightsDatabase {
    private static final Map<LocalDate, Set<Flight>> PLANS  = new HashMap<>();

    @Override
    public Set<Airport> getAirports() {
        return EnumSet.allOf(Airport.class);
    }

    @Override
    public Set<Flight> getFlights(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException();
        }
        if (!PLANS.containsKey(date)) {
            PLANS.put(date, planFlights(date));
        }

        return new HashSet<>(PLANS.get(date));
    }

    private static Set<Flight> planFlights(LocalDate date) {
        Set<Flight> flights = new HashSet<>();
        flights.add(new Flight(EPGD, EPKK, date, 06, 15, 67));
        flights.add(new Flight(EPGD, EPKK, date, 14, 05, 67));
        flights.add(new Flight(EPGD, EPKK, date, 22, 40, 67));
        flights.add(new Flight(EPGD, EPWA, date, 07, 05, 50));
        flights.add(new Flight(EPGD, EPWA, date, 15, 40, 50));
        flights.add(new Flight(EPGD, EPWA, date, 23, 15, 50));
        flights.add(new Flight(EPGD, EPWR, date, 07, 55, 59));
        flights.add(new Flight(EPGD, EPWR, date, 13, 55, 59));
        flights.add(new Flight(EPGD, EPWR, date, 22, 00, 59));
        flights.add(new Flight(EPKT, EPWA, date, 05, 15, 48));
        flights.add(new Flight(EPKT, EPWA, date, 13, 55, 48));
        flights.add(new Flight(EPKT, EPWA, date, 21, 40, 48));
        flights.add(new Flight(EPKK, EPGD, date, 06, 15, 67));
        flights.add(new Flight(EPKK, EPGD, date, 14, 05, 67));
        flights.add(new Flight(EPKK, EPGD, date, 22, 40, 67));
        flights.add(new Flight(EPKK, EPWA, date, 06,35, 49));
        flights.add(new Flight(EPKK, EPWA, date, 14, 20, 49));
        flights.add(new Flight(EPKK, EPWA, date, 22, 15, 49));
        flights.add(new Flight(EPPO, EPWA, date, 07, 10, 52));
        flights.add(new Flight(EPPO, EPWA, date, 14, 00, 52));
        flights.add(new Flight(EPPO, EPWA, date, 22, 30, 52));
        flights.add(new Flight(EPWA, EPGD, date, 07, 05, 50));
        flights.add(new Flight(EPWA, EPGD, date, 15, 40, 50));
        flights.add(new Flight(EPWA, EPGD, date, 23, 15, 50));
        flights.add(new Flight(EPWA, EPKT, date, 05, 15, 48));
        flights.add(new Flight(EPWA, EPKT, date, 13, 55, 48));
        flights.add(new Flight(EPWA, EPKT, date, 21, 40, 48));
        flights.add(new Flight(EPWA, EPKK, date, 06, 35, 49));
        flights.add(new Flight(EPWA, EPKK, date, 14, 20, 49));
        flights.add(new Flight(EPWA, EPKK, date, 22, 15, 49));
        flights.add(new Flight(EPWA, EPPO, date, 07, 10, 52));
        flights.add(new Flight(EPWA, EPPO, date, 14, 00, 52));
        flights.add(new Flight(EPWA, EPPO, date, 22, 30, 52));
        flights.add(new Flight(EPWA, EPWR, date, 06, 50, 53));
        flights.add(new Flight(EPWA, EPWR, date, 13, 00, 53));
        flights.add(new Flight(EPWA, EPWR, date, 20, 50, 53));
        flights.add(new Flight(EPWR, EPGD, date, 07, 55, 59));
        flights.add(new Flight(EPWR, EPGD, date, 13, 55, 59));
        flights.add(new Flight(EPWR, EPGD, date, 22, 00, 59));
        flights.add(new Flight(EPWR, EPWA, date, 06, 50, 53));
        flights.add(new Flight(EPWR, EPWA, date, 13, 00, 53));
        flights.add(new Flight(EPWR, EPWA, date, 20, 50, 53));

        return flights;
    }
}
