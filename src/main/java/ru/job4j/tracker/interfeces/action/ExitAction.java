package ru.job4j.tracker.interfeces.action;

import ru.job4j.tracker.MemTracker;
import ru.job4j.tracker.interfeces.input.Input;
import ru.job4j.tracker.interfeces.output.Output;
import ru.job4j.tracker.interfeces.store.Store;

public class ExitAction implements UserAction {
    private final Output out;

    public ExitAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Exit ===";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("Programm exit!");
        return false;
    }
}
