package ru.gb.smykov.level2.HW1;

public class Human implements Participant {
    private double runLimit;
    private final double jumpLimit;
    private boolean isPlay;

    public Human(double runLimit, double jumpLimit) {
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    @Override
    public String toString() {
        return "Human";
    }

    public boolean isPlay() {
        return isPlay;
    }

    public void setPlay(boolean play) {
        isPlay = play;
    }

    @Override
    public double getRunLimit() {
        return runLimit;
    }

    @Override
    public void setRunLimit(double runLimit) {
        this.runLimit = runLimit;
    }

    public double getJumpLimit() {
        return jumpLimit;
    }
}
