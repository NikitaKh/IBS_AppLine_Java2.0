package com.ibs.appline.task_4;

public abstract class Sweets {
    private String name;
    private double weight;
    private double price;

    public Sweets(){}

    public Sweets(String name, double weight, double price){
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

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return ("наименование: " + name + ", вес: " + weight + "гр., цена: " + price + "руб.");
    }
}
