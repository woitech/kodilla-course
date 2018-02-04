package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private ProductDao productDao;

    @After
    public void after() {
        System.out.println("after");
    }

    @Test
    public void testSaveNewProducts() {
        // Given
        Product product1 = new Product("Bread");
        Product product2 = new Product("Butter");
        Product product3 = new Product("Cheese");

        Invoice invoice = new Invoice("F/1/2018");
        List<Item> items = invoice.getItems();
        Item item1 = new Item(product1, new BigDecimal("3.20"), 3);
        items.add(item1);
        item1.setInvoice(invoice);
        Item item2 = new Item(product2, new BigDecimal("4.60"), 1);
        items.add(item2);
        item2.setInvoice(invoice);
        Item item3 = new Item(product3, new BigDecimal("5.35"), 2);
        items.add(item3);
        item3.setInvoice(invoice);

        // When
        invoiceDao.save(invoice);
        int id = invoice.getId();
        Invoice readInvoice = invoiceDao.findOne(id);
        List<Item> itemsFromSavedInvoice = invoice.getItems();
        List<Item> itemsFromReadInvoice = readInvoice.getItems();

        // Then
        try {
            assertEquals(invoice, readInvoice);
            assertEquals(3, items.size());
            assertEquals(3, itemsFromSavedInvoice.size());
            assertEquals(3, itemsFromReadInvoice.size());
            assertEquals(item1, items.get(0));
            assertEquals(item2, items.get(1));
            assertEquals(item3, items.get(2));
            assertEquals(item1, itemsFromSavedInvoice.get(0));
            assertEquals(item2, itemsFromSavedInvoice.get(1));
            assertEquals(item3, itemsFromSavedInvoice.get(2));
            assertEquals(item1, itemsFromReadInvoice.get(0));
            assertEquals(item2, itemsFromReadInvoice.get(1));
            assertEquals(item3, itemsFromReadInvoice.get(2));
        } catch (AssertionError error) {
            throw error;
        } finally {
            invoiceDao.delete(id);
        }
    }

    // testSaveReadProducts() przechodzi gdy jest w Item.java line 43: CascadeType.MERGE.
    // Przy PERSIST lub ALL nie można zapisać item.setInvoice(invoice) (tutaj linia 96)
    // Z kolei przy MERGE nie mozna zapisać invoice w testSaveNewProducts().
    // Klucz: poznanie czystego Hibernate
    // W rzeczywistości najczęściej do generowania faktur wykorzystuje się produkty istniejace już w bazie,
    // stąd pokusa zrobienia tego testu.
    @Test
    public void testSaveReadProducts() {
        // Given
        Product product = new Product("Tomato");
        productDao.save(product);
        int productId = product.getId();
        Product readProduct = productDao.findOne(productId);

        Invoice invoice = new Invoice("F/2/2018");
        Item item = new Item(readProduct, new BigDecimal("3.20"), 3);
        invoice.getItems().add(item);
        item.setInvoice(invoice);
        // to try-catch w środku testu niezbyt mi się podoba,
        // ale musiałem, zeby uniknąć ciągłego naprawiania danych w bazie
        // dlatego proszę tego nie traktować jako formalnego testu
        int invoiceId = -1;
        try {
            // When
            invoiceDao.save(invoice);
            invoiceId = invoice.getId();
            Invoice readInvoice = invoiceDao.findOne(invoiceId);
            List<Item> itemsFromReadInvoice = readInvoice.getItems();

            // Then
            assertEquals(invoice, readInvoice);
            assertEquals(1, itemsFromReadInvoice.size());
            assertEquals(product, itemsFromReadInvoice.get(0).getProduct());

        } catch (AssertionError error) {
            throw error;
        } catch (Exception exc) {
            throw exc;
        } finally {
            // CleanUp
            try { invoiceDao.delete(invoiceId); } catch (Exception e) { fail(); }
            try { productDao.delete(productId); } catch (Exception e) { fail(); }
        }
    }
}
