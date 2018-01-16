package com.kodilla.good.patterns.food2door.supplies.repo;

import com.kodilla.good.patterns.food2door.data.*;
import com.kodilla.good.patterns.food2door.external.gfs.*;
import com.kodilla.good.patterns.food2door.supplies.*;
import java.util.*;

import static java.util.stream.Collectors.toList;

public final class GFSSupplyService extends AbstractSupplyService implements SupplyService {
    private static final int OFFER_PRODUCT_NAME_IDX = 0;
    private static final int OFFER_MEASURE_IDX = 1;
    private static final int OFFER_QUANTITY_IDX = 2;
    private static final int OFFER_PRICE_IDX = 3;

    private final GFSClient client = new GFSClient();

    public GFSSupplyService(final Company producer, final String url, final String user, final String pass) {
        super(producer, url, user, pass);
    }

    @Override
    public OrderResult process(Order order) {
        String[] efsOrder = convertToGFSOrder(order);
        if(client.connect(getUrl(), getUser(), getPass())) {
            String id = client.sendOrder(efsOrder);
            if (id != null) {
                return new OrderResult(id, order);
            }
        }
        return null;
    }

    @Override
    public List<Offer> getOffers() {
        if(client.connect(getUrl(), getUser(), getPass())) {
            String[][] gfsOffers = client.getOffers();
            if (gfsOffers != null) {
                List<Offer> offers = Arrays.asList(gfsOffers).stream()
                                         .map(gfsOffer -> convertFromGFSOffer(gfsOffer))
                                         .collect(toList());
                return new ArrayList<>(offers);
            }
        }
        return null;
    }

    private String[] convertToGFSOrder(Order o) {
        Product p = o.getProduct();
        return new String[] {o.getDate().toString(), p.getName(), p.getMeasure(), Double.toString(o.getQuantity()),
                             Double.toString(o.getPrice())};
    }

    private Offer convertFromGFSOffer(String[] o) {
        try {
            Product p = new Product(getProducer(), o[OFFER_PRODUCT_NAME_IDX], o[OFFER_MEASURE_IDX]);
            return new Offer(p, Double.parseDouble(o[OFFER_PRICE_IDX]), Double.parseDouble(o[OFFER_QUANTITY_IDX]));
        } catch (IllegalArgumentException  | NullPointerException exc) {
            // todo: log(exc)
        }
        return null;
    }
}
