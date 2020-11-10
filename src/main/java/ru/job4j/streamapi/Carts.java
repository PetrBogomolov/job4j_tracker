package ru.job4j.streamapi;

enum Suit {
    DIAMONDS, HEARTS, SPADES, CLUBS
}

enum Value {
    V_6, V_7, V_8
}

public class Carts {
    private Suit suit;
    private Value value;

    public Carts(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {

    }
}


