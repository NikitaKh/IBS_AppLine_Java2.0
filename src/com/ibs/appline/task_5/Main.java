package com.ibs.appline.task_5;

import java.util.Scanner;

/**
 * Реализация калькулятора с применением принципа преобразования из инфикса в постфикс (обратная польская нотация).
 * Необходимо в строку ввести выражение.
 * Пример: 2+3-1*(1+2), можно делать пробелы.
 *
 * @author Nikita Khvalin
 */
public class Main {

    public static void main(String[] args) {
        while (true) {
            System.out.print("Меню:\n" +
                    " 1. Выполнить вычисление\n" +
                    " 0. Выход\n" +
                    " >>> ");
            switch (new Scanner(System.in).nextLine()) {
                case "1" -> {
                    System.out.print("Выведите арифметическое выражение в строку:\n" +
                            " >>> ");
                    String postfix = InfixToPostfix.convertToPostfix(new Scanner(System.in).nextLine());
                    System.out.println("Ответ: " + Calculation.parsingPostfix(postfix));
                }
                case "0" -> System.exit(0);
                default -> throw new IllegalArgumentException();
            }
        }
    }
}
