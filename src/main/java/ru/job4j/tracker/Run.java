package ru.job4j.tracker;

import ru.job4j.tracker.interfeces.action.*;
import ru.job4j.tracker.interfeces.input.ConsoleInput;
import ru.job4j.tracker.interfeces.input.Input;
import ru.job4j.tracker.interfeces.input.ValidateInput;
import ru.job4j.tracker.interfeces.output.ConsoleOutput;
import ru.job4j.tracker.interfeces.output.Output;
import ru.job4j.tracker.interfeces.store.HbmTracker;
import ru.job4j.tracker.interfeces.store.Store;

public class Run {
    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput(output));
        try (Store tracker = new HbmTracker()) {
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
