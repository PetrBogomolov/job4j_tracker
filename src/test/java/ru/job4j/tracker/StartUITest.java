package ru.job4j.tracker;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.interfeces.action.*;
import ru.job4j.tracker.interfeces.input.Input;
import ru.job4j.tracker.interfeces.input.StubInput;
import ru.job4j.tracker.interfeces.output.ConsoleOutput;
import ru.job4j.tracker.interfeces.output.Output;
import ru.job4j.tracker.interfeces.output.StubOutput;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    private Output output;
    private Output out;
    private Tracker tracker;

    @Before
    public void setup() {
        output = new ConsoleOutput();
        tracker = new Tracker();
        out = new StubOutput();
    }

    @Test
    public void whenCreateItem() {
        String[] answers = {"0", "Item name" , "1"};
        Input input = new StubInput(answers);
        UserAction[] actions = {new CreateAction(output), new ExitAction(output)};
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenEditItemWasItemThenBecomeItem() {
        String[] answers = {"0", "was item", "1", "1", "become item", "2"};
        Input input = new StubInput(answers);
        UserAction[] actions = {new CreateAction(output), new EditAction(output), new ExitAction(output)};
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(1).getName(), is("become item"));
    }

    @Test
    public void whenDeleteItemNewItemThenNull() {
        String[] answers = {"0", "new item", "1", "1", "2"};
        Input input = new StubInput(answers);
        UserAction[] actions = {new CreateAction(output), new DeletAction(output), new ExitAction(output)};
        new StartUI(output).init(input, tracker, actions);
        assertNull(tracker.findById(1));
    }

    @Test
    public void whenFindItemByName() {
        String[] answers = {"0", "Roma", "1", "Roma", "2"};
        Input input = new StubInput(answers);
        UserAction[] actions = {new CreateAction(output), new FindByNameAction(output), new ExitAction(output)};
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is("Menu\r\n" +
                                           "0.=== Create a new Item ====\r\n" +
                                           "1.=== Search for a request by name ===\r\n" +
                                           "2.=== Exit ===\r\nMenu\r\n" +
                                           "0.=== Create a new Item ====\r\n" +
                                           "1.=== Search for a request by name ===\r\n" +
                                           "2.=== Exit ===\r\n" +
                                           "Menu\r\n" +
                                           "0.=== Create a new Item ====\r\n" +
                                           "1.=== Search for a request by name ===\r\n" +
                                           "2.=== Exit ===\r\n"));
    }

    @Test
    public void whenFindItemById() {
        String[] answers = {"0", "new item", "1", "1", "2"};
        Input input = new StubInput(answers);
        UserAction[] actions = {new CreateAction(output), new FindByIdAction(output), new ExitAction(output)};
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is("Menu\r\n" +
                                            "0.=== Create a new Item ====\r\n" +
                                            "1.=== Search for a request by id ===\r\n" +
                                            "2.=== Exit ===\r\nMenu\r\n" +
                                            "0.=== Create a new Item ====\r\n" +
                                            "1.=== Search for a request by id ===\r\n" +
                                            "2.=== Exit ===\r\n" +
                                            "Menu\r\n" +
                                            "0.=== Create a new Item ====\r\n" +
                                            "1.=== Search for a request by id ===\r\n" +
                                            "2.=== Exit ===\r\n"));
    }

    @Test
    public void whenShowAll() {
        String[] answers = {"0", "Roma", "0", "Dima", "1", "2"};
        Input input = new StubInput(answers);
        UserAction[] actions = {new CreateAction(output), new ShowAllAction(output), new ExitAction(output)};
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is("Menu\r\n" +
                                            "0.=== Create a new Item ====\r\n" +
                                            "1.=== Show all items ===\r\n" +
                                            "2.=== Exit ===\r\n" +
                                            "Menu\r\n" +
                                            "0.=== Create a new Item ====\r\n" +
                                            "1.=== Show all items ===\r\n" +
                                            "2.=== Exit ===\r\n" +
                                            "Menu\r\n" +
                                            "0.=== Create a new Item ====\r\n" +
                                            "1.=== Show all items ===\r\n" +
                                            "2.=== Exit ===\r\n" +
                                            "Menu\r\n" +
                                            "0.=== Create a new Item ====\r\n" +
                                            "1.=== Show all items ===\r\n" +
                                            "2.=== Exit ===\r\n"));
    }
}