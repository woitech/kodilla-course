package com.kodilla.good.patterns.food2door.data;

import static com.kodilla.good.patterns.food2door.Validator.*;

public final class Company {
    private final String name;
    private final String address;
    private final String email;
    private final String phone;

    public Company(final String name, final String address, final String email, final String phone) {
        validateString(name, "valueless name");
        validateString(address, "valueless address");
        validateString(email, "valueless email");
        validateString(phone, "valueless phone");

        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        if (!name.equals(company.name)) return false;
        if (!address.equals(company.address)) return false;
        if (!email.equals(company.email)) return false;
        return phone.equals(company.phone);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + phone.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
