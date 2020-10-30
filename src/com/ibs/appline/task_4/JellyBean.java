package com.ibs.appline.task_4;

/**
 * @see Sweets
 */
public class JellyBean extends Sweets {

    private String taste;

    public JellyBean(String name, double weight, double price, String taste) {
        super(name, weight, price);
        this.taste = taste;
    }

    @Override
    public String toString() {
        return "Мармеладное драже [" + super.toString() + ", вкус: " + taste + "]";
    }
}
