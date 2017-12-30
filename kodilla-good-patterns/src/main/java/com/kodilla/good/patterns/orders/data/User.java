package com.kodilla.good.patterns.orders.data;

public class User {
    private final int id;
    private final String name;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String email;
    private final String phone;

    public User(final int id, final String name, final String firstName,
                final String lastName, final String address,
                final String email, final String phone) {
        if (id <= 0 || name == null || name.isEmpty() || firstName == null
            || firstName.isEmpty() || lastName == null || lastName.isEmpty()
            || address == null || address.isEmpty() || email == null
            || email.isEmpty() || phone == null || phone.isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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
        User user = (User) o;
        if (id != user.id) return false;
        if (!name.equals(user.name)) return false;
        if (!firstName.equals(user.firstName)) return false;
        if (!lastName.equals(user.lastName)) return false;
        if (!address.equals(user.address)) return false;
        if (!email.equals(user.email)) return false;
        return phone != null ? phone.equals(user.phone) : user.phone == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
