package ru.job4j.collection.combinedcomparator;

import java.util.Comparator;

public class SortByPriorityDecrease implements Comparator<Job> {
    @Override
    public int compare(Job first, Job second) {
        return Integer.compare(second.getPriority(), first.getPriority());
    }
}
