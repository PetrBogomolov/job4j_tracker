package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.interfeces.action.*;
import ru.job4j.tracker.interfeces.input.Input;
import ru.job4j.tracker.interfeces.input.StubInput;
import ru.job4j.tracker.interfeces.output.ConsoleOutput;
import ru.job4j.tracker.interfeces.output.Output;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        String[] answers = {"0", "Item name" , "1"};
        Input input = new StubInput(answers);
        UserAction[] actions = {new CreateAction(output), new ExitAction(output)};
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenEditItemWasItemThenBecomeItem() {
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        String[] answers = {"0", "was item", "1", "1", "become item", "2"};
        Input input = new StubInput(answers);
        UserAction[] actions = {new CreateAction(output), new EditAction(output), new ExitAction(output)};
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(1).getName(), is("become item"));
    }

    @Test
    public void whenDeleteItemNewItemThenNull() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        String[] answers = {"0", "new item", "1", "1", "2"};
        Input input = new StubInput(answers);
        UserAction[] actions = {new CreateAction(output), new DeletAction(output), new ExitAction(output)};
        new StartUI(output).init(input, tracker, actions);
        assertNull(tracker.findById(1));
    }
}