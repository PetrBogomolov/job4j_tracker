package ru.job4j.tracker.interfeces;

public class StubInput implements Input {
    private String[] answersInt;
    private String[] answersString;
    private  int position = 0;

    public StubInput(String[] answersString) {
        this.answersString = answersString;
    }

    public StubInput(String[] answersInt, String[] answersString) {
        this.answersInt = answersInt;
        this.answersString = answersString;
    }

    @Override
    public String askString(String question) {
        return answersString[position++];
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askString(question));
    }
}
