package ru.job4j.collection;

import java.util.*;

public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean result = true;
        String[] sourse = origin.split("[\\pP\\s]");
        String[] copy = line.split("[\\pP\\s]");
        HashSet<String> check = new HashSet<>();
        HashSet<String> check2 = new HashSet<>();
        Collections.addAll(check, sourse);
        Collections.addAll(check2, copy);
        result = check.containsAll(check2);
        return result;
    }
}
