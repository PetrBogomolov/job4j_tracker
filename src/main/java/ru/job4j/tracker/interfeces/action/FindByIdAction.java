package ru.job4j.tracker.interfeces.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.interfeces.input.Input;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Search for a request by id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id item: ");
        Item resultSearch = tracker.findById(id);
        if (resultSearch != null) {
            System.out.print("Result of search: ");
            System.out.println(resultSearch);
        } else {
            System.out.println("The request with this number was not found");
        }
        return true;
    }
}
