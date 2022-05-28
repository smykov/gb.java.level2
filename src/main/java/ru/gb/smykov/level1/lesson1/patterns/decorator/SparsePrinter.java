package ru.gb.smykov.level1.lesson1.patterns.decorator;

import javafx.beans.binding.StringBinding;

public class SparsePrinter implements Printer {
    private Printer printer;

    public SparsePrinter(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void print(String text) {
        StringBuilder builder = new StringBuilder(" ");
        for (char c : text.toCharArray()) {
            builder.append(c).append(" ");
        }
        printer.print(builder.toString());
    }
}
