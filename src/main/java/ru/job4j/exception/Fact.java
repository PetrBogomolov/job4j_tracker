package ru.job4j.exception;

public class Fact {
    public static void main(String[] args) {
        System.out.println(Fact.calc(5));
    }

    public static int calc(int number) {
        int result = 1;
        if (number < 0) {
            throw new IllegalArgumentException ("Input number can't be less 0");
        }
        for (int index = 1; index <= number; index++) {
            result *= index;
        }
        return result;
    }
}
