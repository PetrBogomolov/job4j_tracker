package ru.job4j.tracker.singltone;

import ru.job4j.tracker.Tracker;

public class TrackerStaticFinal {
    private static final TrackerStaticFinal INSTANCE = new TrackerStaticFinal();
    private Tracker tracker = new Tracker();

    private TrackerStaticFinal() {
    }

    public static TrackerStaticFinal getINSTANCE() {
        return INSTANCE;
    }

    public Tracker getTracker() {
        return tracker;
    }
}
