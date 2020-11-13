package ru.job4j.streamapi;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum Suit {
    DIAMONDS, HEARTS, SPADES, CLUBS
}

enum Value {
    V_6, V_7, V_8
}

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{"
               + "suit=" + suit
               + ", value=" + value
               + '}';
    }

    public static void main(String[] args) {
       List<Card> deck = Stream.of(Suit.values())
               .flatMap(
                       x -> Stream.of(Value.values())
                       .map(e -> new Card(x, e))
               )
               .collect(Collectors.toList());
       deck.forEach(System.out::println);
    }
}


