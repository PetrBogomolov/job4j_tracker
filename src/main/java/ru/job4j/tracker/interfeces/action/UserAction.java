package ru.job4j.tracker.interfeces.action;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.interfeces.input.Input;

public interface UserAction {

    String name();

    boolean execute(Input input, Tracker tracker);
}
