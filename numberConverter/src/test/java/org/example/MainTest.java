//package org.example;
//
//import org.example.enums.Language;
//import org.example.factory.TranslatorFactory;
//import org.example.product.NumberTranslator;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.io.ByteArrayInputStream;
//import java.io.InputStream;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import java.util.Scanner;
//
//public class MainTest {
//
//    private NumberTranslator translator;
//
//    @BeforeEach
//    void setUp() {
//        // TranslatorFactory mock için statik metotları mockla
//        translator = mock(NumberTranslator.class);
//        when(TranslatorFactory.create(Language.e)).thenReturn(translator);
//        when(TranslatorFactory.create(Language.t)).thenReturn(translator);
//    }
//
//    @Test
//    void testValidLanguageAndInput() {
//        // Kullanıcı "E" dili seçiyor ve 5 sayısını giriyor
//        String input = "e\n5\n";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//
//        Scanner scanner = new Scanner(System.in);
//
//        // Translator mock davranışı
//        when(translator.translate(5)).thenReturn("Translated number in English: 5");
//
//        // Test edilen metot
//        NumberTranslator resultTranslator = Main.getLanguageCode(scanner);
//        int inputNumber = Main.getInput(scanner);
//        String result = resultTranslator.translate(inputNumber);
//
//        // Doğrulama
//        assertEquals("Translated number in English: 5", result);
//    }
//
//    @Test
//    void testInvalidLanguage() {
//        // Kullanıcı geçersiz bir dil ("X") seçiyor, ardından tekrar "E" giriyor
//        String input = "X\nE\n5\n";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//
//        Scanner scanner = new Scanner(System.in);
//
//        // Translator mock davranışı
//        when(translator.translate(5)).thenReturn("Translated number in English: 5");
//
//        // Test edilen metot
//        NumberTranslator resultTranslator = Main.getLanguageCode(scanner);
//        int inputNumber = Main.getInput(scanner);
//        String result = resultTranslator.translate(inputNumber);
//
//        // Doğrulama
//        assertEquals("Translated number in English: 5", result);
//    }
//
//    @Test
//    void testInvalidInput() {
//        // Kullanıcı "E" dili seçiyor, ardından geçersiz bir giriş (metin) yapıyor
//        String input = "e\nabc\n3\n";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//
//        Scanner scanner = new Scanner(System.in);
//
//        // Translator mock davranışı
//        when(translator.translate(3)).thenReturn("Translated number in English: 3");
//
//        // Test edilen metot
//        NumberTranslator resultTranslator = Main.getLanguageCode(scanner);
//        int inputNumber = Main.getInput(scanner);
//        String result = resultTranslator.translate(inputNumber);
//
//        // Doğrulama
//        assertEquals("Translated number in English: 3", result);
//    }
//}
