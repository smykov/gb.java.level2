package ru.gb.smykov.level1.lesson1.interfacies;

abstract class AbstractAnimal {
    private int age;
    private String name;

    public abstract void voice();

    public void print() {
        this.age = Animal.age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
