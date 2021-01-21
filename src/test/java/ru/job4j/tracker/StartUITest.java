package ru.job4j.tracker;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.interfeces.action.*;
import ru.job4j.tracker.interfeces.input.Input;
import ru.job4j.tracker.interfeces.input.StubInput;
import ru.job4j.tracker.interfeces.input.ValidateInput;
import ru.job4j.tracker.interfeces.output.ConsoleOutput;
import ru.job4j.tracker.interfeces.output.Output;
import ru.job4j.tracker.interfeces.output.StubOutput;
import ru.job4j.tracker.interfeces.store.SqlTracker;
import ru.job4j.tracker.interfeces.store.Store;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    private Output output;
    private Output out;
    private Store memTracker;
    private Store tracker;

    @Before
    public void setup() {
        output = new ConsoleOutput();
        memTracker = new SqlTracker();
        out = new StubOutput();
        tracker = new MemTracker();
    }

    public Connection init() {
        ClassLoader loader = SqlTracker.class.getClassLoader();
        try (InputStream io = loader.getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(io);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void whenCreateItem() {
        String[] answers = {"0", "Item name", "1"};
        Input input = new StubInput(answers);
        UserAction[] actions = {new CreateAction(output), new ExitAction(output)};
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenEditItemWasItemThenBecomeItem() {
        String[] answers = {"0", "was item", "1", "1", "become item", "2"};
        Input input = new StubInput(answers);
        UserAction[] actions = {
                new CreateAction(output), new EditAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(1).getName(), is("become item"));
    }

    @Test
    public void whenDeleteItemNewItemThenNull() {
        String[] answers = {"0", "new item", "1", "1", "2"};
        Input input = new StubInput(answers);
        UserAction[] actions = {
                new CreateAction(output), new DeletAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertNull(tracker.findById(1));
    }

    @Test
    public void whenFindItemByName() {
        String[] answers = {"0", "Roma", "1", "Roma", "2"};
        Input input = new StubInput(answers);
        UserAction[] actions = {
                new CreateAction(output), new FindByNameAction(output),
                new ExitAction(output)
        };
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is("Menu" + System.lineSeparator()
                + "0.=== Create a new Item ====" + System.lineSeparator()
                + "1.=== Search for a request by name ===" + System.lineSeparator()
                + "2.=== Exit ===" + System.lineSeparator()
                + "Menu" + System.lineSeparator()
                + "0.=== Create a new Item ====" + System.lineSeparator()
                + "1.=== Search for a request by name ===" + System.lineSeparator()
                + "2.=== Exit ===" + System.lineSeparator()
                + "Menu" + System.lineSeparator()
                + "0.=== Create a new Item ====" + System.lineSeparator()
                + "1.=== Search for a request by name ===" + System.lineSeparator()
                + "2.=== Exit ===" + System.lineSeparator()));
    }

    @Test
    public void whenFindItemById() {
        String[] answers = {"0", "new item", "1", "1", "2"};
        Input input = new StubInput(answers);
        UserAction[] actions = {
                new CreateAction(output), new FindByIdAction(output),
                new ExitAction(output)
        };
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is("Menu" + System.lineSeparator()
                + "0.=== Create a new Item ====" + System.lineSeparator()
                + "1.=== Search for a request by id ===" + System.lineSeparator()
                + "2.=== Exit ===" + System.lineSeparator()
                + "Menu" + System.lineSeparator()
                + "0.=== Create a new Item ====" + System.lineSeparator()
                + "1.=== Search for a request by id ===" + System.lineSeparator()
                + "2.=== Exit ===" + System.lineSeparator()
                + "Menu" + System.lineSeparator()
                + "0.=== Create a new Item ====" + System.lineSeparator()
                + "1.=== Search for a request by id ===" + System.lineSeparator()
                + "2.=== Exit ===" + System.lineSeparator()));
    }

    @Test
    public void whenShowAll() {
        String[] answers = {"0", "Roma", "0", "Dima", "1", "2"};
        Input input = new StubInput(answers);
        UserAction[] actions = {
                new CreateAction(output), new ShowAllAction(output),
                new ExitAction(output)
        };
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is("Menu" + System.lineSeparator()
                + "0.=== Create a new Item ====" + System.lineSeparator()
                + "1.=== Show all items ===" + System.lineSeparator()
                + "2.=== Exit ===" + System.lineSeparator()
                + "Menu" + System.lineSeparator()
                + "0.=== Create a new Item ====" + System.lineSeparator()
                + "1.=== Show all items ===" + System.lineSeparator()
                + "2.=== Exit ===" + System.lineSeparator()
                + "Menu" + System.lineSeparator()
                + "0.=== Create a new Item ====" + System.lineSeparator()
                + "1.=== Show all items ===" + System.lineSeparator()
                + "2.=== Exit ===" + System.lineSeparator()
                + "Menu" + System.lineSeparator()
                + "0.=== Create a new Item ====" + System.lineSeparator()
                + "1.=== Show all items ===" + System.lineSeparator()
                + "2.=== Exit ===" + System.lineSeparator()));
    }

    @Test
    public void whenCreateItemDB() throws SQLException {
        SqlTracker tracker = new SqlTracker(ConnectionRollback.create(init()));
        tracker.add(new Item("name"));
        assertThat(tracker.findAll().size(), is(1));
    }

    @Test
    public void whenDeleteItemDB() throws SQLException {
        SqlTracker tracker = new SqlTracker(ConnectionRollback.create(init()));
        Item item = tracker.add(new Item("name"));
        assertThat(tracker.delete(item.getId()), is(true));
    }

    @Test
    public void whenEditItemWasItemThenBecomeItemDB() throws SQLException {
        SqlTracker tracker = new SqlTracker(ConnectionRollback.create(init()));
        Item item = tracker.add(new Item("name"));
        assertThat(tracker.replace(item.getId(), new Item("new name")), is(true));
    }

    @Test
    public void whenFindItemByNameDB() throws SQLException {
        SqlTracker tracker = new SqlTracker(ConnectionRollback.create(init()));
        tracker.add(new Item("name1"));
        tracker.add(new Item("name1"));
        tracker.add(new Item("name2"));
        assertThat(tracker.findByName("name1").size(), is(2));
        assertThat(tracker.findByName("name2").size(), is(1));
    }

    @Test
    public void whenFindItemByIdDB() throws SQLException {
        SqlTracker tracker = new SqlTracker(ConnectionRollback.create(init()));
        Item item1 = tracker.add(new Item("name1"));
        Item item2 = tracker.add(new Item("name2"));
        assertThat(tracker.findById(item1.getId()), is(item1));
    }

    @Test
    public void whenShowAllDB() throws SQLException {
        SqlTracker tracker = new SqlTracker(ConnectionRollback.create(init()));
        tracker.add(new Item("name1"));
        tracker.add(new Item("name2"));
        tracker.add(new Item("name3"));
        assertThat(tracker.findAll().size(), is(3));
    }

    @Test
    public void whenNotInvalidExitThenInvalidExit() {
        Input input = new StubInput(new String[]{"1", "0"});
        UserAction[] actions = {new ExitAction(out)};
        new StartUI(out).init(input, memTracker, actions);
        assertThat(out.toString(), is(
                                            String.format(
                                            "Menu%n"
                                            + "0.=== Exit ===%n"
                                            + "Wrong input, you can select: 0 .. 0%n"
                                            + "Menu%n"
                                            + "0.=== Exit ===%n"
                                            + "Programm exit!%n"
                                             )
        ));
    }

    @Test
    public void whenInvalidInput() {
        Input in = new StubInput(new String[] {"1"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenNotInvalid() {
        Input in = new StubInput(new String[] {"one", "1"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(out.toString(),
                is("Please enter validate data again." + System.lineSeparator()));
    }
}
