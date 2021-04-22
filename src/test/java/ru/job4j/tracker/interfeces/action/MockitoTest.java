package ru.job4j.tracker.interfeces.action;

import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.interfeces.input.Input;
import ru.job4j.tracker.interfeces.output.Output;
import ru.job4j.tracker.interfeces.output.StubOutput;
import ru.job4j.tracker.interfeces.store.MemTracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

public class MockitoTest {

    @Test
    public void editItemSuccessful() {
        String ln = System.lineSeparator();
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        EditAction rep = new EditAction(out);
        Input mock = mock(Input.class);
        when(mock.askInt(any(String.class))).thenReturn(1);
        when(mock.askString(any(String.class))).thenReturn(replacedName);
        rep.execute(mock, tracker);
        assertThat(out.toString(), is("Replacement was successful" + ln));
        assertThat(tracker.findAll().get(0).getName(), is(replacedName));
    }

    @Test
    public void editItemNotSuccessful() {
        String replacedName = "New item name";
        String originalName = "Replaced item";
        String ln = System.lineSeparator();
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item(originalName));
        EditAction rep = new EditAction(out);
        Input mock = mock(Input.class);
        when(mock.askInt(any(String.class))).thenReturn(2);
        when(mock.askString(any(String.class))).thenReturn(replacedName);
        rep.execute(mock, tracker);
        assertThat(out.toString(), is("Error! Try again" + ln));
        assertThat(tracker.findAll().get(0).getName(), is(originalName));
    }

    @Test
    public void deleteItemSuccessful() {
        String ln = System.lineSeparator();
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("item"));
        DeletAction delete = new DeletAction(out);
        Input mock = mock(Input.class);
        when(mock.askInt(any(String.class))).thenReturn(1);
        delete.execute(mock, tracker);
        assertThat(out.toString(), is("Delete was successful" + ln));
        assertTrue(tracker.findAll().isEmpty());
    }

    @Test
    public void deleteItemNotSuccessful() {
        String ln = System.lineSeparator();
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("item");
        tracker.add(item);
        DeletAction delete = new DeletAction(out);
        Input mock = mock(Input.class);
        when(mock.askInt(any(String.class))).thenReturn(2);
        delete.execute(mock, tracker);
        assertThat(out.toString(), is("Select another option" + ln));
        assertThat(tracker.findById(1), is(item));
    }

    @Test
    public void findByIdItemSuccessful() {
        String ln = System.lineSeparator();
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("item");
        tracker.add(item);
        FindByIdAction findById = new FindByIdAction(out);
        Input mock = mock(Input.class);
        when(mock.askInt(any(String.class))).thenReturn(1);
        findById.execute(mock, tracker);
        assertThat(out.toString(), is("Result of search: " + ln + item + ln));
        assertThat(tracker.findById(1), is(item));
    }

    @Test
    public void findByIdItemNotSuccessful() {
        String ln = System.lineSeparator();
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        FindByIdAction findById = new FindByIdAction(out);
        Input mock = mock(Input.class);
        when(mock.askInt(any(String.class))).thenReturn(1);
        findById.execute(mock, tracker);
        assertThat(out.toString(), is("The request with this number was not found" + ln));
        assertNull(tracker.findById(1));
    }

    @Test
    public void findByNameItemSuccessful() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        String nameItem = "item";
        Item item = new Item(nameItem);
        tracker.add(item);
        FindByNameAction findByName = new FindByNameAction(out);
        Input mock = mock(Input.class);
        when(mock.askString(any(String.class))).thenReturn(nameItem);
        findByName.execute(mock, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Result of search: " + ln + item + ln));
        assertThat(tracker.findByName(nameItem).get(0), is(item));
    }

    @Test
    public void findByNameItemNotSuccessful() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        FindByNameAction findByName = new FindByNameAction(out);
        Input mock = mock(Input.class);
        when(mock.askString(any(String.class))).thenReturn("item");
        findByName.execute(mock, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("The request with this name was not found" + ln));
        assertTrue(tracker.findAll().isEmpty());
    }
}
