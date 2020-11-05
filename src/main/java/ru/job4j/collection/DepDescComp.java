package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftArray = left.split("/");
        String[] rightArray = right.split("/");
        int min = Math.min(left.length(), right.length());
        int result = rightArray[0].compareTo(leftArray[0]);
        if (result == 0) {
            String a = left.substring(min);
            String b = right.substring(min);
            result = a.compareTo(b);
        }
        return result;
    }
}
