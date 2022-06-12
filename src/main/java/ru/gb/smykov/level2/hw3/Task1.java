package ru.gb.smykov.level2.hw3;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("Коллекция");
        stringList.add("контейнер");
        stringList.add("множество");
        stringList.add("работать");
        stringList.add("объект");
        stringList.add("множество");
        stringList.add("объект");
        stringList.add("Коллекция");
        stringList.add("обработка");
        stringList.add("множество");
        stringList.add("объект");
        stringList.add("массив");
        stringList.add("массив");
        stringList.add("множество");
        stringList.add("колесо");
        stringList.add("ссылка");
        stringList.add("структура");
        stringList.add("конструктор");

        System.out.println("ArrayList: " + stringList);
        System.out.println("ArrayList.size: " + stringList.size() + "\n");

        HashSet<String> uniqStrings = new HashSet<>(stringList);

        System.out.println("HashSet: " + uniqStrings);
        System.out.println("HashSet.size: " + uniqStrings.size() + "\n");


        HashMap<String, Integer> stringMap = new HashMap<>();
        for (String string : stringList) {
            stringMap.put(string, stringMap.getOrDefault(string, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : stringMap.entrySet()) {
            System.out.printf("Слово \"%s\" встречается %d %s\n", entry.getKey(), entry.getValue(), (Arrays.stream(new int[]{2, 3, 4}).anyMatch(entry.getValue()::equals) ? "раза" : "раз"));
        }

    }
}
