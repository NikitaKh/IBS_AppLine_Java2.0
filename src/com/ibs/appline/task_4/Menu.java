package com.ibs.appline.task_4;

import com.ibs.appline.task_4.array_gen.ArrayGenerator;
import com.ibs.appline.task_4.gift_box.Candy;
import com.ibs.appline.task_4.gift_box.Chocolate;
import com.ibs.appline.task_4.gift_box.Gift;
import com.ibs.appline.task_4.gift_box.JellyBean;

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
                Gift present = new Gift();
                present.addItem(new Candy("Стэп", 150, 298.20, "орехи и карамель"));
                present.addItem(new Chocolate("Бабаевский", 100, 55, 60));
                present.addItem(new JellyBean("Haribo", 75, 135, "вишня + земляника"));
                present.printItems();
                System.out.println("Общий вес подарка: " + present.getTotalWeight());
                System.out.println("Общая цена подарка: " + present.getTotalPrice());
            }
            case 3 -> System.exit(0);
            default -> System.out.println("            ***** ОШИБКА *****\n" +
                    "Необходимо ввести порядковый номер программы!\n");
        }
    }
}
