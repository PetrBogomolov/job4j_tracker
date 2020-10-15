package ru.job4j.tracker.interfeces.action;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.interfeces.input.Input;

public class DeletAction implements UserAction {
    @Override
    public String name() {
        return "=== Delet item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id item: ");
        boolean result = tracker.delete(id);
        if (result) {
            System.out.println("Delete was successful");
        } else {
            System.out.println("Select another option");
        }
        return true;
    }
}
