package ru.gb.smykov.level1.lesson1.patterns.decorator;

public class UppercasePrinter implements Printer {
    private Printer printer;

    public UppercasePrinter(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void print(String text) {
        printer.print(text.toUpperCase());
    }
}
