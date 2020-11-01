package com.ibs.appline.task_4.gift_box;

/**
 * @see Sweets
 */
public class Chocolate extends Sweets {

    private final int cacao;

    public Chocolate(String name, int cacao) {
        super(name);
        this.cacao = cacao;
    }

    public Chocolate(String name, double weight, double price, int cacao) {
        super(name, weight, price);
        this.cacao = cacao;
    }

    @Override
    public String description() {
        return "Шоколад [" + super.toString() + ", % какао: " + cacao + "]";
    }
}
