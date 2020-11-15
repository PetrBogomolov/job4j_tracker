package ru.job4j.streamapi.attestacia;

public class Subject {
    private String name;
    private int scope;

    public Subject(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public int getScope() {
        return scope;
    }

    @Override
    public String toString() {
        return "Subject{"
                + "name='" + name + '\''
                + ", scope=" + scope
                + '}';
    }
}
