package com.ibs.appline.task_4;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ArrayGenerator {

    private int[] intArray = new int[20];
    private int minPos;
    private int maxPos;

    public ArrayGenerator(){
        intsGen();
        positionFinder();
        swap(minPos, maxPos);
    }

    public void intsGen(){
        Random rn = new Random();
        for (int i = 0; i < intArray.length; i++){
            intArray[i] = rn.nextInt((10 - (-10)) + 1) + (-10);
        }
        System.out.print("Создан массив\n" +
                " >>> ");
        System.out.println(Arrays.toString(intArray));
    }

    public void positionFinder(){
        int numMin = 0;
        int numMax = 0;
        for (int i = 0; i < intArray.length; i++){
            if(numMin < intArray[i]){
                numMin = intArray[i];
                minPos = i;
            }
            if (numMax > intArray[i]){
                numMax = intArray[i];
                maxPos = i;
            }
        }
        System.out.printf("Минимальный элемент %d, %d-й по счету!\n", numMin, (minPos + 1));
        System.out.printf("Максимальный элемент %d, %d-й по счету!\n", numMax, (maxPos + 1));
        System.out.println();
    }

    private void swap (int minPos, int maxPos) {
        System.out.println("Меняем местами минимальный и максимальный элементы >>> ");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int c = intArray[minPos];
        intArray[minPos] = intArray[maxPos];
        intArray[maxPos] = c;
        System.out.print("Создан новый массив\n" +
                " >>> ");
        System.out.println(Arrays.toString(intArray));
        System.out.printf("Минимальный элемент %d, %d-й по счету!\n", intArray[minPos], (minPos + 1));
        System.out.printf("Максимальный элемент %d, %d-й по счету!\n", intArray[maxPos], (maxPos + 1));
        System.out.println();
    }
}
