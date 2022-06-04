package ru.gb.smykov.level2.HW1;

public interface Participant {
    default boolean run(double length) {
        if (getRunLimit() >= length) {
            System.out.println(this + " ran.");
            setRunLimit(getRunLimit() - length);
            return true;
        }
        System.out.println(this + " could not run.");
        setPlay(false);
        return false;
    }

    default boolean jump(double height) {
        if (getJumpLimit() >= height) {
            System.out.println(this + " jumped.");
            return true;
        }
        System.out.println(this + " could not jump.");
        setPlay(false);
        return false;

    }

    void setPlay(boolean play);

    boolean isPlay();

    double getRunLimit();

    void setRunLimit(double limit);

    double getJumpLimit();
}
