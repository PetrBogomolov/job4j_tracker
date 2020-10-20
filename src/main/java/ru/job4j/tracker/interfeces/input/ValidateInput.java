package ru.job4j.tracker.interfeces.input;

import ru.job4j.tracker.interfeces.output.Output;

public class ValidateInput implements Input {
    private final Output out;
    private final Input input;

    public ValidateInput(Output out, Input input) {
        this.out = out;
        this.input = input;
    }

    @Override
    public String askString(String question) {
        return input.askString(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = input.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
               out.println("Please enter validate data again.");
            }
        } while (invalid);
        return value;
    }
}
