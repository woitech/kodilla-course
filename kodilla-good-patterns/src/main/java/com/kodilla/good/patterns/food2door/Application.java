package com.kodilla.good.patterns.food2door;

import com.kodilla.good.patterns.food2door.supplies.*;
import com.kodilla.good.patterns.food2door.supplies.repo.*;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // Adding a new service
        // Developer implements interface SupplyService in subpackage supplies.repo using a client of remote service,
        // then edits supplies.repo.ServicesRepository.java. Client library can be provided by producer or it can be
        // a common library like web client, database client, etc.
        // todo: using a config file and the Java reflection API would eliminate re-editions of ServicesRepository

        List<SupplyService> services = ServicesRepository.getServices();
        new MainSystemSimpleExample(services).useServices();
    }
}
