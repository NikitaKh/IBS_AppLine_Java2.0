package com.ibs.appline.java;


import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * This class implements arithmetical operations
 */
class Operations {

    /**
     * Sum
     * @param var1 first var
     * @param var2 second var
     */
    public void sum(float var1, float var2){
        System.out.printf("Sum is: %.4f\n\n", var1 + var2);
    }

    public void subtraction(float var1, float var2){
        System.out.printf("Subtract is: %.4f\n\n", var1 - var2);
    }

    public void division(float var1, float var2){
        if (var2 == 0){
            System.out.println("Division by zero is not allowed!" + "\n");
        } else {
            System.out.printf("Division is: %.4f\n\n", var1 / var2);
        }
    }

    public void multiplication(float var1, float var2){
        System.out.printf("Multiplication is: %.4f\n\n", var1 * var2);
    }
}

/**
 * This class implements menu
 *
 * @author Nikita Khvalin
 * @see Operations
 */
class Menu {

    Scanner sc = new Scanner(System.in);
    private float var1;
    private float var2;

    public Menu(){
        System.out.print("This program implements operations with numbers!\n");
        mainMenue();
    }

    /**
     * Menu implementation
     */
    public void mainMenue (){
        Operations op = new Operations();
        System.out.print("Possible operations: \n 1. Sum\n 2. Subtraction\n 3. Division\n 4. Multiplication\n 0. Exit\n");
        System.out.print("Write ordinal number of operation: ");

        try {
            int operation = sc.nextInt();

            switch (operation){
                case 1:
                    varScanner();
                    op.sum(var1, var2);
                    mainMenue();
                    break;
                case 2:
                    varScanner();
                    op.subtraction(var1, var2);
                    mainMenue();
                    break;
                case 3:
                    varScanner();
                    op.division(var1, var2);
                    mainMenue();
                    break;
                case 4:
                    varScanner();
                    op.multiplication(var1, var2);
                    mainMenue();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("          ***** ERROR *****\n" +
                            "You have to write ordinal number of operation!\n");
                    mainMenue();
                    break;
            }
        } catch (InputMismatchException e){
            System.out.println("          ***** ERROR *****\n" +
                    "You have to write ordinal number of operation!\n");
        }
    }

    /**
     * Variables scanning method
     */
    private void varScanner(){
        try {
            System.out.println("Enter the first number: ");
            var1 = sc.nextFloat();
            System.out.println("Enter the second number: ");
            var2 = sc.nextFloat();
        } catch (InputMismatchException e){
            System.out.println("You have to write numbers!");
        }
    }
}

/**
 * Main class
 *
 * @author Nikita Khvalin
 */
public class Task_2 {
    public static void main(String[] args){
        while (true){
            Menu menue = new Menu();
        }
    }
}
