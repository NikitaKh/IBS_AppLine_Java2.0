package com.ibs.appline.task_5;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfixToPostfix {

    /**
     * Регулярное выражение для проверки введенных значений
     */
    private static final Pattern PATTERN_VALID = Pattern.compile("[\\+\\-\\*\\/\\(\\)\\d][\\+\\-\\*\\/\\(\\)\\d]*");

    /**
     * Метод конвертации из инфикса в постфикс
     *
     * @param infix введенный с терминала пользователем пример
     * @return строка переведенная в постификс
     */
    public static String convertToPostfix(String infix) {

        StringBuilder postfix = new StringBuilder();
        Stack<Character> operator = new Stack<>();
        char popped;

        for (int i = 0; i < infix.length(); i++) {

            char get = infix.charAt(i);

            if (!isOperator(get)) {
                Matcher digitMatch = PATTERN_VALID.matcher(Character.toString(get));
                if (digitMatch.find()) {
                    postfix.append(get);
                } else
                    throw new IllegalArgumentException();
            } else if (get == ')') {
                while ((popped = operator.pop()) != '(') {
                    postfix.append(popped);
                }
            } else {
                while (!operator.isEmpty() && get != '(' && weights(operator.peek()) >= weights(get)) {
                    postfix.append(operator.pop());
                }
                operator.push(get);
            }
        }
        while (!operator.isEmpty()) {
            postfix.append(operator.pop());
        }
        System.out.println(postfix);
        return postfix.toString();
    }

    /**
     * Метод проверки число или оператор
     *
     * @param i строковой симвл
     * @return если значение больше 0, то это оператор, если 0, то это числовое значение
     */
    private static boolean isOperator(char i) {
        return weights(i) > 0;
    }

    /**
     * Метод сортировки операторов по весу, чтобы распределять в правильном порядке в постфиксном выражении
     *
     * @param i строковой симвл
     * @return возвращается вес оператора или 0, если это числовое значение
     */
    private static int weights(char i) {
        if (i == '(' || i == ')') {
            return 1;
        } else if (i == '-' || i == '+') {
            return 2;
        } else if (i == '*' || i == '/') {
            return 3;
        } else
            return 0;
    }
}
