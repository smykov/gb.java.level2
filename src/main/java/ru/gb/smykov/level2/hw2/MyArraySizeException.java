package ru.gb.smykov.level2.hw2;

public class MyArraySizeException extends RuntimeException {
    private static final String ERROR_MESSAGE = "Должен быть передан массив 4х4!";

    public MyArraySizeException() {
        super(String.format(ERROR_MESSAGE));
    }

}
