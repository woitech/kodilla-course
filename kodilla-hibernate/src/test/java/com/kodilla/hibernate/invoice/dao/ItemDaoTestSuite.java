package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemDaoTestSuite {
    @Autowired
    private ItemDao itemDao;

    @Autowired
    private ProductDao productDao;

    @Test
    public void testSave() {
        // Given
        Product productTomato = new Product("Tomatox");
        Item itemTomato = new Item(productTomato, new BigDecimal(0.01), 3);

        //Product readProductButter = productDao.findOne(2);
        //Item itemButter = new Item(readProductButter, new BigDecimal("5.37"), 2);

        // When
        itemDao.save(itemTomato);
        int id1 = itemTomato.getId();
        Item readItemTomato = itemDao.findOne(id1);

        //itemDao.save(itemButter);
        //int id2 = itemButter.getId();
        //Item readItemButter = itemDao.findOne(id2);


        // Then
        assertEquals("Tomatox", readItemTomato.getProduct().getName());
        //assertEquals(0, new BigDecimal("30").compareTo(readItemBread.getValue()));
        //assertEquals("Butter", readItemButter.getProduct().getName());
        //assertEquals(0, new BigDecimal("10.74").compareTo(readItemButter.getValue()));
        // CleanUp
        // itemDao.delete(id);
    }
}
