package ru.job4j.tracker.interfeces.store;

import org.junit.Test;
import ru.job4j.tracker.Item;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HbmTrackerTest {

    @Test
    public void whenSaveItemAndFindAllOneRowWithDescription() {
        Store store = new HbmTracker();
        store.add(
                new Item(
                        "item1",
                        "description1",
                        new Timestamp(new Date().getTime())
                )
        );
        List<Item> all = store.findAll();
        assertThat(all.size(), is(1));
        assertThat(all.get(0).getName(), is("item1"));
        assertThat(all.get(0).getDescription(), is("description1"));
    }

    @Test
    public void whenSaveItemAndFindItById() {
        Store store = new HbmTracker();
        Item save = store.add(
                new Item(
                        "item1",
                        "description1",
                        new Timestamp(new Date().getTime())
                )
        );
       Item dbItem = store.findById(save.getId());
       assertThat(dbItem, is(save));
    }

    @Test
    public void whenNotSaveItemAndFindByIdThenResultNull() {
        Store store = new HbmTracker();
        Item dbItem = store.findById(1);
        assertNull(dbItem);
    }

    @Test
    public void whenSaveTwoItemWithSimilarNameAndFindTheirsByNameThenListWithTwoItems() {
        Store store = new HbmTracker();
        store.add(new Item("item1", "description1"));
        store.add(new Item("item1", "description2"));
        List<Item> dbItems = store.findByName("item1");
        assertThat(dbItems.size(), is(2));
        assertThat(dbItems.get(0).getDescription(), is("description1"));
        assertThat(dbItems.get(1).getDescription(), is("description2"));
    }

    @Test
    public void whenNotSaveItemAndFindByNameThenResultEmptyList() {
        Store store = new HbmTracker();
        List<Item> dbItems = store.findByName("item1");
        assertTrue(dbItems.isEmpty());
    }

    @Test
    public void whenSaveItemAndUpdateIt() {
        Store store = new HbmTracker();
        Item save = store.add(new Item("item", "description1"));
        store.replace(save.getId(), new Item("item replace", "description update"));
        assertThat(store.findById(save.getId()).getName(), is("item replace"));
        assertThat(store.findById(save.getId()).getDescription(), is("description update"));
    }

    @Test
    public void whenSaveItemAndDeleteIt() {
        Store store = new HbmTracker();
        Item save = store.add(new Item("item", "description1"));
        assertTrue(store.delete(save.getId()));
        assertTrue(store.findAll().isEmpty());
    }

    @Test
    public void whenDeleteItemFromEmptyDateBase() {
        Store store = new HbmTracker();
        assertFalse(store.delete(1));
    }
}
