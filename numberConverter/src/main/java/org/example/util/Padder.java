package org.example.util;

public class Padder {
    protected static String leftPadding(String input, int digitNumber) {
        System.out.println("Input: " + input);
        input = (digitNumber % 3 != 0) ? "0".repeat(3 - (digitNumber % 3)) + input : input;
        System.out.println("Padded input: " + input);
        return input;
    }
}
