package com.ibs.appline.task_5;

/**
 * Интерыейс бинарного дерева
 */

public interface Node {
    Node getLeft();

    String getOp();

    Node getRight();

    double apply();
}
