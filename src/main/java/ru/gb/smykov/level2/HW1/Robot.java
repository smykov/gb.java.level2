package ru.gb.smykov.level2.HW1;

public class Robot implements Participant {
    @Override
    public boolean run() {
        System.out.println(this + " ran");
        return true;
    }

    @Override
    public boolean jump() {
        System.out.println(this + " can't jump");
        return false;
    }

    @Override
    public String toString() {
        return "Robot";
    }
}
