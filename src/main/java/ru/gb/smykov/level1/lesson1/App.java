package ru.gb.smykov.level1.lesson1;

public class App {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
        Outer.SInner sInner = new Outer.SInner();

        Animal animal = new Animal() { //анонимный класс
            @Override
            public void run(int length) {
                System.out.println("run");
            }

            @Override
            public void swim(int length) {
                System.out.println("swim");
            }
        };

    }
}
