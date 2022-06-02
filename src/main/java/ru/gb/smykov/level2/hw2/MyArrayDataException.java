package ru.gb.smykov.level2.hw2;

public class MyArrayDataException extends NumberFormatException {
    private static final String ERROR_MESSAGE = "Ошибка преобразования в число [%d][%d]!";

    public MyArrayDataException(int i, int j) {
        super(String.format(ERROR_MESSAGE, i, j));
    }

}
