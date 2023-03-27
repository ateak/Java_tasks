package org.example.task2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] notes = {"Добрый вечер #Питер", "Здравствуй #Москва",
                "#Москва #Питер а в #Воронеж созрели Апельсины",
                "#Москва ниеогда не спит"};
        
        printListTowns(notes);
    }
    public static void printListTowns(String[] text) {
        HashMap<String, Integer> uniqueTowns = new HashMap<>();

        //создание HashMap из хэштегов как ключа и количества их вхождений как значения
        for (int i = 0; i < text.length; i++) {
            String[] arr = text[i].split(" ");
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].charAt(0) == '#') {
                    if (uniqueTowns.containsKey(arr[j])) {
                        uniqueTowns.put(arr[j], uniqueTowns.get(arr[j]) + 1);
                    } else {
                        uniqueTowns.put(arr[j], 1);
                    }
                }
            }
        }

        //создание списка элементов Map.Entry из HashMap
        List<Map.Entry<String, Integer>> list = new ArrayList<>(uniqueTowns.entrySet());

        // определение компаратора для сравнения значений элементов HashMap
        Comparator<Map.Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                Integer v1 = o1.getValue();
                Integer v2 = o2.getValue();
                return v2.compareTo(v1);
            }
        };

        //сортировка списка в порядке убывания
        Collections.sort(list, valueComparator);

        // Создание нового HashMap, который будет содержать элементы отсортированного списка
        LinkedHashMap<String, Integer> sortedByValue = new LinkedHashMap<>();

        //Перебор отсортированного списка и добавление его элементов в LinkedHashMap
        for (Map.Entry<String, Integer> entry : list) {
            sortedByValue.put(entry.getKey(), entry.getValue());
        }

        //создание списка с хэштегами, отсортированными в порядке количества вхождений
        Set<String> setKeys = sortedByValue.keySet();
        System.out.println(setKeys);
    }
}