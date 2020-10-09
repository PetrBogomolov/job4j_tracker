package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item[] getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Tracker{" +
                "items=" + Arrays.toString(items) +
                ", ids=" + ids +
                ", size=" + size +
                '}';
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll(Item[] items) {
        Item[] result = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            if (items[index] != null) {
                result[size] = items[index];
                size++;
            }
        }
        return Arrays.copyOf(result, size);
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            if (items[index].getName().equals(key)) {
                result[size] = items[index];
                size++;
            }
        }
        return Arrays.copyOf(result, size);
    }

    public Item findById(int id) {
        Item result = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                result = item;
                break;
            }
        }
        return result;
    }
}