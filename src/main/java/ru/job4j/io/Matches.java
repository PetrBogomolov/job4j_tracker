package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        int matches = 11;
        Scanner inputName = new Scanner(System.in);
        Scanner inputNumber = new Scanner(System.in);
        System.out.println("Hello,  it's Eleven game");
        System.out.print("Enter the first player's name: ");
        String player1 = inputName.nextLine();
        System.out.print("Enter the second player's name: ");
        String player2 = inputName.nextLine();
        while (matches > 0) {
            int numberPlayer1;
            int numberPlayer2;
            do {
                System.out.print("Walks in the game " + player1 + " : ");
                numberPlayer1 = inputNumber.nextInt();
            } while (numberPlayer1 < 1 || numberPlayer1 > 3);
            matches -= numberPlayer1;
            System.out.println("There are " + matches + " matches left in the game");
            do {
                System.out.print("Walks in the game  " + player2 + " : ");
                numberPlayer2 = inputNumber.nextInt();
            } while (numberPlayer2 < 1 || numberPlayer2 > 3);
            matches -= numberPlayer2;
            System.out.println("There are " + matches + " matches left in the game");
        }
        System.out.println("Game Over!!!");
    }
}
