package ru.job4j.tracker.interfeces.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.MemTracker;
import ru.job4j.tracker.interfeces.input.Input;
import ru.job4j.tracker.interfeces.output.Output;
import ru.job4j.tracker.interfeces.store.Store;

public class CreateAction implements UserAction {
    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Create a new Item ====";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        String name = input.askString("Enter name: ");
        Item item = new Item(name);
        memTracker.add(item);
        if (item.getName().equals(name)) {
            out.println("Create was successful");
        } else {
            out.println("Error! Try again");
        }
        return true;
    }
}
