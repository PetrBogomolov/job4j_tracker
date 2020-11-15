package ru.job4j.streamapi.attestacia;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(x -> x.getSubjects().stream())
                .mapToInt(Subject::getScope)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(x -> new Tuple(x.getName(),
                x.getSubjects().stream()
                        .mapToInt(Subject::getScope)
                        .average()
                        .orElse(0D)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(x -> x.getSubjects().stream())
                .collect(
                        Collectors.groupingBy(
                                Subject::getName,
                                Collectors.averagingDouble(Subject::getScope)
                        )
                )
                .entrySet().stream()
                .map(x -> new Tuple(x.getKey(), x.getValue()))
                .sorted(Comparator.comparing(Tuple::getScope))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(x -> new Tuple(x.getName(),
                x.getSubjects().stream()
                .mapToInt(Subject::getScope)
                .sum()))
                .max(Comparator.comparingDouble(Tuple::getScope))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(x -> x.getSubjects().stream())
                .collect(
                        Collectors.groupingBy(
                                Subject::getName,
                                Collectors.summingDouble(Subject::getScope)
                        )
                )
                .entrySet().stream()
                .map(x -> new Tuple(x.getKey(), x.getValue()))
                .max(Comparator.comparing(Tuple::getScope))
                .orElse(null);
    }
}
