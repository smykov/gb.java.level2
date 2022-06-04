package ru.gb.smykov.level2.HW1;

public class Robot implements Participant {
    private double runLimit;
    private final double jumpLimit;
    private boolean isPlay;

    public Robot(double runLimit, double jumpLimit) {
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    @Override
    public boolean run(double length) {
        if (runLimit >= length) {
            System.out.println(this + " ran.");
            runLimit -= length;
            return true;
        }
        System.out.println(this + " could not run.");
        return false;
    }

    @Override
    public boolean jump(double height) {
        if (jumpLimit >= height) {
            System.out.println(this + " jumped.");
            return true;
        }
        System.out.println(this + " could not jump.");
        return false;
    }

    @Override
    public String toString() {
        return "Robot";
    }

    public boolean isPlay() {
        return isPlay;
    }

    public void setPlay(boolean play) {
        isPlay = play;
    }
}
