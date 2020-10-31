package ru.job4j.collection.treeset;

import org.junit.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void whenSortByName() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
        users.add(new User("Pavel", 35));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Ivan", 31)));
        assertThat(it.next(), is(new User("Pavel", 35)));
        assertThat(it.next(), is(new User("Petr", 32)));
    }

    @Test
    public void whenSortByAge() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 32));
        users.add(new User("Petr", 31));
        users.add(new User("Petr", 35));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Petr", 31)));
        assertThat(it.next(), is(new User("Petr", 32)));
        assertThat(it.next(), is(new User("Petr", 35)));
    }

    @Test
    public void whenComparePertVSIvanThenGreaten0() {
        int rsl = new User("Petr", 32).compareTo(new User("Ivan", 31));
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparePertEqualPetrThen0() {
        int rsl = new User("Petr", 32).compareTo(new User("Petr", 32));
        int expected = 0;
        assertThat(rsl, is(expected));
    }
}