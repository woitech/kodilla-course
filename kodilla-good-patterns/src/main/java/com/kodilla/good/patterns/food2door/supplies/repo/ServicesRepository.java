package com.kodilla.good.patterns.food2door.supplies.repo;

import com.kodilla.good.patterns.food2door.data.Company;
import com.kodilla.good.patterns.food2door.supplies.SupplyService;
import java.util.*;

public final class ServicesRepository {
    private static final List<SupplyService> SERVICES = new ArrayList<>();
    static {
    // editable section ///////////////////////////////////////////////////////////////////////////////////////////////

    SERVICES.add(new EFSSupplyService(new Company("ExtraFoodShop", "ul. Rolnicza 1, 11-111 Kapustowo", "efs@example.com", "111111111"),
                                      "efs.example.com:1111", "user", "pass"));

    SERVICES.add(new GFSSupplyService(new Company("GlutenFreeShop", "ul. Bezglutenowa 3, 33-333 Laktoza", "gfs@example.com", "222222222"),
                                      "gfs.example.com:2222", "user", "pass"));

    // end of editable section ///////////////////////////////////////////////////////////////////////////////////////
    }

    public static List<SupplyService> getServices() {
        return new ArrayList<>(SERVICES);
    }

    private ServicesRepository() {
    }
}
