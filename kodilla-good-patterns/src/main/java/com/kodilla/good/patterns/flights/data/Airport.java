package com.kodilla.good.patterns.flights.data;

// Airports by ICAO codes
public enum Airport {
    EPGD("Gdańsk", "Port lotniczy Gdańsk-Rębiechowo im. Lecha Wałęsy"),
    EPKT("Katowice", "Międzynarodowy Port Lotniczy Katowice w Pyrzowicach"),
    EPKK("Kraków", "Port lotniczy Kraków-Balice im. Jana Pawła II"),
    EPPO("Poznań", "Port lotniczy Poznań-Ławica im. Henryka Wieniawskiego"),
    EPWA("Warszawa", "Lotnisko Chopina w Warszawie"),
    EPWR("Wrocław", "Port lotniczy Wrocław-Strachowice im. Mikołaja Kopernika");

    private final String city;
    private final String name;

    private Airport(String city, String name) {
        this.city = city;
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public String toFineString() {
        return city + " \"" + name + "\" " + '(' + name() + ')';
    }
}
