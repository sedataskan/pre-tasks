package org.example.util;

import java.util.ArrayList;
import java.util.List;

public class NumberParser {
    public static List<String> parseAsTriple(int input) {
        String numberAsString = String.valueOf(input);
        int digitNumber = numberAsString.length();

        numberAsString = leftPadding(numberAsString, digitNumber);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < numberAsString.length(); i += 3) {
            result.addLast(numberAsString.substring(i, i + 3));
        }
        return result;
    }

    private static String leftPadding(String numberAsString, int digitNumber) {
        numberAsString = (digitNumber % 3 != 0) ? "0".repeat(3 - (digitNumber % 3)) + numberAsString : numberAsString;
        return numberAsString;
    }
}
