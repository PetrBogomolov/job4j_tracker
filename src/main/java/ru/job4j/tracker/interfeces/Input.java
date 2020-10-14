package ru.job4j.tracker.interfeces;

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
