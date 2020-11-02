package ru.job4j.tracker.interfeces.input;

import ru.job4j.tracker.interfeces.output.Output;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private final Output out;
    private Scanner scanner = new Scanner(System.in);

    public ConsoleInput(Output out) {
        this.out = out;
    }

    @Override
    public String askString(String question) {
        out.println(question);
        return scanner.nextLine();
    }

    public Scanner getScanner() {
        return scanner;
    }

    @Override
    public int askInt(String question) {
        return Integer.valueOf(askString(question));
    }
}
