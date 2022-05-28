package ru.gb.smykov.level1.lesson1.interfacies.example;

public class FileReader implements Reader {
    private String fileName;

    public FileReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String read() {
        return "zsdfsdf sdf";
    }
}
