package ru.gb.smykov.level2.lesson5;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        //ананимная функция
        I helloWorld = new I() {
            @Override
            public void m() {
                System.out.print("Hello World!");
            }
        };
        //лямбда функция
        I helloWorldLambda = () -> System.out.print("Hello World!");


        T t = new T();
        t.start();

        Thread r = new Thread(new R());
        r.start();

        //ананимная функция
        Thread myRunnableThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread thread = Thread.currentThread();
                thread.setName("MyRunnableThread");
                System.out.println("Привет из потока" + Thread.currentThread().getName());
                System.out.println("MyRunnableThread.getStackTrace() = " + Arrays.toString(Thread.currentThread().getStackTrace()));
            }
        });
        myRunnableThread.start();

        //лямбда функция
        Thread myLambdaThread = new Thread(() -> {
            Thread thread = Thread.currentThread();
            thread.setName("MyLambdaThread");
            System.out.println("Привет из потока" + Thread.currentThread().getName());
            System.out.println("MyLambdaThread.getStackTrace() = " + Arrays.toString(Thread.currentThread().getStackTrace()));

        });
        myLambdaThread.start();

        printThreadInfo();
    }

    private static void printThreadInfo() {
        Thread thread = Thread.currentThread();
        System.out.println("thread.getName() = " + thread.getName());
        System.out.println("thread.getStackTrace() = " + Arrays.toString(thread.getStackTrace()));
    }
}

class T extends Thread {
    @Override
    public void run() {
        System.out.println("Привет из потока" + Thread.currentThread().getName());
        System.out.println("T.getStackTrace() = " + Arrays.toString(Thread.currentThread().getStackTrace()));
    }
}

class R implements Runnable {

    @Override
    public void run() {
        System.out.println("Привет из потока" + Thread.currentThread().getName());
        System.out.println("R.getStackTrace() = " + Arrays.toString(Thread.currentThread().getStackTrace()));

    }
}

interface I {
    void m();
}