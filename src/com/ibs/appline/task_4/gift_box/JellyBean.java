package com.ibs.appline.task_4.gift_box;

/**
 * @see Sweets
 */
public class JellyBean extends Sweets {

    private final String taste;

    public JellyBean(String name, String taste) {
        super(name);
        this.taste = taste;
    }

    public JellyBean(String name, double weight, double price, String taste) {
        super(name, weight, price);
        this.taste = taste;
    }

    @Override
    public String description() {
        return "Мармеладное драже [" + super.toString() + ", вкус: " + taste + "]";
    }
}
