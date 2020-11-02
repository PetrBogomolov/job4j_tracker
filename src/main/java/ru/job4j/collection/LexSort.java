package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftArray = left.split("\\D+");
        String[] rightArray = right.split("\\D+");
        int leftInt = 0;
        int rightInt = 0;
        for (String i : leftArray) {
            leftInt = Integer.parseInt(i);
        }
        for (String i : rightArray) {
            rightInt = Integer.parseInt(i);
        }
        return Integer.compare(leftInt, rightInt);
    }
}
