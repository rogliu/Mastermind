package main;

import java.util.Scanner;

public class Main {
    private static final int NUMBER_TRIES = 12;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SecretCode secretCode = new SecretCode();
        System.out.println("Welcome to Mastermind! Please enter a 4 digit (1-6) number. You have 12 tries, good luck!");
        for (int i = 0; i < NUMBER_TRIES; i++) {
            System.out.print("Enter your guess: ");
            String guess = scanner.nextLine();
            // if checks for invalid length and non-integer input
            if (guess.length() != 4) {
                System.out.println("Your guess should be 4 integers.");
            } else if (!guess.matches("^[0-9]+$")) {
                System.out.println("Your guess should not contain non-numeric characters.");
            } else {
                String guessResult = secretCode.checkGuess(guess);
                if (guessResult.equals("++++")) {
                    System.out.println("You solved it!");
                    return;
                }
                System.out.println(guessResult);
            }
        }

        System.out.println("You lose :(");
    }
}
