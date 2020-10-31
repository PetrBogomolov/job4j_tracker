package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String first, String second) {
        int result = 0;
        for (int i = 0; i < first.length() - 1 || i < second.length() - 1; i++) {
            char sourse = first.charAt(i);
            char compared = second.charAt(i);
            if (sourse != compared) {
                result = Character.compare(sourse, compared);
                break;
               }
        }
        int compare = Integer.compare(first.length(), second.length());
        return (result == 0 && first.length() != second.length()) ? compare : result;
    }
}
