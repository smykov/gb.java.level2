package ru.gb.smykov.level2.HW1;

public class RunningTrack implements Barrier {
    @Override
    public Barrier go(Participant participant) {
        if (participant.run()) {
            System.out.println(participant + " successfully ran on the running track!");
        } else {
            System.out.println(participant + " was unable to run on the running track!");
        }
        return this;
    }
}
