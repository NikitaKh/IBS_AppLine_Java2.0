package com.ibs.appline.task_5;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfixToPostfix {

    /**
     * Регулярные выражения для проверки значений
     * 1. Валидность поступающих значений;
     * 2. Проверка на числа;
     * 3. Проверка на знаки;
     */
    private static final Pattern PATTERN_VALID = Pattern.compile("[\\+\\-\\*\\/\\(\\)\\.\\d]");
    private static final Pattern PATTERN_DIGIT = Pattern.compile("([0-9]*[.])?[0-9]+");
    private static final Pattern PATTERN_OPERATIONS = Pattern.compile("[\\+\\-\\*\\/\\(\\)][\\+\\-\\*\\/\\(\\)]*");


    /**
     * В данном методе введеный пример парсится на строки и записывается в листы
     * это позволило избежать ошибок при работе с значениями с плавающей точкой
     *
     * @param input строковое уравнение введенное с терминала
     * @return коллекция строк
     */
    public static List<String> infixListToArray(String input) {

        List<String> infixList = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            Matcher operMatch = PATTERN_OPERATIONS.matcher(Character.toString(input.charAt(i)));
            if (operMatch.find()) {
                infixList.add(Character.toString(input.charAt(i)));
            } else {
                StringBuilder digits = new StringBuilder();
                try {
                    do {
                        digits.append(input.charAt(i));
                        i++;
                    } while (Character.isDigit(input.charAt(i)) || input.charAt(i) == '.');
                    infixList.add(digits.toString());
                    i--;
                } catch (StringIndexOutOfBoundsException e) {
                    infixList.add(digits.toString());
                    break;
                }
            }
        }
        return infixList;
    }

    /**
     * Метод конвертации из инфикса в постфикс
     *
     * @param infixList введенный с терминала пользователем пример в виде листа
     * @return строка переведенная в постификс
     */

    public static List<String> convertToPostfix(List<String> infixList) {

        List<String> postfixList = new ArrayList<>();
        Stack<String> operator = new Stack<>();
        String popped;

        for (String get : infixList) {
            Matcher digitMatch = PATTERN_DIGIT.matcher(get);
            if (digitMatch.find()) {
                Matcher validMatcher = PATTERN_VALID.matcher(get);
                if (validMatcher.find()) {
                    postfixList.add(get);
                } else
                    throw new IllegalArgumentException();
            } else if (get.equals(")")) {
                try {
                    while (!(popped = operator.pop()).equals("(")) {
                        postfixList.add(popped);
                    }
                } catch (EmptyStackException e){
                    throw new NumberFormatException("Введено невалидное значение!");
                }
            } else {
                while (!operator.isEmpty() && !get.equals("(") && weights(operator.peek()) >= weights(get)) {
                    postfixList.add(operator.pop());
                }
                operator.push(get);
            }
        }
        while (!operator.isEmpty()) {
            postfixList.add(operator.pop());
        }
        return postfixList;
    }


    /**
     * Метод сортировки операторов по весу, чтобы распределять в правильном порядке в постфиксном выражении
     *
     * @param i строковой симвл
     * @return возвращается вес оператора или 0, если это числовое значение
     */
    private static int weights(String i) {
        return switch (i) {
            case "(", ")" -> 1;
            case "-", "+" -> 2;
            case "*", "/" -> 3;
            default -> 0;
        };
    }
}