package com.kodilla.good.patterns.food2door.data;

public class Company {
    private final int id;
    private final String name;
    private final String address;
    private final String email;
    private final String phone;

    public Company(final int id, final String name, final String address, final String email, final String phone) {
        validate(id, name, address, email, phone);

        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    private void validate(int id, String name, String address, String email, String phone) {
        if (id <= 0) {
            throw new IllegalArgumentException("id <= 0");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("valueless name");
        }
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("valueless address");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("valueless email");
        }
        if (phone == null || phone.isEmpty()) {
            throw new IllegalArgumentException("valueless phone");
        }
    }

    public int getId() {
        return id;
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
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        if (id != company.id) return false;
        if (!name.equals(company.name)) return false;
        if (!address.equals(company.address)) return false;
        if (!email.equals(company.email)) return false;
        return phone.equals(company.phone);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + phone.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
