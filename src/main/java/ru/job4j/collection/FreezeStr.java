package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public  boolean equals(String left, String right) {
        if (left.length() != right.length()) {
            return false;
        }
        Map<Character, Integer> mapLeft = conversion(left);
        Map<Character, Integer> mapRight = conversion(right);
        for (Character character : mapLeft.keySet()) {
            if (!mapLeft.get(character).equals(mapRight.get(character))) {
                return false;
            }
        }
        return true;
    }

    public Map<Character, Integer> conversion(String sourse) {
        Map<Character, Integer> result = new HashMap<>();
        for (Character character : sourse.toCharArray()) {
           int count = 1;
           if (result.containsKey(character)) {
               count = result.get(character);
               count++;
           }
           result.put(character, count);
        }
        return result;
    }
}
