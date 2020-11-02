package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Arrays;

public class LexSortTest {
    @Test
    public void sortNum1and2and10() {
        String[] input = {
                "772. Task.",
                "779. Task.",
                "773. Task."
        };
        String[] out = {
                "772. Task.",
                "773. Task.",
                "779. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }
}