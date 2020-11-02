package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String first, String second) {
        int result = 0;
        for (int i = 0; i < Math.min(first.length(), second.length()); i++) {
            char sourse = first.charAt(i);
            char compared = second.charAt(i);
            if (sourse != compared) {
                result = Character.compare(sourse, compared);
                break;
               }
        }
        result = result == 0 ? Integer.compare(first.length(), second.length()) : result;
        return result;
    }
}
