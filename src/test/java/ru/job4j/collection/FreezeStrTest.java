package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

public class FreezeStrTest {

    FreezeStr freezeStr;

    @Before
    public void setup() {
        freezeStr = new FreezeStr();
    }

    @Test
    public void whenEq() {
        assertThat(freezeStr.equals("Hello", "Hlloe"), is(true));
    }

    @Test
    public void whenNotEq() {
        assertThat(freezeStr.equals("Hello", "Halle"), is(false));
    }

    @Test
    public void whenNotMultiEq() {
        assertThat(freezeStr.equals("heloo", "hello"), is(false));
    }
}