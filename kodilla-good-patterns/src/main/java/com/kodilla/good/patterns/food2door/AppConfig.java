package com.kodilla.good.patterns.food2door;

import com.kodilla.good.patterns.food2door.data.Company;
import com.kodilla.good.patterns.food2door.demands.*;
import com.kodilla.good.patterns.food2door.process.*;
import com.kodilla.good.patterns.food2door.services.*;

import java.util.*;

// dummy implementation of config class. Normally it should read data from config file, for example config.xml
public final class AppConfig {
    private Company appUser;
    private DemandRetriever demandRetriever;
    private  StorageService storageService;
    private  Map<Company, OfferService> offerServices;
    private  Map<Company, OrderService> orderServices;
    private OrderProcessorResultHandler orderProcessorResultHandler;

    public AppConfig(String configFile) {
        // demo
        parseConfigFile(configFile);
    }

    private boolean parseConfigFile(String configFile) {
        // dummy implementation

        appUser = new Company(1, "Food2Door", "ul. Handlowa 10, 12-345 Fudowo", "food2door@example.com", "123456789");
        storageService = new MySqlStorageService("jdbc:mysql://localhost:3306/storage", "supply_processor",
                                                 "IUyhgTy^599*JH");
        demandRetriever = new DefaultDemandRetriever();

        Company efs = new Company(101, "ExtraFoodShop", "ul. Rolnicza 1, 11-111 Kapustowo", "efs@example.com",
                                  "111111111");
        Company hs = new Company(102, "HealthyShop", "ul. Ekologiczna 2, 22-222 Zdrowotniki", "hs@example.com",
                                 "222222222");
        Company gfs =  new Company(103, "GlutenFreeShop", "ul. Bezglutenowa 3, 33-333 Laktoza", "gfs@example.com",
                                   "333333333");

        offerServices = new HashMap<>();
        offerServices.put(efs, new EFSOfferService("jdbc:mysql://efs.com:3306/sale", "f2d", "uiJh*7^78hB"));
        offerServices.put(hs, new HSOfferService("https://health.com/offers","f2d", "JU89uGBt7"));
        offerServices.put(gfs, new GFSOfferService("https://gfs.com/show","f2d", "RRtyu&5^ju"));

        orderServices = new HashMap<>();
        orderServices.put(efs, new EFSOrderService("jdbc:mysql://efs.com:3306/sale", "f2d", "uiJh*7^78hB"));
        orderServices.put(hs, new HSOrderService("https://health.com:8080/order","orderf2d", "IuhJH&^^&"));
        orderServices.put(gfs, new GFSOrderService("https://gfs.com:5678/orders","f2d", "JkJK7&*((U*9"));

        orderProcessorResultHandler = new DefaultOrderProcessorResultHandler();

        return true;
    }

    public Company getAppUser() {
        return appUser;
    }

    public Map<Company, OfferService> getOfferServices() {
        return new HashMap<>(offerServices);
    }

    public DemandRetriever getDemandRetriever() {
        return demandRetriever;
    }

    public Map<Company, OrderService> getOrderServices() {
        return new HashMap<>(orderServices);
    }

    public Rules getRules() {
        return new Rules();
    }

    public StorageService getStorageService() {
        return storageService;
    }

    public OrderProcessorResultHandler getOrderProcessorResultHandler() {
        return orderProcessorResultHandler;
    }
}
