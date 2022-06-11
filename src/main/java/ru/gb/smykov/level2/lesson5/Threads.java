package ru.gb.smykov.level2.lesson5;

public class Threads {
    public static void main(String[] args) throws InterruptedException {
        //работа с потоками
        myThread t0 = new myThread();
        myThread t1 = new myThread();
        myThread t2 = new myThread();
        myThread t3 = new myThread();
        myThread t4 = new myThread();
        myThread t5 = new myThread();
        t0.start();
        t1.start();
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.join();//блокирует программу пока тоток не завершит работу
        t3.start();
        t3.setPriority(Thread.NORM_PRIORITY);
        t4.start();
        t4.setDaemon(true);// демон поток прерывается при завершении программы
        t5.setPriority(Thread.MAX_PRIORITY);
        t5.start();

        //остановка потока
        myThread2 myThread2 = new myThread2();
        myThread2.start();
        myThread2.interrupt();
    }
}

class myThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Привет из потока" + Thread.currentThread().getName());
    }
}

class myThread2 extends Thread {
    @Override
    public void run() {
        while (!isInterrupted()) {
            System.out.println("Привет из потока" + Thread.currentThread().getName());
        }
    }
}