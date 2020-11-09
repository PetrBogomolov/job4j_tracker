package ru.job4j.streamapi;

import java.util.Objects;

public class Student {
    private int scope;
    private String name;

    public Student(int scope, String name) {
        this.scope = scope;
        this.name = name;
    }

    public int getScope() {
        return scope;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return scope == student.scope
                && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scope, name);
    }

    @Override
    public String toString() {
        return "Student{"
               + "scope=" + scope
               + ", name='" + name + '\''
               + '}';
    }
}
