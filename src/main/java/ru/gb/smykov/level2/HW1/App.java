package ru.gb.smykov.level2.HW1;

public class App {
    public static void main(String[] args) {
        Participant cat = new Cat();
        cat.run().jump();
        Participant human = new Human();
        human.jump().run();
        Participant robot = new Robot();
        robot.run().jump().run();

    }
}
