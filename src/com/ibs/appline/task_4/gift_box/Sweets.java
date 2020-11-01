package com.ibs.appline.task_4.gift_box;

/**
 * Абстрактный класс сладостей)
 */
public abstract class Sweets {
    private String name;
    private double weight;
    private double price;

    public Sweets(String name) {
        this.name = name;
    }

    public Sweets(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws Exception {
        if (price < 0) {
            throw new Exception("Цена не может быть меньше 0!");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return ("наименование: " + name + ", вес: " + weight + "гр., цена: " + price + "руб.");
    }

    public abstract String description();
}
