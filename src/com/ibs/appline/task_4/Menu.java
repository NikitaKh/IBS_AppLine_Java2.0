package com.ibs.appline.task_4;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {

    Scanner sc = new Scanner(System.in);

    public void mainMenu() throws InputMismatchException {
        System.out.print("\nВыберете программу:\n 1.Найти максимальный отрицательный и минимальный положительный элементы массива\n" +
                " 2.Cформировать новогодний подарок\n" +
                " 3.Выход\n" +
                " >>> ");
        switch (sc.nextInt()) {
            case 1 -> {
                ArrayGenerator make = new ArrayGenerator();
            }
            case 2 -> {
                System.out.println("\n *** Давайте соберем подарок! *** ");
                Gift present = new Gift();
                if (present.isException()) {
                    return;
                }
            }
            case 3 -> System.exit(0);
            default -> System.out.println("            ***** ОШИБКА *****\n" +
                    "Необходимо ввести порядковый номер программы!\n");
        }
    }
}
