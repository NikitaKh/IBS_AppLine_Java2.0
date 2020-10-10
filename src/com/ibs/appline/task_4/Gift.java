package com.ibs.appline.task_4;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * В этом классе реализована основная логика программы сборщика подарка
 */
public class Gift {

    private int candyEmount;
    private int chocolateEmount;
    private int jellyEmount;
    private boolean exception = false;

    Scanner sc = new Scanner(System.in);

    public Gift() {
        showGifts();
    }

    public boolean isException() {
        return exception;
    }

    /**
     * Метод сканирует кол-во конфет
     */
    private void candyScanner() {
        try {
            System.out.print("Сколько упаковок конфет вы хотите использовать?\n");
            candyEmount = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Необходимо вводить ко-во в виде цифр!");
            exception = true;
        }
    }

    /**
     * Метод сканирует кол-во шоколада
     */
    private void chocolateScanner() {
        try {
            System.out.print("Сколько плиток шоколада вы хотите использовать?\n");
            chocolateEmount = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Необходимо вводить ко-во в виде цифр!");
            exception = true;
        }
    }

    /**
     * Метод сканирует кол-во мармеладок
     */
    private void jellyScanner() {
        try {
            System.out.print("Сколько мармеладных драже вы хотите использовать?\n");
            jellyEmount = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Необходимо вводить ко-во в виде цифр!");
            exception = true;
        }
    }

    /**
     * Метод выводит информацию по подарку
     */
    public void showGifts() {
        System.out.println("Выберите сладости из списка: ");
        Candy step = new Candy("СТЭП", 1000, 491, "орехи и карамель");
        Chocolate black = new Chocolate("Бабаевский", 100, 59.90, 90);
        JellyBean gummy = new JellyBean("Haribo", 100, 67, "малина и ежевика");
        Sweets[] gift = {step, black, gummy};

        for (Sweets someSweet : gift) {
            System.out.println(someSweet.toString());
        }

        try {
            candyScanner();
            if (exception) {
                return;
            }
            chocolateScanner();
            if (exception) {
                return;
            }
            jellyScanner();
            if (exception) {
                return;
            }
        } catch (Exception e) {
            return;
        }

        System.out.printf("\nИнформация по подарку:\n" +
                ">>> Вес: %.2f\n" +
                ">>> Стоимость: %.2f\n", ((candyEmount * step.getWeight()) +
                (chocolateEmount * black.getWeight()) +
                (jellyEmount * gummy.getWeight())), ((candyEmount * step.getPrice()) +
                (chocolateEmount * black.getPrice()) +
                (jellyEmount * gummy.getPrice())));
        System.out.print("Состав:\n");

        step.setPrice(candyEmount * step.getPrice());
        step.setWeight(candyEmount * step.getWeight());

        black.setPrice(chocolateEmount * black.getPrice());
        black.setWeight(chocolateEmount * black.getWeight());

        gummy.setPrice(jellyEmount * gummy.getPrice());
        gummy.setWeight(jellyEmount * gummy.getWeight());

        Sweets[] giftAll = {step, black, gummy};
        for (Sweets someSweet : giftAll) {
            System.out.println(someSweet.toString());
        }
    }
}
