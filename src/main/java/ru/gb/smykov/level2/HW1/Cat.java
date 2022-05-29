package ru.gb.smykov.level2.HW1;

public class Cat implements Participant {
    @Override
    public Participant run() {
        System.out.println("Cat ran");
        return this;
    }

    @Override
    public Participant jump() {
        System.out.println("Cat jumped");
        return this;
    }
}
