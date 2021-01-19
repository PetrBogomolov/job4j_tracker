package ru.job4j.tracker.singltone;

import ru.job4j.tracker.MemTracker;

public class TrackerInnerClass {
    private MemTracker memTracker = new MemTracker();

    private TrackerInnerClass() {
    }

    public MemTracker getTracker() {
        return memTracker;
    }

    public static TrackerInnerClass getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerInnerClass INSTANCE = new TrackerInnerClass();
    }
}
