package com.ibs.appline.task_4;

public class JellyBean extends Sweets {

    private String taste;

    public JellyBean(){}

    public JellyBean(String name, double weight, double price, String taste) {
        super(name, weight, price);
        this.taste = taste;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    @Override
    public String toString() {
        return "Мармеладное дражже [" + super.toString() + ", вкус: " + taste + "]";
    }
}
