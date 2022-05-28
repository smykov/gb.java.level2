package ru.gb.smykov.level1.lesson1;

public class Outer {
    private int a;
    private static int i;

    private void m() {
        class A { //локальный класс
        }
        A a = new A();
    }

    private static void sm() {
    }

    public class Inner { //внутренний класс
        void innerM() {
            a = 1;
            i = 42;
            m();
            sm();
        }
    }

    public static class SInner { //вложенный класс
        void SInnerM() {
            i = 42;
            sm();
        }

    }
}
