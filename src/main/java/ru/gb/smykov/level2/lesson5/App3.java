package ru.gb.smykov.level2.lesson5;

public class App3 {
    private final Object mutex = new Object();
    private int data = 0;

    public void receive() {
        synchronized (mutex) {
            try {
                mutex.wait();
                System.out.println("Data received " + data);
                mutex.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void prepare() {
        synchronized (mutex) {
            System.out.println("Data prepared " + (++data));
            mutex.notify();
            try {
                mutex.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        App3 app3 = new App3();
        Thread receiver = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                app3.receive();
            }
        });
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                app3.prepare();
            }
        });

        receiver.start();
        producer.start();

        try {
            receiver.join();
            producer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
