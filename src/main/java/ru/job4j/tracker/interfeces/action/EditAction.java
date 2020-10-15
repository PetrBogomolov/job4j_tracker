package ru.job4j.tracker.interfeces.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.interfeces.input.Input;
import ru.job4j.tracker.interfeces.output.Output;

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
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id item: ");
        String name = input.askString("Enter name new item: ");
        Item replacement = new Item(name);
        String result = tracker.replace(id, replacement) ? "Replacement was successful" : "Error! Try again";
        out.println(result);
        return true;
    }
}
