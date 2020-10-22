package ru.job4j.tracker.singltone;

import org.junit.Test;
import ru.job4j.tracker.Tracker;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSingletonTest {

    @Test
    public void whenGet2TrackersInTrackerEnumThenHave1Tracker() {
        Tracker tracker = TrackerEnum.INSTANCE.getTracker();
        Tracker otherTracker = TrackerEnum.INSTANCE.getTracker();
        assertThat(tracker, is(otherTracker));
    }

    @Test
    public void whenGet2TrackersInTrackerInnerClassThenHave1Tracker() {
        Tracker tracker = TrackerInnerClass.getInstance().getTracker();
        Tracker otherTracker = TrackerInnerClass.getInstance().getTracker();
        assertThat(tracker, is(otherTracker));
    }

    @Test
    public void whenGet2TrackersInTrackerStaticThenHave1Tracker() {
        Tracker tracker = TrackerStatic.getInstance().getTracker();
        Tracker otherTracker = TrackerStatic.getInstance().getTracker();
        assertThat(tracker, is(otherTracker));
    }

    @Test
    public void whenGet2TrackersInTrackerStaticFinalThenHave1Traker() {
        Tracker tracker = TrackerStaticFinal.getINSTANCE().getTracker();
        Tracker otherTracker = TrackerStaticFinal.getINSTANCE().getTracker();
        assertThat(tracker, is(otherTracker));
    }
}