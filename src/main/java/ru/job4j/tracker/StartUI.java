package ru.job4j.tracker;

import ru.job4j.tracker.interfeces.action.*;
import ru.job4j.tracker.interfeces.input.ConsoleInput;
import ru.job4j.tracker.interfeces.input.Input;
import ru.job4j.tracker.interfeces.input.ValidateInput;
import ru.job4j.tracker.interfeces.output.ConsoleOutput;
import ru.job4j.tracker.interfeces.output.Output;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.length) {
                out.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
                continue;
            }
                UserAction action = actions[select];
                run = action.execute(input, tracker);
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
        Tracker tracker = new Tracker();
        Input input = new ValidateInput(output, new ConsoleInput(output));
        UserAction[] actions = {
                new CreateAction(output), new ShowAllAction(output),
                new EditAction(output), new DeletAction(output), new FindByIdAction(output),
                new FindByNameAction(output), new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
    }
}