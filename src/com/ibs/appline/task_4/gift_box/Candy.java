package com.ibs.appline.task_4.gift_box;

/**
 * Класс конфет))))
 *
 * @see Sweets
 */
public class Candy extends Sweets {

    private final String filling;

    public Candy(String name, String filling) {
        super(name);
        this.filling = filling;
    }

    public Candy(String name, double weight, double price, String filling) {
        super(name, weight, price);
        this.filling = filling;
    }

    @Override
    public String description() {
        return "Конфеты [" + super.toString() + ", начинка: " + filling + "]";
    }
}
