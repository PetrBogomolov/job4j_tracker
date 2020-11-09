package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CountFunck {
    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        double x, y;
        for (int i = start; i < end; i++) {
            x = i;
            y = func.apply(x);
            result.add(y);
        }
        return result;
    }
}
