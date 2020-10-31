package ru.job4j.tracker.comparator;

import ru.job4j.tracker.Item;

import java.util.Comparator;

public class SotrByIdIncrease implements Comparator<Item> {
    @Override
    public int compare(Item first, Item second) {
        return Integer.compare(first.getId(), second.getId());
    }
}
