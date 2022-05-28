package ru.gb.smykov.level1.lesson1.patterns.decorator;

public class BorderPrinter implements Printer {
    private Printer printer;

    public BorderPrinter(Printer printer) {
        this.printer = printer;
    }
    @Override
    public void print(String text) {
//        System.out.println("*".repeat(text.length() + 4));// 11 версия
        for (int i = 0; i < text.length() + 4; i++) {
            System.out.print("*");
        }
        System.out.print("\n* ");
        printer.print(text);
        System.out.println(" *");
        for (int i = 0; i < text.length() + 4; i++) {
            System.out.print("*");
        }
        System.out.println("");

    }
}
