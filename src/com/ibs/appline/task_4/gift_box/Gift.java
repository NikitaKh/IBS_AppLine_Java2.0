package com.ibs.appline.task_4.gift_box;

import java.util.LinkedList;
import java.util.List;

/**
 * В этом классе реализована основная логика программы сборщика подарка
 */
public class Gift {

    List<Sweets> sweets = new LinkedList<>();
    private double totalWeight = 100;
    private double totalPrice;

    public double getTotalWeight() {
        return totalWeight;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void addItem(Sweets sweet) {
        sweets.add(sweet);
        totalPrice += sweet.getPrice();
        totalWeight += sweet.getWeight();
    }

    public void printItems() {
        for (Sweets s : sweets) {
            System.out.println(s.description());
        }
    }
}
