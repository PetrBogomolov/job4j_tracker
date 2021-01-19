package ru.job4j.tracker.singltone;

import ru.job4j.tracker.MemTracker;

public enum TrackerEnum {
    INSTANCE;

    private MemTracker memTracker = new MemTracker();

    public MemTracker getTracker() {
        return memTracker;
    }
}
