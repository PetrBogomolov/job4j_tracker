package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.interfeces.Input;
import ru.job4j.tracker.interfeces.StubInput;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;

public class StartUITest {

    @Test
    public void whenCreateItemRomaThenRoma() {
        String[] answers = {"Roma"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Roma");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenEditItemRomaThenVova() {
        Tracker tracker = new Tracker();
        Item roma = new Item("Roma");
        tracker.add(roma);
        String[] answers = {Integer.toString(roma.getId()), "Vova"};
        Input edit = new StubInput(answers);
        StartUI.editItem(edit, tracker);
        Item replace = tracker.findById(roma.getId());
        assertThat(replace.getName(), is("Vova"));
    }

    @Test
    public void whenDeleteItemRomaThenNull() {
        Tracker tracker = new Tracker();
        Item roma = new Item("Roma");
        tracker.add(roma);
        String[] answers = {Integer.toString(roma.getId())};
        Input edit = new StubInput(answers);
        StartUI.deleteItem(edit, tracker);
        Item replace = tracker.findById(roma.getId());
        assertNull(replace);
    }
}