package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.interfeces.Input;
import ru.job4j.tracker.interfeces.StubInput;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        String[] answers = {"Roma"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Roma");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenEditItem() {
        Tracker tracker = new Tracker();
        String[] name = {"Roma"};
        Input input = new StubInput(name);
        StartUI.createItem(input, tracker);

        String[] idName = {"1"};
        String[] editName = {"Vova"};
        Input editItem = new StubInput(idName, editName);
        StartUI.editItem(editItem, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Vova");
        assertThat(created.getName(), is(expected.getName()));
    }
}