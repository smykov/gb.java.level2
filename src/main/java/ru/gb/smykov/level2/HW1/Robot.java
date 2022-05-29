package ru.gb.smykov.level2.HW1;

public class Robot implements Participant {
    @Override
    public Participant run() {
        System.out.println("Robot ran");
        return this;
    }

    @Override
    public Participant jump() {
        System.out.println("Robot jumped");
        return this;
    }
}
