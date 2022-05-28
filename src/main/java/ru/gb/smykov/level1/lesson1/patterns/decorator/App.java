package ru.gb.smykov.level1.lesson1.patterns.decorator;

public class App {
    public static void main(String[] args) {
        Printer consolePrinter = new ConsolePrinter();
        Printer borderPrinter = new BorderPrinter(consolePrinter);
        Printer uppercasePrinter = new UppercasePrinter(borderPrinter);
        Printer sparsePrinter = new SparsePrinter(uppercasePrinter);
        Printer performanceMeter = new PerformanceMeter(sparsePrinter);
        performanceMeter.print("Hello World!!!");
    }
}
