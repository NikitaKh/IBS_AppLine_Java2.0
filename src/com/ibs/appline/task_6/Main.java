package com.ibs.appline.task_6;


/**
 * @author Nikita Khvalin
 */
public class Main {

    public static void main(String[] args) {
        FileReading text = new FileReading("test.txt");
        Compare.wordsCounter(text.fileReading());
    }
}
