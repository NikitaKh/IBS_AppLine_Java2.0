package com.ibs.appline.task_5;

import java.util.Scanner;

import static jdk.nashorn.internal.objects.Global.Infinity;

/**
 * Реализация калькулятора с применением бинарного дерева.
 * Необходимо в строку ввести выражение.
 * !!! На данный момент программа не поддерживает скобки !!!
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
                    AST ast = AST.create(new Scanner(System.in).nextLine());
                    var res = ast.calc();
                    if (res == Infinity) {
                        System.out.println("Делить на 0 нельзя!\n");
                        break;
                    }
                    System.out.printf("Ответ = %.2f\n\n", res);
                    break;
                }
                case "0" -> {
                    System.exit(0);
                    break;
                }
                default -> {
                    throw new IllegalArgumentException();
                }
            }
        }
    }
}
