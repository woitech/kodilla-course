package com.kodilla.hibernate.manytomany;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;
@NamedNativeQueries({
    @NamedNativeQuery(
        name = "Company.retrieveCompaniesWithNamePrefix",
        query = "SELECT * FROM COMPANIES WHERE COMPANY_NAME LIKE CONCAT(:PREFIX, '%') ORDER BY COMPANY_NAME",
        resultClass = Company.class
    ),
    @NamedNativeQuery(
    name = "Company.retrieveCompaniesWithNameFragment",
            query = "SELECT * FROM COMPANIES WHERE COMPANY_NAME LIKE CONCAT('%', :FRAGMENT, '%') ORDER BY COMPANY_NAME",
            resultClass = Company.class
    )
})
@Entity
@Table(name = "COMPANIES")
public class Company {
    private int id;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COMPANY_ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "COMPANY_NAME")
    public String getName() {
        return name;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        if (id != company.id) return false;
        return name.equals(company.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        return result;
    }
}