package ru.gb.smykov.level2.HW1;

public class RunningTrack implements Barrier {
    private final double length;

    public RunningTrack(double length) {
        this.length = length;
    }

    @Override
    public boolean go(Participant participant) {
        if (participant.run(length)) {
            System.out.println(participant + " successfully ran on the running track!");
            return true;
        }
        System.out.println(participant + " was unable to run on the running track!");
        participant.setPlay(false);
        return false;
    }
}
