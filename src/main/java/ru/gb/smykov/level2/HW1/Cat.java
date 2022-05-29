package ru.gb.smykov.level2.HW1;

public class Cat implements Participant {
    @Override
    public boolean run() {
        System.out.println(this + " ran");
        return true;
    }

    @Override
    public boolean jump() {
        System.out.println(this + " jumped");
        return true;
    }

    @Override
    public String toString() {
        return "Cat";
    }
}
