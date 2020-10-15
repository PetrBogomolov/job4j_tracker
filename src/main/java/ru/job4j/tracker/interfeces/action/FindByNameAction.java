package ru.job4j.tracker.interfeces.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.interfeces.input.Input;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Search for a request by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askString("Enter name item: ");
        Item[] resultSearch = tracker.findByName(name);
        if (resultSearch.length > 0) {
            System.out.println("Result of search: ");
            for (Item index: resultSearch) {
                System.out.println(index);
            }
        } else {
            System.out.println("The request with this name was not found");
        }
        return true;
    }
}
