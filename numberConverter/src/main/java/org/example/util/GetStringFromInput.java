package org.example.util;

import java.util.ArrayList;
import java.util.List;

public class GetStringFromInput {
    public static List<String> getStringFromInput(int input) {
        int digitNumber = (int)Math.log10(input) + 1;
        String numberAsString = String.valueOf(input);

        numberAsString = (digitNumber % 3 != 0) ? "0".repeat(3 - (digitNumber % 3)) + numberAsString : numberAsString;
        List<String> coupleOfDigit = new ArrayList<>();
        for (int i = 0; i < numberAsString.length(); i += 3) {
            coupleOfDigit.add(numberAsString.substring(i, i + 3));
        }
        return coupleOfDigit;
    }
}
