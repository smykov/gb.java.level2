package ru.gb.smykov.level1.lesson1.patterns.builder;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Employee employee = new Employee.Builder("Ivanov", "Ivan")
                .middlename("Ivanovich")
                .department("IT")
                .birthday(LocalDate.of(1990, 3,15))
                .gender(Gender.MALE)
                .age(22)
                .build();
    }
}
