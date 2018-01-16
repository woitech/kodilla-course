package com.kodilla.good.patterns.food2door.supplies.repo;

import com.kodilla.good.patterns.food2door.data.*;
import com.kodilla.good.patterns.food2door.external.efs.*;
import com.kodilla.good.patterns.food2door.supplies.*;
import java.util.*;

import static java.util.stream.Collectors.toList;

public final class EFSSupplyService extends AbstractSupplyService implements SupplyService {
    private final EFSClient client = new EFSClient();

    public EFSSupplyService(final Company producer, final String url, final String user, final String pass) {
        super(producer, url, user, pass);
    }

    @Override
    public OrderResult process(Order order) {
        EFSOrder efsOrder = convertToEFSOrder(order);
        if(client.connect(getUrl(), getUser(), getPass())) {
            String id = client.send(efsOrder);
            if (id != null) {
                return new OrderResult(id, order);
            }
        }
        return null;
    }

    @Override
    public List<Offer> getOffers() {
        if(client.connect(getUrl(), getUser(), getPass())) {
            List<EFSOffer> efsOffers = client.fetch();
            if (efsOffers != null) {
                List<Offer> offers = efsOffers.stream()
                                         .map(efsOffer -> convertFromEFSOffer(efsOffer))
                                         .collect(toList());
                return new ArrayList<>(offers);
            }
        }
        return null;
    }

    private EFSOrder convertToEFSOrder(Order o) {
        Product p = o.getProduct();
        return new EFSOrder(o.getDate(), p.getName(), p.getMeasure(), o.getQuantity(), o.getPrice());
    }

    private Offer convertFromEFSOffer(EFSOffer o) {
        Product p = new Product(getProducer(), o.getProductName(), o.getMeasure());
        return new Offer(p, o.getQuantity(), o.getPrice());
    }
}
