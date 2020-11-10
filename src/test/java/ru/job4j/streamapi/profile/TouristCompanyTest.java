package ru.job4j.streamapi.profile;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TouristCompanyTest {

    @Test
    public void whenCollectProfileByAddressAndSortByCity() {
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
        List<Address> result = TouristCompany.collect(profiles);
        List<Address> expected = Arrays.asList(
                new Address("city 1", "street", 1, 1),
                new Address("city 2", "street", 2, 2),
                new Address("city 3", "street", 3, 3)
        );
        assertThat(result, is(expected));
    }

}