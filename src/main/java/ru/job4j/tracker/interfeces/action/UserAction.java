package ru.job4j.tracker.interfeces.action;

import ru.job4j.tracker.interfeces.input.Input;
import ru.job4j.tracker.interfeces.store.Store;

public interface UserAction {

    String name();

    boolean execute(Input input, Store memTracker);
}
