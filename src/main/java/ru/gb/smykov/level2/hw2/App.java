package ru.gb.smykov.level2.hw2;

public class App {
    public static void main(String[] args) {

        String[][] strings = new String[5][4];

        checkArray4x4(strings);

    }

    private static void checkArray4x4(String[][] strings) {
        if (strings.length != 4 || strings[0].length != 4) {
            throw new MyArraySizeException();
        }
    }
}
