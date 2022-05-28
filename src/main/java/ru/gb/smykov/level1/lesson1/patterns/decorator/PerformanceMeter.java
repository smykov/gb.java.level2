package ru.gb.smykov.level1.lesson1.patterns.decorator;

public class PerformanceMeter implements Printer {
    private Printer printer;

    public PerformanceMeter(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void print(String text) {
        final long l = System.currentTimeMillis();
        printer.print(text);
        System.out.println(System.currentTimeMillis() - l);
    }
}
