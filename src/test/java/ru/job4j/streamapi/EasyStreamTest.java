package ru.job4j.streamapi;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EasyStreamTest {

    private EasyStream easyStream;

    @Before
    public void setup() {
        easyStream = new EasyStream();
    }

    @Test
    public void whenEmptySource() {
        var rsl = easyStream.of(List.of(0)).collect();
        assertThat(rsl, is(List.of(0)));
    }

    @Test
    public void whenFilledSource() {
        var rsl = easyStream.of(List.of(1, 2, 3))
                .collect();
        assertThat(rsl, is(List.of(1, 2, 3)));
    }

    @Test
    public void whenFilteredSource() {
        var rsl = easyStream.of(new ArrayList<>(Arrays.asList(1, 2, 3)))
                .filter(e -> e == 2)
                .collect();
        assertThat(rsl, is(List.of(2)));
    }

    @Test
    public void whenMappedSource() {
        var rsl = easyStream.of(new ArrayList<>(Arrays.asList(1, 2, 3)))
                .map(e -> e * 2)
                .collect();
        assertThat(rsl, is(List.of(2, 4, 6)));
    }

    @Test
    public void whenFilteredMappedSource() {
        var rsl = easyStream.of(new ArrayList<>(Arrays.asList(1, 2, 3)))
                .filter(e -> e == 2)
                .map(e -> e * 2)
                .collect();
        assertThat(rsl, is(List.of(4)));
    }

    @Test
    public void whenMappedFilteredSource() {
        var rsl = easyStream.of(new ArrayList<>(Arrays.asList(1, 2, 3)))
                .map(e -> e * 2)
                .filter(e -> e == 2)
                .collect();
        assertThat(rsl, is(List.of(2)));
    }

    @Test
    public void whenMultyFilterSource() {
        var rsl = easyStream.of(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)))
                .filter(e -> e >= 2)
                .filter(e -> e <= 4)
                .collect();
        assertThat(rsl, is(List.of(2, 3, 4)));
    }

}