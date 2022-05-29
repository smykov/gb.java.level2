package ru.gb.smykov.level2.HW1;

public class App {
    public static void main(String[] args) {
        Barrier[] barriers = {
                new RunningTrack(),
                new Wall(),
                new RunningTrack(),
                new RunningTrack(),
                new Wall(),
                new RunningTrack(),
        };

        Participant[] participants = {
                new Human(),
                new Cat(),
                new Robot(),
                new Human(),
                new Cat(),
                new Robot(),
        };

        for (Participant participant : participants) {
            System.out.println(participant + " started to pass the barrier course.");
            for (Barrier barrier : barriers) {
                barrier.go(participant);
            }
            System.out.println("-----");
        }
    }
}
