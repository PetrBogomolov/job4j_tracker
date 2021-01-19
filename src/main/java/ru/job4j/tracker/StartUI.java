package ru.job4j.tracker;

import ru.job4j.tracker.interfeces.action.*;
import ru.job4j.tracker.interfeces.input.ConsoleInput;
import ru.job4j.tracker.interfeces.input.Input;
import ru.job4j.tracker.interfeces.input.ValidateInput;
import ru.job4j.tracker.interfeces.output.ConsoleOutput;
import ru.job4j.tracker.interfeces.output.Output;
import ru.job4j.tracker.interfeces.store.SqlTracker;
import ru.job4j.tracker.interfeces.store.Store;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store memTracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.length) {
                out.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
                continue;
            }
                UserAction action = actions[select];
                run = action.execute(input, memTracker);
            }
    }

    private void showMenu(UserAction[] actions) {
        out.println("Menu");
        for (int index = 0; index < actions.length; index++) {
            out.println(index + "." + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput(output));
        try (Store tracker = new SqlTracker()) {
            tracker.init();
            UserAction[] actions = {
                    new CreateAction(output), new ShowAllAction(output),
                    new EditAction(output), new DeletAction(output), new FindByIdAction(output),
                    new FindByNameAction(output), new ExitAction(output)
            };
            new StartUI(output).init(input, tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
