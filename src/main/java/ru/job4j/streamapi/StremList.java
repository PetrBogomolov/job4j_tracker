package ru.job4j.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StremList {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(- 1, 1, - 2, 2, - 3, 3, - 4, 4, - 5, 5);
        List<Integer> positive = numbers.stream().filter(Int -> Int > 0).collect(Collectors.toList());
        positive.forEach(System.out::print);
    }
}