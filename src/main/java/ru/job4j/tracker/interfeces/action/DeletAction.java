package ru.job4j.tracker.interfeces.action;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.interfeces.input.Input;
import ru.job4j.tracker.interfeces.output.Output;

public class DeletAction implements UserAction {
    private final Output out;

    public DeletAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delet item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id item: ");
        boolean result = tracker.delete(id);
        if (result) {
            out.println("Delete was successful");
        } else {
            out.println("Select another option");
        }
        return true;
    }
}
