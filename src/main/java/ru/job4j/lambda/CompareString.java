package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CompareString {
    public static void sort(List<String> list) {
        Comparator<String> comparator = (string1, string2) -> {
            System.out.println("compare - " + string1 + ":" + string2);
            return string1.compareTo(string2);
        };
        list.sort(comparator);
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "Petr",
                "Ivan",
                "Andrei",
                "Victor"
        );
        sort(list);
        System.out.println(list);
    }
}
