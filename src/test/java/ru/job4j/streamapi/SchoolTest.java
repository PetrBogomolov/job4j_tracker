package ru.job4j.streamapi;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {
    private final List<Student> students = new ArrayList<>();
    private School school;

    @Before
    public void setUp() {
        school = new School();
        students.add(new Student(10, "Surname1"));
        students.add(new Student(20, "Surname2"));
        students.add(new Student(30, "Surname3"));
        students.add(new Student(40, "Surname4"));
        students.add(new Student(50, "Surname5"));
        students.add(new Student(60, "Surname6"));
        students.add(new Student(70, "Surname7"));
        students.add(new Student(80, "Surname8"));
        students.add(new Student(90, "Surname9"));
    }

    @Test
    public void whenCollectClassA() {
        Predicate<Student> pr = student -> student.getScope() >= 70;
        List<Student> rsl = school.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(70, "Surname7"));
        expected.add(new Student(80, "Surname8"));
        expected.add(new Student(90, "Surname9"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassB() {
        Predicate<Student> pr = student -> (student.getScope() >= 50)
                && (student.getScope() < 70);
        List<Student> rsl = school.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(50, "Surname5"));
        expected.add(new Student(60, "Surname6"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassC() {
        Predicate<Student> pr = student -> (student.getScope() > 0)
                && (student.getScope() < 50);
        List<Student> rsl = school.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(10, "Surname1"));
        expected.add(new Student(20, "Surname2"));
        expected.add(new Student(30, "Surname3"));
        expected.add(new Student(40, "Surname4"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenConvertListThenMap() {
        List<Student>students = Arrays.asList(
                new Student(10, "Name 1"),
                new Student(10, "Name 1"),
                new Student(20, "Name 2"),
                new Student(30, "Name 3"),
                new Student(40, "Name 4")
        );
        Map<String, Student> result = school.convert(students);
        Map<String, Student> expect = new HashMap<>();
        expect.put("Name 1", new  Student(10, "Name 1"));
        expect.put("Name 2", new  Student(20, "Name 2"));
        expect.put("Name 3", new  Student(30, "Name 3"));
        expect.put("Name 4", new  Student(40, "Name 4"));
        assertThat(result, is(expect));
    }
}