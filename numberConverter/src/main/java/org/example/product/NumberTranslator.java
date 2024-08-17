package org.example.product;

public interface NumberTranslator {
    String translate(int input);
    default String translate(double input){
        int intPart = 0;
        int fractionalPart=0;
        return translate(intPart)+" "+translate(fractionalPart);
    }
}
