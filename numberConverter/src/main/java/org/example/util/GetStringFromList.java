package org.example.util;

import java.util.List;

public class GetStringFromList {
    public static String getStringFromList(List<String> stringNumbers) {
        StringBuilder translatedNumber = new StringBuilder();
        for (String ch : stringNumbers) {
            translatedNumber.append(ch.trim()).append(" ");
        }
        return translatedNumber.toString();
    }
}
