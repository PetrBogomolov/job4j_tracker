package ru.job4j.collection;

import java.util.Collections;
import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean result = true;
        String[] origin = originText.split(" ");
        String[] copy = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        Collections.addAll(check, origin);
        for (String word : copy) {
           result = check.contains(word);
           break;
        }
        return result;
    }
}
