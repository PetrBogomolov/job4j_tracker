package ru.job4j.streamapi.profile;

import java.util.Objects;

public class Profile {
    private Address address;
    private int age;
    private String name;

    public Profile(Address address, int age, String name) {
        this.address = address;
        this.age = age;
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Profile profiles = (Profile) o;
        return age == profiles.age
                && Objects.equals(address, profiles.address)
                && Objects.equals(name, profiles.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, age, name);
    }

    @Override
    public String toString() {
        return "Profile{"
                + "address=" + address
                + ", age=" + age
                + ", name='" + name + '\''
                + '}';
    }
}
