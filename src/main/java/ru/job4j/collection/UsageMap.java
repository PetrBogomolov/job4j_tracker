package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> students = new HashMap<>();
        students.put("Petrov@gmail.com", "Petrov");
        students.put("Ivanov@gmail.com", "Ivanov");
        students.put("Smirnov@gmail.com", "Smirnov");
        students.put("Smirnov@gmail.com", "Smirnov Oleg");
        students.remove("Petrov@gmail.com");
        for (String key : students.keySet()) {
             String value = students.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
