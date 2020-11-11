package ru.job4j.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        List<Student> result = new ArrayList<>();
        result = students.stream().filter(predict).collect(Collectors.toList());
        return result;
    }

    public Map<String, Student> convert(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(Student::getName, e -> e, (element, dublicate) -> element));
    }

    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(Objects::nonNull)
                .sorted((left, right) -> Integer.compare(right.getScope(), left.getScope()))
                .takeWhile(student -> student.getScope() > bound)
                .collect(Collectors.toList());
    }
}
