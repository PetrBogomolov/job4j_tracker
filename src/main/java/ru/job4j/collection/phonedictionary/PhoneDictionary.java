package ru.job4j.collection.phonedictionary;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> func = person -> person.getName().contains(key)
                || person.getSurname().contains(key)
                || person.getPhone().contains(key)
                || person.getAddress().equals(key);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (func.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}