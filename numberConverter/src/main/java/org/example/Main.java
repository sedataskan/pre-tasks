package org.example;

import org.example.enums.Language;
import org.example.factory.TranslatorFactory;
import org.example.product.NumberTranslator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        NumberTranslator translator = getLanguageCode(scanner);

        var input = getInput(scanner);

        var result = translator.translate(input);
        System.out.println(result);
    }

    private static NumberTranslator getLanguageCode(Scanner scanner) {

        System.out.println("Please Select a Language!\n-E for English or T for Turkish: ");
        String lang = scanner.nextLine();

        if (isValidLanguage(lang)) {
            Language language = Language.valueOf(lang.toLowerCase());
            System.out.println(STR."Selected language: \{language}");

            return TranslatorFactory.create(language);
        } else {
            System.out.println("I cannot translate in this language. Please enter a valid language.");
            return getLanguageCode(scanner);
        }
    }
    private static boolean isValidLanguage(String lang) {
        try {
            Language.valueOf(lang);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private static double getInput(Scanner scanner) {
        var input = 0.0;
        try{
            String str = scanner.nextLine();
            input = Double.parseDouble(str.replace(',', '.'));
        } catch (Exception e) {
            System.out.println("I cannot translate these numbers. Please enter a valid number.");
            scanner.nextLine();
            return getInput(scanner);
        }
        return input;
    }
}