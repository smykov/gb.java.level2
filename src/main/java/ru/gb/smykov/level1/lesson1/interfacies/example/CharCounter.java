package ru.gb.smykov.level1.lesson1.interfacies.example;

public class CharCounter {
    private final Writer writer;
    private final Reader reader;

    public CharCounter(Writer writer, Reader reader) {
        this.writer = writer;
        this.reader = reader;
    }

    public void processText() {
        String text = reader.read();
        int[] c = new int[128];
        for (char c1 : text.toCharArray()) {
            c[c1]++;
        }
        for (char i = 0; i < c.length; i++) {
            if (c[i] != 0) {
                writer.write(i + " встретилось " + c[i] + " раз");
            }
        }
    }
}
