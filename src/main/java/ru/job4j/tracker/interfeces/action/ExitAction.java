package ru.job4j.tracker.interfeces.action;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.interfeces.input.Input;

public class ExitAction implements UserAction {
    @Override
    public String name() {
        return "=== Exit ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("Programm exit!");
        return false;
    }
}
