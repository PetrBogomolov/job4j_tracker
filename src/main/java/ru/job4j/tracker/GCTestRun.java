package ru.job4j.tracker;

import ru.job4j.tracker.interfeces.action.ExitAction;
import ru.job4j.tracker.interfeces.action.ShowAllAction;
import ru.job4j.tracker.interfeces.action.UserAction;
import ru.job4j.tracker.interfeces.input.ConsoleInput;
import ru.job4j.tracker.interfeces.input.Input;
import ru.job4j.tracker.interfeces.input.ValidateInput;
import ru.job4j.tracker.interfeces.output.ConsoleOutput;
import ru.job4j.tracker.interfeces.output.Output;
import ru.job4j.tracker.interfeces.store.MemTracker;
import ru.job4j.tracker.interfeces.store.Store;

public class GCTestRun implements UserAction {
    private final Output out;

    public GCTestRun(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "GC Test";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        for (int i = 0; i < 5000; i++) {
            Item item = new Item("test" + i);
            tracker.add(item);
            System.out.println(i);
        }
        return true;
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput(output));
        Store tracker = new MemTracker();
        UserAction[] actions = {
                new GCTestRun(output), new ShowAllAction(output), new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
    }
}
