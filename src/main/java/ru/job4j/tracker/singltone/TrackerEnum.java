package ru.job4j.tracker.singltone;

import ru.job4j.tracker.interfeces.store.MemTracker;

public enum TrackerEnum {
    INSTANCE;

    private MemTracker memTracker = new MemTracker();

    public MemTracker getTracker() {
        return memTracker;
    }
}
