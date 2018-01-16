package com.kodilla.good.patterns.flights.data;

import java.time.*;
import java.util.*;
import static java.util.stream.Collectors.*;

public final class TravelPlan implements Comparable<TravelPlan> {
    public static final long INTERVAL_MINUTES = 60L;

    private final List<Flight> flights;
    // derived
    private final Airport from;
    private final Airport to;
    private final LocalDateTime departure;
    private final LocalDateTime arrival;
    private final Duration duration;

    public TravelPlan(final List<Flight> flights) {
        validate(flights);

        this.flights = flights;

        Flight first = flights.get(0);
        Flight last = flights.get(flights.size() - 1);
        this.from = first.getFrom();
        this.to = last.getTo();
        this.departure = first.getDeparture();
        this.arrival = last.getArrival();
        this.duration = Duration.between(first.getDeparture(), last.getArrival());
    }

    public TravelPlan(final Flight flight) {
        if (flight == null) {
            throw new IllegalArgumentException("null Flight");
        }

        this.flights = new ArrayList<>();
        this.flights.add(flight);
        this.from = flight.getFrom();
        this.to = flight.getTo();
        this.duration = flight.getDuration();
        this.departure = flight.getDeparture();
        this.arrival = flight.getArrival();
    }

    private void validate(List<Flight> flights) {
        if(flights == null || flights.isEmpty()) {
            throw new IllegalArgumentException("valueless flights list");
        }
        Iterator<Flight> it = flights.iterator();
        Flight flight = null;
        while(it.hasNext()) {
            Flight f = flight;
            flight = it.next();
            if (flight == null) {
                throw new IllegalArgumentException("null Flight");
            }
            if (f == null) { continue; }
            if (f.getTo() != flight.getFrom()) {
                throw new IllegalArgumentException("previous 'to' and next 'from' are different");
            }
            LocalDateTime minDepart = f.getArrival().plus(Duration.ofMinutes(INTERVAL_MINUTES));
            if (!minDepart.isBefore(flight.getDeparture())) {
                throw new IllegalArgumentException("interval is too small");
            }
        }
    }

    public List<Flight> getFlights() {
        return new ArrayList<>(flights);
    }

    public Airport getFrom() {
        return from;
    }

    public Airport getTo() {
        return to;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    public Duration getDuration() {
        return duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelPlan tplan = (TravelPlan) o;
        return flights.equals(tplan.flights);
    }

    @Override
    public int hashCode() {
        return flights.hashCode();
    }

    public String toFineString() {
        return "=== Travel plan from " + from.getCity() + " to " + to.getCity() + " ===" +
               flights.stream()
                    .map(f -> "\n\t" + f.toFineString().replace("\n","\n\t"))
                    .collect(joining("\n", "\n", "\n\n")) +
               "Total travel time: " + Flight.formatFlightDuration(duration);
    }

    @Override
    public String toString() {
        return "TravelPlan{" +
                "flights=" + flights +
                ", duration=" + duration +
                ", from=" + from +
                ", to=" + to +
                '}';
    }

    @Override
    public int compareTo(TravelPlan o) {
        final int EQUAL = 0;

        if (this == o) return EQUAL;
        int comparison = this.from.compareTo(o.from);
        if (comparison != EQUAL) { return comparison; }
        comparison = this.to.compareTo(o.to);
        if (comparison != EQUAL) { return comparison; }
        comparison = this.departure.compareTo(o.departure);
        if (comparison != EQUAL) { return comparison; }
        return this.duration.compareTo(o.duration);
    }
}
