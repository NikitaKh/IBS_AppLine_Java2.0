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

class ArrayLen {

    private int arrayLen;

    public ArrayLen(int arrayLen){
        this.arrayLen = arrayLen;
        arraysScanner();
    }

    /**
     * This method scanning input and writing it to string array
     */
    private void arraysScanner(){
        Scanner sc = new Scanner(System.in);
        String[] stringArray = new String[arrayLen];
        for(int i = 0; i < arrayLen; i++){
            System.out.printf("Input %d word: ", (i + 1));
            stringArray[i] = sc.nextLine();
            System.out.println();
        }
        arrayParser(stringArray);
    }

    /**
     * Method for finding the largest array
     *
     * @param array array of strings
     */

    private void arrayParser(String[] array){
        int tmp = 0;
        int word = 0;
        for (int i = 0; i < array.length; i++){
            if(array[i].length() > tmp){
                tmp = array[i].length();
                word = i;
            }
        }
        System.out.println("The longest word is >> " + array[word] + "\n");
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

    /**
     * Main menu
     */
    public void menu(){
        System.out.print("Possible programs: \n 1. Calculator\n 2. String array counter\n 0. Exit\n");
        try {
            System.out.print("Your choice >> ");
            switch (sc.nextInt()){
                case 1:
                    System.out.print("This program implements operations with numbers!\n");
                    calculator();
                    break;
                case 2:
                    System.out.println("This program find's the longest string in the string array!");
                    stringArray();
                    break;
                case 0:
                    System.exit(0);
            }
        } catch (InputMismatchException e){
            System.out.println("          ***** ERROR *****\n" +
                    "You have to write ordinal number of program!\n");
        }
    }

    /**
     * Menu implementation
     */
    private void calculator() {
        Operations op = new Operations();
        System.out.print("Possible operations: \n 1. Sum\n 2. Subtraction\n 3. Division\n 4. Multiplication\n 0. Exit\n");
        System.out.print("Write ordinal number of operation: ");

        try {
            int operation = sc.nextInt();

            switch (operation){
                case 1:
                    varScanner();
                    op.sum(var1, var2);
                    menu();
                    break;
                case 2:
                    varScanner();
                    op.subtraction(var1, var2);
                    menu();
                    break;
                case 3:
                    varScanner();
                    op.division(var1, var2);
                    menu();
                    break;
                case 4:
                    varScanner();
                    op.multiplication(var1, var2);
                    menu();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("          ***** ERROR *****\n" +
                            "You have to write ordinal number of operation!\n");
                    menu();
                    break;
            }
        } catch (InputMismatchException e){
            System.out.println("          ***** ERROR *****\n" +
                    "You have to write ordinal number of operation!\n");
        }
    }

    /**
     * Sub method to call array parser
     */
    private void stringArray(){
        System.out.print("Set the length of array: ");
        try {
            ArrayLen arrayLenCounter = new ArrayLen(sc.nextInt());
        } catch (InputMismatchException e){
            System.out.println("You should use ints!");
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
            Menu main = new Menu();
            main.menu();
        }
    }
}
