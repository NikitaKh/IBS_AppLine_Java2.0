package com.ibs.appline.task_5;

import java.util.Stack;

public class Calculation {

    /**
     * В данном методе парсится сгенерированная постфиксная строка, идет последовательная запись чисел в стек,
     * в случае если попадается оператор, то достаются последние два числа из стека и к ним применяется
     * арифметическая операция, согласно переданной в строке
     *
     * @param inputString строка с постфиксным выражением
     * @return долгожданный результат всего выражения =)
     */
    public static double parsingPostfix(String inputString) {
        Stack<Double> calc = new Stack<>();
        for (int i = 0; i < inputString.length(); i++) {
            if (Character.isDigit(inputString.charAt(i))) {
                calc.add(Double.parseDouble(String.valueOf(inputString.charAt(i))));
            } else {
                if (i == 1) {
                    calc.set(0, (calc.lastElement() * -1));
                    continue;
                }
                double opB = calc.remove(calc.size() - 1);
                double opA = calc.remove(calc.size() - 1);
                double tempCalc = makeCalculation(inputString.charAt(i), opA, opB);
                calc.add(tempCalc);
            }
        }
        return calc.remove(calc.size() - 1);
    }

    /**
     * Метод выполняет арифметическую отперацию в зависимости от поступающих значений
     *
     * @param operator арифметический оператор
     * @param operandA первый операнд
     * @param operandB второй операнд
     * @return результат арифметического уравнения
     */
    private static double makeCalculation(char operator, double operandA, double operandB) {
        double result = 0;
        switch (operator) {
            case '+':
                result = operandA + operandB;
                break;
            case '-':
                result = operandA - operandB;
                break;
            case '*':
                result = operandA * operandB;
                break;
            case '/':
                if (operandB == 0.0) {
                    throw new ArithmeticException("Деление на ноль");
                } else {
                    result = operandA / operandB;
                }
                break;
        }
        return result;
    }
}
