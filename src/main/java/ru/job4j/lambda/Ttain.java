package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Ttain {
    public static void main(String[] args) {
        Predicate<Integer>  predicate = i -> (i > 0 && i % 2 == 0);
        System.out.println(predicate.test(4));
        BinaryOperator<String> operator = (string1, string2) -> string1 + string2;
        System.out.println(operator.apply("Tom", " and Jerry"));
        List<String> names = Arrays.asList("jjvj", "vuyvu", "ubii");
        Consumer<String> out = System.out::println;
        names.forEach(out);
    }
}
