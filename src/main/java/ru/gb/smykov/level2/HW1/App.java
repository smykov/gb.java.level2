package ru.gb.smykov.level2.HW1;

public class App {
    public static void main(String[] args) {
        Barrier runningTrack = new RunningTrack();
        Barrier wall = new Wall();

        Participant cat = new Cat();
        Participant human = new Human();
        Participant robot = new Robot();

        wall.go(cat).go(human).go(robot);
        runningTrack.go(human).go(robot).go(cat);
    }
}
