package ru.job4j.tracker.interfeces.input;

public interface Input {

    /**
     *  Метод служит для ввода текста
     */

    String askString(String question);

    /**
     * Метод служит для ввода цифр
     */

    int askInt(String question);
}
