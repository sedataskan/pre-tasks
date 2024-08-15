package org.example.util;

import java.util.ArrayList;
import java.util.List;

import static org.example.util.Padder.leftPadding;

public class NumberParser {
    public static List<String> parseAsTriple(String input) {
        int digitNumber = input.length();

        input = leftPadding(input, digitNumber);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < digitNumber; i += 3) {
            result.addLast(input.substring(i, i + 3));
        }
        return result;
    }
}
