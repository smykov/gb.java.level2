package ru.gb.smykov.level1.lesson1.interfacies.example;

public class FileWriter implements Writer {
    private String fileName;

    public FileWriter(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void write(String text) {

    }
}
