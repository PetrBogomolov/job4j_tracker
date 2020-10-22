package ru.job4j.tracker.singltone;

import ru.job4j.tracker.Tracker;

public class TrackerInnerClass {
    private Tracker tracker = new Tracker();

    private TrackerInnerClass() {
    }

    public Tracker getTracker() {
        return tracker;
    }

    public static TrackerInnerClass getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerInnerClass INSTANCE = new TrackerInnerClass();
    }
}
