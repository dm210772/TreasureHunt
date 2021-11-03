package com.company;

import java.util.Scanner;

public class Main {

    static String[][] board = new String[10][8];
    static int treasureX;
    static int treasureY;
    static int guessX;
    static int guessY;
    static int coins = 0;

    public static void main(String[] args) {
        // write your code here

        initBoard();
        int guesses = 5;
        treasurePosition();
        System.out.println(treasureX + ", " + treasureY);

        while (guesses > 0) {

            treasureGuess();

            if (guessX == treasureX && guessY == treasureY) {
                board[treasureX][treasureY] = "[X]";
                printBoard();

                System.out.println("You found the treasure!");

                coins += coinsGen();
                System.out.println("You have " + coins + " coins.");

                break;
            } else {
                board[guessX][guessY] = "[O]";
                printBoard();

                System.out.println("You didn't find the treasure...");
                System.out.println("Keep going!");

                guesses--;
                System.out.println("You have " + guesses + " guesses left.");
            }
            System.out.println("");
        }
        if (guesses == 0) {
            System.out.println("You ran out of guesses!");
        }
    }

    static int coinsGen() {
        return (int) (50 + Math.random() * 101);
    }

    static void treasurePosition() {
        treasureX = (int) (Math.random() * 7);
        treasureY = (int) (Math.random() * 9);
    }

    static void treasureGuess() {
        Scanner input = new Scanner(System.in);

        System.out.println("Guess the treasure's X coordinate: (7)");
        guessX = input.nextInt();

        System.out.println("Guess the treasure's Y coordinate: (9)");
        guessY = input.nextInt();
    }

    static void printBoard() {
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 8; ++j) {
                System.out.print(board[i][j]);
            }

            System.out.println("");
        }
    }

    static void initBoard() {
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 8; ++j) {
                board[i][j] = "[ ]";
                System.out.print(board[i][j]);
            }

            System.out.println("");
        }
    }
}
