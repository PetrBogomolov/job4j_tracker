package ru.job4j.collection.combinedcomparator;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameIncrease() {
        Comparator<Job> compareByName = new SortByNameIncrease();
        int result = compareByName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(result, greaterThan(0));
    }

    @Test
    public void whenCompatorByNameDecrease() {
        Comparator<Job> compareByName = new SortByNameDecrease();
        int result = compareByName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(result, lessThan(0));
    }

    @Test
    public void whenCompatorByPriorityIncrease() {
        Comparator<Job> compareByPriority = new SortByPriorityIncrease();
        int result = compareByPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(result, lessThan(0));
    }

    @Test
    public void whenCompatorByPriorityDecrease() {
        Comparator<Job> compareByPriority = new SortByPriorityDecrease();
        int result = compareByPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(result, greaterThan(0));
    }

    @Test
    public void whenCompatorByNameDecreaseAndProrityDecrease() {
        Comparator<Job> cmpNamePriority = new SortByNameDecrease().
                                            thenComparing(new SortByPriorityDecrease());
        int result = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(result, lessThan(0));
    }

    @Test
    public void whenCompatorByNameIncreaseAndProrityIncrease() {
        Comparator<Job> cmpNamePriority = new SortByNameIncrease().
                                                thenComparing(new SortByPriorityIncrease());
        int result = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(result, greaterThan(0));
    }

    @Test
    public void whenCompatorByNameIncreaseAndProrityDecrease() {
        Comparator<Job> cmpNamePriority = new SortByNameIncrease().
                                                thenComparing(new SortByPriorityDecrease());
        int result = cmpNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 1)
        );
        assertThat(result, is(0));
    }
}