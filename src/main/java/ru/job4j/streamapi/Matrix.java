package ru.job4j.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Matrix {
    public static List<Integer> convert(Integer[][] arrays) {
        return Arrays.stream(arrays).flatMap(Stream::of).collect(Collectors.toList());
    }
}
