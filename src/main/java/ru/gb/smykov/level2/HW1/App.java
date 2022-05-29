package ru.gb.smykov.level2.HW1;

public class App {
    public static void main(String[] args) {
        Barrier[] barriers = {
                new RunningTrack(100),
                new Wall(1.0),
                new RunningTrack(50),
                new RunningTrack(200),
                new Wall(1.3),
                new RunningTrack(75),
        };

        Participant[] participants = {
                new Human(1000, 1.5),
                new Cat(200, 1),
                new Robot(2000, 1),
                new Human(1200, 0.8),
                new Cat(150, 1.5),
                new Robot(1500, 0.5),
        };

        for (Participant participant : participants) {
            System.out.println(participant + " started to pass the barrier course.");
            for (Barrier barrier : barriers) {
                if (!barrier.go(participant)) {
                    System.out.println(participant + " went out of the way!");
                    break;
                }
            }
            System.out.println("-----");
        }
    }
}
