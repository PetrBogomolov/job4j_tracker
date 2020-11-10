package ru.job4j.streamapi;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void whenConvertArraysThenList() {
        Integer[][] arrays = {
                {1, 2, 3, 4},
                {5, 6, 7, 8}
        };
        List<Integer> result = Matrix.convert(arrays);
        List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(result, is(expect));
    }
}