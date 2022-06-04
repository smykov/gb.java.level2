package ru.gb.smykov.level2.HW1;

public interface Participant {
    boolean run(double length);

    boolean jump(double height);

    void setPlay(boolean play);

    boolean isPlay();
}
