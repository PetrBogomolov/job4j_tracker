package ru.job4j.tracker.singltone;

import ru.job4j.tracker.Tracker;

public class TrackerStatic {
    private static TrackerStatic instance;
    private Tracker tracker = new Tracker();

    private TrackerStatic() {
    }

    public static TrackerStatic getInstance() {
        if (instance == null) {
            instance = new TrackerStatic();
        }
        return instance;
    }

    public Tracker getTracker() {
        return tracker;
    }
}
