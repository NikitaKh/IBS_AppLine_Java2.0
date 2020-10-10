package com.ibs.appline.task_2;

/**
 * В этом классе реализованы арифметические операции
 *
 * @see Operations
 */
class Calculator implements Operations {

    private boolean zero = false;

    /**
     * Метод проверки на ноль
     *
     * @return возвращает true если деление на 0
     */
    public boolean getZero() {
        return zero;
    }

    /**
     * Операция сложения
     *
     * @param num1 первое слагаемое
     * @param num2 второе слагаемое
     * @return возвращается сумма
     */
    @Override
    public double sum(double num1, double num2) {
        return (num1 + num2);
    }

    /**
     * Операция умножения
     *
     * @param num1 первый множитель
     * @param num2 второй множитель
     * @return результат перемножения
     */
    @Override
    public double multiply(double num1, double num2) {
        return (num1 * num2);
    }

    /**
     * Оперция деления
     *
     * @param num1 делимое
     * @param num2 делитель
     * @return частное
     */
    @Override
    public double division(double num1, double num2) {
        if (num2 == 0) {
            zero = true;
        }
        return (num1 / num2);
    }

    /**
     * Операция вычетания
     *
     * @param num1 уменьшаемое
     * @param num2 вычитаемое
     * @return резульат
     */
    @Override
    public double subtraction(double num1, double num2) {
        return (num1 - num2);
    }
}
