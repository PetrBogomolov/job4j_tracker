package ru.job4j.collection.combinedcomparator;

import java.util.Comparator;

public class SortByNameDecrease implements Comparator<Job> {
    @Override
    public int compare(Job first, Job second) {
        return second.getName().compareTo(first.getName());
    }
}
