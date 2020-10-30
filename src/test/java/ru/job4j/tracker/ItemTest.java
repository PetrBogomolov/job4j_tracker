package ru.job4j.tracker;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void whenSortOfIncreaseSuccessful() {
        List<Item> items = Arrays.asList(
                new Item(5, "item 1"),
                new Item(4, "item 2"),
                new Item(1, "item 3"),
                new Item(9, "item4")
                );
        Collections.sort(items);
        List<Item> result = Arrays.asList(
                new Item(1, "item 3"),
                new Item(4, "item 2"),
                new Item(5, "item 1"),
                new Item(9, "item4")
        );
        assertEquals(items, result);
    }

    @Test
    public void whenSortOfDecreaseSuccessful() {
        List<Item> items = Arrays.asList(
                new Item(5, "item 1"),
                new Item(4, "item 2"),
                new Item(1, "item 3"),
                new Item(9, "item4")
        );
        Collections.sort(items, Collections.reverseOrder());
        List<Item> result = Arrays.asList(
                new Item(9, "item4"),
                new Item(5, "item 1"),
                new Item(4, "item 2"),
                new Item(1, "item 3")
        );
        assertEquals(items, result);
    }
}