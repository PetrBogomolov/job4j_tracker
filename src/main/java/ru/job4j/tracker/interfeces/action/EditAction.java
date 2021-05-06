package ru.job4j.tracker.interfeces.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.interfeces.input.Input;
import ru.job4j.tracker.interfeces.output.Output;
import ru.job4j.tracker.interfeces.store.Store;

import java.sql.Timestamp;
import java.util.Date;

public class EditAction implements UserAction {
    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        int id = input.askInt("Enter id item: ");
        String name = input.askString("Enter name new item: ");
        String description = input.askString("Enter description: ");
        Item replacement = new Item(name, description);
        String result = memTracker.replace(id, replacement)
                ? "Replacement was successful" : "Error! Try again";
        out.println(result);
        return true;
    }
}
