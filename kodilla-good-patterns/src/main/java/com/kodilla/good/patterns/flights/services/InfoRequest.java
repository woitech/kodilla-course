package com.kodilla.good.patterns.flights.services;

import com.kodilla.good.patterns.flights.data.*;
import java.time.LocalDate;

import static com.kodilla.good.patterns.flights.data.ConnectType.*;

public final class InfoRequest {
    private final ConnectType conType;
    private final Airport from;
    private final Airport to;
    private final Airport via;
    private final LocalDate travelDate;

    // InfoRequest valid states depend on connection type:
    // DIRECT_FROM
    //     requires: from != null && to == null && via == null
    // DIRECT_TO
    //     requires: from == null && to != null && via == null
    // DIRECT_FROM_TO
    //     requires: from != null && to != null && via == null
    // DIRECT_OR_INDIRECT_FROM_TO
    //     requires: from != null && to != null && via == null
    // INDIRECT_FROM_TO_VIA
    //     requires: from != null && to != null && via != null
    // travelDate has to be always not null
    public InfoRequest(final ConnectType conType, final Airport from, final Airport to, final Airport via,
                       final LocalDate travelDate) {
       validate(conType, from, to, via, travelDate);

       this.conType = conType;
       this.from = from;
       this.to = to;
       this.via = via;
       this.travelDate = travelDate;
    }

    public void validate(ConnectType conType, Airport from, Airport to, Airport via, LocalDate travelDate) {
        if (travelDate == null) {
            throw new IllegalArgumentException("null date");
        }
        if (conType == DIRECT_FROM && (from == null || to != null || via != null) ||
            conType == DIRECT_TO && (from != null || to == null || via != null) ||
            (conType == DIRECT_FROM_TO || conType == DIRECT_OR_INDIRECT_FROM_TO) &&
                (from == null || to == null || via != null || from == to) ||
            conType == INDIRECT_FROM_TO_VIA &&
                (from == null || to == null || via == null || from == to || from == via || via == to)) {
            throw new IllegalArgumentException("Bad arguments arrangement. Check if they are suitable for connection " +
                                               "type " + conType + " and if all given airports are different.");
        }
    }

    public ConnectType getConType() {
        return conType;
    }

    public Airport getFrom() {
        return from;
    }

    public Airport getTo() {
        return to;
    }

    public Airport getVia() {
        return via;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InfoRequest that = (InfoRequest) o;
        if (conType != that.conType) return false;
        if (from != that.from) return false;
        if (to != that.to) return false;
        if (via != that.via) return false;
        return travelDate.equals(that.travelDate);
    }

    @Override
    public int hashCode() {
        int result = conType.hashCode();
        result = 31 * result + from.hashCode();
        result = 31 * result + to.hashCode();
        result = 31 * result + via.hashCode();
        result = 31 * result + travelDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "InfoRequest{" +
                "conType=" + conType +
                ", from=" + from +
                ", to=" + to +
                ", via=" + via +
                ", travelDate=" + travelDate +
                '}';
    }
}
