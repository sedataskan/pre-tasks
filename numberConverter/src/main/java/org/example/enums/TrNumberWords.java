package org.example.enums;

public enum TrNumberWords {
    ONES(new String[]{"", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz"}),
    TENS(new String[]{"", "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan"}),
    POSTFIX(new String[]{"", "yüz", "bin", "milyon", "milyar", "trilyon"});

    final String[] trnumberwords;

    TrNumberWords(String[] input) {
        this.trnumberwords = input;
    }

    public String[] getTrNumberWords() {
        return trnumberwords;
    }
}
