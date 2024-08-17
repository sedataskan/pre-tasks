package org.example.product;

public interface NumberTranslator {
    String translate(int intInput);
    String[] translate();
    default String translate(double doubleInput) {
        var intPart = (int) doubleInput;
        var fractionalPart = (int) Math.round((doubleInput - intPart) * 100);

        var sb = new StringBuilder();

        if (fractionalPart == 0) {
            sb.append(translate(intPart));
        } else {
            sb.append(translate(intPart)).append(translate()[0]).append(translate(Math.abs(fractionalPart)));
        }
        return sb.toString();
    }
}
