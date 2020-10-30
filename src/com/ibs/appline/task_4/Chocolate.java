package com.ibs.appline.task_4;

/**
 * @see Sweets
 */
public class Chocolate extends Sweets {

    private int cacao;

    public Chocolate(String name, double weight, double price, int cacao) {
        super(name, weight, price);
        this.cacao = cacao;
    }

    @Override
    public String toString() {
        return "Шоколад [" + super.toString() + ", % какао: " + cacao + "]";
    }
}
