package ru.job4j.tracker.singltone;

import ru.job4j.tracker.MemTracker;

public class TrackerStatic {
    private static TrackerStatic instance;
    private MemTracker memTracker = new MemTracker();

    private TrackerStatic() {
    }

    public static TrackerStatic getInstance() {
        if (instance == null) {
            instance = new TrackerStatic();
        }
        return instance;
    }

    public MemTracker getTracker() {
        return memTracker;
    }
}
