package org.example.enums;

public enum EngNumberWords {
    ONES(new String[] {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"}),
    TEN(new String[]{"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"}),
    TENS(new String[]{"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"}),
    POSTFIX(new String[]{"", "hundred", "thousand", "million", "billion", "trillion"});

    final String[] engnumberwords;

    EngNumberWords(String[] input) {
        this.engnumberwords = input;
    }

    public String[] getEngNumberWords() {
        return engnumberwords;
    }
}
