package ru.job4j.tracker.singltone;

import org.junit.Test;
import ru.job4j.tracker.interfeces.store.MemTracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSingletonTest {

    @Test
    public void whenGet2TrackersInTrackerEnumThenHave1Tracker() {
        MemTracker memTracker = TrackerEnum.INSTANCE.getTracker();
        MemTracker otherMemTracker = TrackerEnum.INSTANCE.getTracker();
        assertThat(memTracker, is(otherMemTracker));
    }

    @Test
    public void whenGet2TrackersInTrackerInnerClassThenHave1Tracker() {
        MemTracker memTracker = TrackerInnerClass.getInstance().getTracker();
        MemTracker otherMemTracker = TrackerInnerClass.getInstance().getTracker();
        assertThat(memTracker, is(otherMemTracker));
    }

    @Test
    public void whenGet2TrackersInTrackerStaticThenHave1Tracker() {
        MemTracker memTracker = TrackerStatic.getInstance().getTracker();
        MemTracker otherMemTracker = TrackerStatic.getInstance().getTracker();
        assertThat(memTracker, is(otherMemTracker));
    }

    @Test
    public void whenGet2TrackersInTrackerStaticFinalThenHave1Traker() {
        MemTracker memTracker = TrackerStaticFinal.getINSTANCE().getTracker();
        MemTracker otherMemTracker = TrackerStaticFinal.getINSTANCE().getTracker();
        assertThat(memTracker, is(otherMemTracker));
    }
}