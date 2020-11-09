package ru.job4j.streamapi.profile;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TouristCompany {
    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .distinct()
                .map(Profile::getAddress)
                .sorted(Comparator.comparing(Address::getCity))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Profile> profiles = Arrays.asList(
                new Profile(new Address("city 3", "street", 3, 3),
                        18, "Name 3"),
                new Profile(new Address("city 3", "street", 3, 3),
                        18, "Name 3"),
                new Profile(new Address("city 2", "street", 2, 2),
                        18, "Name 2"),
                new Profile(new Address("city 2", "street", 2, 2),
                        18, "Name 2"),
                new Profile(new Address("city 1", "street", 1, 1),
                        18, "Name 1"),
                new Profile(new Address("city 1", "street", 1, 1),
                        18, "Name 1")
        );
        collect(profiles).forEach(System.out::println);
    }
}
