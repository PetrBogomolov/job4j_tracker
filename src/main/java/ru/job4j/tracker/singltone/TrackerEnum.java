package ru.job4j.tracker.singltone;

import ru.job4j.tracker.Tracker;

public enum TrackerEnum {
    INSTANCE;

    private Tracker tracker = new Tracker();

    public Tracker getTracker() {
        return tracker;
    }
}
