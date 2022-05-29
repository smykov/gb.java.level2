package ru.gb.smykov.level2.HW1;

public class Wall implements Barrier {
    @Override
    public Barrier go(Participant participant) {
        if (participant.jump()) {
            System.out.println(participant + " successful jumped over the wall!");
        } else {
            System.out.println(participant + " was unable to jump over the wall!");
        }
        return this;
    }
}
