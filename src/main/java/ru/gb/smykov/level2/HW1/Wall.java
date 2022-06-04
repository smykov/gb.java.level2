package ru.gb.smykov.level2.HW1;

public class Wall implements Barrier {
    private final double height;

    public Wall(double height) {
        this.height = height;
    }

    @Override
    public boolean go(Participant participant) {
        if (participant.jump(height)) {
            System.out.println(participant + " successful jumped over the wall!");
            return true;
        }
        System.out.println(participant + " was unable to jump over the wall!");
        participant.setPlay(false);
        return false;
    }
}
