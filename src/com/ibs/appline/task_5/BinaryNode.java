package com.ibs.appline.task_5;

public class BinaryNode implements Node {
    private final Node left;
    private final String op;
    private final Node right;

    public BinaryNode(Node left, String op, Node right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }

    @Override
    public Node getLeft() {
        return left;
    }

    @Override
    public String getOp() {
        return op;
    }

    @Override
    public Node getRight() {
        return right;
    }

    /**
     * В данном методе происходит выполнение операций, в конструктор поступает левый и правый узел,
     * то есть левое и правое числовое значение, с которыми будет осуществлена арифметическая операция,
     * а также операторы между ними.
     *
     * @return возвращается результат арифметической операции
     * @see public BinaryNode
     */
    @Override
    public double apply() {
        char opCode = operation(op);
        switch (opCode) {
            case '+':
                return left.apply() + right.apply();
            case '-':
                return left.apply() - right.apply();
            case '/':
                return left.apply() / right.apply();
            case '*':
                return left.apply() * right.apply();
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * В этом методе определяется финальный оператор на основе арифметических правил.
     *
     * @param op строка с одним или более арифметическим оператором.
     * @return итоговый оператор, который будет использован в вычислениях.
     */
    private char operation(String op) {
        return op.charAt(0);
    }
}
