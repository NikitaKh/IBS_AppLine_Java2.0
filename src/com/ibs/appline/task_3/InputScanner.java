package com.ibs.appline.task_3;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * В этом классе реализованы сканеры инфомации с консоли
 */
class InputScanner {

    Scanner sc = new Scanner(System.in);

    private float var1;
    private float var2;
    private boolean exception = false;

    public float getVar1() {
        return var1;
    }

    public float getVar2() {
        return var2;
    }

    public boolean getException() {
        return exception;
    }

    /**
     * Сканер для операции сложения
     */
    public void sumScanner() {
        try {
            System.out.println("Введите первое слагаемое: ");
            var1 = sc.nextFloat();
            System.out.println("Введите второе слагаемое: ");
            var2 = sc.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("*** Нужно вводить числа! ***\n");
            exception = true;
        }
    }

    /**
     * Сканер для операции умножения
     */
    public void multiplyScanner() {
        try {
            System.out.println("Введите первый множитель: ");
            var1 = sc.nextFloat();
            System.out.println("Введите второй множитель: ");
            var2 = sc.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("*** Нужно вводить числа! ***\n");
            exception = true;
        }
    }

    /**
     * Сканер для операции деления
     */
    public void divisionScanner() {
        try {
            System.out.println("Введите делимое: ");
            var1 = sc.nextFloat();
            System.out.println("Введите делитель: ");
            var2 = sc.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("*** Нужно вводить числа! ***\n");
            exception = true;
        }
    }

    /**
     * Сканер для операции вычетания
     */
    public void subtractionScanner() {
        try {
            System.out.println("Введите уменьшаемое: ");
            var1 = sc.nextFloat();
            System.out.println("Введите вычитаемое: ");
            var2 = sc.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("*** Нужно вводить числа! ***\n");
            exception = true;
        }
    }

    /**
     * Сканер строки для работы с парсером массива строк
     *
     * @see ArrayParser
     */
    public String[] stringsScanner(int arrayLen) {
        String[] stringArray = new String[arrayLen];
        for (int i = 0; i < arrayLen; i++) {
            System.out.printf("Введите %d слово >> ", (i + 1));
            stringArray[i] = sc.nextLine();
        }
        return stringArray;
    }
}
