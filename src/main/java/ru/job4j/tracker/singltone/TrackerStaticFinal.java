package ru.job4j.tracker.singltone;

import ru.job4j.tracker.interfeces.store.MemTracker;

public class TrackerStaticFinal {
    private static final TrackerStaticFinal INSTANCE = new TrackerStaticFinal();
    private MemTracker memTracker = new MemTracker();

    private TrackerStaticFinal() {
    }

    public static TrackerStaticFinal getINSTANCE() {
        return INSTANCE;
    }

    public MemTracker getTracker() {
        return memTracker;
    }
}
