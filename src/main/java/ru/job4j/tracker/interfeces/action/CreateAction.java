package ru.job4j.tracker.interfeces.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.interfeces.input.Input;

public class CreateAction implements UserAction {
    @Override
    public String name() {
        return "=== Create a new Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askString("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        if (item.getName().equals(name)) {
            System.out.println("Create was successful");
        } else {
            System.out.println("Error! Try again");
        }
        return true;
    }
}
