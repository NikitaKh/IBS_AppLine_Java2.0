package com.ibs.appline.task_6;

import java.util.*;

/**
 * Класс для сравнения и подстчета одинковых слов
 */
public class Compare {

    /**
     * В методе реализован проход по листам и запись значений в мапу,
     * в мапе в качестве ключа исользуеются слова, в качестве значений кол-во повторений этого слова
     *
     * @param inputAsList слова из фала в видео листа строк.
     */
    public static void wordsCounter(List<String> inputAsList) {
        Map<String, Integer> map = new HashMap<>();
        for (String s1 : inputAsList) {
            int counter = 1;
            map.put(s1, counter);
            for (String s2 : inputAsList) {
                if (s1.equals(s2)) {
                    map.replace(s1, counter++);
                }
            }
        }

        System.out.println("Cтатистика введенных слов:");
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);

        System.out.println("\nСлово с максимальным кол-вом повторений:");
        Optional<Map.Entry<String, Integer>> min = map.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());

        System.out.print(min.get());
    }
}
