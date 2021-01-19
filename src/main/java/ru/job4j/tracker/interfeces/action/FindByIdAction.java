package ru.job4j.tracker.interfeces.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.MemTracker;
import ru.job4j.tracker.interfeces.input.Input;
import ru.job4j.tracker.interfeces.output.Output;
import ru.job4j.tracker.interfeces.store.Store;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Search for a request by id ===";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        int id = input.askInt("Enter id item: ");
        Item resultSearch = memTracker.findById(id);
        if (resultSearch != null) {
            out.println("Result of search: ");
            out.println(resultSearch);
        } else {
            out.println("The request with this number was not found");
        }
        return true;
    }
}
