package ru.gb.smykov.level1.lesson1.patterns.builder;

import java.time.LocalDate;

public class Employee {
    private final String firstname;
    private final String lastname;
    private final String middlename;
    private final String email;
    private final int age;
    private final double salary;
    private final String department;
    private final Employee manager;
    private final Gender gender;
    private final LocalDate birthday;

    private Employee(Builder builder) {
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
        this.middlename = builder.middlename;
        this.email = builder.email;
        this.age = builder.age;
        this.salary = builder.salary;
        this.department = builder.department;
        this.manager = builder.manager;
        this.gender = builder.gender;
        this.birthday = builder.birthday;
    }

    public static class Builder {
        private String firstname;
        private String lastname;
        private String middlename;
        private String email;
        private int age;
        private double salary;
        private String department;
        private Employee manager;
        private Gender gender;
        private LocalDate birthday;

        public Builder(String firstname, String lastname) {
            this.firstname = firstname;
            this.lastname = lastname;
        }

        public Builder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder middlename(String middlename) {
            this.middlename = middlename;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder salary(double salary) {
            this.salary = salary;
            return this;
        }

        public Builder department(String department) {
            this.department = department;
            return this;
        }

        public Builder manager(Employee manager) {
            this.manager = manager;
            return this;
        }

        public Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder birthday(LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }

}
