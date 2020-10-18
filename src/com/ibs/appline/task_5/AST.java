package com.ibs.appline.task_5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Abstract Syntax Tree (AST)
 * Абстрактное синтаксическое дерево.
 * <p>
 * В данном класе проводится анализ введенных с консоли данных
 * Происходит парсинг цифр и операторов
 * В левый узел записывается перыое значение, во второй узел записываетя второе значение,
 * в результате парсинга оператора получаем итоговый оператор, выполняется операция,
 * далее, если у нас еще есть данные для продолжения вычислений, создается новая ветвь,
 * в левый узел записывается полученный в предыдущей операции результат, опять происходт парсин операторов
 * на основе регулярного выражения, далее в правый узел записывается значение после оператора и т.д.
 *
 * @see BinaryNode
 */
public class AST {
    private Node root;

    private static final Pattern PATTERN_DIGIT = Pattern.compile("^[0-9]\\d*");
    private static final Pattern PATTERN_OPER = Pattern.compile("[\\+\\-\\/\\*][\\+\\-\\/\\*\\s]*");

    public AST(Node root) {
        this.root = root;
    }

    public static AST create(String input) {
        return new AST(parse(input));
    }

    private static Node parse(String s) {
        String input = s.trim();
        Matcher digitMatch = PATTERN_DIGIT.matcher(input);
        if (digitMatch.find()) {
            String sub = input.substring(digitMatch.end()).trim();
            Matcher operMatch = PATTERN_OPER.matcher(sub);
            if (operMatch.find()) {
                return new BinaryNode(new Term(Double.parseDouble(digitMatch.group())),
                        operMatch.group(),
                        parse(sub.substring(operMatch.end())));
            } else {
                return new Term(Double.parseDouble(digitMatch.group()));
            }
        } else
            throw new IllegalArgumentException();
    }

    public double calc() {
        return root.apply();
    }
}
