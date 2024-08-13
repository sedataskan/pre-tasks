package org.example;

import org.example.factory.TranslatorFactory;
import org.example.language.NumberTranslator;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Select a Language!\n-Press E for English or T for Turkish: ");
        String lang = scanner.nextLine();

        if (!List.of("e", "t").contains(lang.toLowerCase())) {
            main(args);
            return;
        }

        System.out.println("Your int Input: ");
        int input = scanner.nextInt();

        NumberTranslator translator = TranslatorFactory.create(lang);
        var result = translator.translate(input);
        System.out.println(result);
    }
}