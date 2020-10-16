package ru.job4j.exception;

import org.junit.Test;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenNumberMinus1ThenIllegalArgumentException() {
        Fact.calc(-1);
    }
}