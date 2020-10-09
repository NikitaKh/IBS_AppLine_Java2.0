package com.ibs.appline.task_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private double ans;

    public void calculatorMenu(){
        try {
            Scanner sc = new Scanner(System.in);
            InputScanner input = new InputScanner();
            Calculator calc = new Calculator();
            System.out.println("*** КАЛЬКУЛЯТОР ***");
            System.out.print("Выберите операцию:\n 1.Сложение\n 2.Вычитание\n 3.Умножение\n 4.Деление\n >>> ");
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
                default -> System.out.println("            ***** ОШИБКА *****\n" +
                        "Необходимо ввести порядковый номер операции!\n\n");
            }

            if (input.getException())
                return;

            if (calc.getZero()){
                System.out.println("Делить на 0 нельзя!\n");
                return;
            }

            System.out.printf("Ответ: %.4f\n\n", ans);
        } catch (InputMismatchException e){
            System.out.println("            ***** ОШИБКА *****\n" +
                    "Необходимо ввести порядковый номер операции!\n");
        }
    }
}
