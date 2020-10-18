package com.ibs.appline.task_5;


/**
 * При выхове данного класса происходит запись числовых значений в левый или правый узел.
 */
public class Term implements Node {
    private final double value;

    public Term(double value) {
        this.value = value;
    }

    @Override
    public Node getLeft() {
        return null;
    }

    @Override
    public String getOp() {
        return null;
    }

    @Override
    public Node getRight() {
        return null;
    }

    @Override
    public double apply() {
        return value;
    }
}
