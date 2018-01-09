package com.kodilla.good.patterns.flights.services;

import com.kodilla.good.patterns.flights.db.FlightsDatabase;
import com.kodilla.good.patterns.flights.data.*;
import java.time.*;
import java.util.*;
import java.util.function.Predicate;

import static java.util.stream.Collectors.*;

public class DefaultInfoService implements InfoService {
    private final FlightsDatabase db;

    public DefaultInfoService(FlightsDatabase db) {
        if (db == null) {
            throw new IllegalArgumentException("null database");
        }
        this.db = db;
    }

    @Override
    public Set<Airport> getAirports() {
        return db.getAirports();
    }

    // This InfoService implementation assumes only 1 change
    // i.e. maximum 2 flights for a travel.
    @Override
    public List<TravelPlan> getTravelPlans(InfoRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("null request");
        }

        ConnectType conType = request.getConType();
        Airport from = request.getFrom();
        Airport to = request.getTo();
        Airport via = request.getVia();
        LocalDate date = request.getTravelDate();

        switch (conType) {
            case DIRECT_FROM:
            case DIRECT_TO:
            case DIRECT_FROM_TO:
                return prepareDirectTravels(conType, from, to, date);
            case DIRECT_OR_INDIRECT_FROM_TO:
            case INDIRECT_FROM_TO_VIA:
                return prepareTravels(conType, from, to, via, date);
            default:
                throw new IllegalArgumentException("unknown connection type");
        }
    }

    private List<TravelPlan> prepareDirectTravels(ConnectType conType, final Airport from, final Airport to,
                                                  LocalDate date) {
        Predicate<Flight> checkDirection;
        switch (conType) {
            case DIRECT_FROM_TO:
                checkDirection = f -> f.isFromTo(from, to);
                break;
            case DIRECT_FROM:
                checkDirection = f -> f.isFrom(from);
                break;
            case DIRECT_TO:
                checkDirection = f -> f.isTo(to);
                break;
            default:
                throw new IllegalArgumentException(conType + " is not suitable here");
        }

        List<TravelPlan> tplist = db.getFlights(date).stream()
                .filter(checkDirection)
                .map(TravelPlan::new)
                .collect(toList());
        Collections.sort(tplist);

        return tplist;
    }

    private List<TravelPlan> prepareTravels(ConnectType conType, final Airport from, final Airport to,
                                            final Airport via, LocalDate date) {
        boolean allowDirect = false;
        Predicate<Flight> checkDirection;
        switch (conType) {
            case DIRECT_OR_INDIRECT_FROM_TO:
                checkDirection = f -> f.isFromOrTo(from, to);
                allowDirect = true;
                break;
            case INDIRECT_FROM_TO_VIA:
                checkDirection = f -> f.isFromTo(from, via) || f.isFromTo(via, to);
                break;
            default:
                throw new IllegalArgumentException(conType + " is not suitable here");
        }

        boolean mapKeyFrom = true;
        boolean mapKeyTo = false;
        Map<Boolean, List<Flight>> m;
        m = db.getFlights(date).stream()
                .filter(checkDirection)
                .collect(partitioningBy(f -> f.isFrom(from) == mapKeyFrom));
        m.entrySet().stream()
                .map(Map.Entry::getValue)
                .forEach(Collections::sort);

        List<TravelPlan> tplist = new ArrayList<>();
        for(Flight f1 : m.get(mapKeyFrom)) {
            if (allowDirect && f1.isTo(to)) {
                tplist.add(new TravelPlan(f1));
                continue;
            }
            for(Flight f2 : m.get(mapKeyTo)) {
                LocalDateTime minDeparture = f1.getArrival().plus(Duration.ofMinutes(TravelPlan.INTERVAL_MINUTES));
                if (f2.isFrom(f1.getTo()) && minDeparture.isBefore(f2.getDeparture())) {
                    tplist.add(new TravelPlan(Arrays.asList(f1, f2)));
                    break;
                }
            }
        }
        Collections.sort(tplist);

        return tplist;
    }
}
