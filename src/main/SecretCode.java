package main;

import java.util.*;

public class SecretCode {
    private static final int[] SECRET_CODE_ARRAY = new int[4];
    private static final int SECRET_CODE_LENGTH = 4;
    private static final Random RANDOM = new Random();
    private static String SECRET_CODE_STRING;

    public SecretCode() {
        // initialize SECRET_CODE with 4 random numbers 1-6
        initializeSecretCode();
    }

    private void initializeSecretCode() {
        for (int i = 0; i < SECRET_CODE_LENGTH; i++) {
            SECRET_CODE_ARRAY[i] = RANDOM.nextInt(6) + 1;
        }
        StringBuilder builder = new StringBuilder();
        for (int i : SECRET_CODE_ARRAY) {
            builder.append(i);
        }
        SECRET_CODE_STRING = builder.toString();
    }

    public String checkGuess(String guess) {
        StringBuilder builder = new StringBuilder();
        List<Integer> unmatched_indices = new ArrayList<>();
        ArrayList<Integer> unmatched_numbers = new ArrayList<>();
        // 4 since secret code is 4 digits every time
        for (int i = 0; i < SECRET_CODE_LENGTH; i++) {
            // characters are represented as Unicode i.e. 0 is 48
            // numerical value - '0' effectively converts to its numerical value
            // efficient way of comparing character by character
            int current = guess.charAt(i) - '0';
            if (current == SECRET_CODE_ARRAY[i]) {
                builder.append("+");
            } else {
                // put the other characters in a set to check later
                // put index in a list to iterate through later
                unmatched_indices.add(i);
                unmatched_numbers.add(current);
            }
        }
        // iterate through non matched characters
        // if its character is in the set, then add a '-' and then remove it from the set
        for (Integer i : unmatched_indices) {
            if (unmatched_numbers.contains(SECRET_CODE_ARRAY[i])) {
                builder.append("-");
                unmatched_numbers.remove(unmatched_numbers.indexOf(SECRET_CODE_ARRAY[i]));
            }
        }
        return builder.toString();
    }

    public static String getSecretCode() {
        // return a copy of the array to avoid users modifying the original values
        return SECRET_CODE_STRING;
    }
}
