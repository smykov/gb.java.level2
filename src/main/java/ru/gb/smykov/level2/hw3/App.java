package ru.gb.smykov.level2.hw3;

public class App {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.add("Иванов",     "7222999848677");
        phonebook.add("Пупкин",     "7222936828847");
        phonebook.add("Петров",     "7222979868727");
        phonebook.add("Сидоров",    "7222989668737");
        phonebook.add("Пупкин",     "7222936828747");
        phonebook.add("Петренко",   "7222969838757");

        System.out.println(phonebook.get("Пупкин"));
    }
}
