package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
public class EmploymentFacade {
    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmploymentFacade.class);
    private static final String ERR_UNEXPECTED = "Unexpected error";
    private static final String ERR_NULL_FRAGMENT = "Null fragment string";

    public Optional<List<Company>> findCompanyByNameFragment(String s) {
        List<Company> result = null;
        if (s == null) {
            LOGGER.error(ERR_NULL_FRAGMENT);
        } else {
            LOGGER.info("Finding companies with name containing: " + s);
            try {
                result = companyDao.retrieveCompaniesWithNameFragment(s);
            } catch (RuntimeException e) {
                LOGGER.error(ERR_UNEXPECTED, e);
            }
        }
        return ofNullable(result);
    }

    public Optional<List<Employee>> findEmployeeByLastNameFragment(String s) {
        List<Employee> result = null;
        if (s == null) {
            LOGGER.error(ERR_NULL_FRAGMENT);
        } else {
            LOGGER.info("Finding employees with last name containing: " + s);
            try {
                result = employeeDao.retrieveEmployeesWithLastNameFragment(s);
            } catch (RuntimeException e) {
                LOGGER.error(ERR_UNEXPECTED, e);
            }
        }
        return ofNullable(result);
    }
}
