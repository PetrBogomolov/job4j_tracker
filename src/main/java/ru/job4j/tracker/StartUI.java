package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Item first = new Item(12, "Petr");
        Item second = new Item(13, "Dima");
        Tracker tracker = new Tracker();
        tracker.add(first);
        tracker.add(second);
        System.out.println(tracker.findById(1));
        System.out.println(tracker.findById(2));
        System.out.println();
        for (Item index: tracker.findAll(tracker.getItems())) {
            System.out.println(index);
        }
        System.out.println();
        for (Item index : tracker.findByName("Petr")) {
            System.out.println(index);
        }
    }
}
