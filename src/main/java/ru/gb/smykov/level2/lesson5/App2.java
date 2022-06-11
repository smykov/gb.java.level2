package ru.gb.smykov.level2.lesson5;

import java.util.concurrent.atomic.AtomicInteger;

public class App2 {

    public static void main(String[] args) {
        CounterInterface counter = new Counter();
        startThreadsWithCounter(counter);

        CounterInterface atomicCounter = new AtomicCounter();
        startThreadsWithCounter(atomicCounter);

    }

    private static void startThreadsWithCounter(CounterInterface counter) {
        MyThreadCounterInc t1 = new MyThreadCounterInc(counter);
        MyThreadCounterDec t2 = new MyThreadCounterDec(counter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("counter.getCount() = " + counter.getCount());
    }
}

class AtomicCounter implements CounterInterface {
    private AtomicInteger count = new AtomicInteger();

    @Override
    public void increment() {
        count.incrementAndGet();
    }

    @Override
    public void decrement() {
        count.decrementAndGet();
    }

    @Override
    public int getCount() {
        return count.get();
    }
}

class Counter implements CounterInterface{
    private int count;
    private final Object mutex = new Object();


    //void increment() { //read - add - write
    //// race condition (состояние гонки) борьба за ресурс
    //    count++;
    //}
//нужно добавить synchronized//
    public synchronized void increment() { //read - add - write //за мьютекс берется текущий объект класса
        count++;
    }

    public void decrement() { //read - add - write
        synchronized (this) { //либо указывать мьютекс вместо this
            count--;
        }
    }


    public int getCount() {
        return count;
    }
}

interface CounterInterface {
    void increment();
    void decrement();
    int getCount();
}
class MyThreadCounterInc extends Thread {
    private final CounterInterface counter;

    MyThreadCounterInc(CounterInterface counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50000; i++) {
            counter.increment();
        }
    }
}

class MyThreadCounterDec extends Thread {
    private final CounterInterface counter;

    MyThreadCounterDec(CounterInterface counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50000; i++) {
            counter.decrement();
        }
    }
}
