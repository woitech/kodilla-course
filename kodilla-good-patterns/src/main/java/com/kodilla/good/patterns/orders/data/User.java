package com.kodilla.good.patterns.orders.data;

public class User {
    private final int id;
    private final String nickname;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String email;
    private final String phone;

    public User(final int id, final String nickname, final String firstName,
                final String lastName, final String address,
                final String email, final String phone) {
        validate(id, nickname, firstName, lastName, address, email, phone);

        this.id = id;
        this.nickname = nickname;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    private void validate(int id, String nickname, String firstName,
                          String lastName, String address, String email,
                          String phone) {
        if (id <= 0) {
            throw new IllegalArgumentException("id less or equals zero");
        }
        if (nickname == null || nickname.isEmpty()) {
            throw new IllegalArgumentException("valueless nickname");
        }
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("valueless firstName");
        }
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("valueless lastName");
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

    public String getNickname() {
        return nickname;
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
        if (!nickname.equals(user.nickname)) return false;
        if (!firstName.equals(user.firstName)) return false;
        if (!lastName.equals(user.lastName)) return false;
        if (!address.equals(user.address)) return false;
        if (!email.equals(user.email)) return false;
        return phone != null ? phone.equals(user.phone) : user.phone == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + nickname.hashCode();
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
                ", nickname='" + nickname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
