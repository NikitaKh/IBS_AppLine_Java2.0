package com.ibs.appline.task_5;

import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculation {

    /**
     * Регулярные выражения для проверки числовых значений
     */
    private static final Pattern PATTERN_DIGIT = Pattern.compile("([0-9]*[.])?[0-9]+");


    /**
     * В данном методе парсится сгенерированная постфиксная строка, идет последовательная запись чисел в стек,
     * в случае если попадается оператор, то достаются последние два числа из стека и к ним применяется
     * арифметическая операция, согласно переданной в строке
     *
     * @param postfixList строка с постфиксным выражением
     * @return долгожданный результат всего выражения =)
     */
    public static double parsingPostfix(List<String> postfixList) {
        Stack<Double> calc = new Stack<>();
        for (int i = 0; i < postfixList.size(); i++) {
            Matcher digitMatch = PATTERN_DIGIT.matcher(postfixList.get(i));
            if (digitMatch.find()) {
                calc.add(Double.parseDouble(postfixList.get(i)));
            } else {
                if (i == 1) {
                    calc.set(0, (calc.lastElement() * -1));
                    continue;
                }
                double opB = calc.remove(calc.size() - 1);
                double opA = calc.remove(calc.size() - 1);
                double tempCalc = makeCalculation(postfixList.get(i), opA, opB);
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
    private static double makeCalculation(String operator, double operandA, double operandB) {
        double result;
        switch (operator) {
            case "+":
                result = operandA + operandB;
                break;
            case "-":
                result = operandA - operandB;
                break;
            case "*":
                result = operandA * operandB;
                break;
            case "/":
                if (operandB == 0.0) {
                    throw new ArithmeticException("Деление на ноль");
                } else {
                    result = operandA / operandB;
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }
        return result;
    }
}
