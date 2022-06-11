package ru.gb.smykov.level2.lesson5;

public class App4 {
    volatile int i;
    void m(){
        i++;
        System.out.println("i = " + i);
    }
    public static void main(String[] args) {
        App4 app4 = new App4();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                app4.m();
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                app4.m();
            }
        }).start();

    }
}
