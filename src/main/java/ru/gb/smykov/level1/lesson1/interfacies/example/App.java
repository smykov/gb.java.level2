package ru.gb.smykov.level1.lesson1.interfacies.example;

public class App {
    public static void main(String[] args) {
        Reader reader = new FileReader("abc.txt");
        Writer writer = new ConsoleWriter();
        CharCounter charCounter = new CharCounter(writer, reader);
        charCounter.processText();
    }
}
