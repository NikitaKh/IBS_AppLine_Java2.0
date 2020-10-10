package com.ibs.appline.task_4;

public class Chocolate extends Sweets {

    private int cocao;

    public Chocolate(){}

    public Chocolate(String name, double weight, double price, int cocao) {
        super(name, weight, price);
        this.cocao = cocao;
    }

    public int getCocao() {
        return cocao;
    }

    public void setCocao(int cocao) {
        this.cocao = cocao;
    }

    @Override
    public String toString() {
        return "Шоколад [" + super.toString() + ", % кокао: " + cocao + "]";
    }
}
