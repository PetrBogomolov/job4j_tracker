package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.add(new Item("Petr"));
        tracker.add(new Item("Dima"));
        System.out.println(tracker.findById(1));
        System.out.println(tracker.findById(2));
        System.out.println();
        for (Item index: tracker.findAll()) {
            System.out.println(index);
        }
        System.out.println();
        for (Item index : tracker.findByName("Petr")) {
            System.out.println(index);
        }
    }
}
