package com.ibs.appline.task_3;

/**
 * Класс реализации программы поска наиболее длинного слова в массиве строк
 */
class ArrayParser {

    public ArrayParser(int len) {
        InputScanner input = new InputScanner();
        arrayParser(input.stringsScanner(len));
    }

    private void arrayParser(String[] stringArray) {
        int len = 0;
        int pos = 0;
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].length() > len) {
                pos = i;
                len = stringArray[i].length();
            }
        }
        System.out.printf("Самое длинное слово:\n" +
                " : %s\n" +
                " его длина - %d симв.\n", stringArray[pos], len);
    }
}
