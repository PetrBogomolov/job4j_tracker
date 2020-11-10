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
}