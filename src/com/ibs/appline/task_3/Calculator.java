package com.ibs.appline.task_3;

class Calculator implements Operations {

    private boolean zero = false;

    public boolean getZero(){
        return zero;
    }

    @Override
    public double sum(double num1, double num2) {
        return (num1 + num2);
    }

    @Override
    public double multiply(double num1, double num2) {
        return (num1 * num2);
    }

    @Override
    public double division(double num1, double num2) {
        if (num2 == 0) {
            zero = true;
        }
        return (num1 / num2);
    }

    @Override
    public double subtraction(double num1, double num2) {
        return (num1 - num2);
    }
}
