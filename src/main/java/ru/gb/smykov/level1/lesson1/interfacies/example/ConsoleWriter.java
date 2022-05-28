package ru.gb.smykov.level1.lesson1.interfacies.example;

public class ConsoleWriter implements Writer {
    @Override
    public void write(String text) {
        System.out.println(text);
    }
}
