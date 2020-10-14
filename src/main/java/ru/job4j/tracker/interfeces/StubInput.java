package ru.job4j.tracker.interfeces;

public class StubInput implements Input {
    private String[] answers;
    private  int position = 0;

    public StubInput(String[] answersString) {
        this.answers = answersString;
    }

    @Override
    public String askString(String question) {
        return answers[position++];
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askString(question));
    }
}
