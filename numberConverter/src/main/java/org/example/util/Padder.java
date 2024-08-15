package org.example.util;

public class Padder {
    protected static String leftPadding(String input, int digitNumber) {
        input = (digitNumber % 3 != 0) ? "0".repeat(3 - (digitNumber % 3)) + input : input;
        return input;
    }
}
