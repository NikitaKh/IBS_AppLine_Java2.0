package com.ibs.appline.task_3;

import java.util.InputMismatchException;
import java.util.Scanner;

class Menu {

    private double ans;

    Scanner sc = new Scanner(System.in);

    /**
     * Главное меню
     */
    public void mainMenu() {
        try {
            System.out.print("Выберите программу:\n 1.Калькулятор\n " +
                    "2.Поиск максимального элемента в массиве\n " +
                    "3.Выход\n >>> ");
            switch (sc.nextInt()) {
                case 1 -> calculatorMenu();
                case 2 -> arrayMenu();
                case 3 -> System.exit(0);
                default -> System.out.println("            ***** ОШИБКА *****\n" +
                        "Необходимо ввести порядковый номер программы!\n");
            }
        } catch (InputMismatchException e) {
            System.out.println("            ***** ОШИБКА *****\n" +
                    "Необходимо ввести порядковый номер программы!\n");
        }
    }

    /**
     * Меню калькулятора
     */
    private void calculatorMenu() {
        try {
            InputScanner input = new InputScanner();
            Calculator calc = new Calculator();
            System.out.println("*** КАЛЬКУЛЯТОР ***");
            System.out.print("Выберите операцию:\n 1.Сложение\n 2.Вычитание\n " +
                    "3.Умножение\n 4.Деление\n 0.Выход в главное меню\n >>> ");
            switch (sc.nextInt()) {
                case 1 -> {
                    input.sumScanner();
                    ans = calc.sum(input.getVar1(), input.getVar2());
                }
                case 2 -> {
                    input.subtractionScanner();
                    ans = calc.subtraction(input.getVar1(), input.getVar2());
                }
                case 3 -> {
                    input.multiplyScanner();
                    ans = calc.multiply(input.getVar1(), input.getVar2());
                }
                case 4 -> {
                    input.divisionScanner();
                    ans = calc.division(input.getVar1(), input.getVar2());
                }
                case 0 -> mainMenu();
                default -> System.out.println("            ***** ОШИБКА *****\n" +
                        "Необходимо ввести порядковый номер операции!\n\n");
            }

            if (input.getException())
                return;

            if (calc.getZero()) {
                System.out.println("Делить на 0 нельзя!\n");
                return;
            }

            System.out.printf("Ответ: %.4f\n\n", ans);
            calculatorMenu();
        } catch (InputMismatchException e) {
            System.out.println("            ***** ОШИБКА *****\n" +
                    "Необходимо ввести порядковый номер операции!\n");
        }
    }

    /**
     * Меню программы парсера
     */
    private void arrayMenu() {
        boolean exception = true;
        try {
            System.out.println("*** Поиск максимального элемента в массиве ***");
            System.out.print("Выберите операцию:\n 1.Задать длину массива\n 2.Выход в главное меню\n >>> ");
            switch (sc.nextInt()) {
                case 1 -> {
                    exception = false;
                    System.out.print("Введите длину массива >>> ");
                    ArrayParser pars = new ArrayParser(sc.nextInt());
                }
                case 2 -> mainMenu();
                default -> System.out.println("            ***** ОШИБКА *****\n" +
                        "Необходимо ввести порядковый номер операции!\n\n");
            }
            arrayMenu();
        } catch (InputMismatchException e) {
            if (exception) {
                System.out.println("            ***** ОШИБКА *****\n" +
                        "Необходимо ввести порядковый номер операции!\n");
            } else {
                System.out.println("*** Нужно вводить числа! ***\n");
            }
        }
    }
}
