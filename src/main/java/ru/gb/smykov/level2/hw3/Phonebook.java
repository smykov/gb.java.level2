package ru.gb.smykov.level2.hw3;

import java.util.HashMap;
import java.util.HashSet;

public class Phonebook {
    private final HashMap<String, HashSet<String>> book;

    public Phonebook() {
        this.book = new HashMap<>();
    }

    public void add(String name, String phone) {
        HashSet<String> phoneList = book.getOrDefault(name, new HashSet<>());
        phoneList.add(phone);
        book.put(name, phoneList);
    }

    public HashSet<String> get(String name) {
        return book.getOrDefault(name, new HashSet<>());
    }

    @Override
    public String toString() {
        return book.toString();
    }
}
