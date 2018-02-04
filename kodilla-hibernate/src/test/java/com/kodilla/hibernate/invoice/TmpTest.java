package com.kodilla.hibernate.invoice;

import com.kodilla.hibernate.invoice.dao.ProductDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TmpTest {
    @Autowired
    private ProductDao productDao;

    @Test
    public void testProduct() {
        Product p = new Product(null);
        System.out.println(p);
    }
}
