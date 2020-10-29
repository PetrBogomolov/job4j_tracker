package ru.job4j.tracker.interfeces.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.interfeces.input.Input;
import ru.job4j.tracker.interfeces.output.Output;
import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Search for a request by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askString("Enter name item: ");
        List<Item> resultSearch = tracker.findByName(name);
        if (resultSearch.size() > 0) {
            out.println("Result of search: ");
            for (Item index: resultSearch) {
                out.println(index);
            }
        } else {
            out.println("The request with this name was not found");
        }
        return true;
    }
}
