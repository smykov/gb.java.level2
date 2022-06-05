package ru.gb.smykov.level2.hw3;

import java.util.HashMap;
import java.util.HashSet;

public class Phonebook {
    private final HashMap<String, HashSet<String>> book;

    public Phonebook() {
        this.book = new HashMap<>();
    }

    public void add(String name, String phone) {
        if (!book.containsKey(name)) {
            HashSet<String> phoneSet = new HashSet<>();
            phoneSet.add(phone);
            book.put(name, phoneSet);
        } else {
            book.get(name).add(phone);
        }
    }

    public HashSet<String> get(String name) {

        return book.get(name);
    }
}
