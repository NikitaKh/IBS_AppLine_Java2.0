package com.ibs.appline.task_6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 * Вданном классе реализовано чтение файла
 */
public class FileReading {

    private static String fileName;

    public FileReading(String fileName) {
        this.fileName = fileName;
    }

    /**
     * В данном методе происходит чтение файла,
     * каждое слово записывается в отдельную строку и хранится в лситах
     *
     * @return коллекция строк
     */
    public List<String> fileReading() {
        List<String> inputAsList = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String input;
            while ((input = br.readLine()) != null) {
                String[] inputArray = input.split(" ");
                Collections.addAll(inputAsList, inputArray);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла.");
        }
        Collections.sort(inputAsList);
        return inputAsList;
    }
}
