package org.example.task1;

import java.util.SortedSet;
import java.util.TreeSet;


public class Main {
    public static void main(String[] args) {
        String[] notes = {"Добрый вечер #Питер", "Здравствуй #Москва",
                "#Москва #Питер а в #Воронеж созрели Апельсины",
                "#Москва ниеогда не спит"};
        
        printListTowns(notes);
    }

    public static void printListTowns(String[] text) {
        SortedSet<String> set = new TreeSet<>();
        for (int i = 0; i < text.length; i++) {
            String[] arr = text[i].split(" ");
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].charAt(0) == '#') {
                    set.add(arr[j]);
                }
            }
        }
        System.out.println(set);
    }
}