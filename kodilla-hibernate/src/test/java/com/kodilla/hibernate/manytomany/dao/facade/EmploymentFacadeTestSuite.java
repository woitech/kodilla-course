package com.kodilla.hibernate.manytomany.dao.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import com.kodilla.hibernate.manytomany.facade.EmploymentFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmploymentFacadeTestSuite {
    @Autowired
    private EmploymentFacade employment;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmploymentFacadeTestSuite.class);

    @Test
    public void testFindCompany() {
        // Given
        final String fragment = "ABC";

        List<Company> searched = new ArrayList<>();
        searched.add(new Company("Abc"));
        searched.add(new Company("ABCSuffix"));
        searched.add(new Company("PrefixAbcSuffix"));
        searched.add(new Company("Prefixabc"));
        searched.sort(Comparator.comparing(c -> c.getName().toUpperCase()));

        List<Company> ignored = new ArrayList<>();
        ignored.add(new Company("Test ab c"));
        ignored.add(new Company("Test X"));
        ignored.add(new Company("Test Y"));
        ignored.add(new Company("Test Z"));

        try {
            associateAndSave(searched.get(3), new Employee("Name1", "Lastname1"));
            associateAndSave(ignored.get(0), new Employee("Name2", "Lastname2"));
            associateAndSave(searched.get(1), new Employee("Name3", "Lastname3"));
            associateAndSave(ignored.get(1), new Employee("Name4", "Lastname4"));
            associateAndSave(searched.get(2), new Employee("Name5", "Lastname5"));
            associateAndSave(ignored.get(2), new Employee("Name6", "Lastname6"));
            associateAndSave(searched.get(0), new Employee("Name7", "Lastname7"));
            associateAndSave(ignored.get(3), new Employee("Name8", "Lastname8"));

            // When
            Optional<List<Company>> found = employment.findCompanyByNameFragment(fragment);

            // Then
            assertTrue(found.isPresent());
            assertEquals(searched, found.get());

        } finally {
            final Company[] companyArray = {};
            companiesCleanUp(searched.toArray(companyArray));
            companiesCleanUp(ignored.toArray(companyArray));
        }
    }

    @Test
    public void testFindEmployee() {
        // Given
        final String fragment = "ABC";

        List<Employee> searched = new ArrayList<>();
        searched.add(new Employee("Name1", "Abc"));
        searched.add(new Employee("Name2", "ABCSuffix"));
        searched.add(new Employee("Name3", "PrefixAbcSuffix"));
        searched.add(new Employee("Name4", "Prefixabc"));
        searched.sort(Comparator.comparing(e -> e.getLastname().toUpperCase()));

        List<Employee> ignored = new ArrayList<>();
        ignored.add(new Employee("Name1", "Test ab c"));
        ignored.add(new Employee("Name2", "Test X"));
        ignored.add(new Employee("Name3", "Test Y"));
        ignored.add(new Employee("Name4", "Test Z"));

        Company company1 = new Company("Test Company 1");
        Company company2 = new Company("Test Company 2");

        try {
            associate(company1,searched.get(3));
            associate(company1,ignored.get(0));
            associate(company1,searched.get(1));
            associateAndSave(company1,ignored.get(1));
            associate(company2,searched.get(2));
            associate(company2,ignored.get(2));
            associate(company2,searched.get(0));
            associateAndSave(company2,ignored.get(3));

            // When
            Optional<List<Employee>> found = employment.findEmployeeByLastNameFragment(fragment);

            // Then
            assertTrue(found.isPresent());
            assertEquals(searched, found.get());

        } finally {
            companiesCleanUp(company1, company2);
        }
    }

    private void associate(Company c, Employee e) {
        assertNotNull(c);
        assertNotNull(e);
        e.getCompanies().add(c);
        c.getEmployees().add(e);
    }

    private void associateAndSave(Company c, Employee e) {
        associate(c, e);
        companyDao.save(c);
    }

    private void companiesCleanUp(Company... companies) {
        for(Company c : companies) {
            try {
                companyDao.delete(c.getId());
            } catch (Exception exc) {
                LOGGER.warn("CleanUp: " + exc);
            }
        }
    }
}
