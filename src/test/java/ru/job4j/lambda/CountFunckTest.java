package ru.job4j.lambda;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CountFunckTest {

    private CountFunck countFunck;

    @Before
    public void setup() {
        countFunck = new CountFunck();
    }

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = countFunck.createLinearFunc(5, 8);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenSquareResults() {
        List<Double> result = countFunck.createSquareFunc(5, 8);
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        List<Double> result = countFunck.createExponentialFunc(5, 8);
        List<Double> expected = Arrays.asList(3125D, 46656D, 823543D);
        assertThat(result, is(expected));
    }
}