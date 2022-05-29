package ru.gb.smykov.level2.HW1;

public class Human implements Participant {
    @Override
    public Participant run() {
        System.out.println("Human ran");
        return this;
    }

    @Override
    public Participant jump() {
        System.out.println("Human jumped");
        return this;
    }
}
