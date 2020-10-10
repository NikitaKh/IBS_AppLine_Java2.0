package com.ibs.appline.task_4;

/**
 * Класс конфет))))
 *
 * @see Sweets
 */
public class Candy extends Sweets {

    private String filling;

    public Candy() {
    }

    public Candy(String name, double weight, double price, String filling) {
        super(name, weight, price);
        this.filling = filling;
    }

    public String getFilling() {
        return filling;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }

    @Override
    public String toString() {
        return "Конфеты [" + super.toString() + ", начинка: " + filling + "]";
    }
}
